package dev.patika.services;

import dev.patika.model.Course;
import dev.patika.model.Student;
import dev.patika.repository.CrudRepository;
import dev.patika.repository.StudentRepository;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CrudRepository<Student>, StudentRepository {

    EntityManager entityManager= EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("SELECT c FROM Student c",Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public boolean saveToDatabase(Student object) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(object);
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e){
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean deleteFromDatabase(Student object) {
        entityManager.getTransaction().begin();
        entityManager.remove(object);
        entityManager.getTransaction().commit();
        return false;
    }

    @Override
    public boolean deleteFromDatabase(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.createQuery("SELECT c FROM Student c WHERE c.id=:id",Student.class).setParameter("id",id).getSingleResult());
        entityManager.getTransaction().commit();
        return false;
    }

    @Override
    public void update(Student object) {
        entityManager.merge(object);
    }

    @Override
    public List<Course> getCourseFromStudent(int id) {
        return entityManager.find(Student.class,id).getCourses();
    }

    @Override
    public int getIdFromName(String name) {
        return entityManager.createQuery("SELECT c.id FROM Student c WHERE c.name=:name",Integer.class).setParameter("name",name).getSingleResult();
    }
}
