package ar.edu.undec.tpseminario2.service;

import ar.edu.undec.tpseminario2.dto.PanesDto;
import ar.edu.undec.tpseminario2.dto.Response;
import ar.edu.undec.tpseminario2.entity.Panes;
import ar.edu.undec.tpseminario2.repository.PanesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
