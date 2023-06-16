package com.example.sample_exercises.controller;
import com.example.sample_exercises.model.Student;
import com.example.sample_exercises.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("list",studentService.getList());
        return "student/list";
    }
    @GetMapping("/create")
    public String showFormCreate(){
        return "student/create";
    }
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String save(String name,boolean gender,String birth,String nameClass,String department){
        studentService.addStudent(new Student(studentService.getList().size()+1,name,gender,birth,nameClass,department));
        return "redirect:/";
    }

}
