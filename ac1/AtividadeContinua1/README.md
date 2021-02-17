
# Projeto (GitHub + JUnit) 1

- Faça um programa em Java, que tenha a classe Arranjo que:
  - Encontre o menor número em um arranjo de inteiros desordenado.
  - Encontre o maior número em um arranjo de inteiros desordenado.
  - Some todos os valores de uma arranjo de inteiros.
  - Conte o número de vezes que um número inteiro aparece em um arranjo.
  - Exiba os resultdos dos métodos acima para o arranho abaixo.

```java
Integer[] a = (940, 880, 830, 790, 750, 660, 650, 590, 510, 940)
```

## O programa deve passar nos testes abaixo

```Java
class FuncoesPrincipaisTest {

	@Test
	void test() {
		Arranjo a = new Arranjo();
		
		assertEquals(510, a.menor(), "O menor deve ser 440");
		
		assertEquals(940, a.maior(), "O maior é 940");

		assertEquals(7540, a.soma(), "A soma é 7040");
		
		assertEquals(0, a.repeticoes(3), "940 aparece 2 vezes");

		assertEquals(1, a.repeticoes(790), "940 aparece 2 vezes");

		assertEquals(2, a.repeticoes(940), "940 aparece 2 vezes");
	}

}
```
