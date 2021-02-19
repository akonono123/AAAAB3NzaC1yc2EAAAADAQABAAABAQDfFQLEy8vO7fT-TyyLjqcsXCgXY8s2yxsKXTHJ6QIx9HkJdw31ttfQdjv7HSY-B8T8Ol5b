package com.bootcamp.springboot.repository;

import com.bootcamp.springboot.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoList,Long> {

}
