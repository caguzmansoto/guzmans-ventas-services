package com.guzmans.app.producto.repository;

import com.guzmans.app.producto.model.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<Producto, String> {

}
