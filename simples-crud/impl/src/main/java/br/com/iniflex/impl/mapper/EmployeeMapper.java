package br.com.iniflex.impl.mapper;

import br.com.iniflex.impl.dtos.EmployeeDTO;
import br.com.iniflex.impl.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {


    public static EmployeeDTO mapToDTO(Employee employee) {
        return new EmployeeDTO(employee.getIdPerson(), employee.getNamePerson(), employee.getDtBirth());
    }
}
