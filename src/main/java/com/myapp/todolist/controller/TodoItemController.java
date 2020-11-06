package com.myapp.todolist.controller;

import com.myapp.todolist.model.TodoData;
import com.myapp.todolist.model.TodoItem;
import com.myapp.todolist.service.TodoItemService;
import com.myapp.todolist.util.AttributeNames;
import com.myapp.todolist.util.Mappings;
import com.myapp.todolist.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class TodoItemController {
    // == fields ==
    private final TodoItemService todoItemService;

    // == constructors ==
    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // == model attributes ==
    @ModelAttribute
    public TodoData todoData(){
        return todoItemService.getData();
    }

    // == handler methods ==
    // http://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id,
                              Model model){
        TodoItem todoItem = todoItemService.getItem(id);

        if (todoItem == null){
            todoItem = new TodoItem("","", LocalDate.now());
        }
        model.addAttribute(AttributeNames.TODO_ITEM,todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        if (todoItem.getId() == 0) {
            todoItemService.addItem(todoItem);
        } else {
            todoItemService.updateItem(todoItem);
        }
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model){
        TodoItem todoItem = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM,todoItem);
        return ViewNames.VIEW_ITEM;
    }
}
