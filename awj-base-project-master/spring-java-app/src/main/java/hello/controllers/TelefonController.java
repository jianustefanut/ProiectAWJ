package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class TelefonController {
  private List<Telefon> telefoane = new ArrayList<Telefon>();

  TelefonController() {
    Telefon t1 = new Telefon(110, "Nokia");
    Telefon t2 = new Telefon(5100, "Motorola");
    Telefon t3 = new Telefon(201, "Samsung");

    telefoane.add(t1);
    telefoane.add(t2);
    telefoane.add(t3);
  }

  @RequestMapping(value="/telefon", method = RequestMethod.GET)
  public List<Telefon> index() {
    return this.telefoane;
  }

  @RequestMapping(value="/telefon/{numar}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("numar") int numar) {
    for(Telefon t : this.telefoane) {
      if(t.getNumar() == numar) {
        return new ResponseEntity<Telefon>(t, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/telefon/{numar}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("numar") int numar) {
    for(Telefon t : this.telefoane) {
      if(t.getNumar() == numar) {
        this.telefoane.remove(t);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
  @RequestMapping(value="/telefon/{numar}", method = RequestMethod.PUT)
  public ResponseEntity put(@PathVariable("numar") int numar) {
    for(Telefon t : this.telefoane) {
      if(t.getNumar() == numar) {
        t.setNumar(110);
        t.setModel("Lenovo");
        return new ResponseEntity<Telefon>(t, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }



  @RequestMapping(value="/telefon/{numar}/{model}", method = RequestMethod.POST)
   public ResponseEntity post(@PathVariable("numar") int numar, @PathVariable("model") String model) {
    Telefon t = new Telefon(numar, model);
    telefoane.add(t);
    return new ResponseEntity<Telefon>(t, new HttpHeaders(), HttpStatus.OK);
  }
}
