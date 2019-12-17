package com.example.watchio.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.watchio.Retrofit.ApiInterface.BASE_URL;

public class RetrofitClient {

    public ApiInterface apiInterface;
    private static RetrofitClient INSTANCE;


    public static RetrofitClient getInstance(){

        if (INSTANCE == null) {
            INSTANCE = new RetrofitClient();
          Retrofit  retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        INSTANCE.setApiInterface(apiInterface);

        }
        return INSTANCE;
    }

    private void setApiInterface(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }
    public ApiInterface getApiInterface() {
        return apiInterface;
    }
}
