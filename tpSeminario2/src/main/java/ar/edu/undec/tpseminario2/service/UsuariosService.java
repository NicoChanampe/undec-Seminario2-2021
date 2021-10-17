package ar.edu.undec.tpseminario2.service;

import ar.edu.undec.tpseminario2.dto.Response;
import ar.edu.undec.tpseminario2.entity.Usuarios;
import ar.edu.undec.tpseminario2.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public Response findAll(){
        Response thisResponse = new Response();
        List<Usuarios> usuariosList = usuariosRepository.findAll();
        thisResponse.setData(usuariosList);
        return thisResponse;
    }
}
