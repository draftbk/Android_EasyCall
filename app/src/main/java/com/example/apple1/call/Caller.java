package com.example.apple1.call;

/**
 * Created by apple1 on 2015/8/30.
 */
public class Caller {
    private String name;
    private String phonenumber;

    public Caller(String name, String phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
