package com.app.todoapp.controller;
import org.springframework.ui.Model;


import com.app.todoapp.models.Task;
import com.app.todoapp.repository.TaskRepository;
import com.app.todoapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks=taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);

        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/";
    }

    @PostMapping
    public String createTask(@RequestParam String title){
       taskService.createTask(title);
        return "redirect:/";
    }
}
