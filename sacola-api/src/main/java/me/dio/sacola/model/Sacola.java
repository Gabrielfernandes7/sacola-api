package me.dio.sacola.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import me.dio.sacola.enumeration.FormaPagamento;

@Entity
public class Sacola {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itens;
    private Double valorTotal;

    @Enumerated
    private FormaPagamento FormaPagamento;
    private boolean fechado;

    public Sacola() {
    }

    public Sacola(long id, Cliente cliente, List<Item> itens, Double valorTotal,
            me.dio.sacola.enumeration.FormaPagamento formaPagamento, boolean fechado) {
        this.id = id;
        this.cliente = cliente;
        this.itens = itens;
        this.valorTotal = valorTotal;
        FormaPagamento = formaPagamento;
        this.fechado = fechado;
    }

    public long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public FormaPagamento getFormaPagamento() {
        return FormaPagamento;
    }

    public boolean isFechado() {
        return fechado;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        FormaPagamento = formaPagamento;
    }

    public void setFechado(boolean fechado) {
        this.fechado = fechado;
    }

    
    
}
