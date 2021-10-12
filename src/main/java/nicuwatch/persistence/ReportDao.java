package nicuwatch.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
import nicuwatch.entity.Report;

public class ReportDao {
    
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public Session openCurrentSession() {
        return null; // TODO: add a return

    }

    public Report getByReference(int id) {
        return null;
        
    }
    public void saveOrUpdate(Report report) {

    }
    public int insert(Report report){
        return 0;
    }
    public void delete(Report report){

    }
    public List<Report> getAll() {

        return null;
    }
}
