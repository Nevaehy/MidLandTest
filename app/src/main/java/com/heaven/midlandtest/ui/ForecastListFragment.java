package com.heaven.midlandtest.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.heaven.midlandtest.R;
import com.heaven.midlandtest.model.ForecastResponse;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ForecastListFragment extends Fragment implements OnMapReadyCallback{
    private ForecastResponse forecast;
    private GoogleMap mMap;

    @BindView (R.id.list) RecyclerView recyclerView;

    public ForecastListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            forecast = getArguments().getParcelable("forecast");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        ButterKnife.bind(this, view);

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Set the adapter
        recyclerView.setAdapter(new ForecastRecyclerViewAdapter(forecast.getList()));

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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in current Location
        LatLng current = new LatLng(forecast.getCity().getCoord().getLat(), forecast.getCity().getCoord().getLon());
        mMap.addMarker(new MarkerOptions().position(current).title("Current location forecast"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(current));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(current, 8.0f));
    }
}
