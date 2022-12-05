package com.guzmans.app.producto.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categoria")
@RefreshScope
public class CategoriaController {

  @Value("${app.test.propiedad}")
  private String testPropiedad;

  public String getTestPropiedad() {
    return testPropiedad;
  }

  public void setTestPropiedad(String testPropiedad) {
    this.testPropiedad = testPropiedad;
  }

  @GetMapping("/propiedad")
  public String getTestProp() {
    return this.testPropiedad;
  }


}


