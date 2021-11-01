package nicuwatch.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Doctor")
@Table(name = "Doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "docId_id")
    private int id;

    @Column(name = "first_name")
    private String firstname;
    
    @Column(name = "last_name")
    private String lastname;
    
    @Column(name = "tenure")
    private int tenure;

    @OneToMany(mappedBy = "docId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Report> report = new HashSet<>();

    public Doctor() {
    }

    public Doctor(String firstname, String lastname, int tenure) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.tenure = tenure;
    }

    public Doctor(int id, String firstname, String lastname, int tenure) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.tenure = tenure;
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

    public Set<Report> getReport() {
        return report;
    }
    public void setReport(Set<Report> report) {
        this.report = report;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", tenure=" + tenure +
                '}';
    }
}
