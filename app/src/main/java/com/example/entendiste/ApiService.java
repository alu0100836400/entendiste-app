package com.example.entendiste;

import com.example.entendiste.io.response.AsignaturasResponse;
import com.example.entendiste.io.response.LoginResponse;
import com.example.entendiste.io.response.TestResponse;
import com.example.entendiste.model.Asignatura;

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
    Call<List<Asignatura>> getAsignaturas(
            @Query("user") String user
    );

    @GET("3")
    Call<TestResponse> getOne();
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
