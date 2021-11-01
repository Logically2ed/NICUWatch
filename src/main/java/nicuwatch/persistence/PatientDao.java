package nicuwatch.persistence;

import nicuwatch.entity.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PatientDao {
    
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /** 
     * @return Session
     */
    public Session openCurrentSession() {
        Session session = sessionFactory.openSession();
        return session;
    }

    public Patient getByPatientId(int pId) {
        Session session = openCurrentSession();
        Patient patient = session.get(Patient.class, pId);
        session.close();
        return patient;
    }

    /** 
     * @param patient
     */
    public void saveOrUpdate(Patient patient) {
        Session session = openCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(patient);
        transaction.commit();
        session.close();
    }
    
    /** 
     * @param patient
     * @return int
     */
    public int insert(Patient patient){
        int id = 0;
        Session session = openCurrentSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(patient);
        transaction.commit();
        session.close();
        return id;
    }
    
    /**
     * @param patient
     */
    public void delete(Patient patient){
        Session session = openCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(patient);
        transaction.commit();
        session.close();
    } 

    /** 
     * @return List<Patient>
     */
    public List<Patient> getAll() {

        Session session = openCurrentSession();
        //CriteriaBuilder builder = session.getCriteriaBuilder();
        //CriteriaQuery<Report> query = builder.createQuery( Report.class );
        //Root<Report> root = query.from( Report.class );
        List<Patient> patients = session.createQuery( "from Patient " ).getResultList();

        logger.debug("The list of users " + patients);
        session.close();

        return patients;
    }

}
