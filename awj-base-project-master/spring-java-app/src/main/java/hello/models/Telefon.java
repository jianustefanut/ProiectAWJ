package hello;

import java.util.List;
import java.util.ArrayList;

public class Telefon {
  private String model;
  private int numar;

  public Telefon() {}

  public Telefon(int numar, String model) {
      this.model = model;
      this.numar = numar;
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
