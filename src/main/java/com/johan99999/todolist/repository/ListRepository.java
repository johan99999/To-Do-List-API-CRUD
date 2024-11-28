package com.johan99999.todolist.repository;


import com.johan99999.todolist.entity.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<TaskList, Integer> {
    boolean existsByList(String list);

//    Boolean existsByNo(Integer no);
//    Boolean existsByList(String list);

}
