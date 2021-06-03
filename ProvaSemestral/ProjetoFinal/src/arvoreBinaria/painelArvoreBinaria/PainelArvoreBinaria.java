package arvoreBinaria.painelArvoreBinaria;

import java.util.ArrayList;
import java.util.Scanner;

import arvoreBinaria.implementacao.position.Position;
import arvoreBinaria.implementacao.source.BTNode;
import arvoreBinaria.implementacao.source.LinkedBinaryTree;
import painel.Menu;

public class PainelArvoreBinaria {
    static LinkedBinaryTree<String> T = null;
    static boolean arvoreCriada = false;
    static ArrayList<String> aux = new ArrayList<String>();
    static ArrayList<Position<String>> posicao = new ArrayList<Position<String>>();
    static Scanner enter = new Scanner(System.in);

    public static void apresentacao(){
        System.out.println("\n==========================================================");
        System.out.println("|                TAD - Árvore Binaria                   |");
        System.out.println("==========================================================");
    }

     // Retorna todas as posicoes e as coloca em um ArrayList
	public static ArrayList<Position<String>> listaDePosicoes() {
		Iterable<Position<String>> positions = T.positions();
		posicao.clear();
		for (Position<String> pos : positions){
			posicao.add(pos);
		}
		// elements.addLast(pos.element());
		return posicao;
	}

    private static void iniciandoArvore() {
        System.out.println(" -----------------------------------------");
        System.out.println("|      Iníciando uma Àrvore Binaria      |");
        System.out.println("|-----------------------------------------|");
        System.out.println("| 1. Vazia                                |");
        System.out.println("| 2. Com elementos                        |");
        System.out.println("|_________________________________________|");

        System.out.print("Informa a forma da árvore inícial: ");
        int entrada = enter.nextInt();

        if(entrada == 1){
            T = new LinkedBinaryTree<String>();
        }else if(entrada == 2){
            T = criarArvoreBinaria();
        }else{
            System.out.println("Opção invalida, tente novamente!");
            iniciandoArvore();
        }
        arvoreCriada = true;
    }

    public static void menuArvoreBinaria(){

        apresentacao();

        if(arvoreCriada == false){
            iniciandoArvore();
        }

        aux.clear();
        for(Position<String> p : listaDePosicoes()){
            aux.add(p.element());
        }

        System.out.println(" -----------------------------------------");
        System.out.println("|                 Métodos                 |");
        System.out.println("|-----------------------------------------|");
        System.out.println("| 1. size                                 |");
        System.out.println("| 2. isInternal                           |");
        System.out.println("| 3. isRoot                               |");
        System.out.println("| 4. hasLeft                              |");
        System.out.println("| 5. root                                 |");
        System.out.println("| 6. left                                 |");
        System.out.println("| 7. parent                               |");
        System.out.println("| 8. replace                              |");
        System.out.println("| 9. sibling                              |");
        System.out.println("| 10. addRoot                             |");
        System.out.println("| 11. insertLeft                          |");
        System.out.println("| 12. insertRight                         |");
        System.out.println("| 13. remove                              |");
        System.out.println("| 14. isEmpty                             |");
        System.out.println("| 15. IsExternal                          |");
        System.out.println("| 16. right                               |");
        System.out.println("| 17. hasRight                            |");
        System.out.println("|-----------------------------------------|");
        System.out.println("| 0. Voltar                               |");
        System.out.println("|_________________________________________|");

        System.out.print("Informa o número do método que deseja testar: ");
        int entrada = enter.nextInt();
        
        
        
        
        
        
        
        
        
        
        
        switch (entrada) {
            case 1:
                testeSize();
                break;
            case 2:
                testeIsInternal(pegaPosicao());
                break;
            case 3:
                testeIsRoot(pegaPosicao());
                break;
            case 4:
                testeHasLeft(pegaPosicao());
                break;
            case 5:
                testeRoot();
                break;
            case 6:
                testeLeft(pegaPosicao());
                break;
            case 7:
                testeParent(pegaPosicao());
                break;
            case 8:
                testeReplace(pegaPosicao());
                break;
            case 9:
                testeSibling(pegaPosicao());
                break;
            case 10:
                testeAddRoot();
                break;
            case 11:
                testeInsertLeft(pegaPosicao());
                break;
            case 12:
                testeInsertRight(pegaPosicao());
                break;
            case 13:
                testeRemove(pegaPosicao());
                break;
            case 14:
                testeIsEmpty();
                break;
            case 15:
                testeIsExternal(pegaPosicao());
                break;
            case 16:
                testeRight(pegaPosicao());
                break;
            case 17:
                testeHasRight(pegaPosicao());
                break;
            case 0:
                Menu.painelGeral();
                break;
        }

    }   

    public static Position<String> pegaPosicao(){
        System.out.println(" -----------------------------------------");
        System.out.println("|                Posições                 |");
        System.out.println("|-----------------------------------------|");
        int item = 1;
        for(String e : aux){
            System.out.println("| " + item + ". " + e + "                                 |");
            item++;
            //if(item == aux.size()) break;
        }
        System.out.println("|_________________________________________|");

        System.out.print("Informa posição que deseja: ");
        int entrada = enter.nextInt();


        return posicao.get(entrada - 1);
    }

