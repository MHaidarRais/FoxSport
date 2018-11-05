package com.rais.haidar.foxsport.Network;

import com.rais.haidar.foxsport.main.model.ResponseFoxSport;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("top-headlines?sources=fox-news&apiKey=742f9c39ed6c4d5c8874aadb10b34b79")
    Call<ResponseFoxSport> getFox(
    );
}
