package com.codebrains.todolist.controllers;

import com.codebrains.todolist.entities.Todo;
import com.codebrains.todolist.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/todos")
public class TodoController {

     @Autowired
     private TodoRepository todoRepos;


     @GetMapping
     public List<Todo> getTodo() {
          return todoRepos.findAll();
     }

     @GetMapping("/{todoId}")
     public Optional<Todo> getTodo(@PathVariable("todoId") Long todoId) {
          return todoRepos.findById(todoId);
     }

     @PostMapping
     public Todo newTodo(@RequestBody Todo todo) {
          return todoRepos.save(todo);
     }

     @PutMapping("/{todoId}")
     public Optional<Todo> updateTodo(@PathVariable("todoId") Long todoId, @RequestBody Todo updateTodo){
          return todoRepos.findById(todoId)
                  .map(oldTodo -> todoRepos.save(updateTodo));
     }
     @DeleteMapping("/{todoId}")
     void deleteTodo(@PathVariable("todoId") Long todoId){
          todoRepos.deleteById(todoId);
     }
}
