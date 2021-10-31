package com.codebrains.todolist.repositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.codebrains.todolist.entities.Todo;


@Repository
public interface TodoRepository extends JpaRepository<Todo,Long>{

}