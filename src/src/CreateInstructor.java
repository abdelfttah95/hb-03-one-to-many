package src;

import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author abdel
 */
public class CreateInstructor {
    public static void main(String[] args) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();
            
            Instructor tempInstructor = 
                    new Instructor("abdelfttah", "sameeh", "abdelfttah@email.com");
            InstructorDetail tempInstructorDetail = 
                    new InstructorDetail("yotube.com", "video games");
            
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            
            System.out.println("Saving instructor : " + tempInstructor);
            session.save(tempInstructor);
            
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
