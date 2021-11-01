package nicuwatch.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Patient")
@Table(name = "Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "patient_id")
    private int id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "birth_date")
    private LocalDate bday;

    @OneToMany(mappedBy = "docId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Report> report = new HashSet<>();

    public Patient() {
    }

    public Patient(String docId, String firstname, String lastname, LocalDate tenure) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.bday = tenure;
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
        return bday;
    }
    public void setTenure(int tenure) {
        this.bday = tenure;
    }

    public Set<Report> getReport() {
        return report;
    }
    public void setReport(Set<Report> report) {
        this.report = report;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", tenure=" + bday +
                ", report=" + report +
                '}';
    }
}
