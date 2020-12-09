/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GMS.GymManagementSystem.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Sai Rohith Gorla
 */
@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    private int age;
    @NotBlank(message = "Licence number is mandatory")
    private String licenceNumber;
    private String contactNumber;
    private int experience;

    public Instructor() {

    }

    public Instructor(@NotBlank(message = "Name is mandatory") String name, int age,
                      @NotBlank(message = "Licence number is mandatory") String licenceNumber, int experience) {

        this.name = name;
        this.age = age;
        this.licenceNumber = licenceNumber;
        this.experience = experience;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public String getLicenceNumber() {

        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {

        this.licenceNumber = licenceNumber;
    }

    public int getExperience() {

        return experience;
    }

    public void setExperience(int experience) {

        this.experience = experience;
    }

    public String getContactNumber() {

        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {

        this.contactNumber = contactNumber;
    }
}
