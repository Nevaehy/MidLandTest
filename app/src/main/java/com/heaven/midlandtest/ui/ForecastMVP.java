package com.heaven.midlandtest.ui;

import com.heaven.midlandtest.model.ForecastResponse;
import com.heaven.midlandtest.ui.base.BasePresenter;
import com.heaven.midlandtest.ui.base.BaseView;

public interface ForecastMVP {
    interface SearchView extends BaseView<SearchPresenter> {
        void changeButtonState(boolean state);
        void showLoading();
        void hideLoading();
        void showError(String error);
        void addFragment(ForecastResponse response);
    }

    interface SearchPresenter extends BasePresenter {
        void onNextClick(String city);
        void getData(String city);
        void onTextChanged(CharSequence text);
    }
}
