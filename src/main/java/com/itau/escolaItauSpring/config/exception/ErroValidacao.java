package com.itau.escolaItauSpring.config.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErroValidacao {
    private String campo;
    private String mensagem;
}
