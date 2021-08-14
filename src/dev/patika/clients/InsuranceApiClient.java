package dev.patika.clients;

import dev.patika.controller.StudentController;
import dev.patika.model.*;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

public class InsuranceApiClient {
    public static void main(String[] args) {
        //saveDate();
        StudentController studentController=new StudentController();
        //Student student=new Student("Emirhan Akar",LocalDate.of(2000,Month.FEBRUARY,4),"Denizli","Erkek");
        //studentController.saveStudent(student);

        deleteData();
        for(Student s:studentController.findAllStudents()){
            System.out.print(studentController.getIdFromName(s.getName()));
            System.out.println(s.toString());
        }
    }

    private static void deleteData(){
        StudentController studentController=new StudentController();
        studentController.deleteFromDatabase(studentController.getIdFromName("Emre Çatalkaya"));
    }

    private static void saveDate(){

        GuestInstructor instructor1=new GuestInstructor("Bartu Baran","Konya",+904512314778L,45);
        GuestInstructor instructor2=new GuestInstructor("Nurcihan Çağlayan","Artvin",+907415423247L,60);
        RegularInstructor instructor3=new RegularInstructor("Furkan Gözleyen","İstanbul",+905412135674L,2500);

        Course course1=new Course("Mukavvemet","MUK201",3.5f,instructor1);
        Course course2=new Course("Robotik","ROB303",2.5f,instructor2);
        Course course3=new Course("İngilizce","ING102",3,instructor3);
        Course course4=new Course("Akışkanlar mekaniği","AKM201",3.5f,instructor1);
        Course course5=new Course("Lineer Cebir","MAT212",3,instructor3);

        Student student1=new Student("Aslı Günder",LocalDate.of(1995,Month.AUGUST,17),"Ankara","Kadın",null);
        Student student2=new Student("Emre Çatalkaya", LocalDate.of(1998, Month.APRIL,5),"Eskişehir","Erkek",null);
        Student student3=new Student("Arda Adalan",LocalDate.of(2000,Month.DECEMBER,1),"Samsun","Erkek",null);
        Student student4=new Student("Betül Bahtıl",LocalDate.of(1999,Month.OCTOBER,19),"Diyarbakır","Kadın",null);
        Student student5=new Student("Güler Gündüz", LocalDate.of(1997, Month.JANUARY,25),"İstanbul","Kadın",null);
        Student student6=new Student("Osman Yıldıray",LocalDate.of(2000,Month.JUNE,9),"Rize","Erkek",null);
        Student student7=new Student("Elif Dere Çetin",LocalDate.of(1996,Month.NOVEMBER,27),"Ankara","Kadın",null);
        Student student8=new Student("Deniz Can Çağlayan", LocalDate.of(1999, Month.SEPTEMBER,15),"Eskişehir","Erkek",null);
        Student student9=new Student("Mehmet Yavuz Yağdıran",LocalDate.of(1996,Month.DECEMBER,6),"Ağrı","Erkek",null);

        instructor1.getCourses().add(course1);  course1.setInstructor(instructor1);
        instructor1.getCourses().add(course2);  course2.setInstructor(instructor1);
        instructor2.getCourses().add(course3);  course3.setInstructor(instructor2);
        instructor3.getCourses().add(course4);  course4.setInstructor(instructor3);
        instructor3.getCourses().add(course5);  course5.setInstructor(instructor3);

        student1.setCourses(Arrays.asList(course1,course2,course3));
        student2.setCourses(Arrays.asList(course1,course2,course4));
        student3.setCourses(Arrays.asList(course1,course2,course5));
        student4.setCourses(Arrays.asList(course1,course3,course4));
        student5.setCourses(Arrays.asList(course1,course3,course5));
        student6.setCourses(Arrays.asList(course1,course4,course5));
        student7.setCourses(Arrays.asList(course2,course3,course4));
        student8.setCourses(Arrays.asList(course2,course3,course5));
        student9.setCourses(Arrays.asList(course2,course4,course5));

        EntityManager entityManager= EntityManagerUtils.getEntityManager("mysqlPU");
        saveObject(entityManager,
                instructor1,instructor2,instructor3,
                course1,course2,course3,course4,course5,
                student1,student2,student3,student4,student5,student6,student7,student8,student9);

        EntityManagerUtils.cleanEntityManager(entityManager);
    }
    private static void saveObject(EntityManager entityManager,Object... objects){
        entityManager.getTransaction().begin();
        try {
            for (Object object:objects){
                entityManager.persist(object);
            }
            entityManager.getTransaction().commit();
            System.out.println("All data persisted");
        }
        catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            System.out.println("Persisted data roll back");
        }
    }
}
