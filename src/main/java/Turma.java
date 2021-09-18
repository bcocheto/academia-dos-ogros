import java.util.ArrayList;
import java.util.List;

public class Turma {
    private List<Cliente> clientes;
    private Aula aula;

    public Turma(Aula aula){
        if (aula == null) {
            throw new NullPointerException("Aula é obrigatoria");
        }
        this.aula = aula;
        this.clientes = new ArrayList<Cliente>();
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public int getNumeroClientes() {
        return this.clientes.size();
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void removerCliente(Cliente cliente) {
        this.clientes.remove(cliente);
    }

    public boolean verificarCliente(Cliente cliente) {
        return this.clientes.contains(cliente);
    }

    public List getNomesClientes() {
        if (this.clientes.size() == 0) {
            throw new NullPointerException("Turma sem clientes");
        }
        List<String> nomes = new ArrayList<String>();
        for (Cliente cliente : this.clientes) {
            nomes.add(cliente.getNome());
        }
        return nomes;
    }
}
