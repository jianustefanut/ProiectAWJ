package hello.models;

import java.util.List;
import java.util.ArrayList;

public class Serial {
  private int id;
  private String titlu;
  private int numarSez;
  private int numarEp;

  public Serial() {}

  public Serial(int id,String titlu, int numarSez, int numarEp) {
      this.id = id;
      this.titlu = titlu;
      this.numarSez = numarSez;
	  this.numarEp = numarEp;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
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
