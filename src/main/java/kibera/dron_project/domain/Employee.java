package kibera.dron_project.domain;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Table(name="employee")
@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "surname")
    private String surname;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Organization organization;

    @Column(name = "position")
    private String position;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "pasport_data")
    private String pasportData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getPasportData() {
        return pasportData;
    }

    public void setPasportData(String pasportData) {
        this.pasportData = pasportData;
    }

    public Employee id(Long id) {
        this.id = id;
        return this;
    }

    public Employee firstName(String firstName) {
        this.firstName = firstName;
        return  this;
    }

    public Employee lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Employee surname(String surname) {
        this.surname = surname;
        return this;
    }

    public Employee organization(Organization organization) {
        this.organization = organization;
        return this;
    }

    public Employee position(String position) {
        this.position = position;
        return this;
    }

    public Employee birthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public Employee placeOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
        return this;
    }

    public Employee pasportData(String pasportData) {
        this.pasportData = pasportData;
        return this;
    }
}
