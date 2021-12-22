package src;

import entity.Course;
import entity.Instructor;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author abdel
 */
public class CreateCourses {
    public static void main(String[] args) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();
            
            int theId = 1;
            Instructor tempInstructor = (Instructor) session.get(Instructor.class, theId);
            
            Course tempCourse1 = new Course("Java");
            Course tempCourse2 = new Course("Security");
            
            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);
            
            session.save(tempCourse1);
            session.save(tempCourse2);
            
            session.getTransaction().commit();
            System.out.println("Done.");
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }
}
