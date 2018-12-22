package com.heaven.midlandtest.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.heaven.midlandtest.R;
import com.heaven.midlandtest.model.ForecastResponse;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ForecastRecyclerViewAdapter extends RecyclerView.Adapter<ForecastRecyclerViewAdapter.ViewHolder> {

    private final List<ForecastResponse.List> mValues;

    public ForecastRecyclerViewAdapter(List<ForecastResponse.List> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mDate.setText(mValues.get(position).getDt().toString());
        holder.mTemperature.setText(mValues.get(position).getMain().getTemp().toString());
        holder.mWeather.setText(mValues.get(position).getWeather().get(0).getDescription());
        holder.mPressure.setText(mValues.get(position).getMain().getPressure().toString());
        holder.mHumidity.setText(mValues.get(position).getMain().getHumidity().toString());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        @BindView(R.id.item_date) TextView mDate;
        @BindView(R.id.item_weather) TextView mWeather;
        @BindView(R.id.item_temperature) TextView mTemperature;
        @BindView(R.id.item_pressure) TextView mPressure;
        @BindView(R.id.item_humidity) TextView mHumidity;
        public ForecastResponse.List mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mDate.getText() + "'";
        }
    }
}
