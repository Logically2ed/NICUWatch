package nicuwatch.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nicuwatch.entity.Report;

public class ReportDaoTest {
    
    ReportDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());


    @BeforeEach
    void setUp(){
        dao = new ReportDao();

        DB db = DB.getInstance();
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
        logger.debug("this test returns something.");
    }

    @Test
    void testGetByReference() {
        Report ref = dao.getByReference(1);
        Report expectation = new Report("jDoe", "bWallis", "Lung Infection", "Positive", "Not a problem to be worried about.");
        assertNotNull(ref);
        assertTrue(ref.equals(expectation));
        //assertEquals("jDoe", ref.getPatientId());
        //assertEquals("bWallis", ref.getDocId());
        //assertEquals("Lung Infection", ref.getTest());
        //assertEquals("Positive", ref.getResult());
        //assertEquals("Not a problem to be worried about.", ref.getNotes());
    }

    @Test
    // TODO confirgure to resemble sample work.
    void testInsert() {
        //Report newInsert = new Report(0, "jDoe", "bWallis", "Lung Infection", "Positive", "Not a problem to be worried about.");
        Report report = new Report();
        report.setPatientId("jDoe");
        report.setDocId("jMadden");
        report.setTest("Luchemia");
        report.setResult("It's Fine");
        report.setNotes("I said its fine!");
        //dao.insert(newInsert);
        dao.insert(report);
        List<Report> reports = dao.getAll();
        assertEquals(4, reports.size());
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
