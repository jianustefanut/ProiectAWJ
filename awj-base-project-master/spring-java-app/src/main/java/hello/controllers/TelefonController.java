package hello.controllers;


import hello.models.Telefon;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class TelefonController {
  private List<Telefon> telefoane = new ArrayList<Telefon>();

  TelefonController() {
    Telefon t1 = new Telefon(1, "Nokia",1100);
    Telefon t2 = new Telefon(2, "Motorola",254);
    Telefon t3 = new Telefon(3, "Samsung",56);

    telefoane.add(t1);
    telefoane.add(t2);
    telefoane.add(t3);
  }

  @RequestMapping(value="/telefon", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Telefon t4) {
    telefoane.add(t4);
    return new ResponseEntity<Telefon>(t4, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/telefon", method = RequestMethod.GET)
  public List<Telefon> index() {
    return this.telefoane;
  }

  @RequestMapping(value="/telefon/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Telefon t : this.telefoane) {
      if(t.getId() == id) {
        return new ResponseEntity<Telefon>(t, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/telefon/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Telefon t : this.telefoane) {
      if(t.getId() == id) {
        this.telefoane.remove(t);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/telefon/{initialId}/{id}/{model}/{numar}", method = RequestMethod.PUT)
  public ResponseEntity put(@PathVariable("initialId") int initialId, @PathVariable("id") int id, @PathVariable("model") String model, @PathVariable("numar") int numar) {
    for(Telefon t : this.telefoane) {
      if(t.getId() == initialId) {
        t.setId(id);
        t.setModel(model);
        t.setNumar(numar);
        return new ResponseEntity<Telefon>(t, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
