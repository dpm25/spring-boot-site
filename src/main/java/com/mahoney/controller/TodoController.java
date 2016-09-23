package com.mahoney.controller;

import com.mahoney.model.Todo;
import com.mahoney.repository.TodoRespository;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("my-site/api/v1/")
public class TodoController {
    @Autowired
    private TodoRespository todoRespository;

    @RequestMapping(value = "todos", method = RequestMethod.GET)
    @ApiOperation(value = "list", nickname = "listAllTodos")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue="Niklas")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Todo.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public List<Todo> list() {

        return todoRespository.findAll();
    }

    @RequestMapping(value = "todos", method = RequestMethod.POST)
    public Todo create(@RequestBody Todo todo) {
        todo.setComplete(false);
        todo.setCreateDate(new Date());
        return todoRespository.saveAndFlush(todo);
    }

    @RequestMapping(value = "todos/{id}", method = RequestMethod.GET)
    public Todo get(@PathVariable Long id) {

        return todoRespository.findOne(id);
    }

    @RequestMapping(value = "todos/{id}", method = RequestMethod.PUT)
    public Todo udpdate(@PathVariable Long id, @RequestBody Todo todo) {
        Todo existingTodo = todoRespository.findOne(id);
        BeanUtils.copyProperties(todo, existingTodo);
        return todoRespository.saveAndFlush(existingTodo);
    }

    @RequestMapping(value = "todos/{id}", method = RequestMethod.DELETE)
    public Todo delete(@PathVariable Long id) {
        Todo existingTodo = todoRespository.findOne(id);
        todoRespository.delete(existingTodo);
        return existingTodo;
    }
}
