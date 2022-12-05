package com.guzmans.app.producto.controller;

import com.guzmans.app.producto.model.Producto;
import com.guzmans.app.producto.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("producto")
public class ProductoController {

  private final ProductoRepository productoRepository;
  private final MongoTemplate mongoTemplate;

  @Autowired
  public ProductoController(ProductoRepository productoRepository, MongoTemplate mongoTemplate) {
    this.productoRepository = productoRepository;
    this.mongoTemplate = mongoTemplate;
  }

  @GetMapping("/listar")
  public List<Producto> getProductos(){
    return productoRepository.findAll();
  }

  @PutMapping("/actualizar")
  public void updateProducto(@RequestBody Producto producto) {
    productoRepository.save(producto);
  }

  @PostMapping("/guardar")
  public void createProducto(@RequestBody Producto producto) {
    productoRepository.save(producto);
  }

  @DeleteMapping("/eliminar")
  public void deleteProducto(@RequestBody Producto producto) {
    productoRepository.delete(producto);
  }

}
