package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Paciente;

public interface PacienteService {
    public boolean insertar (Paciente paciente);
    public boolean modificar (Paciente paciente);
    public void eliminar (int idPaciente);
    public Optional<Paciente> listarId(int idPaciente);
    List<Paciente> listar();
    List<Paciente> buscarNombre(String nombrePaciente);
}
