package service;

import entity.Sport;
import repository.SportRepository;

import java.util.ArrayList;
import java.util.Map;

public class SportService {
    SportRepository sportRepository=new SportRepository();

    public void createSport(String nome,int n){
        Sport sport=new Sport();
        sport.setNome(nome);
        sport.setNgiocatori(n);
        sportRepository.createSport(sport);
    }

    public ArrayList<Sport> readSport(){ return sportRepository.readSport(); }

    public void deleteSport(int id){
        Sport sport=new Sport();
        sport.setId(id);
        sportRepository.deleteSport(sport);
    }

    public void updateSport(int id,String nome,int n){
        Sport sport=new Sport();
        sport.setId(id);
        sport.setNome(nome);
        sport.setNgiocatori(n);
        sportRepository.updateSport(sport);
    }

    public ArrayList<Sport> readSportSquadra(){
        return sportRepository.readSportSquadra();
    }

    public Map<Sport,Integer> readSportNatleti(){
        return sportRepository.readSportNatleti();
    }

    public ArrayList<Sport> readSport2Atleti(){
        return sportRepository.readSport2Atleti();
    }
}
