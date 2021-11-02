package nicuwatch.persistence;

import nicuwatch.entity.Doctor;
import nicuwatch.entity.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PatientDaoTest {

    PatientDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        dao = new PatientDao();
        DB db = DB.getInstance();
        db.runSQL("sample.sql");
    }

    @Test
    void testDelete() {
        dao.delete(dao.getByPatientId(1));
        assertNull(dao.getByPatientId(1));
    }

    @Test
    void testGetAllPatients() {
        List<Patient> patient = dao.getAll();
        assertEquals(1, patient.size());
        logger.debug("testGetAllDoctors returns: " + patient);
    }

    @Test
    void testGetByPatientId() {
        Patient patient = dao.getByPatientId(1);
        String patientString = patient.toString();
        assertNotNull(patient);
        Patient expectation = new Patient(1,"Jon", "Doe", LocalDate.parse("2021-08-06"));
        String expectationString = expectation.toString();
        Assertions.assertEquals(patientString, expectationString);
    }

    @Test
    void testInsert() {
        Patient newInsert = new Patient("New","Patient",LocalDate.parse("1995-08-21"));
        dao.insert(newInsert);
        List<Patient> patients = dao.getAll();
        assertEquals(2, patients.size());
    }

    @Test
    void testSaveOrUpdate() {
        String firstNameToUpdate = "test";
        Patient patientToUpdate = dao.getByPatientId(1);
        patientToUpdate.setFirstname(firstNameToUpdate);
        dao.saveOrUpdate(patientToUpdate);
        Patient newlyUpdatedTest = dao.getByPatientId(1);
        assertEquals(firstNameToUpdate, newlyUpdatedTest.getFirstname());
    }
}