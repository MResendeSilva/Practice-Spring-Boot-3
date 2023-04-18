package med.voll.api.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter // Gera todos métodos getter
@NoArgsConstructor // Gera construtor default para funcionamento da jpa
@AllArgsConstructor // Gera construtor com todos os argumentos
@EqualsAndHashCode(of = "id") // Gerara equals e hashcode apenas do id


public class Medico {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;
    private boolean ativo;
    
    public Medico(DadosCadastroMedico dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.crm = dados.crm();
		this.endereco = new Endereco(dados.endereco()); // Fazemos isso para que os dados do endereço sejam convertidos para a tipagem correta
		// Ja que endereco tem sua própria tipagem por ter sua própria classe
		// Agora para que funcione corretamente, criaremos um construtor na classe endereco.
		this.especialidade = dados.especialidade();
		this.ativo = true;
		
	}
    
	public void atualizarInformacoes(@Valid DadosAtualizacaoMedico dados) {
		
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		
		if (dados.telefone() != null) {
			this.telefone = dados.telefone();
		}
		
		if (dados.endereco() != null) {
			this.endereco.atualizarInformacoes(dados.endereco()); // Criando método na classe endereco para atualizar os enderecos por la
		}
		
	}

	public void excluir() {
		this.ativo = false;
	
	}

}
