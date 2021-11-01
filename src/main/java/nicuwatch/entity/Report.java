package nicuwatch.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Report")
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "ref")
    private int reference;
    
    @Column(name = "test")
    private String test;
    
    @Column(name = "result")
    private String result;
    
    @Column(name = "notes")
    private String notes;

    //@ManyToOne
    //@JoinColumn(name = "patient_id", nullable = false)
    private String patientId;

    @ManyToOne
    @JoinColumn(name = "docId", nullable = false)
    private Doctor docId;
    
    public Report() {
    }

    public Report(String test, String result, String notes) {
        this.test = test;
        this.result = result;
        this.notes = notes;
    }

    /*
    public Report(String test, String result, String notes, String patientId, String docId) {
        this.test = test;
        this.result = result;
        this.notes = notes;
        this.patientId = patientId;
        this.docId = docId;
    }

     */

    public int getReference() {
        return reference;
    }
    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
/*
    public Doctor getDocId() {
        return docId;
    }
    public void setDocId(Doctor docId) {
        this.docId = docId;
    }
*/

    public String getTest() {
        return test;
    }
    public void setTest(String test) {
        this.test = test;
    }

    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Doctor getDoctor() {
        return docId;
    }
    public void setDoctor(Doctor docId) {
        this.docId = docId;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reference=" + reference +
                ", test='" + test + '\'' +
                ", result='" + result + '\'' +
                ", notes='" + notes + '\'' +
                ", patientId='" + patientId + '\'' +
                '}';
    }
}