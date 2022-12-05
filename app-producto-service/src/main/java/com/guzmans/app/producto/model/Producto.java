package com.guzmans.app.producto.model;


import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "productos")
public class Producto {

  @Id
  private String id;
  private Long codigo;
  private String descripcion;
  private Double precionVenta;
  private Double stockActual;

  public Producto() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Long getCodigo() {
    return codigo;
  }

  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Double getPrecionVenta() {
    return precionVenta;
  }

  public void setPrecionVenta(Double precionVenta) {
    this.precionVenta = precionVenta;
  }

  public Double getStockActual() {
    return stockActual;
  }

  public void setStockActual(Double stockActual) {
    this.stockActual = stockActual;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Producto)) {
      return false;
    }
    Producto producto = (Producto) o;
    return Objects.equals(getId(), producto.getId()) && Objects.equals(
        getCodigo(), producto.getCodigo()) && Objects.equals(getDescripcion(),
        producto.getDescripcion()) && Objects.equals(getPrecionVenta(),
        producto.getPrecionVenta()) && Objects.equals(getStockActual(),
        producto.getStockActual());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getCodigo(), getDescripcion(), getPrecionVenta(),
        getStockActual());
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Producto{");
    sb.append("id='").append(id).append('\'');
    sb.append(", codigo=").append(codigo);
    sb.append(", descripcion='").append(descripcion).append('\'');
    sb.append(", precionVenta=").append(precionVenta);
    sb.append(", stockActual=").append(stockActual);
    sb.append('}');
    return sb.toString();
  }
}
