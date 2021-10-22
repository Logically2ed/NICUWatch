package nicuwatch.entity;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "DOCTORS")
public class Doctor {
    @Id
    @Column(name = "docId")
    private String docId;
    @Column(name = "firstName")
    private String firstname;
    @Column(name = "lastName")
    private String lastname;
    @Column(name = "tenure")
    private int tenure;
    
    public Doctor() {

    }

    public Doctor(String docId, String firstname, String lastname, int tenure) {
        this.docId = docId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.tenure = tenure;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String patientId) {
        this.docId = patientId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    @Override
    public String toString() {
        return "Doctor [birthDate=" + tenure + ", firstname=" + firstname + ", lastname=" + lastname + ", docId="
                + docId + "]";
    }
    

}
