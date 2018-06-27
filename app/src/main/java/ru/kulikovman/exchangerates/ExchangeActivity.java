package ru.kulikovman.exchangerates;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.kulikovman.exchangerates.models.CbrBodyResponse;
import ru.kulikovman.exchangerates.models.Valute;

public class ExchangeActivity extends AppCompatActivity {
    private static final String TAG = "ExchangeActivity";

    private TextView mRateEuro, mRateDollar;
    long mDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);

        // Инициализация вью элементов
        mRateEuro = findViewById(R.id.rate_euro);
        mRateDollar = findViewById(R.id.rate_dollar);

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
        // Получаем данные о валютах и выводим на экран
        String targetDate = DataHelper.convertLongToDateForApi(mDate);
        Log.d(TAG, "targetDate = " + targetDate);

        App.getApi().getRateOnDate(targetDate).enqueue(new Callback<CbrBodyResponse>() {
            @Override
            public void onResponse(@NonNull Call<CbrBodyResponse> call, @NonNull Response<CbrBodyResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "Response is successful: " + response.code());

                    ArrayList<Valute> valutList = new ArrayList<>();
                    try {
                        Collections.addAll(valutList, response.body().getValCurs().getValute());
                    } catch (Exception ignored) {
                        Log.d(TAG, "Exception:" + ignored.getMessage());
                    }

                    if (valutList.size() > 0) {
                        Log.d(TAG, "valutList.size() = " + valutList.size());
                    }
                } else {
                    Log.d(TAG, "Response is not successful: " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<CbrBodyResponse> call, @NonNull Throwable t) {
                showErrorToast(t);
            }
        });
    }

    private void showErrorToast(Throwable t) {
        Toast.makeText(ExchangeActivity.this, "Error with internet connection", Toast.LENGTH_LONG).show();
        Log.d(TAG, "Error with internet connection: " + t.getMessage());
    }
}
