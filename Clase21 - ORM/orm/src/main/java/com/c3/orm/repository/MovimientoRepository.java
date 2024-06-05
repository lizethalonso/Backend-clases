package com.c3.orm.repository;


import com.c3.orm.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento,Long> {
    //puedo tener todos los metodos manuales.

}
