package com.wiliam.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.wiliam.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Date dataVencimeto;
	private Date dataPagamento;
	
	public PagamentoComBoleto() {
		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		
		this.dataPagamento = dataPagamento;
		this.dataVencimeto = dataVencimento;
	}

	public Date getDataVencimeto() {
		return dataVencimeto;
	}

	public void setDataVencimeto(Date dataVencimeto) {
		this.dataVencimeto = dataVencimeto;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	



}
