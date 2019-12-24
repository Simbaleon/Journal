package com.journal;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Server {

@GET("myPerson")
    Call<JSONObject> checkFromServer(String login, String password);

@GET("getRasp")
    Call<JSONObject> getRaspFropServer (int id, int data);

@GET("getStudent")
    Call<JSONObject> getStudentFromServer (String login, String password);

@GET("setStudentElective")
    Call<JSONObject> setStudentElectiveToServer(int id, String electiveName);

@GET("deleteStudentElective")
    Call<JSONObject> deleteStudentElectiveFromSetvet (int id, String electiveName);

@GET("getTeacher")
    Call<JSONObject> getTeacherFromServer (String login, String password);

@GET("getTeacherSchool")
    Call<JSONObject> getTeacherSchoolFromServer ();

@POST("setDz")
    void setDzToServer (int id, String predmet, String dz);

@POST("setmark")
    void setMarkToServer (int id, String predmet, int mark);
}

