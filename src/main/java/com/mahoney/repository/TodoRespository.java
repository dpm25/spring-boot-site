package com.mahoney.repository;

import com.mahoney.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRespository extends JpaRepository<Todo, Long> {

}
