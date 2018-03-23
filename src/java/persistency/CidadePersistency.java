package persistency;

import database.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cidade;

public class CidadePersistency {

    private Connection conn;

    public ArrayList<Cidade> index() {
        this.conn = ConnectionFactory.getConnection();
        PreparedStatement st;
        try {
            st = this.conn.prepareStatement("select * from cidades");
            return this.processResultSet(st.executeQuery());
        } catch (SQLException ex) {
            Logger.getLogger(CidadePersistency.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private ArrayList<Cidade> processResultSet(ResultSet rs) {
        ArrayList<Cidade> cidades = new ArrayList<>();
        try {
            while (rs.next()) {
                cidades.add(new Cidade(rs.getInt("id"), rs.getString("nome")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CidadePersistency.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cidades;
    }
}
