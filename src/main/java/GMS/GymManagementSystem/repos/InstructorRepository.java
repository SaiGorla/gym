/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GMS.GymManagementSystem.repos;

import GMS.GymManagementSystem.models.Instructor;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Sai Rohith Gorla
 */
public interface InstructorRepository extends CrudRepository<Instructor, Integer> {

}