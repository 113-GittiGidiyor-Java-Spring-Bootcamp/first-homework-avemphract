package dev.patika.model;

import java.util.Objects;

public class PermanentInstructor extends Instructor {
    double constantSalary;

    public PermanentInstructor(String name, String address, double phoneNumber, double constantSalary, Course... courses) {
        super(name, address, phoneNumber, courses);
        this.constantSalary = constantSalary;
    }

    public PermanentInstructor() {
    }

    //getter setter
    public double getConstantSalary() {
        return constantSalary;
    }

    public void setConstantSalary(double constantSalary) {
        this.constantSalary = constantSalary;
    }

    //object overriding
    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermanentInstructor that = (PermanentInstructor) o;
        return Double.compare(that.constantSalary, constantSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(constantSalary);
    }
}
