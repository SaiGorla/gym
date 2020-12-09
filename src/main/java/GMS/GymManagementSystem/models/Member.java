/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GMS.GymManagementSystem.models;

import java.sql.Date;
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
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "NIC is mandatory")
    private String nic;
    @NotBlank(message = "Name is mandatory")
    private String name;
    private int age;
    @NotBlank(message = "Address is mandatory")
    private String address;
    @NotBlank(message = "Contact Number is mandatory")
    private String contactNumber;
    private Date membershipStartingDate;

    public Member() {

    }

    public Member(@NotBlank(message = "Name is mandatory") String name, int age,
                  @NotBlank(message = "Address is mandatory") String address, Date membershipStartingDate) {

        this.name = name;
        this.age = age;
        this.address = address;
        this.membershipStartingDate = membershipStartingDate;
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

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public Date getMembershipStartingDate() {

        return membershipStartingDate;
    }

    public void setMembershipStartingDate(Date membershipStartingDate) {

        this.membershipStartingDate = membershipStartingDate;
    }

    public String getNic() {

        return nic;
    }

    public void setNic(String nic) {

        this.nic = nic;
    }

    public String getContactNumber() {

        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {

        this.contactNumber = contactNumber;
    }
}
