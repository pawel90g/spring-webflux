package eu.garbacik.webfluxapi.controllers;

import eu.garbacik.webfluxapi.models.Employee;
import eu.garbacik.webfluxapi.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(value = "")
    public Flux<Employee> getAll() {
        return Flux.fromIterable(employeeRepository.getAll())
                .delayElements(Duration.ofSeconds(1));
    }

    @GetMapping(value ="/{id}")
    public Mono<Employee> getById(@PathVariable Integer id){
        return Mono.just(employeeRepository.findById(id));
    }
}
