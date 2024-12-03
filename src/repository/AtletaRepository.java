package repository;

import config.DbConnection;
import entity.Atleta;
import entity.Sport;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AtletaRepository {
    private static final Logger logger = Logger.getLogger(AtletaRepository.class.getName());
    public void createAtleta(Atleta atleta) {
        try {
            Connection c = DbConnection.openConnection();
            Statement stm = c.createStatement();
            stm.execute("INSERT INTO atleti(nome,cognome,anno,altezza_cm,id_sport) " +
                    "VALUES('" + atleta.getNome() + "','" + atleta.getCognome() + "','" + atleta.getAnno() + "','" + atleta.getAltezza_cm() + "','" + atleta.getSport().getId() + "')");
            System.out.println("Atleta created");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public ArrayList<Atleta> readAtleta() {
        ArrayList<Atleta> listaAtleti = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita");
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery("SELECT* FROM atleti a JOIN sport s on s.id=a.id_sport order by a.id asc");
            while (rs.next()) {
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
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaAtleti;
    }

    public void deleteAtleta(Atleta atleta) {
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita");
            Statement stm = c.createStatement();
            stm.execute("DELETE FROM atleti WHERE id='" + atleta.getId() + "'");
            System.out.println("Atleta deleted");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void updateAtleta(Atleta atleta) {
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita");
            Statement stm = c.createStatement();
            stm.execute("UPDATE atleti SET" +
                    " nome='" + atleta.getNome() + "'," +
                    "cognome='" + atleta.getCognome() + "'," +
                    "anno='" + atleta.getAnno() + "'," +
                    "altezza='" + atleta.getAltezza_cm() + "'," +
                    "id_sport='" + atleta.getSport().getId() + "'" +
                    "WHERE id=" + atleta.getId());

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

    }

    public ArrayList<Atleta> readAtletiTennis2000() {
        ArrayList<Atleta> listaAtleti = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita");
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery("SELECT a.id,a.nome,a,cognome,a.anno,a.altezza_cm,s.id as ids,s.nome as nomes,s.n_giocatori as n  FROM atleti a JOIN sport s ON s.id=a.id_sport where s.nome='Tennis' and a.anno>1999 order by a.id asc");
            while (rs.next()) {
                Atleta atleta = new Atleta();
                atleta.setId(rs.getInt("id"));
                atleta.setNome(rs.getString("nome"));
                atleta.setCognome(rs.getString("cognome"));
                atleta.setAnno(rs.getInt("anno"));
                atleta.setAltezza_cm(rs.getInt("altezza_cm"));
                Sport sport = new Sport();
                sport.setId(rs.getInt("ids"));
                sport.setNome(rs.getString("nomes"));
                sport.setNgiocatori(rs.getInt("n"));
                atleta.setSport(sport);
                listaAtleti.add(atleta);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaAtleti;
    }

    public ArrayList<Atleta> readAtletiAltezzaSopraMedia() {

        ArrayList<Atleta> listaAtleti = new ArrayList<>();
        String query = "SELECT a.id,a.nome,a.cognome,a.anno,a.altezza_cm,s.id as ids,s.nome as nomes,s.n_giocatori as n FROM atleti a JOIN sport s ON s.id=a.id_sport  WHERE altezza_cm>(SELECT AVG(altezza_cm) FROM atleti)";
        try {
            Connection c = DbConnection.openConnection();
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Atleta atleta = new Atleta();
                atleta.setId(rs.getInt("id"));
                atleta.setNome(rs.getString("nome"));
                atleta.setCognome(rs.getString("cognome"));
                atleta.setAnno(rs.getInt("anno"));
                atleta.setAltezza_cm(rs.getInt("altezza_cm"));
                Sport sport = new Sport();
                sport.setId(rs.getInt("ids"));
                sport.setNome(rs.getString("nomes"));
                sport.setNgiocatori(rs.getInt("n"));
                atleta.setSport(sport);
                listaAtleti.add(atleta);
            }
        } catch (ClassNotFoundException | SQLException e) {
            logger.log(Level.SEVERE, "Errore nella lettura degli atleti", e);
        }
        return listaAtleti;

    }
}
