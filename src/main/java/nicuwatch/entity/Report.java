package nicuwatch.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "report")
@Table(name = "REPORTS")
public class Report {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    //@Column(name = "ref")
    private int reference;

    @Column(name = "patientId")
    private String patientId;

    private Doctor docId;
    
    @Column(name = "test")
    private String test;
    
    @Column(name = "result")
    private String result;
    
    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "REPORTS", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Doctor> report = new HashSet<>();
    
    public Report() {
    }

    public Report(String patientId, String test, String result, String notes) {
        this.patientId = patientId;
        this.test = test;
        this.result = result;
        this.notes = notes;
    }

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

    public Doctor getDocId() {
        return docId;
    }
    public void setDocId(Doctor docId) {
        this.docId = docId;
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

    public Set<Doctor> getReport() {
        return report;
    }

    public void setReport(Set<Doctor> report) {
        this.report = report;
    }

    @Override
    public String toString() {
        return "Report [docId=" + docId + ", notes=" + notes + ", patientId=" + patientId + ", reference=" + reference
                + ", result=" + result + ", test=" + test + "]";
    }
    

}