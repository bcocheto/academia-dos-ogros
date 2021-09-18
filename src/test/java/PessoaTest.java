import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void criaPessoa() {
        Pessoa pessoa = new Pessoa("Jão");

        assertEquals("Jão", pessoa.getNome());
    }

    @Test
    void retornaNomeNuloConstrutor() {
        try {
            Pessoa pessoa = new Pessoa(null);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Nome é obrigatorio", e.getMessage());
        }
    }

    @Test
    void retornaNomeVazioConstrutor() {
        try {
            Pessoa pessoa = new Pessoa("");
            fail();
        } catch (NullPointerException e) {
            assertEquals("Nome é obrigatorio", e.getMessage());
        }
    }

    @Test
    void mudaNomePessoa() {
        Pessoa pessoa = new Pessoa("Jão");
        pessoa.setNome("Jãozin");

        assertEquals("Jãozin", pessoa.getNome());
    }

    @Test
    void retornaExecaoMudarNomePessoaNulo() {
        try {
            Pessoa pessoa = new Pessoa("João");
            pessoa.setNome(null);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Nome é obrigatorio", e.getMessage());
        }
    }

    @Test
    void retornaExecaoMudarNomePessoaVazio() {
        try {
            Pessoa pessoa = new Pessoa("Jão");
            pessoa.setNome("");
            fail();
        } catch (NullPointerException e) {
            assertEquals("Nome é obrigatorio", e.getMessage());
        }
    }

}