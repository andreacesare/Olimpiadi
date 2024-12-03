package repository;
import java.sql.*;
import config.DbConnection;
import entity.Atleta;
import entity.Sport;
import java.util.*;

import java.util.ArrayList;

public class SportRepository {

    public void createSport(Sport sport) {
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita");
            Statement stm = c.createStatement();
            stm.execute("INSERT INTO sport(nome,n_giocatori) " +
                    "VALUES('" + sport.getNome() + "','" + sport.getNgiocatori() + "')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public ArrayList<Sport> readSport() {
        ArrayList<Sport> listaSport = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita");
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery("SELECT* FROM sport order by id asc");
            while (rs.next()) {
                Sport sport = new Sport();
                sport.setId(rs.getInt("id"));
                sport.setNome(rs.getString("nome"));
                sport.setNgiocatori(rs.getInt("n_giocatori"));
                listaSport.add(sport);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return listaSport;
    }

    public void deleteSport(Sport sport) {
        try{
            Connection c=DbConnection.openConnection();
            System.out.println("Connessione riuscita");
            Statement stm=c.createStatement();
            stm.execute("DELETE FROM sport WHERE id='"+sport.getId()+"'");
            System.out.println("model.dao.Docente eliminato");
        }catch(ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void updateSport(Sport sport) {
        try{
            Connection c=DbConnection.openConnection();
            System.out.println("Connessione riuscita");
            Statement stm=c.createStatement();
            stm.execute("UPDATE sport SET nome= '"+sport.getNome()+"',n_giocatori='"+sport.getNgiocatori()+"' WHERE id= '"+sport.getId()+"'");
            System.out.println("model.dao.sport aggiornato");
        }catch(ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public ArrayList<Sport> readSportSquadra(){
        ArrayList<Sport> listaSportSquadra = new ArrayList<>();
        try{
            Connection c=DbConnection.openConnection();
            System.out.println("Connessione riuscita");
            Statement stm=c.createStatement();
            ResultSet rs = stm.executeQuery("SELECT* FROM sport WHERE n_giocatori >2 order by id asc");
            while (rs.next()) {
                Sport sport = new Sport();
                sport.setId(rs.getInt("id"));
                sport.setNome(rs.getString("nome"));
                sport.setNgiocatori(rs.getInt("n_giocatori"));
                listaSportSquadra.add(sport);
            }

        }catch(ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaSportSquadra;

    }

    public Map<Sport,Integer> readSportNatleti() {
        Map<Sport,Integer> lista = new HashMap<>();
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita");
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery("SELECT s.id,s.nome,s.n_giocatori,COUNT(*) AS numerodiatleti FROM sport s JOIN atleti a ON s.id=a.id_sport GROUP BY s.id,s.nome,s.n_giocatori");
            while (rs.next()) {
                Sport sport = new Sport();
                sport.setId(rs.getInt("id"));
                sport.setNome(rs.getString("nome"));
                sport.setNgiocatori(rs.getInt("n_giocatori"));
                int count = rs.getInt("numerodiatleti");
                lista.put(sport,count);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
            }
        return lista;
    }

    public ArrayList<Sport> readSport2Atleti(){
        ArrayList<Sport> lista = new ArrayList<>();
        try{
            Connection c=DbConnection.openConnection();
            System.out.println("Connessione riuscita");
            Statement stm=c.createStatement();
            ResultSet rs=stm.executeQuery("SELECT s.id,s.nome,s.n_giocatori, COUNT(*) AS numerodiatleti FROM sport s JOIN atleti a ON s.id=a.id_sport GROUP BY s.id,s.nome,s.n_giocatori HAVING COUNT(*)>1");

            while (rs.next()) {
                Sport sport=new Sport();
                sport.setId(rs.getInt("id"));
                sport.setNome(rs.getString("nome"));
                sport.setNgiocatori(rs.getInt("n_giocatori"));
                lista.add(sport);
            }
        }catch(ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return lista;
    }


}
