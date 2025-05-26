package project.schedule.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.schedule.service.ScheduleService;

@RestController
@RequestMapping("/scedules")
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
    public void createScheduleAPI() {

    }

}
