package com.daniel.evaluacionl2.dao;

import com.daniel.evaluacionl2.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface IEmployeeDAO extends CrudRepository<Employee, Long> {
}
