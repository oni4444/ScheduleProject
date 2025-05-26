package project.schedule.service;

import org.springframework.stereotype.Service;
import project.schedule.dto.ScheduleRequestDto;
import project.schedule.entity.Schedule;
import project.schedule.repository.ScheduleRepository;

@Service
public class ScheduleService {

    // 속성
    private ScheduleRepository scheduleRepository;


    // 생성자
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    // 기능
    public Schedule createSchedule(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule(dto);
        Schedule saved = scheduleRepository.save(schedule);
        return saved;
    }

    public void getAllSchedules() {
        scheduleRepository.findAll();
    }

    public void getScheduleById() {
        scheduleRepository.findById();
    }


    public void updateSchedule() {
        scheduleRepository.update();
    }

    public void deleteSchedule() {
        scheduleRepository.delete();
    }

}
