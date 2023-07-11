package br.com.iniflex.impl.dtos;

import br.com.iniflex.impl.model.Person;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EmployeeDTO extends Person {
    private static final long serialVersionUID = 1L;

    @NumberFormat(pattern = ",##0,00", style = NumberFormat.Style.PERCENT)
    private BigDecimal salary;
    private String function;

    public EmployeeDTO(Long idPerson, String namePerson, LocalDate dtBirth) {
        super(idPerson, namePerson, dtBirth);
    }
}