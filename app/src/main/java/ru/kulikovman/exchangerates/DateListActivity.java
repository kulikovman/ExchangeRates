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
    private EndlessRVScrollListener mScrollListener;
    private Calendar mCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Started onCreate in DateListActivity");

        // Инициализация
        mCalendar = Calendar.getInstance();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new DateRVAdapter(this);
        mAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mAdapter);

        // Начальный набор дат
        getPackOfDates();

        // Добавляем даты по мере прокручивания
        mScrollListener = new EndlessRVScrollListener(linearLayoutManager) {

            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                Log.d(TAG, "Started onLoadMore in EndlessRVScrollListener");
                getPackOfDates();
            }
        };

        mRecyclerView.addOnScrollListener(mScrollListener);
    }

    public void getPackOfDates() {
        int sizeOfPack = 100;
        for (int i = 0; i < sizeOfPack; i++) {
            mAdapter.addDateInList(mCalendar.getTimeInMillis());
            mAdapter.notifyItemInserted(mAdapter.getItemCount());
            mCalendar.add(Calendar.DAY_OF_YEAR, -1);
        }
    }

    @Override
    public void onItemClick(View view, int position) {

    }


}
