package com.uniovi.sdi.controllers;

import com.uniovi.sdi.entities.Mark;
import com.uniovi.sdi.entities.Professor;
import com.uniovi.sdi.services.MarksService;
import com.uniovi.sdi.services.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorsController {

    @Autowired
    private ProfessorsService professorsService;

    @RequestMapping("/professor/list")
    public String getList(Model model)
    {
        //model.addAttribute("professorList",professorsService.getProfessors());
        return professorsService.getProfessors().toString();
    }

    @RequestMapping(value="/professor/add",method = RequestMethod.POST)
    public String setProfessor(@ModelAttribute Professor professor) {
        professorsService.addProfessor(professor);
        return "Ok";
    }

    @RequestMapping("/professor/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        //model.addAttribute("professor", professorsService.getProfessor(id));
        //return "professor/details";
        return professorsService.getProfessor(id).toString();
    }

    @RequestMapping("/professor/delete/{id}")
    public String deleteProfessor(@PathVariable Long id) {
        professorsService.deleteProfessor(id);
        //return "redirect:/professor/list";
        return "Deleted";
    }

    @RequestMapping(value = "/professor/add")
    public String getProfessor() {
        //return "professor/add";
        return "añadiendo";
    }

    @RequestMapping(value = "/professor/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        //model.addAttribute("professor", professorsService.getProfessor(id));
        //return "professor/edit";
        return "editar";
    }

    @RequestMapping(value="/professor/edit/{id}", method = RequestMethod.POST)
    public String setEdit(@ModelAttribute Professor professor, @PathVariable Long id) {
        //professor.setId(id);
        //professorsService.addProfessor(professor);
       // return "redirect:/professor/details/"+id;
        return "editar";
    }
}
