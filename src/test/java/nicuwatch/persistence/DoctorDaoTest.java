package nicuwatch.persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

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
        dao.delete(dao.getByDocId(1));
        assertNull(dao.getByDocId(1));
    }

    @Test
    void testGetAll() {
        List<Doctor> doctors = dao.getAll();
        assertEquals(3, doctors.size());
        logger.debug("testGetAll returns: " + doctors);
    }

    @Test
    void testGetByPatientId() {
        Doctor doct = dao.getByDocId(1);
        assertNotNull(doct);
        Doctor expectation = new Doctor(1,"Brad","Wallis",10);
        Assertions.assertEquals(doct, expectation);
    }

    @Test
    void testInsert() {
        Doctor newInsert = new Doctor("New","Doctor",121);
        dao.insert(newInsert);
        List<Doctor> doctors = dao.getAll();
        assertEquals(4, doctors.size());
    }

    @Test
    void testSaveOrUpdate() {
        String stringToUpdate = "Eye";
        Doctor reportToUpdate = dao.getByDocId(1);
        reportToUpdate.setTenure(3);
        dao.saveOrUpdate(reportToUpdate);
        Doctor newlyUpdatedTest = dao.getByDocId(1);
        assertEquals(stringToUpdate, newlyUpdatedTest.getTenure());
    }

    // TODO test to test foreign key assignment
}
