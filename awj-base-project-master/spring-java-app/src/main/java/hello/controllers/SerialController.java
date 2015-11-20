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
public class SerialController {
  private List<Serial> seriale = new ArrayList<Serial>();

  SerialController() {
    Serial s1 = new Serial("BreakingBad",5,62);
    Serial s2 = new Serial("TheMentalist",7,151);
    Serial s3 = new Serial("GameOfThrones",6,60);
	Serial s4 = new Serial("Dexter",8,12);

    seriale.add(s1);
    seriale.add(s2);
    seriale.add(s3);
	seriale.add(s4);
  }

  @RequestMapping(value="/serial", method = RequestMethod.GET)
  public List<Serial> index() {
    return this.seriale;
  }

  @RequestMapping(value="/serial/{titlu}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("titlu") String titlu) {
    for(Serial s : this.seriale) {
      if(s.getTitlu().equals(titlu)) {
        return new ResponseEntity<Serial>(s, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/serial/{titlu}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("titlu") String titlu) {
    for(Serial s : this.seriale) {
      if(s.getTitlu().equals(titlu)) {
        this.seriale.remove(s);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
  @RequestMapping(value="/serial/{titlu}", method = RequestMethod.PUT)
  public ResponseEntity put(@PathVariable("titlu") String titlu) {
    for(Serial s : this.seriale) {
      if(s.getTitlu().equals(titlu)) {
        s.setTitlu("GameOfThrones");
        s.setNumarSez(7);
		s.setNumarEp(70);
        return new ResponseEntity<Serial>(s, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }



  @RequestMapping(value="/serial/{titlu}/{numarSez}/{numarEp}", method = RequestMethod.POST)
   public ResponseEntity post(@PathVariable("titlu") String titlu, @PathVariable("numarSez") int numarSez, @PathVariable("numarEp") int numarEp) {
    Serial s = new Serial(titlu, numarSez, numarEp);
    seriale.add(s);
    return new ResponseEntity<Serial>(s, new HttpHeaders(), HttpStatus.OK);
  }
}
