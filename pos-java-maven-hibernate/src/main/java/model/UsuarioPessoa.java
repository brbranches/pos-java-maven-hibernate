package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	
	@NamedQuery(name="UsuarioPessoa.listarTodos", query = " select u from UsuarioPessoa u "),
	@NamedQuery(name="UsuarioPessoa.buscarPorNome", query = " select u from UsuarioPessoa u where u.nome = :nome ")

})
/*
 * Essa anotação @Entity diz para o Hibernate que ele tem que pegar essa classe
 * e gerar uma tabela no banco Dentro do persistence tem que chamar a classe,
 * ver <class> na persistence.xml
 */
public class UsuarioPessoa {

	@Id /* Para que possa ser gerado o id de forma automática */
	@GeneratedValue(strategy = GenerationType.AUTO) /* Auto, o hibernate gera uma sequência automática colocando +1 */
	private Long id;

	private String nome;
	private String sobrenome;
	private String email;
	private String login;
	private String senha;
	private int idade;
	
	@OneToMany(mappedBy = "usuarioPessoa")
	private List<UsuarioTelefone> usuarioTelefones;
	
	public List<UsuarioTelefone> getUsuarioTelefones() {
		return usuarioTelefones;
	}

	public void setUsuarioTelefones(List<UsuarioTelefone> usuarioTelefones) {
		this.usuarioTelefones = usuarioTelefones;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "UsuarioPessoa [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email
				+ ", login=" + login + ", senha=" + senha + ", idade=" + idade + "]";
	}
	
	

}
