import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

class AulaTest {

        @Test
        public void criaAula(){
            Conteudo conteudo = new Conteudo();
            conteudo.setDescricao("Aula do treinamento ogro");
            Instrutor instrutor = new Instrutor("Ixtronda");

            Aula aula = new Aula(conteudo,"10:00",instrutor);
            assertEquals(conteudo, aula.getConteudo());
        }

        @Test
        public void retornaExcecaoConteudoNulo(){
            try {
                Instrutor instrutor = new Instrutor("Ixtronda");
                Aula aula = new Aula(null,"10:00",instrutor);
                fail();
            } catch (NullPointerException e) {
                assertEquals("Conteudo é obrigatorio", e.getMessage());
            }
        }

    @Test
    public void retornaExcecaoHorarioNulo(){
        try {
            Conteudo conteudo = new Conteudo();
            Instrutor instrutor = new Instrutor("Ixtronda");
            Aula aula = new Aula(conteudo,null,instrutor);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Horário é obrigatorio", e.getMessage());
        }
    }

        @Test
        public void retornaDescricaoConteudoAula() {
            Conteudo conteudo = new Conteudo();
            conteudo.setDescricao("Aula pra engrossar as pernas");
            Instrutor instrutor = new Instrutor("Ixtronda");
            Aula aula = new Aula(conteudo,"10:00",instrutor);

            assertEquals("Aula pra engrossar as pernas", aula.getDescricaoConteudo());
        }

    @Test
    public void retornaHorarioAula() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Aula pra engrossar as pernas");
        Instrutor instrutor = new Instrutor("Ixtronda");

        Aula aula = new Aula(conteudo,"10:00",instrutor);

        assertEquals("10:00", aula.getHorario());
    }

        @Test
        public void retornaInstrutor() {
            Conteudo conteudo = new Conteudo();
            conteudo.setDescricao("Aula racha coluna");

            Instrutor instrutor = new Instrutor("Leozin Ixtronda");

            Aula aula = new Aula(conteudo,"10:00",instrutor);
            aula.setInstrutor(instrutor);

            assertEquals(instrutor, aula.getInstrutor());
        }

        @Test
        public void retornaNomeInstrutor() {

            Conteudo conteudo = new Conteudo();
            conteudo.setDescricao("Aula de spinning pra raxar perna");
            Instrutor instrutor = new Instrutor("Bam Bam do Birl");

            Aula aula = new Aula(conteudo,"10:00",instrutor);
            aula.setInstrutor(instrutor);

            assertEquals("Bam Bam do Birl", aula.getNomeInstrutor());
        }

        @Test
        public void retornaAulaSemInstrutor() {
            Conteudo conteudo = new Conteudo();
            conteudo.setDescricao("Aula do monxtro");

            Aula aula = new Aula(conteudo,"10:00",null);

            assertEquals("Aula sem instrutor", aula.getNomeInstrutor());
        }

        @Test
        public void retornaNomeInstrutorMock() {
            Conteudo conteudo = new Conteudo();

            Instrutor instrutor = createMock(Instrutor.class);
            expect(instrutor.getNome()).andReturn("Leozin Ixtronda");
            replay(instrutor);

            Aula aula = new Aula(conteudo,"10:00",instrutor);
            aula.setInstrutor(instrutor);

            assertEquals("Leozin Ixtronda", aula.getNomeInstrutor());
        }

        @Test
        public void retornaDescricaoConteudoAulaMock() {
            Conteudo conteudo = createMock(Conteudo.class);
            expect(conteudo.getDescricao()).andReturn("Aula pra engrossar as pernas");
            replay(conteudo);
            Instrutor instrutor = new Instrutor("Bam Bam do Birl");

            Aula aula = new Aula(conteudo,"10:00",instrutor);

            assertEquals("Aula pra engrossar as pernas", aula.getDescricaoConteudo());
        }

    }

