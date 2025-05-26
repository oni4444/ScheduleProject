package project.schedule.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.stereotype.Repository;
import project.schedule.entity.Schedule;

import java.util.List;

@Repository
public class ScheduleRepository {

    // 속성
    private final EntityManagerFactory emf;


    // 생성자
    public ScheduleRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }


    // 기능

    /**
     * 생성
     * @param schedule
     */
    public void save(Schedule schedule) {

        // 1. 엔티티매니저 준비
        EntityManager entityManager = emf.createEntityManager();

        // 2. 트랜잭션 준비
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // 3. 저장!
        entityManager.persist(schedule);

        // 4. 트랜잭션 커밋
        transaction.commit();

        // 5. entityManager 정리
        entityManager.close();

    }

    /**
     * 리스트 조회
     */
    public List<Schedule> findAll() {
        // 1. 엔티티 매니저 준비
        EntityManager entityManager = emf.createEntityManager();

        // 2. 조회 - JPQL
        List<Schedule> scheduleList = entityManager.createQuery("SELECT s FROM Schedule s", Schedule.class)
                .getResultList();

        // 3. 엔티티 매니저 정리
        entityManager.close();

        // 4. 반환
        return scheduleList;
    }

    /**
     * 단건 조회
     */
    public Schedule findById(Long ScheduleId) {
        // 1. 엔티티 매니저 준비
        EntityManager entityManager = emf.createEntityManager();

        // 2. 조회 - JPQL
        Schedule schedule = entityManager.find(Schedule.class, ScheduleId);

        // 3. 엔티티 매니저 정리
        entityManager.close();

        // 4. 반환
        return schedule;
    }

    /**
     * 수정
     */
    public void update(Long scheduleId, String newScheduleTitle) {
        // 1. 엔티티매니저 준비
        EntityManager entityManager = emf.createEntityManager();

        // 2. 트랜잭션 준비
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // 3. 수정 로직
        Schedule foundSchedule = entityManager.find(Schedule.class, scheduleId);
        foundSchedule.changeTitle(newScheduleTitle);

        // 4. 트랜잭션 끝
        transaction.commit();

        // 5. 엔티티매니저 정리
        entityManager.close();
    }

    /**
     * 삭제
     */
    public void delete(Long scheduleId) {

        // 1. 엔티티 매니저 준비
        EntityManager entityManager = emf.createEntityManager();

        // 2. 트랜잭션 필요
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Schedule schedule = entityManager.find(Schedule.class, scheduleId);
        entityManager.remove(schedule);

        // . 트랙잭션 끝
        transaction.commit();

        // 엔티티 매니저 정리
        entityManager.close();
    }

}
