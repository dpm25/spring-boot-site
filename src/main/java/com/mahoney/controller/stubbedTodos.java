package com.mahoney.controller;

import com.mahoney.model.Todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class stubbedTodos {


    public stubbedTodos() {
    }

    public static List getTodos() {

        Todo todo1  = new Todo("Sample Title", "Sample Note", new Date(), new Date(), true);
        return new ArrayList(Arrays.asList(todo1));
    }
}
