package dive.tech.projeto.aula3.service;

import dive.tech.projeto.aula3.dao.EscolaDao;
import dive.tech.projeto.aula3.entity.Escola;
import dive.tech.projeto.aula3.entity.Turma;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class EscolaService {

    private final EscolaDao escolaDao = new EscolaDao();

    public List<Escola> consultarEscolas() {
        return escolaDao.consultarEscolas();
    }

    public Escola cadastrarEscola(String nome, List<Long> idsTurma) throws Exception {
        validarCadastrarEscola(nome, idsTurma);

        List<Turma> turmas = escolaDao.consultarTurmasPorIds(idsTurma);

        Escola escola = new Escola(nome, turmas);
        escolaDao.salvarEscolaNoBanco(escola);

        return escola;
    }

    private void validarCadastrarEscola(String nome, List<Long> idsTurma) throws Exception {
        if (StringUtils.isBlank(nome)) {
            throw new Exception("O nome da escola é obrigatório!");
        }

        if (idsTurma.isEmpty()) {
            throw new Exception("Necessário selecionar pelo menos uma turma!");
        }
    }
}
