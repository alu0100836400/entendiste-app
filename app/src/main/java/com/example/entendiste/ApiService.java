package com.example.entendiste;

import com.example.entendiste.io.response.AsignaturasResponse;
import com.example.entendiste.io.response.LoginResponse;
import com.example.entendiste.io.response.TemasResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("login")
    Call<LoginResponse> getLogin(                   //argumentos que le pasas a la api
            @Query("username") String username,
            @Query("password") String password
    );

    @GET("asignaturas")
    Call<List<AsignaturasResponse>> getAsignaturas(
            @Query("user") String user
    );

    @GET("temas")
    Call<List<TemasResponse>> getOne();
/*
    @FormUrlEncoded
    @POST("product")
    Call<SimpleResponse> postNewProduct(
            @Field("code") String code,
            @Field("name") String name,
            @Field("description") String description
    );

 */
}
