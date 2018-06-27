package ru.kulikovman.exchangerates;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.kulikovman.exchangerates.models.ValCurs;
import ru.kulikovman.exchangerates.models.Valute;

public class ExchangeActivity extends AppCompatActivity {
    private static final String TAG = "ExchangeActivity";

    private TextView mEuroRate, mDollarRate, mDateOfRate;
    long mDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);

        // Инициализация вью элементов
        mEuroRate = findViewById(R.id.euro_rate);
        mDollarRate = findViewById(R.id.dollar_rate);
        mDateOfRate = findViewById(R.id.date_of_rate);

        // Получаем дату
        mDate = (long) getIntent().getSerializableExtra("date_in_long");
        if (mDate != 0) {
            loadExchangeRates();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // Возврат назад без перезапуска
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void loadExchangeRates() {
        // Выводим дату на экран
        mDateOfRate.setText(DataHelper.convertLongToDateForList(mDate));

        // Создаем строку с датой для запроса
        String targetDate = DataHelper.convertLongToDateForApi(mDate);
        Log.d(TAG, "targetDate = " + targetDate);

        // Получаем данные
        App.getApi().getRateOnDate(targetDate).enqueue(new Callback<ValCurs>() {
            @Override
            public void onResponse(@NonNull Call<ValCurs> call, @NonNull Response<ValCurs> response) {
                if (response.isSuccessful()) {
                    List<Valute> list = new ArrayList<>();
                    try {
                        list = response.body().getList();
                    } catch (Exception e) {
                        Log.d(TAG, "Exception:" + e.getMessage());
                    }

                    if (list.size() > 0) {
                        getCurrencyRate(list, R.string.usd, mDollarRate);
                        getCurrencyRate(list, R.string.eur, mEuroRate);
                    }
                } else {
                    Log.d(TAG, "Response is not successful: " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ValCurs> call, @NonNull Throwable t) {
                showErrorToast(t);
            }
        });
    }

    private void getCurrencyRate(List<Valute> list, int usd, TextView valueField) {
        for (Valute valute : list) {
            if (valute.getCharCode().equals(getString(usd))) {
                valueField.setText(valute.getValue());
                Log.d(TAG, "Currency: " + valute.getCharCode() + " " + valute.getValue());
            }
        }
    }

    private void showErrorToast(Throwable t) {
        Toast.makeText(ExchangeActivity.this, "Error with internet connection", Toast.LENGTH_LONG).show();
        Log.d(TAG, "Error with internet connection: " + t.getMessage());
    }
}
