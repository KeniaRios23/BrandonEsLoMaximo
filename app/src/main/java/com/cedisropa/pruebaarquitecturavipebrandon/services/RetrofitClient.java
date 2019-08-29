package com.cedisropa.pruebaarquitecturavipebrandon.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    private static String last_url = "";

    public RetrofitClient() {}

    public static Retrofit getClient(String baseUrl) {
        if (retrofit == null || !last_url.equals(baseUrl)) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static <T> T getService(Class<T> serviceClass, String base_url) {
        return getClient(base_url).create(serviceClass);
    }
}
