package Biblioteca;

public class Livro {
	private int id_livro;
	private String codigo;
	private String titulo;
	private String autor;
	private String ano;

	public Livro(int id_livro, String codigo, String titulo, String autor, String ano) {
		this.id_livro = id_livro;
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
	}

	public int getId_livro() {
		return id_livro;
	}

	public void setId_livro(int id_livro) {
		this.id_livro = id_livro;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Livro [id_livro=" + id_livro + ", codigo=" + codigo + ", titulo=" + titulo + ", autor=" + autor
				+ ", ano=" + ano + "]";
	}

}
