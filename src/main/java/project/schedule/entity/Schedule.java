package project.schedule.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import project.schedule.dto.ScheduleRequestDto;

import java.time.LocalDateTime;

@Entity
public class Schedule {

    // 속성
    @Id // PK 값으로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private Long schedulesId;

    @Column(length = 20, nullable = false)
    private String username;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(length = 20, nullable = false)
    private String contents;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    // 생성자
    // 기본생성자: JPA에서 기본으로 사용됩니다. -> 명시적으로 적어주는 게 좋다.
    public Schedule() {}

    public Schedule(ScheduleRequestDto dto) {
        this.username = dto.getUsername();
        this.title = dto.getTitle();
        this.contents = dto.getContents();
    }

    // 기능
    public void changeTitle(String newTitle) {
        this.title = newTitle;
    }
}
