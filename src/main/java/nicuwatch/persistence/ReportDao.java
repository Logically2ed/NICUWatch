package nicuwatch.persistence;

import java.util.List;

import nicuwatch.entity.Doctor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import nicuwatch.entity.Report;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

public class ReportDao {
    
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    
    /** 
     * @return Session
     */
    public Session openCurrentSession() {
        Session session = sessionFactory.openSession();
        return session;
    }

    /**
     * @return List<Report>
     */
    public List<Report> getAll() {

        Session session = openCurrentSession();
        List<Report> reports = session.createQuery( "from Report " ).getResultList();

        logger.debug("The list of users " + reports);
        session.close();

        return reports;
    }

    /** 
     * @param id
     * @return Report
     */
    public Report getByReference(int id) {
        Session session = openCurrentSession();
        Report report = session.get( Report.class, id );
        session.close();
        return report;
    }
    
    /** 
     * @param report
     */
    public void saveOrUpdate(Report report) {
        Session session = openCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(report);
        transaction.commit();
        session.close();
    }

    /** 
     * @param report
     * @return int
     */
    public int insert(Report report){
        int id = 0;
        Session session = openCurrentSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(report);
        transaction.commit();
        session.close();
        return id;
    }
    
    /** 
     * @param report
     */
    public void delete(Report report){
        Session session = openCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(report);
        transaction.commit();
        session.close();
    }

    public List<Report> getReportByDoctorId(int docId) {
        Session session = openCurrentSession();

        logger.debug("The list of reports associated to the doctor: ");

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Report> query = builder.createQuery( Report.class );
        Root<Report> root = query.from(Report.class);
        query.select(root).where(builder.equal(root.get("docId"), docId));
        List<Report> reports = session.createQuery( query ).getResultList();

        session.close();
        return reports;
    }
}
