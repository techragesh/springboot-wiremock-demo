package com.techragesh.restclientdemo.model;

public class Student {

    private String studId;
    private String studName;
    private String city;
    private String phone;

    public Student() {
    }

    public Student(String studId, String studName, String city, String phone) {
        this.studId = studId;
        this.studName = studName;
        this.city = city;
        this.phone = phone;
    }

    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
