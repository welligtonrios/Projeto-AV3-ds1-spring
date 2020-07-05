package com.example.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Conta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numero;
	private Double saldo;
	private Boolean estado;
	

	// conta tem uma categoria
	//Na tabela Conta em tenho uma coluna que guardara o id da Categoria
	//muitas contas para categoria
	@ManyToOne
	@JsonIgnore // eu nao preciso ficar renderizando o objeto conta, e sim o obj categoria com a lista de contas
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	//realiconameno Conta Cliente
	// é representado na classe cliente pelo atributo conta
	@JsonIgnore // 
	@OneToOne(mappedBy = "conta") //mapeamento realizado na tabela cliente 
	private Cliente cliente;
	
	//uma conta tem muitos cartões
	@OneToMany(mappedBy = "conta") // o mapeamento foi feito na classe Cartão atributo conta
	private List<Cartão> cartões = new ArrayList<>();
	
	public Conta() {

	}

	public Conta(Integer id, Integer numero, Double saldo, Boolean estado, Categoria categoria) {
		super();
		this.id = id;
		this.numero = numero;
		this.saldo = saldo;
		this.estado = estado;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

	public List<Cartão> getCartões() {
		return cartões;
	}

	public void setCartões(List<Cartão> cartões) {
		this.cartões = cartões;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
