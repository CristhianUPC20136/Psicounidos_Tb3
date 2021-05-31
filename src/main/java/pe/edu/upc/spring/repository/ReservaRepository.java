package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
    @Query("from Reserva r where r.descripcionReserva like %:descripcionReserva%")
	List<Reserva> buscarNombre(@Param("descripcionReserva")String descripcionReserva);
}
