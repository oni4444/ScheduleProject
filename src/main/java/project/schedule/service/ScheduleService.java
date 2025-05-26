package project.schedule.service;

import org.springframework.stereotype.Service;
import project.schedule.dto.ScheduleRequestDto;
import project.schedule.entity.Schedule;
import project.schedule.repository.ScheduleRepository;

import java.util.List;

@Service
public class ScheduleService {

    // 속성
    private ScheduleRepository scheduleRepository;


    // 생성자
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    // 기능

    /**
     * 생성
     * @param dto
     * @return
     */
    public Schedule createSchedule(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule(dto);
        scheduleRepository.save(schedule);
        return schedule;
    }

    /**
     * 리스트 조회
     * @return
     */
    public List<Schedule> getAllSchedules() {
            List<Schedule> find = scheduleRepository.findAll();
            return find;
    }

    /**
     * 단건 조회
     * @param ScheduleId
     * @return
     */
    public Schedule getScheduleById(Long ScheduleId) {
        return scheduleRepository.findById(ScheduleId);
    }

    /**
     * 수정
     */
    public void updateSchedule(Long scheduleId, String newScheduleTitle) {
        scheduleRepository.update(scheduleId, newScheduleTitle);
    }

    /**
     * 삭제
     */
    public void deleteSchedule(Long scheduleId) {
        scheduleRepository.delete(scheduleId);
    }

}
