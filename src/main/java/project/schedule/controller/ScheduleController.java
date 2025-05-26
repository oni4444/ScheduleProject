package project.schedule.controller;

import org.springframework.web.bind.annotation.*;
import project.schedule.dto.ScheduleRequestDto;
import project.schedule.entity.Schedule;
import project.schedule.service.ScheduleService;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    // 속성
    private ScheduleService service;




    // 생성자
    public ScheduleController(ScheduleService service) {
        this.service = service;
    }




    // 기능
    /**
     * 생성하는 기능
     */
    @PostMapping
    public Schedule creatScheduleAPI(@RequestBody ScheduleRequestDto dto) {
        Schedule result = service.createSchedule(dto);
        return result;
    }

    /**
     * 전체 조회하는 기능
     */
    @GetMapping
    public List<Schedule> getScheduleAPI() {
        return service.getAllSchedules();
    }

    /**
     * 단건 조회하는 기능
     */
    @GetMapping("/{scheduleId}")
    public Schedule getScheduleByIdAPI(@PathVariable Long scheduleId) {
        return service.getScheduleById(scheduleId);
    }

    /**
     * 수정하는 기능
     */
    @PatchMapping("/{scheduleId}")
    public void updateScheduleAPI(Long scheduleId, String newScheduleTitle) {
        service.updateSchedule(scheduleId, newScheduleTitle);
    }

    /**
     * 삭제하는 기능
     */
    @DeleteMapping("/{scheduleId}")
    public void deleteScheduleAPI(@PathVariable Long scheduleId) {
        service.deleteSchedule(scheduleId);
    }

}
