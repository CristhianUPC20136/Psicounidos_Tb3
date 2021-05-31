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

import pe.edu.upc.spring.model.Reserva;
import pe.edu.upc.spring.service.ReservaService;

@Controller
@RequestMapping("/reserva")
public class ReservaController {
	
	@Autowired
	private ReservaService dService;
    
	@RequestMapping("/bienvenido")
	public String irReservaBienvenida() {
		return "bienvenido";
	}

	@RequestMapping("/")
	public String irpaginaListadoReservas(Map<String, Object>model) {
        model.put("listaReservas", dService.listar());
    	return "listReserva";
    }
    
	@RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
    	model.addAttribute("reserva", new Reserva());
    	return "reserva";
    }

	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Reserva objReserva, BindingResult binRes, Model model)
	       throws ParseException
	       {
		         if (binRes.hasErrors())
		        	 return "reserva";
		         else {
		        	 boolean flag = dService.insertar(objReserva);
		        	 if (flag)
		        		 return "redirect:/reserva/listar";
		        	 else {
		        		 model.addAttribute("mensaje", "Ocurrio un error");
		        		 return "redirect:/reserva/irRegistrar";
		        	 }
		         }
	       }   
	    
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException 
	{
		Optional<Reserva> objReserva = dService.listarId(id);
		if (objReserva == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/reserva/listar";
		}
		else {
			model.addAttribute("reserva", objReserva);
			return "reserva";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
         try {
        	 
        	 if (id!=null && id>0) {
        		 dService.eliminar(id);
        		 model.put("listaReservas", dService.listar());
        	 }
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "ocurrio un error");
			model.put("listaReservas", dService.listar());
		}
		return "listReserva";

	}
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
	model.put("listaReservas", dService.listar());
	return "listReserva";
	}	
}

	


