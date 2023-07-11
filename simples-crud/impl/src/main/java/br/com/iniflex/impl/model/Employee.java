package br.com.iniflex.impl.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_EMPLOYEE")
public class Employee extends Person {
    private static final long serialVersionUID = 1L;

    @NumberFormat(pattern = ",##0,00", style = Style.PERCENT)
    private BigDecimal salary;
    private String function;

}