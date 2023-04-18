package med.voll.api.medico;

import med.voll.api.endereco.Endereco;
import med.voll.api.paciente.Paciente;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone, Especialidade Especialidade, Endereco endereco) {
	public DadosDetalhamentoMedico (Medico medico) {
		this(medico.getId(), medico.getNome(),medico.getTelefone(), medico.getEmail(), medico.getCrm(),medico.getEspecialidade(),medico.getEndereco());
	}

}
