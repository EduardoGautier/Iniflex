package br.com.iniflex.impl.service;

import br.com.iniflex.impl.dtos.EmployeeDTO;
import br.com.iniflex.impl.exception.DatabaseException;
import br.com.iniflex.impl.mapper.EmployeeMapper;
import br.com.iniflex.impl.model.Employee;
import br.com.iniflex.impl.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public EmployeeDTO findAll() {
        return repository.findAll().stream()
                .map(EmployeeMapper::mapToDTO)
                .toList();
    }

    public Employee groupByFunction() {
        return repository.getGroupByFunction();
    }

    public int updateSalary() {
        return repository.updateSalary();
    }

    public Employee monthOfBirthDay() {
        return repository.monthOfBirthDay();
    }

    public Employee alphabeticalOrder() {
        return repository.alphabeticalOrder();
    }

    public void olderEmployee() {
        return repository.olderEmployee();
    }

    public double sumSalary() {
        return repository.sumSalary();
    }

    public void minSalary() {
        return repository.minSalary();
    }

    public void delete(Long id) throws DatabaseException {
        repository.deleteById(id);
    }

}
