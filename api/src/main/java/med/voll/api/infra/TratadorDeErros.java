package med.voll.api.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErros {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity tratarErro404 () {
		return ResponseEntity.notFound().build();
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity tratarErro400 (MethodArgumentNotValidException ex) {
		var erros = ex.getFieldErrors();
		
		return ResponseEntity.badRequest().body(erros.stream().map(DadosErrosValidacao::new).toList());
		
	}
	
	// Criando dto para chamar apenas informações necessárias no tratamento do erro 400
	private record DadosErrosValidacao(String campo, String mensagem) {
		public DadosErrosValidacao(FieldError field) {
			this (field.getField(), field.getDefaultMessage());
		}
	}
}
