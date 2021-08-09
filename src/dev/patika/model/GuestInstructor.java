package dev.patika.model;

import java.util.Objects;

public class GuestInstructor extends Instructor {
    double hourlySalary;

    public GuestInstructor(String name, String address, double phoneNumber, double hourlySalary, Course... courses) {
        super(name, address, phoneNumber, courses);
        this.hourlySalary=hourlySalary;
    }

    public GuestInstructor() {
        super();
    }

    //getter setter
    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    //object overriding
    @Override
    public String toString() {
        return "GuestInstructor{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuestInstructor that = (GuestInstructor) o;
        return Double.compare(that.hourlySalary, hourlySalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hourlySalary);
    }
}
