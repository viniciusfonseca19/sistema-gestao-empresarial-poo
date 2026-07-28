package utils;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void iniciar() {

        int opcao;

        do {

            exibirMenuPrincipal();

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("\n=== MÓDULO DE PRODUTOS ===\n");
                    break;

                case 2:
                    System.out.println("\n=== MÓDULO DE CLIENTES ===\n");
                    break;

                case 3:
                    System.out.println("\n=== MÓDULO DE VENDAS ===\n");
                    break;

                case 0:
                    System.out.println("\nEncerrando o sistema...");
                    break;

                default:
                    System.out.println("\nOpção inválida!\n");

            }

        } while (opcao != 0);

        scanner.close();

    }

    private void exibirMenuPrincipal() {

        System.out.println(" SISTEMA DE GESTÃO COMERCIAL");
        System.out.println("\n1 - Produtos");
        System.out.println("2 - Clientes");
        System.out.println("3 - Vendas");
        System.out.println("0 - Sair");
        System.out.println("=================================");

    }

}