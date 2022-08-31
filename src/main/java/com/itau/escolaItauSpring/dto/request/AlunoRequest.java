package com.itau.escolaItauSpring.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class AlunoRequest {
    @NotNull(message = "nao pode ser null cara") @NotEmpty @Length(min = 2)
    private String nome;
    private Integer idade;
    private Long cpf;
    private CursoRequest curso;
}
