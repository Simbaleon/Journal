package com.journal;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Server {

    @GET("aut/login")
    Call<JSONObject> checkTeacherFromServer(String login, String pass);

    @POST("setTeacher")
    Call<JSONObject> registerTeacherToServer(String Login, String password, String name, String surname, String position, String email, String phone, String quality);

    @GET("aut/login")
    Call<JSONObject> checkPupilFromServer(String login, String pass);

    @POST("auth/register")
    Call<JSONObject> registerPupulToServer(String Login, String password, String name, String surname, String position, String email, String phone, String quality);

    @GET("auth/login")
    Call<JSONObject> checkParentFromServer();

    @POST("auth/register")
    Call<JSONObject> registerParentToServer(String Login, String password, String name, String surname, String position, String email, String phone, String quality);

    @POST("getTeacherSchool")
    Call<JSONObject> getTeacherSchoolFromServer();
}

