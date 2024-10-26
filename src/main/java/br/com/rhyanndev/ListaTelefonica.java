package br.com.rhyanndev;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ListaTelefonica extends Remote {
    void addContato(Cliente cliente) throws RemoteException;
    List<Cliente> getContatos() throws RemoteException;
    void removeContato(String nome) throws RemoteException; // Método para remover cliente
}