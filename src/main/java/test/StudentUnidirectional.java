package test;

import entities.Student;
import entities.StudentDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class StudentUnidirectional {

    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = new Student();
        student.setEmail("email2");
        student.setName("name2");

        StudentDetails details = new StudentDetails();
        details.setCollege("college2");
        details.setEnrollmentDate(LocalDate.now());


        student.setStudentDetails(details);

        //both student and details are in NEW state
        //cascade type is ALL
        //it is enough if we persist the student into the hibernate sessioon
        session.persist(student);

        transaction.commit();

//        Student student = session.get(Student.class, 2);
//        System.out.println(student.toString()+"details: "+student.getStudentDetails());
//
//        StudentDetails studentDetails = session.get(StudentDetails.class, 2);


        session.close();
    }
}
