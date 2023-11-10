package kibera.dron_project.domain;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "surname")
    private String surname;

    @ManyToOne
    private Organization organization;

    @ManyToOne
    private Position position;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "pasport_data")
    private String pasportData;

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

    public Employee position(Position position) {
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
