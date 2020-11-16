package br.hoteleveris.app.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ocupacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int qntDiaria;
	private Date data;
	private String situacao;

	@ManyToOne
	@JoinColumn(name = "clienteId")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "quartoId")
	private Quarto quarto;

	public Ocupacao(Cliente cliente, Quarto quarto) {
		super();
		this.cliente = cliente;
		this.quarto = quarto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQntDiaria() {
		return qntDiaria;
	}

	public void setQntDiaria(int qntDiaria) {
		this.qntDiaria = qntDiaria;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

}