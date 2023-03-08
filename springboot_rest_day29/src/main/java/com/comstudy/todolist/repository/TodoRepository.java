package com.comstudy.todolist.repository;

import com.comstudy.todolist.domain.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {

    Optional<TodoEntity> findById(String id);

    // 네이티브 쿼리는 실제 DBMS에서 사용되는 SQL을 사용
    @Query(value = "SELECT * FROM TODO WHERE USERID=?",nativeQuery = true)
    List<TodoEntity> findByUserIdQuery(String userId);

    // JPQL은 엔티티 이름과 엔티티 멤버 필드를 기준으로 사용
    @Query(value = "SELECT t FROM TodoEntity AS t WHERE t.userId = ?1")
    List<TodoEntity> findByUserIdQuery2(String userId);

}
