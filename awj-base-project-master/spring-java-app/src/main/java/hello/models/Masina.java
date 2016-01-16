package hello.models;

import java.util.List;
import java.util.ArrayList;

public class Masina {
  private int id;
  private String name;
  private String marca;

  public Masina() {}

  public Masina(int id,String marca, String name) {
      this.id = id;
      this.name = name;
      this.marca = marca;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
