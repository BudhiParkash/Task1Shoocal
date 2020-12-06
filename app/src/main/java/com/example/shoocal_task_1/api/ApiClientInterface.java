package com.example.shoocal_task_1.api;

import com.example.shoocal_task_1.model.MainPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class ApiClientInterface {

    private static final String url = "https://api.github.com/";


    public static ApiInterface apiInterface = null;

    public  static ApiInterface getApiInterface(){
        if(apiInterface == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiInterface = retrofit.create(ApiInterface.class);
        }
        return apiInterface;


}

public interface ApiInterface{
        @GET("repositories/19438/issues")
        Call<List<MainPojo>>  getData();
    }
}
