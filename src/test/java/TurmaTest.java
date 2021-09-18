import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

class TurmaTest {

    @Test
    public void criaTurma() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Aula pra engrossar as pernas");
        Instrutor instrutor = new Instrutor("Ixtronda");
        Aula aula = new Aula(conteudo,"10:00",instrutor);
        Turma turma = new Turma(aula);

        assertEquals(aula, turma.getAula());
    }

    @Test
    void adicionarCliente() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Aula pra engrossar as pernas");
        Instrutor instrutor = new Instrutor("Ixtronda");

        Aula aula = new Aula(conteudo,"10:00",instrutor);
        Turma turma = new Turma(aula);
        Cliente cliente = new Cliente("Jobesclau");

        turma.adicionarCliente(cliente);

        assertEquals(1, turma.getNumeroClientes());
    }

    @Test
    void removeCliente() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Aula pra engrossar as pernas");
        Instrutor instrutor = new Instrutor("Ixtronda");
        Aula aula = new Aula(conteudo,"10:00",instrutor);
        Turma turma = new Turma(aula);
        Cliente cliente = new Cliente("Josefina");

        turma.removerCliente(cliente);

        assertEquals(0, turma.getNumeroClientes());
    }

    @Test
    void verificaCliente() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Aula pra engrossar as pernas");
        Instrutor instrutor = new Instrutor("Ixtronda");
        Aula aula = new Aula(conteudo,"10:00",instrutor);
        Turma turma = new Turma(aula);
        Cliente cliente = new Cliente("Joaninha");
        turma.adicionarCliente(cliente);

        assertTrue(turma.verificarCliente(cliente));
    }

    @Test
    void naoVerificaCliente() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Aula sobre segurança no transito");
        Instrutor instrutor = new Instrutor("Ixtronda");
        Aula aula = new Aula(conteudo,"10:00",instrutor);
        Turma turma = new Turma(aula);
        Cliente cliente = new Cliente("Leozin");

        assertFalse(turma.verificarCliente(cliente));
    }

    @Test
    void retornaNomeClientes() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Estora panturrilha");
        Instrutor instrutor = new Instrutor("Ixtronda");
        Aula aula = new Aula(conteudo,"10:00",instrutor);
        Turma turma = new Turma(aula);
        Cliente cliente1 = new Cliente("Zézin");
        Cliente cliente2 = new Cliente("Josefina");

        turma.adicionarCliente(cliente1);
        turma.adicionarCliente(cliente2);

        assertTrue(turma.getNomesClientes().contains(cliente1.getNome()));
        assertTrue(turma.getNomesClientes().contains(cliente2.getNome()));
    }


    @Test
    void retornaExcecaoNomeClientes() {
        try{
            Conteudo conteudo = new Conteudo();
            conteudo.setDescricao("Estoura panturrilha");
            Instrutor instrutor = new Instrutor("Ixtronda");
            Aula aula = new Aula(conteudo,"10:00",instrutor);
            Turma turma = new Turma(aula);
            turma.getNomesClientes();
            fail();
        }
        catch (NullPointerException e) {
            assertEquals("Turma sem clientes", e.getMessage());
        }
    }

    @Test
    void retornaNomeClientesMock() {
        Aula aula = createMock(Aula.class);
        Turma turma = new Turma(aula);

        Cliente cliente = createMock(Cliente.class);
        expect(cliente.getNome()).andReturn("Juluis");
        replay(cliente);

        turma.adicionarCliente(cliente);

        assertTrue(turma.getNomesClientes().contains("Juluis"));
    }

    @Test
    void verificaClienteMock() {
        Aula aula = createMock(Aula.class);
        replay(aula);

        Turma turma = new Turma(aula);
        Cliente cliente = new Cliente("Jãozinhu");
        turma.adicionarCliente(cliente);

        assertTrue(turma.verificarCliente(cliente));
    }

}
