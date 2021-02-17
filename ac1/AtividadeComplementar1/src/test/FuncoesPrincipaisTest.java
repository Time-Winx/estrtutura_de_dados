package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FuncoesPrincipaisTest {

	@Test
	void test() {
		Arranjo a = new Arranjo();
		
		assertEquals(510, a.menor(), "O menor deve ser 510");
		
		assertEquals(940, a.maior(), "O maior é 940");

		assertEquals(7540, a.soma(), "A soma é 7040");
		
		assertEquals(0, a.repeticoes(3), "3 aparece 0 vezes");

		assertEquals(1, a.repeticoes(790), "790 aparece 1 vezes");

		assertEquals(2, a.repeticoes(940), "940 aparece 2 vezes");
		
		System.out.println(a.resultado());
	}

}
