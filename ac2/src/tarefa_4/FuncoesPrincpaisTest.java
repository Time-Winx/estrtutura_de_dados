package tarefa_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FuncoesPrincpaisTest {

    private Integer[] lista_numeros = {4, 8, 15, 16, 23, 42};
    private String[] lista_nomes = {"jaiminho", "chaves", "chiquinha", "kiko"};
    private Integer[] lista_numeros_esperada = {42, 23, 16, 15, 8, 4,};
    private String[] lista_nomes_esperada = {"kiko", "chiquinha", "chaves", "jaiminho",};


    @Test
    void test() {

        FuncoesPrincpais inverte = new FuncoesPrincpais();

        inverte.reverter_array(lista_numeros);
        inverte.reverter_array(lista_nomes);

        assertArrayEquals(lista_nomes_esperada, lista_nomes);
        assertArrayEquals(lista_numeros_esperada, lista_numeros);
    }

    @Test
    void test_tag_matches() {

        FuncoesPrincpais funcao_tag = new FuncoesPrincpais();

        assertEquals(true, funcao_tag.confere_tag("()"));
        assertEquals(true, funcao_tag.confere_tag("()(( )){([( )])}"));
        assertEquals(true, funcao_tag.confere_tag("((( )(( )){([( )])}))"));
        assertEquals(false, funcao_tag.confere_tag(")(( )){([( )])}"));
        assertEquals(false, funcao_tag.confere_tag(")(( )){([( )])}"));
        assertEquals(false, funcao_tag.confere_tag("("));

    }


}