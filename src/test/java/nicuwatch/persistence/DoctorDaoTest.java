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
    void testGetAllDoctors() {
        List<Doctor> doctors = dao.getAll();
        assertEquals(3, doctors.size());
        logger.debug("testGetAllDoctors returns: " + doctors);
    }

    @Test
    void testGetByPatientId() {
        Doctor doct = dao.getByDocId(1);
        String doctString = doct.toString();
        assertNotNull(doct);
        Doctor expectation = new Doctor("Brad","Wallis",3);
        String expectationString = expectation.toString();
        Assertions.assertEquals(doctString, expectationString);
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
        int tenureToUpdate = 101;
        Doctor doctorToUpdate = dao.getByDocId(1);
        doctorToUpdate.setTenure(101);
        dao.saveOrUpdate(doctorToUpdate);
        Doctor newlyUpdatedTest = dao.getByDocId(1);
        assertEquals(tenureToUpdate, newlyUpdatedTest.getTenure());
    }

    // TODO test to test foreign key assignment
}
