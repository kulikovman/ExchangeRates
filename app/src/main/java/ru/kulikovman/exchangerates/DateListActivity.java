package ru.kulikovman.exchangerates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.Calendar;

import ru.kulikovman.exchangerates.adapters.DateRVAdapter;

public class DateListActivity extends AppCompatActivity implements DateRVAdapter.ItemClickListener {
    private static final String TAG = "DateListActivity";

    private RecyclerView mRecyclerView;
    private DateRVAdapter mAdapter;
    //private List<Long> mDateList = new ArrayList<>();
    private Calendar mCalendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Started onCreate in DateListActivity");

        // Инициализация
        mCalendar = Calendar.getInstance();
        //Log.d(TAG, "mCalendar: " + mCalendar.getTimeInMillis());

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new DateRVAdapter(this);
        getPackOfDates();

        mAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void getPackOfDates() {
        int counter = 30;
        for (int i = 0; i < counter; i++) {
            mAdapter.addDateInList(mCalendar.getTimeInMillis());
            //mDateList.add(mCalendar.getTimeInMillis());
            mCalendar.add(Calendar.DAY_OF_YEAR, -1);
        }
    }

    @Override
    public void onItemClick(View view, int position) {

    }


}
