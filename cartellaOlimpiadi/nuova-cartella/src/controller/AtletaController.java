package controller;

import entity.Atleta;
import entity.Sport;
import service.AtletaService;
import service.SportService;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Scanner;



public class AtletaController {

    public void creatAtleta() {
        System.out.println("Inserisci nome atleta");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        System.out.println("Inserisci cognome");
        String cognome = scanner.nextLine();
        System.out.println("Inserisci anno di nascita");
        int anno = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci altezza in cm");
        int altezza = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ecco la lista degli sport");
        SportService sportService = new SportService();
        ArrayList<Sport> listaSport=sportService.readSport();
        for(Sport s:listaSport){
            System.out.println(s.getId()+" "+s.getNome());
        }
        System.out.println("Inserisci l'id dello sport da seguire");
        int id = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<listaSport.size();i++){
            if(listaSport.get(i).getId()==id){
                Sport sport = listaSport.get(i);
                AtletaService atletaService = new AtletaService();
                atletaService.createAtleta(nome,cognome,anno,altezza,sport);
                System.out.println("Atleta inserito");

            }
        }
    }

    public  void readAtleta() {
        System.out.println("Ecco la lista degli atleti");
        Scanner scanner = new Scanner(System.in);
        AtletaService atletaService = new AtletaService();
        SportService sportService = new SportService();
        ArrayList<Sport> listaSport=sportService.readSport();
        ArrayList<Atleta> listaAtleta=atletaService.readAtleta();
        for(Atleta a:listaAtleta){
            for(Sport s:listaSport){
                if(a.getSport().getId()==s.getId()){
                    System.out.println(a.getId()+" "+a.getNome()+" "+a.getCognome()+" "+s.getNome());

                }
            }
        }
    }

    public void deleteAtleta() {
        readAtleta();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci id dello sport da eliminare");
        int id = scanner.nextInt();
        scanner.nextLine();
        AtletaService atletaService = new AtletaService();
        atletaService.deleteAtleta(id);
        System.out.println("Atleta eliminato");
    }

    public void updateAtleta() {
        readAtleta();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci id delL'atleta da modificare");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci  il nuovo nome");
        String nome = scanner.nextLine();
        System.out.println("Inserisci il nuovo cognome");
        String cognome = scanner.nextLine();
        System.out.println("Inserisci il nuovo anno di nascita");
        int anno = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci la nuova altezza");
        int altezza = scanner.nextInt();
        scanner.nextLine();
        SportController sportController=new SportController();
        sportController.readSport();
        System.out.println("Inserisci ll'id del nuovo sport");
        int id_sport=scanner.nextInt();
        scanner.nextLine();
        SportService sportService=new SportService();
        ArrayList<Sport> listaSport=sportService.readSport();
        for(int i=0;i<listaSport.size();i++){
            if(listaSport.get(i).getId()==id_sport){
                Sport sport = listaSport.get(i);
                AtletaService atletaService=new AtletaService();
                atletaService.updateAtleta(nome,cognome,anno,altezza,sport);

            }
        }

    }

    public void readAtletiTennis2000(){
        System.out.println("Ecco la lista degli atleti che giocano a tennis nati nel nuovo millennio");
        AtletaService atletaService=new AtletaService();
        ArrayList<Atleta> lista=atletaService.readAtletiTennis2000();
        for(Atleta a:lista){
            System.out.println(a.getId()+" "+a.getNome()+" "+a.getCognome());
        }
    }

    public void readAtletiAltezzaSopraMedia(){
        System.out.println("Ecco la lista degli atleti piu alti della media");
        AtletaService atletaService=new AtletaService();
        ArrayList<Atleta> lista=atletaService.readAtletiAltezaSopraMedia();
        for(Atleta a:lista){
            System.out.println(a.getNome()+" "+a.getCognome()+" "+a.getAltezza_cm()+"cm");
        }
    }

}
