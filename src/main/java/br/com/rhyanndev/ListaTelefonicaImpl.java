package br.com.rhyanndev;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class ListaTelefonicaImpl extends UnicastRemoteObject implements ListaTelefonica {
    private List<Cliente> contatos;

    protected ListaTelefonicaImpl() throws RemoteException {
        super();
        contatos = new ArrayList<>();
    }

    @Override
    public void addContato(Cliente cliente) throws RemoteException {
        contatos.add(cliente);
    }

    @Override
    public List<Cliente> getContatos() throws RemoteException {
        return contatos;
    }

    @Override
    public void removeContato(String nome) throws RemoteException {
        contatos.removeIf(cliente -> cliente.getNome().equalsIgnoreCase(nome)); // Remove cliente pelo nome
    }
}
