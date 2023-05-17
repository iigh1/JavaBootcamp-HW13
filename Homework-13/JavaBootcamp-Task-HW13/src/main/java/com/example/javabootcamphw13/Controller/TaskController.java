package com.example.javabootcamphw13.Controller;

import com.example.javabootcamphw13.ApiResponse.ApiResponse;
import com.example.javabootcamphw13.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    ArrayList<Task> tasks=new ArrayList<>();

    // create - Add

    @PostMapping("/add")
    public ApiResponse addTask(@RequestBody Task task){
        tasks.add(task);
        return new ApiResponse("task added");
    }

    // read - Get

    @GetMapping("/get")
    public ArrayList<Task> getTasks(){
        return tasks;
    }

    // update - Put

    @PutMapping("/update/{index}")
    public ApiResponse updateTask(@PathVariable int index, @RequestBody Task task){
        tasks.set(index,task);
        return new ApiResponse("task updated");
    }

    // delete - Delete

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTask(int index){
        tasks.remove(index);
        return new ApiResponse("task deleted");
    }

    //  change status

    @GetMapping("/status/{index}")
    public String getStatus(@PathVariable int index){
        tasks.get(index);
       Task task= tasks.get(index);
       task.setStatus("done");
       tasks.set(index,task);
       return "task updated";
    }

    // search

    @GetMapping("/search/{title}")
    public ArrayList<Task> searchTask(@PathVariable String title){
        ArrayList<Task> foundTasks = new ArrayList<>();
        for (Task task1: tasks) {
            if(task1.getTitle().equals(title)){
                foundTasks.add(task1);
            }
        }
        return foundTasks;
    }

}
