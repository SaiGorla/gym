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
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Member name is mandatory")
    private String memberName;
    @NotBlank(message = "Instructor name is mandatory")
    private String instructorName;
    private Date startDate;
    private Date endDate;
    private String notes;

    public Schedule() {

    }

    public Schedule(
            @NotBlank(message = "Member name is mandatory") String memberName,
            @NotBlank(message = "Instructor name is mandatory") String instructorName, Date startDate,
            Date endDate, String notes) {

        this.memberName = memberName;
        this.instructorName = instructorName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.notes = notes;
    }

    public Schedule(int id,
                    @NotBlank(message = "Member name is mandatory") String memberName,
                    @NotBlank(message = "Instructor name is mandatory") String instructorName, Date startDate,
                    Date endDate, String notes) {

        this.id = id;
        this.memberName = memberName;
        this.instructorName = instructorName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.notes = notes;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getMemberName() {

        return memberName;
    }

    public void setMemberName(String memberName) {

        this.memberName = memberName;
    }

    public String getInstructorName() {

        return instructorName;
    }

    public void setInstructorName(String instructorName) {

        this.instructorName = instructorName;
    }

    public Date getStartDate() {

        return startDate;
    }

    public void setStartDate(Date startDate) {

        this.startDate = startDate;
    }

    public Date getEndDate() {

        return endDate;
    }

    public void setEndDate(Date endDate) {

        this.endDate = endDate;
    }

    public String getNotes() {

        return notes;
    }

    public void setNotes(String notes) {

        this.notes = notes;
    }
}
