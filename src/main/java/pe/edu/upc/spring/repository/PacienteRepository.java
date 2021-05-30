package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{
    @Query("from Paciente p where p.nombrePaciente like %:nombrePaciente%")
	List<Paciente> buscarNombre(@Param("nombrePaciente")String nombrePaciente);
}
