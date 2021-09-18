import java.util.Date;

public class Pessoa {
    private String nome;

    public Pessoa(String nome) {
        if ((nome == null) || (nome.trim().equals(""))) {
            throw new NullPointerException("Nome é obrigatorio");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if ((nome == null) || (nome.trim().equals(""))) {
            throw new NullPointerException("Nome é obrigatorio");
        }
        this.nome = nome;
    }
}