package edu.mum.cs.cs425.fsap.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.fsap.model.Faculty;
import edu.mum.cs.cs425.fsap.model.Student;
import edu.mum.cs.cs425.fsap.service.imp.FacultyServiceImp;
import edu.mum.cs.cs425.fsap.service.imp.StudentServiceImp;

@Controller
public class StudentController {
	
	
	private FacultyServiceImp facultyService;
	
	private StudentServiceImp studentService;
	
	@Autowired
    public StudentController(FacultyServiceImp facultyService, StudentServiceImp studentService) {
		this.facultyService = facultyService;
        this.studentService = studentService;
    }
	
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public ModelAndView students() {
		List<Student> students = studentService.findAll();	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("students", students);
		
		modelAndView.setViewName("student/list");
		return modelAndView;
	}
	
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("student", new Student());
		List<Faculty> faculties = facultyService.findAll();
		model.addAttribute("faculties",faculties);
		
		return "student/edit";
	}
	
	@RequestMapping(value="/student", method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("faculty") Student faculty,
			BindingResult result, Model model) {

		List<Faculty> faculties = facultyService.findAll();
		model.addAttribute("faculties",faculties);
				
		if(result.hasErrors()) {			
			model.addAttribute("errors", result.getAllErrors());
			
			return "student/edit";
		}
		
		faculty = studentService.save(faculty);
		
		return "redirect:/students";
	}
	
	@RequestMapping(value="/student/{id}", method=RequestMethod.GET)
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.findById(id));
		
		List<Faculty> faculties = facultyService.findAll();
		model.addAttribute("faculties",faculties);
				
		return "student/edit";
	}
	
	@RequestMapping(value="/student/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model) {
		studentService.delete(id);
		return "redirect:/students";
	}
}
