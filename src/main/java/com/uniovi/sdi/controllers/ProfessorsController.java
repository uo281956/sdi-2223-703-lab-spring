package com.uniovi.sdi.controllers;

import com.uniovi.sdi.entities.Professor;
import com.uniovi.sdi.entities.User;
import com.uniovi.sdi.services.ProfessorsService;
import com.uniovi.sdi.validators.ProfessorFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfessorsController {

    @Autowired
    private ProfessorsService professorsService;

    @Autowired
    private ProfessorFormValidator professorFormValidator;

    @RequestMapping("/professor/list")
    public String getList(Model model)
    {
        model.addAttribute("professorList",professorsService.getProfessors());
        return "professor/list";
    }

    @RequestMapping(value="/professor/add",method = RequestMethod.POST)
    public String setProfessor(@Validated Professor professor, BindingResult result) {
        professorFormValidator.validate(professor, result);
        if(result.hasErrors()){
            return "/professor/add";
        }

        professorsService.addProfessor(professor);
        return "redirect:/professor/list";
    }

    @RequestMapping("/professor/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("professor", professorsService.getProfessor(id));
        return "professor/details";
    }

    @RequestMapping("/professor/delete/{id}")
    public String deleteProfessor(@PathVariable Long id) {
        professorsService.deleteProfessor(id);
        return "redirect:/professor/list";
    }

    @RequestMapping(value = "/professor/add")
    public String getProfessor(Model model) {
        model.addAttribute("professor", new Professor());
        return "professor/add";
    }

    @RequestMapping(value = "/professor/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("professor", professorsService.getProfessor(id));
        return "professor/edit";
    }

    @RequestMapping(value="/professor/edit/{id}", method = RequestMethod.POST)
    public String setEdit(@ModelAttribute Professor professor, @PathVariable Long id) {
        professor.setId(id);
        professorsService.addProfessor(professor);
        return "redirect:/professor/details/"+id;
    }
}
