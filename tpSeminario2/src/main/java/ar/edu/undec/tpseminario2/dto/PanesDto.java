package ar.edu.undec.tpseminario2.dto;

import ar.edu.undec.tpseminario2.entity.Panes;

import java.sql.Date;
//import java.text.DateFormat;
import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PanesDto {
    private Integer id;
    private String nombre;
    private String contenido;
    private Integer pesoengramos;
    private Double precio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Integer getPesoengramos() {
        return pesoengramos;
    }

    public void setPesoengramos(Integer pesoengramos) {
        this.pesoengramos = pesoengramos;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<PanesDto> getPanesDtoList(List<Panes> panesList){
        List<PanesDto> miLista = new ArrayList<>();
        for (Panes item: panesList){
            PanesDto panDto = new PanesDto();
            panDto.setId(item.getId());
            panDto.setContenido(item.getContenido());
            panDto.setNombre(item.getNombre());
            panDto.setPesoengramos(item.getPesoengramos());
            panDto.setPrecio(item.getPrecio());

            miLista.add(panDto);
        }
        return miLista;
    }

    public PanesDto getPanDto(Panes pan){
        PanesDto panDto = new PanesDto();

        panDto.setId(pan.getId());
        panDto.setContenido(pan.getContenido());
        panDto.setNombre(pan.getNombre());
        panDto.setPesoengramos(pan.getPesoengramos());
        panDto.setPrecio(pan.getPrecio());

        return panDto;
    }

    public Panes getPan(PanesDto panDto){
        LocalDate miFecha = LocalDate.now();
        Date fechaCreacion = Date.valueOf(miFecha);

        Panes miPan = new Panes();

        miPan.setId(panDto.getId());
        miPan.setContenido(panDto.getContenido());
        miPan.setNombre(panDto.getNombre());
        miPan.setPesoengramos(panDto.getPesoengramos());
        miPan.setPrecio(panDto.getPrecio());
        miPan.setEstado((byte)1);
        miPan.setFechadealta(fechaCreacion);

        return miPan;
    }
}
