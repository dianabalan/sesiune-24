package test;

import entities.Teacher;
import entities.TeacherDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TeacherBidirectional {

    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Teacher teacher = new Teacher();
        teacher.setEmail("email22");
        teacher.setName("teacher1");

        TeacherDetails teacherDetails = new TeacherDetails();
        teacherDetails.setAddress("address1");
        teacherDetails.setCollege("college1");

        session.persist(teacher);

        teacherDetails.setTeacher(teacher);
       // teacher.setTeacherDetails(teacherDetails);

        session.merge(teacher);

        transaction.commit();
        session.close();
    }
}
