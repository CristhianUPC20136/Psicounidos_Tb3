package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer>{
    @Query("from Servicio s where s.nombreServicio like %:nombreServicio%")
	List<Servicio> buscarNombre(@Param("nombreServicio")String nombreServicio);
}
