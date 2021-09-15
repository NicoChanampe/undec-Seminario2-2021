package ar.edu.undec.tpseminario2.controller;

import ar.edu.undec.tpseminario2.dto.PanesDto;
import ar.edu.undec.tpseminario2.dto.Response;
import ar.edu.undec.tpseminario2.service.PanesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.text.ParseException;

@RestController
@RequestMapping("/panes")
@Tag(name = "Panes Dulces",description = "Informacion de los panes en el servicio")
public class PanesController {
    @Autowired
    private PanesService panesService;

    @GetMapping()
    public ResponseEntity<Response> panesList(){
        Response response = panesService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getPan(@PathVariable String id){
        Response response = panesService.findOneById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/enstock")
    public ResponseEntity<Response> getPanesActives(){
        Response response = panesService.findAllActive();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Response> put(@RequestBody PanesDto input){
        Response response = panesService.update(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> post(@RequestBody PanesDto input) {
        Response response = panesService.save(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable String id){
        Response response = panesService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
