package nicuwatch.entity;

import javax.persistence.*;

@Entity
@Table(name = "REPORTS")
public class Report {
    @Id
    @Column(name = "ref")
    private int reference;
    @Column(name = "doctor")
    private String doctor;
    @Column(name = "test")
    private String test;
    @Column(name = "result")
    private String result;
    @Column(name = "notes")
    private String notes;
    
    public Report() {
        
    }
    public int getReference() {
        return reference;
    }
    public void setReference(int reference) {
        this.reference = reference;
    }
    public String getDoctor() {
        return doctor;
    }
    public void setDoctor(String doctor) {
        this.doctor = doctor;
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
        return "TestResult [doctor=" + doctor + ", notes=" + notes + ", reference=" + reference + ", result=" + result
                + ", test=" + test + "]";
    }
}