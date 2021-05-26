package tests;

import org.junit.jupiter.api.Test;
import source.BTNode;
import source.LinkedBinaryTree;

class LinkedBinaryTreeTest {

	@Test
	void test() {
		LinkedBinaryTree<String> T = new LinkedBinaryTree<String>();
		BTNode<String> raiz, v, m, i, u;
		T.addRoot("-");
		raiz = (BTNode<String>) T.root();
		//BTNode<String> nodo = new BTNode<String>(element, parent, left, right);
		v = (BTNode<String>) T.insertLeft(raiz, "/");
		m = (BTNode<String>) T.insertRight(raiz, "+");
		sizeLeftRight(T, raiz);
		
		u = (BTNode<String>) T.insertLeft(v, "x");
		i = (BTNode<String>) T.insertRight(v, "+");
		sizeLeftRight(T, v);
		
		v = (BTNode<String>) T.insertLeft(m, "x");
		T.insertRight(m, "6");
		sizeLeftRight(T, m);
		
		m = (BTNode<String>) T.insertLeft(u, "+");
		T.insertRight(u, "3");
		sizeLeftRight(T, u);

		u = (BTNode<String>) T.insertLeft(i, "-");
		T.insertRight(i, "2");
		sizeLeftRight(T, i);

		T.insertLeft(v, "3");
		i = (BTNode<String>) T.insertRight(v, "-");
		sizeLeftRight(T, v);

		T.insertLeft(m, "3");
		T.insertRight(m, "1");
		sizeLeftRight(T, m);

		T.insertLeft(u, "9");
		T.insertRight(u, "5");
		sizeLeftRight(T, u);
		

		T.insertLeft(i, "7");
		T.insertRight(i, "4");
		sizeLeftRight(T, i);


		System.out.println(imprimir(T));

		String expression = "((((3+1)*3)/((9-5)+2))-((3*(7-4))+6))";
		T.buildExpression(expression);

		T.binaryPreorder(T, raiz);
		System.out.println("");
		T.binaryPostorder(T, raiz);


		
	}

	public void sizeLeftRight(LinkedBinaryTree<String> T, BTNode<String> n){
		System.out.println("Tamanho atual:"+ T.size());
		System.out.println("Tem filho a esquerda:"+ T.hasLeft(n));
		System.out.println("Tem filho a direita:"+ T.hasRight(n));
	}
	
	public static <E> String imprimir(LinkedBinaryTree<E> T) {
		String s = "";
		for (E i : T) { s += ", " + i; }
		s = (s.length() == 0 ? s : s.substring(2));
		return "[" + s + "]";
	}
	
}
