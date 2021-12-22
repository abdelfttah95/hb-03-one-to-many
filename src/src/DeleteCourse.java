package src;

import entity.Course;
import entity.Instructor;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author abdel
 */
public class DeleteCourse {
    public static void main(String[] args) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();
            
            int theId = 10;
            Course tempCourse = (Course) session.get(Course.class, theId);
            
            System.out.println("Deleting Course : " + tempCourse);
            session.delete(tempCourse);
            
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
