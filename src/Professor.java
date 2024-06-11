public class Professor extends Pessoa {
    private String disciplinaLecionada;

    public Professor(String nome, int idade, String disciplinaLecionada) {
        super(nome, idade);
        this.disciplinaLecionada = disciplinaLecionada;
    }

    public String getDisciplinaLecionada() {
        return disciplinaLecionada;
    }

    public void setDisciplinaLecionada(String disciplinaLecionada) {
        this.disciplinaLecionada = disciplinaLecionada;
    }
}
