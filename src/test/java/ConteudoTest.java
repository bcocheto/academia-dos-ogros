import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConteudoTest {

    @Test
    public void setaDescricaoConteudo() {
        Conteudo conteudo = new Conteudo();

        conteudo.setDescricao("Aquecimendo mindinho");
        assertEquals("Aquecimendo mindinho", conteudo.getDescricao());
    }
}