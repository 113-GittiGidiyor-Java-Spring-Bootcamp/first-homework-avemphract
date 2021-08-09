package dev.patika.model;

import java.util.Arrays;
import java.util.List;

public abstract class Instructor {
    String name;
    String address;
    double phoneNumber;
    List<Course> courses;

    public Instructor(String name, String address, double phoneNumber, Course... courses) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.courses = Arrays.asList(courses);
    }

    public Instructor() {
    }

    //getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(double phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
