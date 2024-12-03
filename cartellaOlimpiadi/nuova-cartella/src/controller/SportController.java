package controller;

import entity.Sport;
import service.SportService;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class SportController {

    public void createSport(){
        System.out.println("Inserisci nome dello sport");
        Scanner scanner=new Scanner(System.in);
        String nome=scanner.nextLine();
        System.out.println("Inserisci numero dei giocatori che o praticano");
        int numero=scanner.nextInt();
        SportService sportService=new SportService();
        sportService.createSport(nome,numero);
    }

    public  void  readSport(){
        System.out.println("Ecco la lista degli sport");
        SportService sportService=new SportService();
        ArrayList<Sport> listaSport=sportService.readSport();
        for(Sport i:listaSport){
            System.out.println(i.getId()+" "+i.getNome());
        }
    }

    public void deleteSport(){
        readSport();
        System.out.println("Inserisci l'id dello sport da eliminare");
        Scanner scanner=new Scanner(System.in);
        int id=scanner.nextInt();
        scanner.nextLine();
        SportService sportService=new SportService();
        sportService.deleteSport(id);
    }

    public void updateSport(){
        readSport();
        System.out.println("Inserisci l'id dello sport da modificare");
        Scanner scanner=new Scanner(System.in);
        int id=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci il nome del nuovo sport");
        String nome=scanner.nextLine();
        System.out.println("Inserisci il numero del nuovo sport");
        int numero=scanner.nextInt();
        scanner.nextLine();
        SportService sportService=new SportService();
        sportService.updateSport(id,nome,numero);
    }

    public void readSportSquadra(){
        System.out.println("Ecco la lista degli sport di squadra");
        SportService sportService=new SportService();
        ArrayList<Sport> listaSportSquadra=sportService.readSportSquadra();
        for(Sport i:listaSportSquadra){
            System.out.println(i.getId()+" "+i.getNome());
        }

    }

    public void readSportNatleti(){
        System.out.println("Ecco la lista degli sport e il numero di atleti che lo praticano");
        SportService sportService=new SportService();
        Map<Sport,Integer> lista=sportService.readSportNatleti();
        for(Map.Entry<Sport,Integer> i:lista.entrySet()){
            System.out.println(i.getKey().getNome()+" "+i.getValue());
        }
    }

    public void readSport2Atleti(){
        System.out.println("Ecco la lista degli sport con almeno due atleti che lo praticano");
        SportService sportService=new SportService();
        ArrayList<Sport> listaSport=sportService.readSport2Atleti();
        for(Sport i:listaSport){
            System.out.println(i.getNome());

        }
    }
}
