package com.lambdaschool.todos.services;


import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todoService")
public class TodoServiceImpl implements TodosService {

    @Autowired
    private TodosRepository todosrepo;

    @Transactional
    @Override
    public void markComplete(long todoid) {
        Todos currentTodo = todosrepo.findById(todoid)
                .orElseThrow(() -> new EntityNotFoundException("Todo " + todoid + " Not Found!"));

        currentTodo.setCompleted(true);

        todosrepo.save(currentTodo);
    }

}
