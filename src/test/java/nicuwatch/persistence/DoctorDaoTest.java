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

import nicuwatch.entity.Doctor;

public class DoctorDaoTest {

    DoctorDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        dao = new DoctorDao();
        DB db = DB.getInstance();
        db.runSQL("sample.sql");
    }

    @Test
    void testDelete() {
        dao.delete(dao.getByDocId("bWallis"));
        assertNull(dao.getByDocId("bWallis"));
    }

    @Test
    void testGetAll() {
        List<Doctor> doctors = dao.getAll();
        assertEquals(3, doctors.size());
        logger.debug("testGetAll returns: " + doctors);
    }

    @Test
    void testGetByPatientId() {
        Doctor doct = dao.getByDocId("bWallis");
        assertNotNull(doct);
        Doctor expectation = new Doctor("bWallis","Brad","Wallis",10);
        assertTrue(doct.equals(expectation));
    }

    @Test
    void testInsert() {
        Doctor newInsert = new Doctor("bWallis","Brad","Wallis",10);
        dao.insert(newInsert);
        List<Doctor> doctors = dao.getAll();
        assertEquals(4, doctors.size());
    }

    @Test
    void testSaveOrUpdate() {
        String stringToUpdate = "Eye";
        Doctor reportToUpdate = dao.getByDocId("bWallis");
        reportToUpdate.setTenure(3);
        dao.saveOrUpdate(reportToUpdate);
        Doctor newlyUpdatedTest = dao.getByDocId("bWallis");
        assertEquals(stringToUpdate, newlyUpdatedTest.getTenure());
    }

    // TODO test to test foreign key assignment
}
