package br.com.iniflex.controller;

import br.com.iniflex.impl.dtos.EmployeeDTO;
import br.com.iniflex.impl.model.Employee;
import br.com.iniflex.impl.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping()
    @ApiOperation(value = "Obtém todos os funcionários",
            notes = "Retorna uma lista de todos os funcionários.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação bem-sucedida",
                    response = EmployeeDTO.class)
    })
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        var list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/groupByFunction")

    @ApiOperation(value = "Agrupa funcionários por função",
            notes = "Retorna uma lista de funcionários agrupados por função.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação bem-sucedida",
                    response = Employee.class)
    })
    public List<Employee> groupByFunction() {
        return service.groupByFunction();
    }

    @GetMapping(value = "/monthOfBirthDay")
    @ApiOperation(value = "Obtém funcionários com aniversário no mês", notes = "Retorna uma lista de funcionários que têm aniversário no mês atual.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação bem-sucedida", response = Employee.class, responseContainer = "List")
    })
    public List<Employee> monthOfBirthDay() {
        return service.monthOfBirthDay();
    }

    @GetMapping(value = "/alphabeticalOrder")
    @ApiOperation(value = "Obtém funcionários em ordem alfabética", notes = "Retorna uma lista de funcionários em ordem alfabética.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação bem-sucedida", response = Employee.class, responseContainer = "List")
    })
    public List<Employee> alphabeticalOrder() {
        return service.alphabeticalOrder();
    }

    @GetMapping(value = "/olderEmployee")
    @ApiOperation(value = "Obtém o funcionário mais velho", notes = "Retorna o funcionário mais velho.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação bem-sucedida", response = String.class)
    })
    public String olderEmployee() {
        return service.olderEmployee();
    }

    @GetMapping(value = "/sumSalary")
    @ApiOperation(value = "Calcula a soma dos salários",
            notes = "Retorna a soma de todos os salários dos funcionários.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação bem-sucedida", response = double.class)
    })
    public double sumSalary() {
        return service.sumSalary();
    }

    @GetMapping(value = "/minSalary")
    @ApiOperation(value = "Obtém os funcionários com o menor salário",
            notes = "Retorna uma lista de funcionários com o menor salário.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação bem-sucedida", response = String.class, responseContainer = "List")
    })
    public List<String> minSalary() {
        return service.minSalary();
    }

    @PutMapping(value = "/updateSalary")
    @ApiOperation(value = "Atualiza o salário",
            notes = "Atualiza o salário.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação bem-sucedida", response = int.class)
    })
    public int updateSalary() {
        return service.updateSalary();
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Exclui um funcionário",
            notes = "Exclui um funcionário com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Funcionário excluído com sucesso"),
            @ApiResponse(code = 404, message = "Funcionário não encontrado", response = EmployeeDTO.class)
    })
    public ResponseEntity<EmployeeDTO> deleteEmployee(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}