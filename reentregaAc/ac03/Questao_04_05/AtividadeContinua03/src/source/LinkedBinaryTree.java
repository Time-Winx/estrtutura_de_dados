package source;
import java.util.Iterator;
import java.util.Stack;

import exceptions.BoundaryViolationException;
import exceptions.EmptyTreeException;
import exceptions.InvalidPositionException;
import exceptions.NonEmptyTreeException;

import position.Position;
import tad_lista_de_nodos.NodePositionList;
import tad_lista_de_nodos.PositionList;

// * Implementa��o da interface BinaryTree usando uma estrutura encadeada.
public class LinkedBinaryTree<E> implements BinaryTree<E> {
	protected BTPosition<E> root; // refer�ncia para a raiz
	protected int size; // n�mero de nodos
	
	// Cria uma �rvore bin�ria vazia.
	public LinkedBinaryTree() {
		root = null; // inicia com uma �rvore vazia
		size = 0;
	}
	
	// Retorna o n�mero de nodos da �rvore.
	public int size() { return size; }
	// Retorna se um nodo � interno.
	public boolean isInternal(Position<E> v) throws InvalidPositionException {
		checkPosition(v); // m�todo auxiliar
		return (hasLeft(v) || hasRight(v));
	}
	// Retorna se um nodo � a raiz.
	public boolean isRoot(Position<E> v) throws InvalidPositionException {
		checkPosition(v);
		return (v == root());
	}
	
