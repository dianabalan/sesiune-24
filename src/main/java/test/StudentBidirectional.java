package test;

import entities.Student;
import entities.StudentDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class StudentBidirectional {

    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = new Student();
        student.setEmail("email1");
        student.setName("name1");

        StudentDetails details = new StudentDetails();
        details.setCollege("college");
        details.setEnrollmentDate(LocalDate.now());

        student.setStudentDetails(details);
        //uncomment this when student - studentDetails have bidirectional mapping strategy
       // details.setStudent(student);

        //student is in NEW state
        //student details is in NEW state
        //cascade type is ALL
        //=> it is enough to persist the student into the hibernate session
        session.persist(student);

     //   StudentDetails studentDetails = session.get(StudentDetails.class, 1);

        //System.out.println(studentDetails.toString() + ", student :" + studentDetails.getStudent().toString());

        transaction.commit();
        session.close();
    }
}
