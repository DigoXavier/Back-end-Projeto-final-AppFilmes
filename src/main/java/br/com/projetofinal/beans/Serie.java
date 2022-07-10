package br.com.projetofinal.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_serie")
public class Serie {
	
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="genero", length = 30)
	private String genero;
	
	@Column(name="titulo", length = 50)
	private String titulo;
	
	@Column(name="sinopse", length = 150)
	private String sinopse;
	
	@Column(name="lancamento")
	private boolean lancamento;
	
	@ManyToOne
	@JsonIgnoreProperties("series")
	private Provedora provedora;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public boolean isLancamento() {
		return lancamento;
	}
	public void setLancamento(boolean lancamento) {
		this.lancamento = lancamento;
	}
	public Provedora getProvedora() {
		return provedora;
	}
	public void setProvedora(Provedora provedora) {
		this.provedora = provedora;
	}
	
	
}
