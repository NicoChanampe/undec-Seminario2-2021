package ar.edu.undec.tpseminario2.controller;

import ar.edu.undec.tpseminario2.dto.Response;
import ar.edu.undec.tpseminario2.service.UsuariosService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuarios",description = "Informacion de los usuarios en el servicio")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping()
    public ResponseEntity<Response> usuariosList(){
        Response response = usuariosService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
