package com.heaven.midlandtest.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.heaven.midlandtest.R;
import com.heaven.midlandtest.model.ForecastResponse;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SearchFragment extends Fragment implements ForecastMVP.SearchView {

    @BindView(R.id.edit_text_city)
    EditText etCity;
    @BindView (R.id.button_next)
    Button bNext;

    private ForecastSearchPresenter forecastPresenter;
    private ProgressDialog progressDialog;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);

        forecastPresenter = new ForecastSearchPresenter(this);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void init() {
        changeButtonState(false);
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
        bNext.setEnabled(state);
        if (state) {
            bNext.setBackgroundResource(R.color.colorButtonEnabled);
        } else {
            bNext.setBackgroundResource(R.color.colorButtonDisabled);
        }
    }

    @Override
    public void addFragment(ForecastResponse response) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ForecastListFragment fragment = new ForecastListFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelable("forecast", response);
        fragment.setArguments(bundle);

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.frag_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
    }

    public void showLoading() {
        if (progressDialog == null) {
            try {
                progressDialog = ProgressDialog.show(getActivity(), "", "Loading...");
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
