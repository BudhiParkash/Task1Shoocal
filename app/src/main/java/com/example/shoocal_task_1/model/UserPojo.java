package com.example.shoocal_task_1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserPojo {
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
