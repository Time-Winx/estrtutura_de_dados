package filaDePrioridade.painel;

import java.util.Scanner;

import listaArranjo.implementacao.ArrayIndexList;
import painel.Menu;

public class PainelFilaDePrioridade {
    static ArrayIndexList<Integer> arr = new ArrayIndexList<Integer>();

    public static void apresentacao(){
        System.out.println("\n==========================================================");
        System.out.println("|                    Painel de Prioridade                  |");
        System.out.println("============================================================");
    }

    public static void menuFIlaDePrioridade(){
        Scanner enter = new Scanner(System.in);
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
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            default:
                System.out.println("Opção Invalida!");
                voltandoAoMenu();
        }
    }

    public static void voltandoAoMenu(){
        System.out.println("Voltando ao menu...");
        try{ Thread.sleep(2500); }catch(Exception error){}
        menuArranjo();
    }
}
