package com.uniovi.sdi.controllers;

import com.uniovi.sdi.entities.Mark;
import com.uniovi.sdi.services.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarksController {

    @Autowired
    private MarksService marksService;

    @RequestMapping("/mark/list")
    public String getList() {
        return marksService.getMarks().toString();
    }

    @RequestMapping(value="/mark/add",method = RequestMethod.POST)
    public String setMark(@ModelAttribute Mark mark) {
        marksService.addMark(mark);
    return "Added: "+mark.getDescription()
                +" with score: "+mark.getScore()
                +" id: "+mark.getId();
    }

    @RequestMapping("/mark/details/{id}")
    public String getDetail(@PathVariable Long id) {
        return marksService.getMark(id).toString();
    }

    @RequestMapping("/mark/delete/{id}")
    public String deleteMark(@PathVariable Long id) {
        marksService.deleteMark(id);
        return "Ok";
    }
}
