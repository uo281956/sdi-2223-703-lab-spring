package com.uniovi.sdi.services;

import com.uniovi.sdi.entities.Professor;
import com.uniovi.sdi.entities.User;
import com.uniovi.sdi.repositories.ProfessorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorsService {

    @Autowired
    private ProfessorsRepository professorsRepository;


    public List<Professor> getProfessors() {
        List<Professor> professors = new ArrayList<Professor>();
        professorsRepository.findAll().forEach(professors::add);
        return professors;
    }

    public Professor getProfessor(Long id) {
        return professorsRepository.findById(id).get();
    }

    public void addProfessor(Professor professor) {
        professorsRepository.save(professor);
    }

    public void deleteProfessor(Long id) {
        professorsRepository.deleteById(id);
    }

    public Professor getProfessorByDni(String dni) {
        return professorsRepository.findByDni(dni);
    }
}
