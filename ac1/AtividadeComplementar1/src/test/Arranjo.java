package test;

import java.util.Arrays;


public class Arranjo {
	
	public static int[] a = new int[] {940, 880, 830, 790, 750, 660, 650, 590, 510, 940};
	public static int[] clone_a = a.clone();
	

	public Integer menor() {
		// TODO Auto-generated method stub
		Arrays.sort(clone_a);

		return clone_a[0];
	}
	
	public Integer maior() {
		// TODO Auto-generated method stub
		Arrays.sort(clone_a);
		
		return clone_a[a.length-1];
	}

	public Integer soma() {
		// TODO Auto-generated method stub
		int sum = 0;
		
		for(int i = 0; i<a.length; i++) {
			sum = sum + a[i];
		}
		return sum;
	}

	public Integer repeticoes(int value) {
		// TODO Auto-generated method stub
		int rep = 0;
		
		for(int i = 0; i<a.length; i++) {
			if (value == a[i]) {
				rep = rep + 1;
			};
		}
		
		return rep;
	}
	
	public String resultado() {
        return "Valor menor: " + menor() + "\n" +
                "Valor maior: " + maior() + "\n" +
                "Soma de todos: " + soma() + "\n" + 
                "Quantidade inteiro 1: " + repeticoes(3) + "\n" +
                "Quantidade inteiro 1: " + repeticoes(790) + "\n" + 
                "Quantidade inteiro 1: " + repeticoes(940) + "\n";};

	

}
