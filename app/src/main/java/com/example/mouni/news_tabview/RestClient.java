package com.example.mouni.news_tabview;

/**
 * Created by MOUNI on 05-Aug-16.
 */
public class RestClient {
    //You need to change the IP if you testing environment is not local machine
    //or you may have different URL than we have here
    private static final String URL = "http://varthalu.com/";
    private retrofit.RestAdapter restAdapter;
    private API1 studentService;

    public RestClient()
    {

        restAdapter = new retrofit.RestAdapter.Builder()
                .setEndpoint(URL)
                .setLogLevel(retrofit.RestAdapter.LogLevel.FULL)
                .build();

        studentService = restAdapter.create(API1.class);
    }

    public API1 getService()
    {
        return studentService;
    }
}


