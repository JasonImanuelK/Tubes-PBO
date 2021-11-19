package controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Daerah;
import model.Wilayah;

public class MethodWilayah {

    static DbHandler conn = new DbHandler();

    public MethodWilayah() {
        conn.connect();
    }
    
    public ArrayList<Daerah> getSemuaDaerah(){
        String query = "SELECT * FROM daerah";
        ArrayList<Daerah> listDaerah= new ArrayList<>(); 
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                listDaerah.add(new Daerah(rs.getString("provinsi"),rs.getString("kota")));
            };
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDaerah;
    }
    
    public boolean deleteWilayah(String kota){
        String query = "DELETE FROM daerah WHERE kota = ?";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, kota);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Wilayah> getSemuaWilayah(){
        String query = "SELECT * FROM daerah";
        ArrayList<Wilayah> listWilayah= new ArrayList<>(); 
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String query2 = "SELECT deskripsiWilayah FROM wilayah";
            Statement stmt2 = conn.con.createStatement();
            ResultSet rs2 = stmt2.executeQuery(query2);
            while(rs.next() && rs2.next()){
                listWilayah.add(new Wilayah(rs.getString("provinsi"),rs.getString("kota"),rs2.getString("deskripsiWilayah")));
            };
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listWilayah;
    }
    
    public ArrayList<String> getStringDaerah(){
        String query = "SELECT * FROM daerah";
        ArrayList<String> listDaerah= new ArrayList<>(); 
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                listDaerah.add(rs.getString("kota") + ", " + rs.getString("provinsi"));
            };
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDaerah;
    }
    
    public int getIdDaerahTerakhir() {
        String query = "SELECT idDaerah FROM daerah ORDER BY idDaerah DESC LIMIT 2";
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
        
        int jumlah = getIdDaerahTerakhir();
        
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
