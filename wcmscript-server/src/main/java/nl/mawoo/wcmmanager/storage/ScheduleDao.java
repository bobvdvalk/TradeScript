package nl.mawoo.wcmmanager.storage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleDao extends JpaRepository<Schedule, Integer> {
    Schedule findByName(String name);
}
