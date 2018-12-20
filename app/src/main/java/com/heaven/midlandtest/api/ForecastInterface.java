package com.heaven.midlandtest.api;

import com.heaven.midlandtest.model.ForecastResponse;
import com.heaven.midlandtest.utils.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ForecastInterface {

    @GET("forecast")
    Call<ForecastResponse> getForecast(@Query("q") String query,
                                       @Query("mode") String mode,
                                       @Query("appid") String appId);

    class Creator {
        public static ForecastInterface getRetrofitClient() {
            Retrofit.Builder builder;
            Retrofit retrofit;

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            builder =
                    new Retrofit.Builder()
                            .baseUrl(Constants.FORECAST_ENDPOINT)
                            .addConverterFactory(
                                    GsonConverterFactory.create()
                            );

            retrofit =
                    builder
                            .client(
                                    httpClient.build()
                            )
                            .build();

            return retrofit.create(ForecastInterface.class);
        }
    }

}
