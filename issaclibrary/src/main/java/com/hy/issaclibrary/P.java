package com.hy.issaclibrary;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author issac
 * @version 1.0.0
 * @Description
 * @Date 2020/7/2 9:59
 */
public class P {
    public static void show(Context context,String id ,String name){
        Student s=new Student(id,name);
        Gson g=new GsonBuilder().create();
        String ss=g.toJson(s);
        Toast.makeText(context,ss+"build 2.0---",Toast.LENGTH_LONG).show();
    }
}