    public static LinkedBinaryTree<String> criarArvoreBinaria(){
		BTNode<String> raiz, v, m, i, u;
		T.addRoot("-");
		raiz = (BTNode<String>) T.root();
		//BTNode<String> nodo = new BTNode<String>(element, parent, left, right);
		v = (BTNode<String>) T.insertLeft(raiz, "/");
		m = (BTNode<String>) T.insertRight(raiz, "+");
		
		u = (BTNode<String>) T.insertLeft(v, "x");
		i = (BTNode<String>) T.insertRight(v, "+");
		
		v = (BTNode<String>) T.insertLeft(m, "x");
		T.insertRight(m, "6");
		
		m = (BTNode<String>) T.insertLeft(u, "+");
		T.insertRight(u, "3");

		u = (BTNode<String>) T.insertLeft(i, "-");
		T.insertRight(i, "2");

		T.insertLeft(v, "3");
		i = (BTNode<String>) T.insertRight(v, "-");

		T.insertLeft(m, "3");
		T.insertRight(m, "1");

		T.insertLeft(u, "9");
		T.insertRight(u, "5");
		

		T.insertLeft(i, "7");
		T.insertRight(i, "4");

        return T;
    }

    public static void testeSize(){
        System.out.println("=============================================================");
        System.out.println("Numero de nodos na árvore: " + T.size());
        System.out.println("=============================================================");
        voltandoAoMenu();
    }

    public static void testeIsInternal(Position<String> p){
        System.out.println("=============================================================");
        System.out.println("É interno?: " + T.isInternal(p));
        System.out.println("=============================================================");
        voltandoAoMenu();
    }

    public static void testeIsRoot(Position<String> p){
        System.out.println("=============================================================");
        System.out.println("É a raiz?: " + T.isRoot(p));
        System.out.println("=============================================================");
        voltandoAoMenu();
    }

    public static void testeHasLeft(Position<String> p){
        System.out.println("=============================================================");
        System.out.println("É a raiz?: " + T.isRoot(p));
        System.out.println("=============================================================");
        voltandoAoMenu();
    }

    public static void testeRoot(){
        System.out.println("=============================================================");
        System.out.println("Raiz da árvore: " + T.root().element());
        System.out.println("=============================================================");
        voltandoAoMenu();
    }

    public static void testeLeft(Position<String> p){
        System.out.println("=============================================================");
        System.out.println("Filho da esquerda: " + T.left(p).element());
        System.out.println("=============================================================");
        voltandoAoMenu();
    }

    public static void testeParent(Position<String> p){
        System.out.println("=============================================================");
        System.out.println("Pai: " + T.parent(p));
        System.out.println("=============================================================");
        voltandoAoMenu();
    }
    
    public static void testeReplace(Position<String> p){
        System.out.println("Informe o novo elemento: ");
        String elemento = enter.next();

        System.out.println("=============================================================");
        System.out.println("O elemento " + T.replace(p, elemento) + " foi substituido pelo " + elemento +".");
        System.out.println("=============================================================");
        voltandoAoMenu();
    }
    
    public static void testeSibling(Position<String> p){
        System.out.println("=============================================================");
        System.out.println("Irmão: " + T.sibling(p).element());
        System.out.println("=============================================================");
        voltandoAoMenu();
    }
    
    public static void testeAddRoot(){
        System.out.println("Informe o novo elemento: ");
        String elemento = enter.next();

        System.out.println("=============================================================");
        System.out.println("Elemento: " + T.addRoot(elemento).element() + " adicionado a raiz.");
        System.out.println("=============================================================");
        voltandoAoMenu();
    }
    public static void testeInsertLeft(Position<String> p){
        System.out.println("Informe o novo elemento: ");
        String elemento = enter.next();

        System.out.println("=============================================================");
        System.out.println("Elemento: " + T.insertLeft(p, elemento).element() + " adicionado a esquerda de " + p.element() + ".");
        System.out.println("=============================================================");
        voltandoAoMenu();
    }
    
    public static void testeInsertRight(Position<String> p){
        System.out.println("Informe o novo elemento: ");
        String elemento = enter.next();

        System.out.println("=============================================================");
        System.out.println("Elemento: " + T.insertRight(p, elemento).element() + " adicionado a direita de " + p.element() + ".");
        System.out.println("=============================================================");
        voltandoAoMenu();
    }
    
    public static void testeRemove(Position<String> p){
        System.out.println("=============================================================");
        System.out.println("O elemento: " + T.remove(p) + " foi removido da árvore.");
        System.out.println("=============================================================");
        voltandoAoMenu();
    }
    
    public static void testeIsEmpty(){
        System.out.println("=============================================================");
        System.out.println("A árvore está vazia? " + T.isEmpty());
        System.out.println("=============================================================");
        voltandoAoMenu();
    }
    
    public static void testeIsExternal(Position<String> p){
        System.out.println("=============================================================");
        System.out.println("É externo? " + T.isExternal(p));
        System.out.println("=============================================================");
        voltandoAoMenu();
    }
    
    public static void testeRight(Position<String> p){
        System.out.println("=============================================================");
        System.out.println("Filho a direita: " + T.right(p));
        System.out.println("=============================================================");
        voltandoAoMenu();
    }
    
    public static void testeHasRight(Position<String> p){
        System.out.println("=============================================================");
        System.out.println("Tem filho a direita? " + T.hasRight(p));
        System.out.println("=============================================================");
        voltandoAoMenu();
    }
    
    public static void voltandoAoMenu(){
        System.out.println("Voltando ao menu...");
        try{ Thread.sleep(2000); }catch(Exception error){}
        menuArvoreBinaria();
    }
}
