package nicuwatch.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.List;

import nicuwatch.entity.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nicuwatch.entity.Doctor;
import nicuwatch.entity.Report;

public class ReportDaoTest {
    
    ReportDao dao;
    DoctorDao docDao;
    PatientDao patDao;

    private final Logger logger = LogManager.getLogger(this.getClass());


    @BeforeEach
    void setUp(){
        dao = new ReportDao();
        docDao = new DoctorDao();
        patDao = new PatientDao();

        nicuwatch.persistence.DB db = nicuwatch.persistence.DB.getInstance();
        db.runSQL("sample.sql");
    }

    @Test
    void testDelete() {
        dao.delete(dao.getByReference(2));
        assertNull(dao.getByReference(2));
    }

    @Test
    void testGetAll() {
        List<Report> reports = dao.getAll();
        assertEquals(3, reports.size());
        logger.debug("This test should return the full size of the test Report table.");
    }

    @Test
    void testGetByReference() {
        Report expectation = dao.getByReference(1);
        Patient patient = new Patient(1,"Jon", "Doe", LocalDate.parse("2021-08-06"));
        Doctor doctor = new Doctor(1,"Brad", "Wallis", 3);
        Report actual = new Report(1, "Lung Infection", "Positive", "Not a problem to be worried about.", patient, doctor);
        String i = actual.toString();
        String j = expectation.toString();
        assertNotNull(actual);
        assertEquals(j, i);
    }

    @Test
    void testInsertSuccess() {
        int oldLines = dao.getAll().size();
        Report report = new Report("Leukemia", "its fine", "its fine", patDao.getByPatientId(1), docDao.getByDocId(1));
        dao.insert(report);
        int newLines = dao.getAll().size();
        assertEquals(oldLines + 1, newLines);
    }

    @Test
    void testUpdate() {
        String stringToUpdate = "Eye";
        Report reportToUpdate = dao.getByReference(1);
        reportToUpdate.setTest(stringToUpdate);
        dao.saveOrUpdate(reportToUpdate);
        Report newlyUpdatedTest = dao.getByReference(1);
        assertEquals(stringToUpdate, newlyUpdatedTest.getTest());
    }
}
