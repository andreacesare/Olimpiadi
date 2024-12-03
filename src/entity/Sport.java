package entity;

import java.util.ArrayList;

public class Sport {
    private int id;
    private String nome;
    private int ngiocatori;
    private ArrayList<Atleta> atleti=new ArrayList<>();

    public Sport(){};

    public Sport(int id, String nome, int ngiocatori) {
        this.id = id;
        this.nome = nome;
        this.ngiocatori = ngiocatori;
    }
    public int getId() {return id;}
    public String getNome() {return nome;}
    public int getNgiocatori() {return ngiocatori;}
    public void setId(int id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setNgiocatori(int ngiocatori) {this.ngiocatori = ngiocatori;}
    public void aggiungiAtleta(Atleta atleta) {
        atleti.add(atleta);
    }



}
