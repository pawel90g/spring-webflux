package eu.garbacik.webfluxapi.repositories;

import eu.garbacik.webfluxapi.models.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee findById(Integer id);
    List<Employee> getAll();
}
