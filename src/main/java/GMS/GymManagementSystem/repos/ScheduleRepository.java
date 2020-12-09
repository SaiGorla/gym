/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GMS.GymManagementSystem.repos;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import GMS.GymManagementSystem.models.Schedule;

/**
 *
 * @author Sai Rohith Gorla
 */
public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {

    List<Schedule> findByMemberNameContaining(String searchQuery);

}