	//Retorna se um nodo tem o filho da esquerda.
	public boolean hasLeft(Position<E> v) throws InvalidPositionException {
		BTPosition<E> vv = checkPosition(v);
		return (vv.getLeft() != null);
	}
	//Retorna a raiz da �rvore.
	public Position<E> root() throws EmptyTreeException {
		if (root == null) throw new EmptyTreeException("The tree is empty");
		return root;
	}
	//Retorna o filho da esquerda de um nodo.
	public Position<E> left(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<E> vv = checkPosition(v);
		Position<E> leftPos = (Position<E>) vv.getLeft();
		if (leftPos == null) throw new BoundaryViolationException("No left child");
		return leftPos;
	}
	//Retorna o pai de um nodo.
	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<E> vv = checkPosition(v);
		Position<E> parentPos = (Position<E>) vv.getParent();
		if (parentPos == null) throw new BoundaryViolationException("No parent");
		return parentPos;
	}
	//Retorna uma cole��o iter�vel contendo os filhos de um nodo.
	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException {
		PositionList<Position<E>> children = new NodePositionList<Position<E>>();
		if (hasLeft(v)) children.addLast(left(v));
		if (hasRight(v)) children.addLast(right(v));
		return children;
	}
	//Retorna uma cole��o iter�vel (inorder) contendo os nodos da �rvore.
	public Iterable<Position<E>> positionsInorder() {
		PositionList<Position<E>> positions = new NodePositionList<Position<E>>();
		if (size != 0) preorderPositions(root(), positions); // atribui as posi��es usando caminhamento prefixado
		return positions;
	}

	

	//Retorna uma cole��o iter�vel contendo os nodos da �rvore.
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> positions = new NodePositionList<Position<E>>();
		if (size != 0) preorderPositions(root(), positions); // atribui as posi��es usando caminhamento prefixado
		return positions;
	}
	//Retorna um iterador sobre os elementos armazenados nos nodos
	public Iterator<E> iterator() {
		Iterable<Position<E>> positions = positions();
		PositionList<E> elements = new NodePositionList<E>();
		for (Position<E> pos : positions) elements.addLast(pos.element());
		return elements.iterator(); // Um iterador sobre os elementos
	}
	//Substitui o elemento armazenado no nodo.
	public E replace(Position<E> v, E o) throws InvalidPositionException {
		BTPosition<E> vv = checkPosition(v);
		E temp = v.element();
		vv.setElement(o);
		return temp;
	}
	//M�todo de acesso adicional
	//Retorna o irm�o de um nodo
	public Position<E> sibling(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<E> vv = checkPosition(v);
		BTPosition<E> parentPos = vv.getParent();
		if (parentPos != null) {
			BTPosition<E> sibPos;
			BTPosition<E> leftPos = parentPos.getLeft();
			if (leftPos == vv) sibPos = parentPos.getRight();
			else sibPos = parentPos.getLeft();
			if (sibPos != null) return sibPos;
		}
		throw new BoundaryViolationException("No sibling");
	}
	//M�todos de acesso adicionais
	//Insere a raiz em uma �rvore vazia
	public Position<E> addRoot(E e) throws NonEmptyTreeException {
		if (!isEmpty()) throw new NonEmptyTreeException("Tree already has a root");
		size = 1;
		root = createNode(e, null, null, null);
		return root;
	}
	//Insere o filho da esquerda em um nodo.
	public Position<E> insertLeft(Position<E> v, E e) throws InvalidPositionException {
		BTPosition<E> vv = checkPosition(v);
		Position<E> leftPos = (Position<E>) vv.getLeft();
		if (leftPos != null) throw new InvalidPositionException("Node already has a left child");
		BTPosition<E> ww = createNode(e, vv, null, null);
		vv.setLeft(ww);
		size++;
		return ww;
	}
	//Insere o filho da direita em um nodo.
	public Position<E> insertRight(Position<E> v, E e) throws InvalidPositionException {
		BTPosition<E> vv = checkPosition(v);
		Position<E> rightPos = (Position<E>) vv.getRight();
		if (rightPos != null) throw new InvalidPositionException("Node already has a right child");
		BTPosition<E> ww = createNode(e, vv, null, null);
		vv.setRight(ww);
		size++;
		return ww;
	}
	//Remove um nodo com zero ou um filho.
	public E remove(Position<E> v) throws InvalidPositionException {
		BTPosition<E> vv = checkPosition(v);
		BTPosition<E> leftPos = vv.getLeft();
		BTPosition<E> rightPos = vv.getRight();
		if (leftPos != null && rightPos != null) throw new InvalidPositionException("Cannot remove node with two children");
		BTPosition<E> ww; // o �nico filho de v, se houver
		if (leftPos != null) ww = leftPos;
		else if (rightPos != null) ww = rightPos;
		else // v � folha
			ww = null;
		if (vv == root) { // v � a raiz
			if (ww != null) ww.setParent(null);
			root = ww;
		} else { // v n�o � a raiz
			BTPosition<E> uu = vv.getParent();
			if (vv == uu.getLeft()) uu.setLeft(ww);
			else uu.setRight(ww);
			if (ww != null) ww.setParent(uu);
		}
		size--;
		return v.element();
	}
	//Conecta duas �rvores para serem sub�rvores de um nodo externo.
	public void attach(Position<E> v, BinaryTree<E> T1, BinaryTree<E> T2) throws InvalidPositionException {
		BTPosition<E> vv = checkPosition(v);
		if (isInternal(v)) throw new InvalidPositionException("Cannot attach from internal node");
		if (!T1.isEmpty()) {
			BTPosition<E> r1 = checkPosition(T1.root());
			vv.setLeft(r1);
			r1.setParent(vv); // T1 deve ser invalidada
		}
		if (!T2.isEmpty()) {
			BTPosition<E> r2 = checkPosition(T2.root());
			vv.setRight(r2);
			r2.setParent(vv); // T2 deve ser invalidada
		}
	}
	//Se v � um nodo de �rvore bin�ria, converte para BTPosition, caso contr�rio lan�a exce��o
	protected BTPosition<E> checkPosition(Position<E> v) throws InvalidPositionException {
	if (v == null || !(v instanceof BTPosition)) throw new InvalidPositionException("The position is invalid");
	return (BTPosition<E>) v;
	}
	//Cria um novo nodo de �rvore bin�ria
	protected BTPosition<E> createNode(E element, BTPosition<E> parent, BTPosition<E> left, BTPosition<E> right) {
		return new BTNode<E>(element, parent, left, right);
	}
	//Cria uma lista que armazena os nodos da sub�rvore de um nodo ordenados de acordo com o
	//caminhamento prefixado da sub�rvore.
	protected void preorderPositions(Position<E> v, PositionList<Position<E>> pos) throws InvalidPositionException {
		pos.addLast(v);
		if (hasLeft(v)) preorderPositions(left(v), pos); // recurs�o sobre o filho da esquerda
		if (hasRight(v)) preorderPositions(right(v), pos); // recurs�o sobre o filho da direita
	}
	public boolean isEmpty() { return (size == 0); }
	public boolean isExternal(Position<E> v) throws InvalidPositionException { return !isInternal(v); }

	public Position<E> right(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<E> vv = checkPosition(v);
		Position<E> rightPos = (Position<E>) vv.getRight();
		if (rightPos == null) throw new BoundaryViolationException("No right child");
		return rightPos;
	}
	public boolean hasRight(Position<E> v) throws InvalidPositionException {
		BTPosition<E> vv = checkPosition(v);
		return (vv.getRight() != null);
	}

	//======================================================================================
	//	QUESTAO 5
	//======================================================================================
	// Alternativa A
	public LinkedBinaryTree<E> buildExpression(String expression){

		Stack<LinkedBinaryTree<E>> S = new Stack<LinkedBinaryTree<E>>();
		LinkedBinaryTree<E> T, T1, T2;
		for(int i = 0; i < expression.length()-1; i++){
			if(expression.charAt(i) != '(' && expression.charAt(i) != ')'){
				T = new LinkedBinaryTree<E>();
				String elemento = Character.toString(expression.charAt(i));
				T.addRoot((E) elemento);
				S.push(T);
			}else if(expression.charAt(i) == '('){
				continue;
			}else if(expression.charAt(i) == ')'){
				T2 = S.pop();
				T = S.pop();
				T1 = S.pop();
				T.attach(T.root(), T1, T2);
				S.push(T);
			}
		}
		return S.pop();
	}
	// Alternativa B
	public void binaryPreorder(BinaryTree<E> T, Position<E> v){
		System.out.print(v.element().toString() + " "); // ação principal de visita
		if(T.hasLeft(v)){
			binaryPreorder(T, T.left(v));
		}
		if(T.hasRight(v)){
			binaryPreorder(T, T.right(v));
		}
	}

	// Alternativa C
	public void binaryPostorder(BinaryTree<E> T, Position<E> v){
		if(T.hasLeft(v)){
			binaryPostorder(T, T.left(v));
		}
		if(T.hasRight(v)){
			binaryPostorder(T, T.right(v));
		}
		System.out.print(v.element().toString() + " "); // ação principal de visita
	}

	// Alternativa D
	public String evaluateExpression(BinaryTree<E> T, Position<E> v){
		if(T.isInternal(v)){
			
		}
	}



	// Questao 5 Alternativa E
	
	public String inorder(BinaryTree<E> T, Position<E> v){
		String s = "";
		if(T.hasLeft(v)){
			s += "(";
			inorder(T, T.left(v));
		}
		s += v;
		if(T.hasRight(v)){
			inorder(T, T.left(v));
			s += ")";
		}
		return s;
	}
	
	// Questao 5 Alternativa I
	public String printExpression(BinaryTree<E> T, Position<E> v) {
		String s = "";
		if (T.isInternal(v)) {
			s +="(";
		}
		if (T.hasLeft(v)) {
			printExpression(T, T.left(v));
		}
		if (T.isInternal(v)){
			s += v;
		}
	
		if (T.hasRight(v)) {
			printExpression(T,T.right(v));
		}
		if (T.isInternal(v)){
			s +=")";
		}

		return s;
	}
	

}