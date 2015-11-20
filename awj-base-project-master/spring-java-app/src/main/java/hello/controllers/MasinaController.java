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
public class MasinaController {
  private List<Masina> masini = new ArrayList<Masina>();

  MasinaController() {
    Masina m1 = new Masina("Dacia", "Logan");
    Masina m2 = new Masina("BMW", "320");
    Masina m3 = new Masina("Audi", "A8");

    masini.add(m1);
    masini.add(m2);
    masini.add(m3);
  }

  @RequestMapping(value="/masina", method = RequestMethod.GET)
  public List<Masina> index() {
    return this.masini;
  }

  @RequestMapping(value="/masina/{marca}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("marca") String marca) {
    for(Masina m : this.masini) {
      if(m.getMarca() == marca) {
        return new ResponseEntity<Masina>(m, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/masina/{marca}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("marca") String marca) {
    for(Masina m : this.masini) {
      if(m.getMarca() == marca) {
        this.masini.remove(m);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
  @RequestMapping(value="/masina/{marca}", method = RequestMethod.PUT)
  public ResponseEntity put(@PathVariable("marca") String marca) {
    for(Masina m : this.masini) {
      if(m.getMarca() == marca) {
        m.setMarca("Dacia");
        m.setName("Duster");
        return new ResponseEntity<Masina>(m, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }



  @RequestMapping(value="/masina/{marca}/{nume}", method = RequestMethod.POST)
   public ResponseEntity post(@PathVariable("marca") String marca, @PathVariable("nume") String nume) {
    Masina m = new Masina(marca, nume);
    masini.add(m);
    return new ResponseEntity<Masina>(m, new HttpHeaders(), HttpStatus.OK);
  }
}
