package test;

import entities.Course;
import entities.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class TeacherCoursesBidirectional {

    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Course course1 = new Course();
        course1.setDetails("java3");
        course1.setName("java3");

        Course course2 = new Course();
        course2.setDetails("react3");
        course2.setName("react3");

        Teacher teacher = session.get(Teacher.class, 1);

        course1.setTeacher(teacher);
        course2.setTeacher(teacher);

        //teacher is already in PERSISTENT STATE
        //both courses are in NEW state
        //=> we must persist them into the hibernate session
        session.persist(course1);
        session.persist(course2);

        transaction.commit();
        session.close();
    }
}
