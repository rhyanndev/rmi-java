package br.com.rhyanndev;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;


public class ListaTelefonicaCliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(null, 2000);
            ListaTelefonica listaTelefonica = (ListaTelefonica) registry.lookup("ListaTelefonica");

            Scanner scanner = new Scanner(System.in);
            int choice;
        
            do{
                System.out.println("Menu:");
                System.out.println("1. Adicionar contato");
                System.out.println("2. Ver contatos");
                System.out.println("3. Remover contato");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (choice) {
                        case 1:
                            System.out.println("----- ADICIONA CONTATO -----");
                            System.out.print("Nome que você deseja adicionar na lista: ");
                            System.out.print("Nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("Telefone: ");
                            String telefone = scanner.nextLine();
                            listaTelefonica.addContato(new Cliente(nome, telefone));
                            System.out.println("Contato adicionado.");                       
                            break;

                        case 2:
                            System.out.println("----- VER CONTATOS -----");
                            List<Cliente> contatos = listaTelefonica.getContatos();
                            System.out.println("Contatos: ");
                            for (Cliente cliente : contatos){
                                System.out.println(cliente);
                            }
                            break;
                        
                        case 3:
                        System.out.println("----- REMOVE CONTATO -----");
                            System.out.print("Nome que você deseja remover da lista: ");
                            String nomeRemovido = scanner.nextLine();
                            listaTelefonica.removeContato(nomeRemovido);
                            System.out.println("Contato removido.");
                            break;
                        
                        case 4:
                            System.out.println("Saindo...");
                            break;
                
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } while (choice != 4);
            scanner.close();

        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}