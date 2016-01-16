package hello.controllers;

import hello.models.Masina;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class MasinaController {
  private List<Masina> masini = new ArrayList<Masina>();

  MasinaController() {
    Masina m1 = new Masina(1,"Dacia", "Logan");
    Masina m2 = new Masina(2,"BMW", "320");
    Masina m3 = new Masina(3,"Audi", "A8");

    masini.add(m1);
    masini.add(m2);
    masini.add(m3);
  }

  @RequestMapping(value="/masina", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Masina m4) {
    masini.add(m4);
    return new ResponseEntity<Masina>(m4, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/masina", method = RequestMethod.GET)
  public List<Masina> index() {
    return this.masini;
  }

  @RequestMapping(value="/masina/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Masina m : this.masini) {
      if(m.getId() == id) {
        return new ResponseEntity<Masina>(m, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/masina/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Masina m : this.masini) {
      if(m.getId() == id) {
        this.masini.remove(m);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/masina/{initialId}/{id}/{name}/{marca}", method = RequestMethod.PUT)
  public ResponseEntity put(@PathVariable("initialId") int initialId, @PathVariable("id") int id , @PathVariable("name") String name, @PathVariable("marca") String marca) {
    for(Masina m : this.masini) {
      if(m.getId() == initialId) {
        m.setId(id);
        m.setName(name);
        m.setMarca(marca);
        return new ResponseEntity<Masina>(m, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }



  @RequestMapping(value="/masina/{id}/{name}/{marca}", method = RequestMethod.POST)
  public ResponseEntity post(@PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("marca") String marca) {
    Masina m = new Masina(id,name, marca);
    masini.add(m);
    return new ResponseEntity<Masina>(m, new HttpHeaders(), HttpStatus.OK);
  }
}
