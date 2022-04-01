package dive.tech.projeto.aula3.dao;

import dive.tech.projeto.aula3.entity.Escola;
import dive.tech.projeto.aula3.entity.Estudante;
import dive.tech.projeto.aula3.entity.Turma;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EscolaDao {

    public List<Escola> consultarEscolas() {
        return consultarEscolasNoBancoViaSql();
    }

    private List<Escola> consultarEscolasNoBancoViaSql() {
        List<Escola> escolas = new ArrayList<>();

        for (int i = 1; i < 3; i++) {
            Escola escola = new Escola(i);

            for (int j = 1; j < 4; j++) {
                Turma turma = new Turma(j);

                for (int k = 1; k < 6; k++) {
                    turma.getEstudantes().add(new Estudante(turma.getNome(), k));
                }

                escola.getTurmas().add(turma);
            }

            escolas.add(escola);
        }
        return escolas;
    }

    public List<Turma> consultarTurmasPorIds(List<Long> idsTurma) {
        // Aqui fingimos que estamos consultando no banco de dados.
        // Então, para cada ID passado, criamos um objeto Turma com ID e nome
        return idsTurma
                .stream()
                .map(Turma::new)
                .collect(Collectors.toList());
    }

    public void salvarEscolaNoBanco(Escola escola) {
        // Aqui fingimos que estamos cadastrando no banco.
        // Quando cadastramos no banco, não passamos o ID, pois quem gera o ID é o próprio banco.
        // Então o que fazemos aqui é simular a criação desse ID:
        escola.setId(1L);
    }
}
