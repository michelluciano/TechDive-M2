package dive.tech.projeto.exercicios.service;

import dive.tech.projeto.exercicios.dao.CursoDao;
import dive.tech.projeto.exercicios.entity.Curso;

import java.util.List;

public class CursoService {

    CursoDao cursoDao = new CursoDao();

    public List<Curso> obterCursos() {
        return cursoDao.obterCursos();
    }

    // Crie os métodos aqui!
}
