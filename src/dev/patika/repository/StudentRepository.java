package dev.patika.repository;

import dev.patika.model.Course;
import dev.patika.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Course> getCourseFromStudent(int id);
    int getIdFromName(String name);
}
