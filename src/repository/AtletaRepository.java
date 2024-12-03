package repository;

import config.DbConnection;
import entity.Atleta;
import entity.Sport;

import java.sql.*;
import java.util.ArrayList;


public class AtletaRepository {
    public void createAtleta(Atleta atleta) {
        try {
            Connection c = DbConnection.openConnection();
            Statement stm = c.createStatement();
            stm.execute("INSERT INTO atleti(nome,cognome,anno,altezza_cm,id_sport) " +
                    "VALUES('" + atleta.getNome() + "','" + atleta.getCognome() + "','"+atleta.getAnno() + "','"+atleta.getAltezza_cm() +"','"+atleta.getSport().getId()+"')");
            System.out.println("Atleta created");
        }catch(ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public ArrayList<Atleta> readAtleta() {
        ArrayList<Atleta> listaAtleti = new ArrayList<>();
        try{
            Connection c=DbConnection.openConnection();
            System.out.println("Connessione riuscita");
            Statement stm=c.createStatement();
            ResultSet rs= stm.executeQuery("SELECT* FROM atleti a JOIN sport s on s.id=a.id_sport order by a.id asc");
            while(rs.next()){
                Atleta atleta = new Atleta();
                atleta.setId(rs.getInt("id"));
                atleta.setNome(rs.getString("nome"));
                atleta.setCognome(rs.getString("cognome"));
                atleta.setAltezza_cm(rs.getInt("altezza_cm"));
                atleta.setAnno(rs.getInt("anno"));
                Sport sport = new Sport();
                sport.setId(rs.getInt("id_sport"));
                sport.setNome(rs.getString("nome"));
                sport.setNgiocatori(rs.getInt("n_giocatori"));
                atleta.setSport(sport);
                listaAtleti.add(atleta);
            }
        }catch(ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaAtleti;
    }

    public void deleteAtleta(Atleta atleta) {
        try{
            Connection c=DbConnection.openConnection();
            System.out.println("Connessione riuscita");
            Statement stm=c.createStatement();
            stm.execute("DELETE FROM atleti WHERE id='"+atleta.getId()+"'");
            System.out.println("Atleta deleted");
        }catch(ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void updateAtleta(Atleta atleta) {
        try{
            Connection c=DbConnection.openConnection();
            System.out.println("Connessione riuscita");
            Statement stm=c.createStatement();
            stm.execute("UPDATE atleti SET" +
                    " nome='"+atleta.getNome()+"'," +
                    "cognome='"+atleta.getCognome()+"',"+
                    "anno='"+atleta.getAnno()+"'," +
                    "altezza='"+atleta.getAltezza_cm()+"'," +
                    "id_sport='"+atleta.getSport().getId()+"'" +
                    "WHERE id="+atleta.getId());

        }catch(ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }

    }

    public ArrayList<Atleta> readAtletiTennis2000(){
        ArrayList<Atleta> listaAtleti = new ArrayList<>();
        try{
            Connection c=DbConnection.openConnection();
            System.out.println("Connessione riuscita");
            Statement stm=c.createStatement();
            ResultSet rs= stm.executeQuery("SELECT*  FROM atleti a JOIN sport s ON s.id=a.id_sport where s.nome='Tennis' and a.anno>1999 order by a.id asc");
            while(rs.next()){
                Atleta atleta = new Atleta();
                atleta.setId(rs.getInt("id"));
                atleta.setNome(rs.getString("nome"));
                atleta.setCognome(rs.getString("cognome"));
                atleta.setAnno(rs.getInt("anno"));
                Sport sport = new Sport();
                sport.setId(rs.getInt("id_sport"));
                sport.setNome(rs.getString("nome"));
                sport.setNgiocatori(rs.getInt("n_giocatori"));
                atleta.setSport(sport);
                listaAtleti.add(atleta);
            }

        }catch (ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaAtleti;
    }
}
