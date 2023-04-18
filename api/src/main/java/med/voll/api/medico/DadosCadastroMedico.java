package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(
		// Classe dto

		@NotBlank // Não pode vazio e nem pode ser nulo
		String nome,
		@NotBlank // Apenas para String
		@Email
		String email,
		
		@NotBlank
		String telefone,
		
		@NotBlank
		@Pattern(regexp = "\\d{4,6}") // estou dizendo que a expressão regular é um digito e tem de 4 a 6 de tamanho
		String crm, 
		@NotNull
		Especialidade especialidade, // Enum ja faz a validação dos tipos de forma automatica
		@NotNull
		@Valid // Diz para o spring que este objeto também tem é dto e tem atributos a serem validados
		DadosEndereco endereco) {
	
}
