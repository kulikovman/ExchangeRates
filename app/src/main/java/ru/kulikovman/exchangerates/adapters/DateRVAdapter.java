package ru.kulikovman.exchangerates.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.kulikovman.exchangerates.DataHelper;
import ru.kulikovman.exchangerates.R;

public class DateRVAdapter extends RecyclerView.Adapter<DateRVAdapter.ViewHolder> {
    private List<Long> mDateList;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // dateList is passed into the constructor
    public DateRVAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.mDateList = new ArrayList<>();
    }

    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_date, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String date = DataHelper.convertLongToDateForList(mDateList.get(position));
        holder.mDateField.setText(date);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mDateList.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mDateField;

        public ViewHolder(View itemView) {
            super(itemView);
            mDateField = itemView.findViewById(R.id.date_field);
            mDateField.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) {
                int position = getAdapterPosition();
                mClickListener.onItemClick(v, position, mDateList.get(position));
            }
        }
    }

    // convenience method for getting data at click position
    public long getItem(int id) {
        return mDateList.get(id);
    }

    public void addDateInList(long date) {
        mDateList.add(date);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position, long date);
    }
}
