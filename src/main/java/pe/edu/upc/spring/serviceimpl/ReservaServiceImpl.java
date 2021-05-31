package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Reserva;
import pe.edu.upc.spring.repository.ReservaRepository;
import pe.edu.upc.spring.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService{

	@Autowired
	private ReservaRepository dReserva;
	
	@Override
	@Transactional
	public boolean insertar(Reserva reserva) {
		Reserva objReserva =dReserva.save(reserva);
		if (objReserva == null)
		return false;
		else
		return true;
	}

	@Override
	@Transactional
	public boolean modificar(Reserva reserva) {
		boolean flag = false;
		try {
		      dReserva.save(reserva);
		      flag = true;
	        }
		catch(Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}
	

	@Override
	@Transactional
	public void eliminar(int idReserva) {
		dReserva.deleteById(idReserva);
	}

	@Override
	@Transactional (readOnly = true)
	public Optional<Reserva> listarId(int idReserva) {
		return dReserva.findById(idReserva);
	}

	@Override
	@Transactional (readOnly = true)
	public List<Reserva> listar() {
		return dReserva.findAll();
	}

	@Override
	@Transactional (readOnly = true)
	public List<Reserva> buscarNombre(String descripcionReserva) {
		return dReserva.buscarNombre(descripcionReserva);
	}

}
