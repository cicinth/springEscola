package com.itau.escolaItauSpring.config.exception;

import com.itau.escolaItauSpring.exception.ItemNaoExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroValidacao> lidarErroValicao(
            MethodArgumentNotValidException exception
    ){
        List<ErroValidacao> erros = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach( error -> {
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            ErroValidacao erroValidacao = new ErroValidacao(error.getField(), mensagem);
            erros.add(erroValidacao);

        });
        return erros;
    }

    @ExceptionHandler(ItemNaoExistenteException.class)
    public ResponseEntity<String> lidarItemNaoExistente(ItemNaoExistenteException exception){
        return ResponseEntity.status(404).body("item nao existente");
    }
}
