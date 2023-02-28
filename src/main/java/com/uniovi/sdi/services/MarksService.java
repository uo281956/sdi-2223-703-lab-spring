package com.uniovi.sdi.services;

import com.uniovi.sdi.entities.Mark;
import com.uniovi.sdi.repositories.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class MarksService {

    private final HttpSession httpSession;

    @Autowired
    public MarksService(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    @Autowired
    private MarksRepository marksRepository;

    public List<Mark> getMarks() {
        List<Mark> marks = new ArrayList<Mark>();
        marksRepository.findAll().forEach(marks::add);
        return marks;
    }

    public Mark getMark(Long id){
        Set<Mark> consultedList = (Set<Mark>) httpSession.getAttribute("consultedList");
        if ( consultedList == null ) {
            consultedList = new HashSet<Mark>();
        }
        Mark obtainedMark = marksRepository.findById(id).get();
        consultedList.add(obtainedMark);
        httpSession.setAttribute("consultedList", consultedList);
        return obtainedMark;
    }

    public void addMark(Mark mark) {
        marksRepository.save(mark);
    }

    public void deleteMark(Long id) {
        marksRepository.deleteById(id);
    }
}
