package nicuwatch.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import nicuwatch.entity.Report;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReportDaoTest {
    
    ReportDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());


    @BeforeEach
    void setUp(){
        dao = new ReportDao();
    }

    @Test
    void testDelete() {

    }

    @Test
    void testGetAll() {
        List<Report> reports = dao.getAll();
        assertEquals(3, reports.size());
        logger.debug("this test is fine.");
    }

    @Test
    void testGetByReference() {
        Report ref = dao.getByReference(1);
        assertNotNull(ref);
        assertEquals("doctor", ref.getDoctor());
    }

    @Test
    void testInsert() {
        Report report = new Report();
        report.setDoctor("doctor");
        report.setTest("Leg SStuff");
        report.setResult("Its Fine");
        report.setNotes("I said its fine!");
        dao.insert(report);
        List<Report> reports = dao.getAll();
        assertEquals(4, reports);
    }

    @Test
    void testSaveOrUpdate() {
        String docName = "Jon";
        Report reportToUpdate = dao.getByReference(1);
    }
}
