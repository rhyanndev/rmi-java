package br.com.rhyanndev;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ListaTelefonicaServidor {
    public static void main(String[] args) {
        try {
            ListaTelefonicaImpl listaTelefonica = new ListaTelefonicaImpl();
            Registry registry = LocateRegistry.createRegistry(2000);
            registry.rebind("ListaTelefonica", listaTelefonica);
            System.out.println("Servidor de agenda telefônica pronto.");
        } catch (Exception e) {
            System.out.println("Erro no servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}