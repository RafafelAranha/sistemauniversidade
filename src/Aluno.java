import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private List<Disciplina> disciplinasMatriculadas;

    public Aluno(String nome, int idade) {
        super(nome, idade);
        disciplinasMatriculadas = new ArrayList<>();
    }

    public void matricularDisciplina(Disciplina disciplina) {
        disciplinasMatriculadas.add(disciplina);
    }

    public List<Disciplina> getDisciplinasMatriculadas() {
        return disciplinasMatriculadas;
    }
}