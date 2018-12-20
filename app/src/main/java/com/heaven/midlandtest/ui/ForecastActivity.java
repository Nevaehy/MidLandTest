package com.heaven.midlandtest.ui;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.heaven.midlandtest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForecastActivity extends AppCompatActivity implements ForecastMVP.View{

    @BindView(R.id.edit_text_city) EditText etCity;
    @BindView (R.id.button_next) Button bNext;

    private ForecastPresenter forecastPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        forecastPresenter = new ForecastPresenter(this);
    }

    @Override
    public void init() {
        forecastPresenter.onTextChanged(etCity.getText().toString());
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forecastPresenter.onNextClick(etCity.getText().toString());
            }
        });

        etCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                forecastPresenter.onTextChanged(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void changeButtonState(boolean state) {
        if (state) {
            bNext.setEnabled(state);
            bNext.setBackgroundResource(R.color.colorButtonEnabled);
        } else {
            bNext.setEnabled(false);
            bNext.setBackgroundResource(R.color.colorButtonDisabled);
        }
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    public void showLoading() {
        if (progressDialog == null) {
            try {
                progressDialog = ProgressDialog.show(this, "", "Loading...");
                progressDialog.setCancelable(false);
            } catch (Exception e) {

            }
        }
    }

    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        progressDialog = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if((progressDialog != null) && progressDialog.isShowing() ){
            progressDialog.dismiss();
        }
        forecastPresenter.detach();
    }
}
