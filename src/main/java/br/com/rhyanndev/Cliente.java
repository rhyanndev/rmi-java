package br.com.rhyanndev;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String nome;
    private String telefone;

    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return nome + ": " + telefone;
    }
}
