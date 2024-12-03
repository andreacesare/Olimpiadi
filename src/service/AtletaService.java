package service;

import entity.Atleta;
import entity.Sport;
import repository.AtletaRepository;

import java.util.ArrayList;

public class AtletaService {
    AtletaRepository atletaRepository = new AtletaRepository();

    public void createAtleta(String nome, String cognome, int anno, int altezza_cm, Sport sport) {
        Atleta atleta = new Atleta();
        atleta.setNome(nome);
        atleta.setCognome(cognome);
        atleta.setAnno(anno);
        atleta.setAltezza_cm(altezza_cm);
        atleta.setSport(sport);
        sport.aggiungiAtleta(atleta);
        atletaRepository.createAtleta(atleta);
    }

    public ArrayList<Atleta> readAtleta() {
        return atletaRepository.readAtleta();
    }

    public void deleteAtleta(int id) {
        Atleta atleta=new Atleta();
        atleta.setId(id);
        atletaRepository.deleteAtleta(atleta);
    }

    public void updateAtleta(String nome,String cognome,int anno,int altezza_cm, Sport sport) {
        Atleta atleta=new Atleta();
        atleta.setNome(nome);
        atleta.setCognome(cognome);
        atleta.setAnno(anno);
        atleta.setAltezza_cm(altezza_cm);
        atleta.setSport(sport);
        atletaRepository.updateAtleta(atleta);
    }

    public ArrayList<Atleta> readAtletiTennis2000(){
        return atletaRepository.readAtletiTennis2000();
    }
}
