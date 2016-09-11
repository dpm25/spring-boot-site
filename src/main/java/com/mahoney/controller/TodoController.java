package com.mahoney.controller;

import com.mahoney.model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class TodoController {

    @RequestMapping(value = "todos", method = RequestMethod.GET)
    public List<Todo> list() {

        return stubbedTodos.getTodos();
    }

    @RequestMapping(value = "todos", method = RequestMethod.POST)
    public Todo create(@RequestBody Todo todo ) {
        return null;
    }

    @RequestMapping(value = "todos/{id}", method = RequestMethod.GET)
    public Todo get(@PathVariable Long id) {
        return null;
    }

    @RequestMapping(value = "todos/{id}", method = RequestMethod.PUT)
    public Todo udpdate(@PathVariable Long id, @RequestBody Todo todo) {
        return null;
    }

    @RequestMapping(value = "todos/{id}", method = RequestMethod.DELETE)
    public Todo delete(@RequestBody Long id) {
        return null;
    }
}
