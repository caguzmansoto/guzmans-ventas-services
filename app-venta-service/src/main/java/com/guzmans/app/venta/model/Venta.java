package com.guzmans.app.venta.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Venta")
public class Venta {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "id_producto")
  private String idProducto;

  @Column(name = "cantidad")
  private Integer cantidad;

  @Column(name = "precio_venta")
  private Double precioVenta;

  @Column(name = "serie")
  private String serie;


  public Venta() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(String idProducto) {
    this.idProducto = idProducto;
  }

  public Integer getCantidad() {
    return cantidad;
  }

  public void setCantidad(Integer cantidad) {
    this.cantidad = cantidad;
  }

  public Double getPrecioVenta() {
    return precioVenta;
  }

  public void setPrecioVenta(Double precioVenta) {
    this.precioVenta = precioVenta;
  }

  public String getSerie() {
    return serie;
  }

  public void setSerie(String serie) {
    this.serie = serie;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Venta)) {
      return false;
    }
    Venta venta = (Venta) o;
    return Objects.equals(id, venta.id) && Objects.equals(idProducto,
        venta.idProducto) && Objects.equals(cantidad, venta.cantidad)
        && Objects.equals(precioVenta, venta.precioVenta) && Objects.equals(serie,
        venta.serie);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, idProducto, cantidad, precioVenta, serie);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Venta{");
    sb.append("id=").append(id);
    sb.append(", idProducto='").append(idProducto).append('\'');
    sb.append(", cantidad=").append(cantidad);
    sb.append(", precioVenta=").append(precioVenta);
    sb.append(", serie='").append(serie).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
