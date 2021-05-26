package source;

import java.util.Iterator;
import tad_arvore.*;
import exception.*;

public class LinkedTree<E> implements Tree<E> {

    protected TreePosition<E> root; // Referência para a raíz
    
    protected int size; // Número de Nodos
    
    // Cria uma árvore vazia
    public LinkedTree() {
        root = null; // Inicia uma árvore vazia
        size = 0;
    
    }
    // Retorna um número de nodos da árvore
    public int size() {
        return size;
    }
    
    // Retorna se a árvore está vazia
    public boolean isEmpty() { return (size == 0); }
    // Retorna se um nodo é interno
    public boolean isInternal(Position<E> v) throws InvalidPositionException { return !isExternal(v); }
    // Retorna se um nodo é externo
    public boolean isExternal(Position<E> v) throws InvalidPositionException {
        TreePosition<E> vv = checkPosition(v);
        return (vv.getChildren() == null) || vv.getChildren().isEmpty();
    }
    
    // Retorna se um nodo é a raíz
    public boolean isRoot(Position<E> v) throws InvalidPositionException {
        checkPosition(v);
        return (v == root());
    }
    
    // Retorna a raíz da árvore
    public TreePosition<E> root() throws EmptyTreeException {
        if (root == null) throw new EmptyTreeException("The tree is empty");
        return root;
    }
    
    // Retorna o pai de um nodo
    public TreePosition<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
        TreePosition<E> vv = checkPosition(v);
        TreePosition<E> parentPos = vv.getParent();
        if (parentPos == null) throw new BoundaryViolationException("No parent");
        return parentPos;
    }
    
    // Retorna uma coleção iterável dos filhos de um nodo
    public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException {
        TreePosition<E> vv = checkPosition(v);
        return vv.getChildren();
    }
    
    // Retorna uma coleção iterável dos nodos da árvore.
    public Iterable<Position<E>> positions() {
        PositionList<Position<E>> positions = new NodePositionList<Position<E>>();
        if (size != 0) preorderPositions(root(), positions);
        return positions;
    
    }
    
    // Retorna um iterator dos elementos armazenados nos nodos
    
    public Iterator<E> iterator() {
        Iterable<Position<E>> positions = positions();
        PositionList<E> elements = new NodePositionList<E>();
        for (Position<E> pos : positions) elements.addLast(pos.element());
        return elements.iterator();
    }
    
    // Troca o elemento de um nodo
    
    public E replace(Position<E> v, E o) throws InvalidPositionException {
        TreePosition<E> vv = checkPosition(v);
        E temp = v.element();
        vv.setElement(o);
        return temp;
    }
    
    // Métodos de atualização adicionais
    
    // Adiciona um nodo raíz para uma árvore vazia
    
    public TreePosition<E> addRoot(E e) throws NonEmptyTreeException {
        if (!isEmpty()) throw new NonEmptyTreeException("Tree already has a root");
        size = 1;
        root = createNode(e, null, null);
        return root;

    }
    
    // Troca os elementos de dos nodos
    public void swapElements(Position<E> v, Position<E> w) throws InvalidPositionException {
        TreePosition<E> vv = checkPosition(v);
        TreePosition<E> ww = checkPosition(w);
        E temp = w.element();
        ww.setElement(v.element());
        vv.setElement(temp);
    }
    
    // Métodos auxiliares
    
    // Se v é um bom nodo da árvore, cast para TreePosition, caso contrário, lança exceção
    
    protected TreePosition<E> checkPosition(Position<E> v) throws InvalidPositionException {
        if (v == null || !(v instanceof TreePosition)) throw new InvalidPositionException("The position is invalid");
        return (TreePosition<E>) v;
    
    }
    
    // Cria um novo nodo da árvore
    protected TreePosition<E> createNode(E element, TreePosition<E> parent, PositionList<Position<E>> children) {
        return new TreeNode<E>(element, parent, children);
    
    }
    
    // Cria uma lista armazenando os nodos das subárvore de um nodo
    
    // ordenado de acordo com a travessia das subárvores
    protected void preorderPositions(Position<E> v, PositionList<Position<E>> pos) throws InvalidPositionException {
        pos.addLast(v);
        for (Position<E> w : children(v)) preorderPositions(w, pos);
        
    }
    
    public String toString() { return toString(this); }
    
    public static <E> String toString(LinkedTree<E> T) {
        String s = "";
        for (E i : T) { s += ", " + i; }
        s = (s.length() == 0 ? s : s.substring(2));
        return "[" + s + "]";
        
    }






    //=========================================================================================
    //  QUESTAO 03
    //=========================================================================================
    // Implementação 3.A 
    public String parentheticRepresentation (Tree<E> T, Position<E> v) {

        String s = v.element().toString(); // ação principal de visita
        if (T.isInternal(v)) {
            Boolean firstTime = true;
            for (Position<E> w : T.children(v)) {
                if (firstTime) { // primeiro filho
                    s += "(\n"  + parentheticRepresentation(T,w);
                    firstTime = false;
                } 
                else { // filhos seguintes
                    s += "," + parentheticRepresentation(T, w);
                }
                s += ")";
            }
        }
        return s;
    }
    // Implementação 3.B
    public String toStringPostorder(Tree<E> T, Position<E> v){
		String s = "";
		for(Position<E> w : T.children(v)){
			s += toStringPostorder(T, w) + " ";
		}
		s += v.element();
		return s;
	}
    //com base
    public String posorder (Tree<E> T, Position<E> v) {
        String s = "";
        if (T.isInternal(v)) {
            Boolean firstTime = true;
            for (Position<E> w : T.children(v)) {
                if (firstTime) {
                    // primeiro filho
                    s += "(\n" + "    " + posorder(T,w);
                    firstTime = false;
                } else {
                    // filhos seguintes
                    s += "," + posorder(T, w);
                }
                s += ")"; // fecha parênteses
            }
        }
        s = v.element().toString(); // ação principal de visita
        return s;
    }
    // Implementação 3.C
    public int diskSpace(LinkedTree<DiscNode> T, TreePosition<DiscNode> v) {

        int s = v.element().getKbytes();
        for (Position<DiscNode> w : v.getChildren()) {
            s += diskSpace(T, (TreePosition<DiscNode>)w);
        }
        
        if (T.isInternal(v)) {
            System.out.println(v.getElement().getName() + ": " + s);
        
        }
        return s;
    }
    
    // Implementação 3.D
    public int depth(Tree<E> T, Position<E> v){
        if(T.isRoot(v))
            return 0;
        return 1 + depth(T, parent(v));
    }

    // Implementação 3.E
    public int height1(Tree<E> T){
        int h = 0;
        for(Position<E> v : T.positions()){
            h = Math.max(h, depth(T, v));
        }
        return h;
    }
    // Implementação 3.F
    public int height2(Tree<E> T, Position<E> v){
        if(T.isExternal(v)){
            return 0;
        }
        int h = 0;
        for(Position<E> w : T.children(v)){
            h = Math.max(h, height2(T, w));
        }
        return 1 + h;
    }
       
}
