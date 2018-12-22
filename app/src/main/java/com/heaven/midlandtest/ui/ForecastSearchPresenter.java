package com.heaven.midlandtest.ui;

import com.heaven.midlandtest.api.ForecastInterface;
import com.heaven.midlandtest.model.ForecastResponse;
import com.heaven.midlandtest.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForecastSearchPresenter implements ForecastMVP.SearchPresenter{

    ForecastMVP.SearchView mView;

    public ForecastSearchPresenter(ForecastMVP.SearchView view) {
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
                mView.hideLoading();
                if (response != null && response.body() != null)  {
                    mView.addFragment(response.body());
                } else {
                    mView.showError("Something went wrong");
                }
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
