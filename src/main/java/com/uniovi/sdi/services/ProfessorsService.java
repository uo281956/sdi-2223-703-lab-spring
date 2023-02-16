package com.uniovi.sdi.services;

import com.uniovi.sdi.entities.Professor;
import com.uniovi.sdi.repositories.ProfessorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorsService {

   // @Autowired
    private List<Professor> professors = new ArrayList<>();
    //private ProfessorsRepository professorsRepository;

    @PostConstruct
    public void init() {
        professors.add(new Professor(1L, "123123123a", "Pedro","Fdez","Mates"));
        professors.add(new Professor(2L, "123456789b", "Jose","Manuel","Lengua"));
    }

    public List<Professor> getProfessors() {
        //List<Professor> professors = new ArrayList<Professor>();
        //professorsRepository.findAll().forEach(professors::add);
        return professors;
    }

    public Professor getProfessor(Long id) {
        //return professorsRepository.findById(id).get();
        return professors.stream().filter(professor -> professor.getId().equals(id)).findFirst().get();
    }

    public void addProfessor(Professor professor) {
        //professorsRepository.save(professor);
        professors.add(professor);
    }

    public void deleteProfessor(Long id) {
        //professorsRepository.deleteById(id);
        professors.removeIf(professor -> professor.getId().equals(id));
    }
}
