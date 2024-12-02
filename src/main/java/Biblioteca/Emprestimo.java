package Biblioteca;

public class Emprestimo {
	private int id_registroemprestimo;
	private String codigo;
	private String matricula;
	private String dataEmprestimo;
	private String dataDevolucao;
	private String dataDevolucaoEfetiva;

	public Emprestimo(int id_registroemprestimo, String codigo, String matricula, String dataEmprestimo,
		String dataDevolucao, String dataDevolucaoEfetiva) {
		this.id_registroemprestimo = id_registroemprestimo;
		this.codigo = codigo;
		this.matricula = matricula;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
	}

	public int getId_registroemprestimo() {
		return id_registroemprestimo;
	}

	public void setId_registroemprestimo(int id_registroemprestimo) {
		this.id_registroemprestimo = id_registroemprestimo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
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

	public String getDataDevolucaoEfetiva() {
		return dataDevolucaoEfetiva;
	}

	public void setDataDevolucaoEfetiva(String dataDevolucaoEfetiva) {
		this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
	}

	@Override
	public String toString() {
		return "Emprestimo [id_registroemprestimo=" + id_registroemprestimo + ", codigo=" + codigo
				+ ", matricula=" + matricula + ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao="
				+ dataDevolucao + ", dataDevolucaoEfetiva=" + dataDevolucaoEfetiva + "]";
	}

}
