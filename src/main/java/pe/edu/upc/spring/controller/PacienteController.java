package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Paciente;
import pe.edu.upc.spring.service.PacienteService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
	private PacienteService rService;
    
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}

	@RequestMapping("/")
	public String irpaginaListadoPacientes(Map<String, Object>model) {
        model.put("listaPacientes", rService.listar());
    	return "listPaciente";
    }
    
	@RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
    	model.addAttribute("paciente", new Paciente());
    	return "paciente";
    }

	
	@RequestMapping("/Registrar")
	public String registrar(@ModelAttribute Paciente objPaciente, BindingResult binRes, Model model)
	       throws ParseException
	       {
		         if (binRes.hasErrors())
		        	 return "paciente";
		         else {
		        	 boolean flag = rService.insertar(objPaciente);
		        	 if (flag)
		        		 return "redirect:/paciente/listar";
		        	 else {
		        		 model.addAttribute("mensaje", "Ocurrio un error");
		        		 return "redirect:/paciente/irRegistrar";
		        	 }
		         }
	       }   
	    
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException 
	{
		Optional<Paciente> objPaciente = rService.listarId(id);
		if (objPaciente == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/paciente/listar";
		}
		else {
			model.addAttribute("paciente", objPaciente);
			return "paciente";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
         try {
        	 
        	 if (id!=null && id>0) {
        		 rService.eliminar(id);
        		 model.put("listaPacientes", rService.listar());
        	 }
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "ocurrio un error");
			model.put("listaPacientes", rService.listar());
		}
		return "listPaciente";

	}
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
	model.put("listaPacientes", rService.listar());
	return "listPaciente";
	}	
}

	


