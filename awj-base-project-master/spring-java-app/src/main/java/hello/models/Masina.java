package hello;

import java.util.List;
import java.util.ArrayList;

public class Masina {
  private String name;
  private String marca;

  public Masina() {}

  public Masina(String marca, String name) {
      this.name = name;
      this.marca = marca;
  }

  public String getName() {
      return this.name;
  }

  public String getMarca() {
    return this.marca;
  }
  
  public void setName(String name){
	  this.name = name;
  }
  
  public void setMarca(String marca){
	  this.marca = marca;
  }
}
