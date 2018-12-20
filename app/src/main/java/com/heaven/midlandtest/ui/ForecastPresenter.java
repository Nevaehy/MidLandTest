package com.heaven.midlandtest.ui;

import com.heaven.midlandtest.api.ForecastInterface;
import com.heaven.midlandtest.model.ForecastResponse;
import com.heaven.midlandtest.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForecastPresenter implements ForecastMVP.Presenter{

    ForecastMVP.View mView;

    public ForecastPresenter(ForecastMVP.View view) {
        mView = view;
        mView.init();
    }

    @Override
    public void detach() {
        mView = null;
    }

    @Override
    public void onNextClick(String city) {
        mView.showLoading();
        getData(city);
    }

    @Override
    public void getData(String city) {
        Call<ForecastResponse> call = ForecastInterface.Creator.getRetrofitClient().getForecast(city, Constants.FORECAST_MODE, Constants.FORECAST_API);

        call.enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
                if (response != null && response.body() != null)  {

                }
                mView.hideLoading();
            }

            @Override
            public void onFailure(Call<ForecastResponse> call, Throwable t) {
                mView.hideLoading();
                mView.showError(t.getMessage());
            }
        });
    }

    @Override
    public void onTextChanged(CharSequence text) {
        mView.changeButtonState(text.length() > 0);
    }
}
