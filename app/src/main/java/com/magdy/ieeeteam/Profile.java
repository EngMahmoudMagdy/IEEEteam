package com.magdy.ieeeteam;

import java.io.Serializable;

/**
 * Created by engma on 9/7/2017.
 */

 class Profile implements Serializable {
    private String  id , name, password;
    private  int number;

     void setPassword(String password) {
        this.password = password;
    }

     String getPassword() {
        return password;
    }

     void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

     void setNumber(int number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
