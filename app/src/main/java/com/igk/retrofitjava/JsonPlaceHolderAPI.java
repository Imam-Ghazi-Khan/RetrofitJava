package com.igk.retrofitjava;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonPlaceHolderAPI {
    @GET("top-headlines")
    Call<newsAPI> getPosts(@Query("sources")String sources,@Query("apiKey")String apiKey);
}
