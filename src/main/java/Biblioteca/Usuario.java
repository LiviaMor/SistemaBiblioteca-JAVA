package Biblioteca;

public class Usuario {
    private int id_usuario;
    private String nome;
    private String matricula;
    private String email;

    public Usuario(int id_usuario, String nome, String matricula, String email) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
    }

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nome=" + nome + ", matricula=" + matricula + ", email=" + email
				+ "]";
	}

    
}

