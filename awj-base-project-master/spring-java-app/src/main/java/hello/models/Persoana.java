package hello.models;

import java.util.List;
import java.util.ArrayList;

public class Persoana {
  private int id;
  private String name;


  public Persoana() {}

  public Persoana(int id, String name) {
      this.name = name;
      this.id = id;
  }

  public String getName() {
      return this.name;
  }

  public int getId() {
    return this.id;
  }
  
  public void setName(String name){
	  this.name = name;
  }
  
  public void setId(int ID){
	  this.id = ID;
  }
}
