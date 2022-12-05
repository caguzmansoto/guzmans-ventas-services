package com.guzmans.app.venta.repository;

import com.guzmans.app.venta.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {

}
