package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Paciente;
import pe.edu.upc.spring.repository.PacienteRepository;
import pe.edu.upc.spring.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	private PacienteRepository dPaciente;
	
	@Override
	@Transactional
	public boolean insertar(Paciente paciente) {
		Paciente objPaciente =dPaciente.save(paciente);
		if (objPaciente == null)
		return false;
		else
		return true;
	}

	@Override
	@Transactional
	public boolean modificar(Paciente paciente) {
		boolean flag = false;
		try {
		      dPaciente.save(paciente);
		      flag = true;
	        }
		catch(Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}
	

	@Override
	@Transactional
	public void eliminar(int idPaciente) {
		dPaciente.deleteById(idPaciente);
	}

	@Override
	@Transactional (readOnly = true)
	public Optional<Paciente> listarId(int idPaciente) {
		return dPaciente.findById(idPaciente);
	}

	@Override
	@Transactional (readOnly = true)
	public List<Paciente> listar() {
		return dPaciente.findAll();
	}

	@Override
	@Transactional (readOnly = true)
	public List<Paciente> buscarNombre(String nombrePaciente) {
		return dPaciente.buscarNombre(nombrePaciente);
	}

}
