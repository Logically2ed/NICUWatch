package nicuwatch.persistence;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import nicuwatch.entity.Doctor;

public class DoctorDao {
    
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /** 
     * @return Session
     */
    public Session openCurrentSession() {
        Session session = sessionFactory.openSession();
        return session;
    }

    public Doctor getByDocId(String dId) {
        Session session = openCurrentSession();
        Doctor doctor = session.get(Doctor.class, dId);
        session.close();
        return doctor;
    }

    /** 
     * @param doctor
     */
    public void saveOrUpdate(Doctor doctor) {
        Session session = openCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(doctor);
        transaction.commit();
        session.close();
    }
    
    /** 
     * @param doctor
     * @return int
     */
    public int insert(Doctor doctor){
        int id = 0;
        Session session = openCurrentSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(doctor);
        transaction.commit();
        session.close();
        return id;
    }
    
    // FIXME i think in order to delete a row in the doctors table i ned to reassign a doctor to the associated rows first. This will probably have to be a palce holder name. Likely something that will present a flag for NULL doctor.
    /** 
     * @param doctor
     */
    public void delete(Doctor doctor){
        Session session = openCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(doctor);
        transaction.commit();
        session.close();
    } 

    /** 
     * @return List<Doctor>
     */
    public List<Doctor> getAll() {

        Session session = openCurrentSession();
        //CriteriaBuilder builder = session.getCriteriaBuilder();
        //CriteriaQuery<Report> query = builder.createQuery( Report.class );
        //Root<Report> root = query.from( Report.class );
        List<Doctor> doctors = session.createQuery( "from Doctor " ).getResultList();

        logger.debug("The list of users " + doctors);
        session.close();

        return doctors;
    }

}
