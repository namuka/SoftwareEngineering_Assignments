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
public class FacultyController {
	

	private FacultyServiceImp facultyService;
	
	private StudentServiceImp studentService;
	
	@Autowired
    public FacultyController(FacultyServiceImp facultyService, StudentServiceImp studentService) {
		this.facultyService = facultyService;
        this.studentService = studentService;
    }
	
	@RequestMapping(value="/faculties", method=RequestMethod.GET)
	public ModelAndView faculties() {
		List<Faculty> faculties = facultyService.findAll();	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("faculties", faculties);
		
	
		modelAndView.setViewName("faculty/list");
		return modelAndView;
	}
	
	@RequestMapping(value="/faculty", method=RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("faculty", new Faculty());
		List<Student> students = studentService.findAll();
		model.addAttribute("students",students);
		
		return "faculty/edit";
	}
	
	@RequestMapping(value="/faculty", method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("faculty") Faculty faculty,
			BindingResult result, Model model) {

		List<Student> students = studentService.findAll();
		model.addAttribute("students",students);
				
		if(result.hasErrors()) {			
			model.addAttribute("errors", result.getAllErrors());
			
			return "faculty/edit";
		}
		
		faculty = facultyService.save(faculty);
		
		return "redirect:/faculties";
	}
	
	@RequestMapping(value="/faculty/{id}", method=RequestMethod.GET)
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("faculty", facultyService.findById(id));
		
		List<Student> students = studentService.findAll();
		model.addAttribute("students",students);
				
		return "faculty/edit";
	}
	
	@RequestMapping(value="/faculty/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model) {
		facultyService.delete(id);
		return "redirect:/faculties";
	}
	
}
