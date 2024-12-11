package com.alexnogueira.cursomc.domain;

import java.util.Date;

import com.alexnogueira.cursomc.domain.enuns.EstadoPagamento;

import jakarta.persistence.Entity;

@Entity
public class PagamentoComBoleto extends Pagamento {

    private static final long serialVersionUID = 1L;
    private Date dataVencimento;
    private Date dataPagameto;
    
    public PagamentoComBoleto() {
    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento,
            Date dataPagameto) {
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagameto = dataPagameto;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagameto() {
        return dataPagameto;
    }

    public void setDataPagameto(Date dataPagameto) {
        this.dataPagameto = dataPagameto;
    }

    

}
