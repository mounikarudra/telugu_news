package com.example.mouni.news_tabview;

import com.example.mouni.news_tabview.Model.Student;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by MOUNI on 02-Aug-16.
 */
public interface API1 {
    @GET("/getmenuinfo/11")
    public void getObject11(Callback<Student> student);
    @GET("/getmenuinfo/12")
    public void getObject12(Callback<Student> student);
    @GET("/getmenuinfo/13")
    public void getObject13(Callback<Student> student);
    @GET("/getmenuinfo/14")
    public void getObject14(Callback<Student> student);
    @GET("/getmenuinfo/15")
    public void getObject15(Callback<Student> student);
    @GET("/getmenuinfo/16")
    public void getObject16(Callback<Student> student);
    @GET("/getmenuinfo/18")
    public void getObject18(Callback<Student> student);
    @GET("/getmenuinfo/19")
    public void getObject19(Callback<Student> student);
    @GET("/getmenuinfo/20")
    public void getObject20(Callback<Student> student);

}
