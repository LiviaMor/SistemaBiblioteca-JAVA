package Biblioteca;

public class Emprestimo {
	private int id_registroemprestimo;
	private String codigo;
	private String matricula;
	private String dataEmprestimo;
	private String dataDevolucao;
	

	public Emprestimo(int id_registroemprestimo, String codigo, String matricula, String dataEmprestimo,
			String dataDevolucao) {
		this.id_registroemprestimo = id_registroemprestimo;
		this.codigo = codigo;
		this.matricula = matricula;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		
	}

	public int getId_registroemprestimo() {
		return id_registroemprestimo;
	}

	public void setId_registroemprestimo(int id_registroemprestimo) {
		this.id_registroemprestimo = id_registroemprestimo;
	}

	public String getcodigo() {
		return codigo;
	}

	public void setcodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getmatricula() {
		return matricula;
	}

	public void setmatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	

	@Override
	public String toString() {
		return "Emprestimo [id_registroemprestimo=" + id_registroemprestimo + ", codigo=" + codigo + ", matricula="
				+ matricula + ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao=" + dataDevolucao +"]";
	}

}
