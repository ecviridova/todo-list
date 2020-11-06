package com.myapp.todolist.service;

import com.myapp.todolist.model.TodoData;
import com.myapp.todolist.model.TodoItem;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class TodoItemImpl implements TodoItemService{

    // == fields ==
    @Getter
    private final TodoData data = new TodoData();

    // == public methods ==
    @Override
    public void addItem(TodoItem toAdd) {
        data.addItem(toAdd);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem toUpdate) {
        data.updateItem(toUpdate);
    }
}
