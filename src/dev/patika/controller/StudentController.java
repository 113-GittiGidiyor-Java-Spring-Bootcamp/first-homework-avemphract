package dev.patika.controller;

import dev.patika.model.Course;
import dev.patika.model.Student;
import dev.patika.services.StudentService;

import java.util.List;

public class StudentController {
    private final StudentService studentService=new StudentService();

    public Student findStudent(int id){
        return studentService.findById(id);
    }

    public List<Student> findAllStudents(){
        return studentService.findAll();
    }

    public boolean saveStudent(Student student){
        return studentService.saveToDatabase(student);
    }

    public void update(Student student){
        studentService.update(student);
    }

    public void deleteFromDatabase(Student student){
        studentService.deleteFromDatabase(student);
    }

    public void deleteFromDatabase(int id){
        studentService.deleteFromDatabase(id);
    }

    public int getIdFromName(String name){
        return studentService.getIdFromName(name);
    }


    public List<Course> getCourseFromStudent(int id){
        return studentService.findById(id).getCourses();
    }
}
