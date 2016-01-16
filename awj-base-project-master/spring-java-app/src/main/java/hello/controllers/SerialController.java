package hello.controllers;

import hello.models.Serial;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class SerialController {
  private List<Serial> seriale = new ArrayList<Serial>();

  SerialController() {
    Serial s1 = new Serial(1,"BreakingBad",5,62);
    Serial s2 = new Serial(2,"TheMentalist",7,151);
    Serial s3 = new Serial(3,"GameOfThrones",6,60);
	Serial s4 = new Serial(4,"Dexter",8,96);

    seriale.add(s1);
    seriale.add(s2);
    seriale.add(s3);
	seriale.add(s4);
  }

  @RequestMapping(value="/serial", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Serial s4) {
    seriale.add(s4);
    return new ResponseEntity<Serial>(s4, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/serial", method = RequestMethod.GET)
  public List<Serial> index() {
    return this.seriale;
  }

  @RequestMapping(value="/serial/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Serial s : this.seriale) {
      if(s.getId() == id) {
        return new ResponseEntity<Serial>(s, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/serial/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Serial s : this.seriale) {
      if(s.getId() == id) {
        this.seriale.remove(s);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/serial/{initialId}/{id}/{titlu}/{numarSez}/{numarEp}", method = RequestMethod.PUT)
  public ResponseEntity put(@PathVariable("initialId") int initialId, @PathVariable("id") int id, @PathVariable("titlu") String titlu, @PathVariable("numarSez") int numarSez, @PathVariable("numarEp") int numarEp) {
    for(Serial s : this.seriale) {
      if(s.getId() == initialId) {
        s.setId(id);
        s.setTitlu(titlu);
        s.setNumarSez(numarSez);
        s.setNumarEp(numarEp);
        return new ResponseEntity<Serial>(s, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


}

