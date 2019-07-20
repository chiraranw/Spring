/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.portal.studentportal.controller;

import com.myorg.portal.studentportal.model.Student;
import com.myorg.portal.studentportal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author chiraran
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("students", studentService.getAll());
        return "home";
    }

    @RequestMapping("/new")
    public String newStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "new";
    }

//    @RequestMapping("/edit/{id}")
//    public ModelAndView getById(@PathVariable(name = "id") int id) {
//        return new ModelAndView("edit").addObject("student", studentService.get(id));
//    }
    @RequestMapping("/edit/{id}")
    public String getById(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("student", studentService.get(id));
        return "edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        studentService.delete(id);
        return "redirect:/";
    }
}
