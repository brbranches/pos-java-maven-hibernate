package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class UsuarioTelefone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	// nullable False indica que é obrigatório
	@Column(nullable = false)
	private String tipo;

	@Column(nullable = false)
	private String numero;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private UsuarioPessoa usuarioPessoa;

	public Long getId() {
		return Id;
	}

	public String getTipo() {
		return tipo;
	}

	public String getNumero() {
		return numero;
	}

	public UsuarioPessoa getUsuarioPessoa() {
		return usuarioPessoa;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setUsuarioPessoa(UsuarioPessoa usuarioPessoa) {
		this.usuarioPessoa = usuarioPessoa;
	}

	@Override
	public String toString() {
		return "UsuarioTelefone [Id=" + Id + ", tipo=" + tipo + ", numero=" + numero + ", usuarioPessoa="
				+ usuarioPessoa + "]";
	}
	
	

}
