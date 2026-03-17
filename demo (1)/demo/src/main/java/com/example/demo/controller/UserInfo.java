package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo {
    @JsonProperty("id")
    private long id;
    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("lastname")
    private String lastName;
    @JsonProperty("age")
    private Integer age;

    public UserInfo() {
    }

    //public UserInfo(long id, String firstName, String lastName) {
        //this.id = id;
        //this.firstName = firstName;
        //this.lastName = lastName;
    //}

    public UserInfo(long id, String firstName, String lastName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
