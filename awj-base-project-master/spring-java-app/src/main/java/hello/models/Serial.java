package hello;

import java.util.List;
import java.util.ArrayList;

public class Serial {
  private String titlu;
  private int numarEp;
  private int numarSez;

  public Serial() {}

  public Serial(String titlu, int numarSez, int numarEp) {
      this.titlu = titlu;
      this.numarSez = numarSez;
	  this.numarEp = numarEp;
  }

  public String getTitlu() {
      return this.titlu;
  }

  public int getNumarSez() {
    return this.numarSez;
  }
  
  public int getNumarEp(){
	return this.numarEp;
  }
  
  public void setTitlu(String titlu){
	  this.titlu = titlu;
  }
  
    public void setNumarSez(int numarSez){
	  this.numarSez = numarSez;
  }
  
  public void setNumarEp(int numarEp){
	  this.numarEp = numarEp;
  }
}
