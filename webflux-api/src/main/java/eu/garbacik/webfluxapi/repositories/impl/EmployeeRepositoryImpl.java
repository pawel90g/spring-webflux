package eu.garbacik.webfluxapi.repositories.impl;

import eu.garbacik.webfluxapi.models.Employee;
import eu.garbacik.webfluxapi.repositories.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public Employee findById(Integer id) {
        return employees
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Employee> getAll() {
        return employees;
    }

    private static List<Employee> employees = new ArrayList<Employee>();
    static {
        employees.add(new Employee(1, "Employee 1", "employee-1@company.com"));
        employees.add(new Employee(2, "Employee 2", "employee-2@company.com"));
        employees.add(new Employee(3, "Employee 3", "employee-3@company.com"));
        employees.add(new Employee(4, "Employee 4", "employee-4@company.com"));
    }
}
