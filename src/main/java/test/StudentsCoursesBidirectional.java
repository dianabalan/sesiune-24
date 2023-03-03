package test;

import entities.Course;
import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StudentsCoursesBidirectional {

    public static void main(String[] args) {


        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Course course1 = session.get(Course.class, 1);
        Course course2 = session.get(Course.class, 2);

        Student student1 = session.get(Student.class, 1);
        Student student2 = session.get(Student.class, 2);

        course1.setStudents(Arrays.asList(student1, student2));
        course2.setStudents(Arrays.asList(student1));

        student1.setCourses(Arrays.asList(course1,course2));
        student2.setCourses(Arrays.asList(course1));

        //student1 and student2 entities are in PERSISTED state
        //=> any update on their fields will be persisted into the db
        //when commit is called
        //=> no need to call persist/merge

        transaction.commit();
        session.close();
    }
}
