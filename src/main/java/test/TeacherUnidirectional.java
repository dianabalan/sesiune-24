package test;

import entities.Teacher;
import entities.TeacherDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TeacherUnidirectional {

    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Teacher teacher = new Teacher();
        teacher.setEmail("email44");
        teacher.setName("teacher4");

        TeacherDetails teacherDetails = new TeacherDetails();
        teacherDetails.setAddress("address4");
        teacherDetails.setCollege("college4");

        //this generates an id and sets it in the teacher instance
        session.persist(teacher);

        //teacher details associated with previously mentioned teacher
        teacherDetails.setTeacher(teacher);

        //we must persist also the teacher details
        session.persist(teacherDetails);

        transaction.commit();
        session.close();
    }
}
