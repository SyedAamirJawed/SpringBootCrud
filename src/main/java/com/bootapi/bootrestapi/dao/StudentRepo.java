package com.bootapi.bootrestapi.dao;

import org.springframework.data.repository.CrudRepository;
import com.bootapi.bootrestapi.entities.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {

    public Student findById(int id);

    
}
