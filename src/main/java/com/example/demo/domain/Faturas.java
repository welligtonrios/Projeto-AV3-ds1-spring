package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Faturas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataVencimento;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataPagamento;
	
	private Double juros;
	private Boolean estado;
	private Double total;
	
	//relacionamento fatura cartao
	@ManyToOne
	@JsonIgnore // fatura nao carregar o cartão
	@JoinColumn(name = "cartao_id")
	private Cartão cartão;
	
	public Faturas() {
		
	}

	public Faturas(Integer id, Date dataVencimento, Date dataPagamento, Double juros, Boolean estado, Double total,
			Cartão cartão) {
		super();
		this.id = id;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.juros = juros;
		this.estado = estado;
		this.total = total;
		this.cartão = cartão;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getJuros() {
		return juros;
	}

	public void setJuros(Double juros) {
		this.juros = juros;
	}

	public Boolean getEstado() {
		return estado;
	}
	/*
	public void retornaEstado(Boolean result) {
		String result = "";
		if(this.estado == true) {
			result= "Paga";
		}else {
			result= "Pendente";
		}
	}
*/
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Cartão getCartão() {
		return cartão;
	}

	public void setCartão(Cartão cartão) {
		this.cartão = cartão;
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
		Faturas other = (Faturas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
