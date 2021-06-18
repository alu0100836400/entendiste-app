package com.example.entendiste;

import com.example.entendiste.io.response.AsignaturasResponse;
import com.example.entendiste.io.response.LoginResponse;
import com.example.entendiste.io.response.RespuestaResponse;
import com.example.entendiste.io.response.TemasResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
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

    @GET("preguntas")
    Call<List<TemasResponse>> getTemas(
            @Query("idAsignatura") String idAsignatura
    );

    @GET("respuesta")
    Call<RespuestaResponse> getRespuesta(
            @Query("idPregunta") int idPregunta,
            @Query("user") String user
    );

    @FormUrlEncoded
    @POST("respuesta")
    Call<RespuestaResponse> setRespuesta(
            @Field("idPregunta") int idPregunta,
            @Field("user") String user,
            @Field("respuesta") boolean respuesta
    );
}
