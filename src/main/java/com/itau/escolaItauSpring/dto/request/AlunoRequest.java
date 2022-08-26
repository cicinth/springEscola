package com.itau.escolaItauSpring.dto.request;

import com.itau.escolaItauSpring.model.Curso;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class AlunoRequest {
    private String nome;
    private Integer idade;
    private Long cpf;
    private CursoRequest curso;

}
