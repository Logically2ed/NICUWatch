package nicuwatch.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "REPORTS")
public class Report {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    //@Column(name = "ref")
    private int reference;
    @Column(name = "patientId")
    private String patientId;
    @Column(name = "docId")
    private String docId;
    @Column(name = "test")
    private String test;
    @Column(name = "result")
    private String result;
    @Column(name = "notes")
    private String notes;
    
    public Report() {
        
    }

    public Report(String patientId, String docId, String test, String result, String notes) {
        this.patientId = patientId;
        this.docId = docId;
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
    public String getDocId() {
        return docId;
    }
    public void setDocId(String docId) {
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

    @Override
    public String toString() {
        return "Report [docId=" + docId + ", notes=" + notes + ", patientId=" + patientId + ", reference=" + reference
                + ", result=" + result + ", test=" + test + "]";
    }
    

}