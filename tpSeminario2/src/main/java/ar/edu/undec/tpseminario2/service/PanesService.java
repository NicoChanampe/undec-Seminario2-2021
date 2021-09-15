package ar.edu.undec.tpseminario2.service;

import ar.edu.undec.tpseminario2.dto.PanesDto;
import ar.edu.undec.tpseminario2.dto.Response;
import ar.edu.undec.tpseminario2.entity.Panes;
import ar.edu.undec.tpseminario2.repository.PanesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.text.ParseException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class PanesService {
    @Autowired
    private PanesRepository panesRepository;

    public PanesService(PanesRepository panesRepository) {
        this.panesRepository = panesRepository;
    }

    public Response findAll(){
        Response thisResponse = new Response();
        List<Panes> panesList = panesRepository.findAll();
        thisResponse.setData(panesList);
        return thisResponse;
    }

    public Response findAllActive(){
        Response thisResponse = new Response();
        List<PanesDto> panesDTOList = new PanesDto().getPanesDtoList(panesRepository.findPanesByEstadoEquals((byte) 1));
        thisResponse.setData(panesDTOList);
        return thisResponse;
    }

    public Response findOneById(String id){
        Response response = new Response();
        try {
            response.setData(new PanesDto().getPanDto(panesRepository.findById(Integer.parseInt(id)).get()));
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response save(PanesDto input) {
        Response response = new Response();
        try {
            Panes panes = new PanesDto().getPan(input);
            panesRepository.save(panes);
            response.setData(panes);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response update(PanesDto panDto) {
        Response response = new Response();
        LocalDate miFecha = LocalDate.now();
        Date fechaModificacion = Date.valueOf(miFecha);

        Panes pan = panesRepository.findById(panDto.getId()).get();
        if(panDto.getNombre() != null)
            pan.setNombre(panDto.getNombre());
        if(panDto.getContenido() != null)
            pan.setContenido(panDto.getContenido());
        if (panDto.getPesoengramos() != null)
            pan.setPesoengramos(panDto.getPesoengramos());
        if(panDto.getPrecio() != null)
            pan.setPrecio(panDto.getPrecio());
        pan.setFechamodificacion(fechaModificacion);
        panesRepository.save(pan);
        response.setData(pan);

        return response;
    }
}
