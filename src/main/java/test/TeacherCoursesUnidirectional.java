package test;

import entities.Course;
import entities.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TeacherCoursesUnidirectional {

    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Course course1 = new Course();
        course1.setDetails("java1");
        course1.setName("java1");

        Course course2 = new Course();
        course2.setDetails("react1");
        course2.setName("react1");

        Teacher teacher = session.get(Teacher.class, 1);

        course1.setTeacher(teacher);
        course2.setTeacher(teacher);

        //teacher is in PERSISTENT state and is not aware of teacherDetails
        //=>we do nothing with it

        //both courses are in NEW state, we must persist them into the
        //hibernate session
        session.persist(course2);
        session.persist(course1);

        transaction.commit();
        session.close();
    }
}
