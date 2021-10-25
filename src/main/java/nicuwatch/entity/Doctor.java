package nicuwatch.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "doctor")
@Table(name = "DOCTORS")
public class Doctor {
    @Id
    private String docId;

    @Column(name = "firstName")
    private String firstname;
    
    @Column(name = "lastName")
    private String lastname;
    
    @Column(name = "tenure")
    private int tenure;

    @OneToMany
    private Report report;

    @OneToMany(mappedBy = "REPORTS", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Doctor> report = new HashSet<>();

    public Doctor() {
    }

    public Doctor(String docId, String firstname, String lastname, int tenure, Report report) {
        this.docId = docId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.tenure = tenure;
        this.report = report;
    }

    public String getDocId() {
        return docId;
    }
    public void setDocId(String docId) {
        this.docId = docId;
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
