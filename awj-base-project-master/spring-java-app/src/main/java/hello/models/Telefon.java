package hello.models;

import java.util.List;
import java.util.ArrayList;

public class Telefon {
  int id;
  private String model;
  private int numar;

  public Telefon() {}

  public Telefon(int id,String model,int numar) {
      this.id = id;
      this.model = model;
      this.numar = numar;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getModel() {
      return this.model;
  }

  public int getNumar() {
    return this.numar;
  }
  
  public void setModel(String model){
	  this.model = model;
  }
  
  public void setNumar(int numar){
	  this.numar = numar;
  }
}
