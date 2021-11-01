package nicuwatch.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

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

    @ManyToOne
    @JoinColumn(name = "patientId", nullable = false)
    private Patient patientId;

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

    public Report(String test, String result, String notes, Patient patientId, Doctor docId) {
        this.test = test;
        this.result = result;
        this.notes = notes;
        this.patientId = patientId;
        this.docId = docId;
    }

    public Report(int reference, String test, String result, String notes, Patient patientId, Doctor docId) {
        this.reference = reference;
        this.test = test;
        this.result = result;
        this.notes = notes;
        this.patientId = patientId;
        this.docId = docId;
    }

    public int getReference() {
        return reference;
    }
    public void setReference(int reference) {
        this.reference = reference;
    }

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

    public Patient getPatientId() {
        return patientId;
    }
    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reference=" + reference +
                ", test='" + test + '\'' +
                ", result='" + result + '\'' +
                ", notes='" + notes + '\'' +
                ", patientId='" + patientId + '\'' +
                ", docId='" + docId + '\'' +
                '}';
    }
}