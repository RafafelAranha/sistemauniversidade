import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Aluno> alunos = new ArrayList<>();
        List<Professor> professores = new ArrayList<>();
        List<Curso> cursos = new ArrayList<>();
        List<Disciplina> disciplinas = new ArrayList<>();

        int opcao;
        do {
            System.out.println("MENU");
            System.out.println("1 - Adicionar aluno");
            System.out.println("2 - Adicionar professor");
            System.out.println("3 - Adicionar curso");
            System.out.println("4 - Adicionar disciplina");
            System.out.println("5 - Matricular aluno em disciplina");
            System.out.println("6 - Lançar Notas");
            System.out.println("7 - Verificar aprovação do aluno");
            System.out.println("8 - Ver alunos matriculados");
            System.out.println("9 - Ver professores");
            System.out.println("10 - Sair");
            System.out.print("Escolha uma opçao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do aluno: ");
                    String nomeAluno = scanner.nextLine();
                    System.out.print("Idade do aluno: ");
                    int idadeAluno = 0;
                    try {
                        idadeAluno = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: A idade deve ser um numero.");
                        break;
                    }
                    alunos.add(new Aluno(nomeAluno, idadeAluno));
                    System.out.println("Aluno adicionado.");
                    break;

                case 2:
                    System.out.print("Nome do professor: ");
                    String nomeProfessor = scanner.nextLine();
                    System.out.print("Idade do professor: ");
                    int idadeProfessor = 0;
                    try {
                        idadeProfessor = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: A idade deve ser um numero.");
                        break;
                    }
                    System.out.print("Disciplina lecionada: ");
                    String disciplinaLecionada = scanner.nextLine();
                    professores.add(new Professor(nomeProfessor, idadeProfessor, disciplinaLecionada));
                    System.out.println("Professor adicionado com sucesso!");
                    break;

                case 3:
                    System.out.print("Nome do curso: ");
                    String nomeCurso = scanner.nextLine();
                    System.out.print("Codigo do curso: ");
                    String codigoCurso = scanner.nextLine();
                    cursos.add(new Curso(nomeCurso, codigoCurso));
                    System.out.println("Curso adicionado.");
                    break;

                case 4:
                    System.out.print("Nome da disciplina: ");
                    String nomeDisciplina = scanner.nextLine();
                    System.out.print("Codigo da disciplina: ");
                    String codigoDisciplina = scanner.nextLine();
                    System.out.print("Carga horaria da disciplina: ");
                    int cargaHorariaDisciplina = 0;
                    try {
                        cargaHorariaDisciplina = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: A Carga horaria deve ser um numero.");
                        break;
                    }
                    disciplinas.add(new Disciplina(nomeDisciplina, codigoDisciplina, cargaHorariaDisciplina));
                    System.out.println("Disciplina adicionada com sucesso!");
                    break;

                case 5:
                    System.out.println("MATRICULAR ALUNO NA DISCIPLINA");
                    System.out.println("Lista de alunos:");
                    for (Aluno aluno : alunos) {
                        System.out.println("- " + aluno.getNome());
                    }
                    System.out.print("Digite o nome do aluno: ");
                    String nomeAlunoMatricula = scanner.nextLine();
                    Aluno alunoMatricula = null;
                    for (Aluno aluno : alunos) {
                        if (aluno.getNome().equals(nomeAlunoMatricula)) {
                            alunoMatricula = aluno;
                            break;
                        }
                    }
                    if (alunoMatricula == null) {
                        System.out.println("Erro: Aluno nao encontrado.");
                        break;
                    }

                    System.out.println("Lista de disciplinas:");
                    for (Disciplina disciplina : disciplinas) {
                        System.out.println("- " + disciplina.getNome());
                    }
                    System.out.print("Digite o nome da disciplina: ");
                    String nomeDisciplinaMatricula = scanner.nextLine();
                    Disciplina disciplinaMatricula = null;
                    for (Disciplina disciplina : disciplinas) {
                        if (disciplina.getNome().equals(nomeDisciplinaMatricula)) {
                            disciplinaMatricula = disciplina;
                            break;
                        }
                    }
                    if (disciplinaMatricula == null) {
                        System.out.println("Erro: Disciplina nao encontrada.");
                        break;
                    }

                    alunoMatricula.matricularDisciplina(disciplinaMatricula);
                    System.out.println("Aluno matriculado.");
                    break;

                case 6:
                    System.out.println("LANÇAR NOTAS");
                    System.out.println("Lista de alunos:");
                    for (int i = 0; i < alunos.size(); i++) {
                        System.out.println((i + 1) + ". " + alunos.get(i).getNome());
                    }
                    System.out.print("Selecione o numero do aluno: ");
                    int indiceAlunoNotas = scanner.nextInt() - 1;
                    System.out.println("Lista de disciplinas:");
                    for (int i = 0; i < disciplinas.size(); i++) {
                        System.out.println((i + 1) + ". " + disciplinas.get(i).getNome());
                    }
                    System.out.print("Selecione o numero da disciplina: ");
                    int indiceDisciplinaNotas = scanner.nextInt() - 1;
                    System.out.print("Digite a nota do aluno na disciplina: ");
                    double nota = scanner.nextDouble();
                    alunos.get(indiceAlunoNotas).getDisciplinasMatriculadas().get(indiceDisciplinaNotas).addNota(nota);
                    System.out.println("Nota lançada." + alunos.get(indiceAlunoNotas).getNome());
                    break;

                case 7:
                    System.out.println("VERIFICAR APROVAÇAO");
                    System.out.println("Lista de alunos:");
                    for (int i = 0; i < alunos.size(); i++) {
                        System.out.println((i + 1) + ". " + alunos.get(i).getNome());
                    }
                    System.out.print("Selecione o numero do aluno: ");
                    int indiceAlunoAprovacao = scanner.nextInt() - 1;
                    System.out.println("Lista de disciplinas:");
                    for (int i = 0; i < disciplinas.size(); i++) {
                        System.out.println((i + 1) + ". " + disciplinas.get(i).getNome());
                    }
                    System.out.print("Selecione o numero da disciplina: ");
                    int indiceDisciplinaAprovacao = scanner.nextInt() - 1;
                    Disciplina disciplinaAprovacao = alunos.get(indiceAlunoAprovacao).getDisciplinasMatriculadas().get(indiceDisciplinaAprovacao);
                    if (disciplinaAprovacao.verificarAprovacao()) { // Correção aqui
                        System.out.println("O aluno " + alunos.get(indiceAlunoAprovacao).getNome() + " esta aprovado em " + disciplinaAprovacao.getNome());
                    } else {
                        System.out.println("O aluno " + alunos.get(indiceAlunoAprovacao).getNome() + " esta reprovado em " + disciplinaAprovacao.getNome());
                    }
                    break;

                case 8:
                    System.out.println("ALUNOS MATRICULADOS");
                    System.out.println("Lista de disciplinas:");
                    for (int i = 0; i < disciplinas.size(); i++) {
                        System.out.println((i + 1) + ". " + disciplinas.get(i).getNome());
                    }
                    System.out.print("Selecione o numero da disciplina: ");
                    int indiceDisciplinaAlunos = scanner.nextInt() - 1;
                    Disciplina disciplinaSelecionadaAlunos = disciplinas.get(indiceDisciplinaAlunos);
                    System.out.println("Alunos matriculados em " + disciplinaSelecionadaAlunos.getNome() + ":");
                    for (Aluno aluno : alunos) {
                        if (aluno.getDisciplinasMatriculadas().contains(disciplinaSelecionadaAlunos)) {
                            System.out.println("- " + aluno.getNome());
                        }
                    }
                    break;

                case 9:
                    System.out.println("PROFESSORES");
                    System.out.println("Lista de disciplinas:");
                    for (int i = 0; i < disciplinas.size(); i++) {
                        System.out.println((i + 1) + ". " + disciplinas.get(i).getNome());
                    }
                    System.out.print("Selecione o numero da disciplina: ");
                    int indiceDisciplinaProfessores = scanner.nextInt() - 1;
                    Disciplina disciplinaSelecionadaProfessores = disciplinas.get(indiceDisciplinaProfessores);
                    System.out.println("Professores que lecionam " + disciplinaSelecionadaProfessores.getNome() + ":");
                    for (Professor professor : professores) {
                        if (professor.getDisciplinaLecionada().equals(disciplinaSelecionadaProfessores.getNome())) {
                            System.out.println("- " + professor.getNome());
                        }
                    }
                    break;

                case 10:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção invalida.");
            }
        } while (opcao != 10);

        scanner.close();
    }
}
