package com.heaven.midlandtest.ui;

import com.heaven.midlandtest.ui.base.BasePresenter;
import com.heaven.midlandtest.ui.base.BaseView;

public interface ForecastMVP {
    interface View extends BaseView<Presenter> {
        void changeButtonState(boolean state);
        void showLoading();
        void hideLoading();
        void showError(String error);
    }

    interface Presenter extends BasePresenter {
        void onNextClick(String city);
        void getData(String city);
        void onTextChanged(CharSequence text);
    }
}
