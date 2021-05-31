package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Reserva;

public interface ReservaService {
    public boolean insertar (Reserva reserva);
    public boolean modificar (Reserva reserva);
    public void eliminar (int idReserva);
    public Optional<Reserva> listarId(int idReserva);
    List<Reserva> listar();
    List<Reserva> buscarNombre(String descripcionReserva);
}
