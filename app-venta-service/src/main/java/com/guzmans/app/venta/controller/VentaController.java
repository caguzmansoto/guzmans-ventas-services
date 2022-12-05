package com.guzmans.app.venta.controller;

import com.guzmans.app.venta.model.Venta;
import com.guzmans.app.venta.repository.VentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("venta")
public class VentaController {

  private final VentaRepository ventaRepository;

  @Autowired
  public VentaController(VentaRepository ventaRepository) {
    this.ventaRepository = ventaRepository;
  }


  @GetMapping("/listar")
  public List<Venta> getVentas() {
    return ventaRepository.findAll();
  }


  @HystrixCommand(fallbackMethod = "metodoAlternativo")
  @PutMapping("/actualizar")
  public Venta updateVenta(@RequestBody Venta venta) throws Exception {
    boolean ok = false;
    if(ok==false) {
      throw new Exception("No se pudo cargar la informacion");
    }
    return ventaRepository.save(venta);
  }

  public Venta metodoAlternativo(@RequestBody Venta venta) {
    Venta ventaTmp = new Venta();
    ventaTmp.setPrecioVenta(10.0);
    ventaTmp.setCantidad(20);
    ventaTmp.setSerie("LC1234");
    return ventaTmp;
  }

  @PostMapping("/guardar")
  public void createVenta(@RequestBody Venta venta) {
    ventaRepository.save(venta);
  }

  @DeleteMapping("/eliminar")
  public void deleteVenta(@RequestBody Venta venta) {
    ventaRepository.delete(venta);
  }


}
