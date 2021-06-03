package filaDePrioridade.painel;

import java.util.Scanner;

import filaDePrioridade.implementacao.SortedListPriorityQueue;
import listaArranjo.implementacao.ArrayIndexList;
import painel.Menu;

public class PainelFilaDePrioridade {
    static ArrayIndexList<Integer> arr = new ArrayIndexList<Integer>();

    public static void apresentacao(){
        System.out.println("\n==========================================================");
        System.out.println("|                    Fila de Prioridade                     |");
        System.out.println("============================================================");
    }

    public static void menuFIlaDePrioridade(){
        Scanner enter = new Scanner(System.in);
        SortedListPriorityQueue<Integer, Integer> Lista = new SortedListPriorityQueue<Integer, Integer>();
        apresentacao();
        //mostrarArranjo();

        System.out.println(" -----------------------------------------");
        System.out.println("|                 Métodos                 |");
        System.out.println("|-----------------------------------------|");
        System.out.println("| 1. Size                                 |");
        System.out.println("| 2. IsEmpty                              |");
        System.out.println("| 3. Min                                  |");
        System.out.println("| 4. Insert                               |");
        System.out.println("| 5. removeMin                            |");
        System.out.println("|_________________________________________|");
        System.out.println("| 8. Voltar                               |");
        System.out.println("|_________________________________________|");

        System.out.print("Informa o número do método que deseja testar: ");
        int entrada = enter.nextInt();

        switch (entrada) {
            case 1:
                testeSize(Lista);
                break;
            case 2:
                testaEmpty(Lista);
                break;
            case 3:
                testaMin(Lista);
                break;
            case 4:
                testaInsert(Lista);
                break;
            case 5:
                testaRemoveMin(Lista);
                break;
            default:
                System.out.println("Opção Invalida!");
                voltandoAoMenu();
        }
    }

    private static void testaRemoveMin(SortedListPriorityQueue<Integer, Integer> lista) {
        System.out.println("|--------------------------------|");
        System.out.println("| Valor" + lista.removeMin() + "removido |");
        System.out.println("|________________________________|");
        voltandoAoMenu();
    }

    private static void testaInsert(SortedListPriorityQueue<Integer, Integer> lista) {
        Scanner entradas = new Scanner(System.in);
        System.out.println("Insira uma chave(Integer)");

        int chave =  entradas.nextInt();

        System.out.println("Insira um valor(Integer)");

        int valor =  entradas.nextInt();

        System.out.println("|--------------------------------|");
        System.out.println("| Valor " + lista.insert(chave, valor) + " inserido|");
        System.out.println("|________________________________|");
        voltandoAoMenu();
    }

    private static void testeSize(SortedListPriorityQueue<Integer, Integer> lista) {
        System.out.println("|--------------------------------|");
        System.out.println("| Tamanho da lista: " + lista.size() + "|");
        System.out.println("|________________________________|");
        voltandoAoMenu();
    }

    private static void testaEmpty(SortedListPriorityQueue<Integer, Integer> lista) {
        System.out.println("|--------------------------------|");
        System.out.println("| Lista vazia: " + lista.isEmpty() + "|");
        System.out.println("|________________________________|");
        voltandoAoMenu();
    }

    private static void testaMin(SortedListPriorityQueue<Integer, Integer> lista) {
        System.out.println("|--------------------------------|");
        System.out.println("| Valor minimo: " + lista.min() + "|");
        System.out.println("|________________________________|");
        voltandoAoMenu();
    }

    public static void voltandoAoMenu(){
        System.out.println("Voltando ao menu...");
        try{ Thread.sleep(2500); }catch(Exception error){}
        menuFIlaDePrioridade();
    }
}
