package ru.kulikovman.exchangerates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class ExchangeActivity extends AppCompatActivity {
    long mDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);

        mDate = (long) getIntent().getSerializableExtra("date_in_long");

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
}
