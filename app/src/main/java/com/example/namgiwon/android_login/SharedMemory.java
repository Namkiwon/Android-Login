package com.example.namgiwon.android_login;

/**
 * Created by namgiwon on 2018. 1. 21..
 */


public class SharedMemory {
    private static SharedMemory sharedMemory = null;

    public static synchronized SharedMemory getinstance(){
        if(sharedMemory == null){
            sharedMemory = new SharedMemory();
        }
        return sharedMemory;
    }
    private String resultString;
    private UserInfoVO userinfo;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserInfoVO getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserInfoVO userinfo) {
        this.userinfo = userinfo;
    }

    public String getResultString() {
        return resultString;
    }

    public void setResultString(String resultString) {
        this.resultString = resultString;
    }

}