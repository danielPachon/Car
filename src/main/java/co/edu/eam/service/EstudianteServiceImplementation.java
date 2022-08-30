package co.edu.eam.service;

import co.edu.eam.dao.EstudianteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstudianteServiceImplementation implements EstudianteService{
    
    private EstudianteDao estudianteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> listar() {
        return (List<Estudiante>) estudianteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Estudiante buscarPorId(Estudiante estudiante) {
        return estudianteDao.findById(estudiante.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void guardar(Estudiante estudiante) {
        estudianteDao.save(estudiante);
    }

    @Override
    @Transactional
    public void eliminar(Estudiante estudiante) {
        estudianteDao.delete(estudiante);
    }
}
