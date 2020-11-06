package com.myapp.todolist.service;

import com.myapp.todolist.model.TodoData;
import com.myapp.todolist.model.TodoItem;

public interface TodoItemService {

    void addItem(TodoItem toAdd);

    void removeItem(int id);

    TodoItem getItem(int id);

    void updateItem(TodoItem toUpdate);

    TodoData getData();
}
