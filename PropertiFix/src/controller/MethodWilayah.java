package controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Wilayah;

public class MethodWilayah {

    static DbHandler conn = new DbHandler();

    public MethodWilayah() {
        conn.connect();
    }
    
    public int getIdDaerah() {
        String query = "select idDaerah from daerah ORDER BY idDaerah DESC LIMIT 2";
        int jumlah = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
                jumlah = rs.getInt("idDaerah");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jumlah;
    }
    
    public boolean insertWilayahBaru(Wilayah newWilayah) {
        boolean hasil;
        String query = "INSERT INTO daerah (provinsi,kota) VALUES (?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, newWilayah.getProvinsi());
            stmt.setString(2, newWilayah.getKota());
            stmt.executeUpdate();
            hasil = true;
        } catch (SQLException e) {
            e.printStackTrace();
            hasil = false;
        }
        
        int jumlah = getIdDaerah();
        
        query = "INSERT INTO wilayah VALUES (?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1,jumlah);
            stmt.setString(2,newWilayah.getDeskripsiWilayah());
            stmt.executeUpdate();
            hasil = true;
        } catch (SQLException e) {
            e.printStackTrace();
            hasil = false;
        }
        
        return hasil;
    }
    
}
