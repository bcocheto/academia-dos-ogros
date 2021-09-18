public class Aula {

    private Conteudo conteudo;
    private String horario;
    private Instrutor instrutor;

    public Aula(Conteudo conteudo, String horario, Instrutor instrutor){
        if ((conteudo == null) || (conteudo.equals(""))){
            throw new NullPointerException("Conteudo é obrigatorio");
        }
        if ((instrutor == null)|| (instrutor.equals(""))) {
            throw new NullPointerException("Instrutor é obrigatorio");
        }
        if ((horario == null) || (horario.trim().equals(""))){
            throw new NullPointerException("Horário é obrigatorio");
        }
        this.horario = horario;
        this.conteudo = conteudo;
        this.instrutor = instrutor;
    }

    public String getHorario() {

        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Conteudo getConteudo() {

        return conteudo;
    }

    public String getDescricaoConteudo() {

        return this.conteudo.getDescricao();
    }

    public void setConteudo(Conteudo conteudo) {

        this.conteudo = conteudo;
    }
    public Instrutor getInstrutor() {

        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {

        this.instrutor = instrutor;
    }

    public String getNomeInstrutor() {
        if (instrutor == null) {
            return "Aula sem instrutor";
        }
        return instrutor.getNome();
    }
}