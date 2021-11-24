/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Daerah;
import model.Member;
import model.Property;
import model.StatusJualSewa;
import model.StatusPerson;
import model.TipeProperty;
import model.User;
import model.UserSingeltonManager;

/**
 *
 * @author Aloysius
 */
public class ControllerProperty {

    DbHandler conn = new DbHandler();

    public ControllerProperty() {
        conn.connect();
    }

    public boolean inputProperty(Property property) {
        conn.connect();
        String query = "INSERT INTO `properti` (`idPengguna`, `idDaerah`, `alamat`, `deskripsiBangunan`, `statusJualSewa`, `harga`, `tipeProperty`, `luasBangunan`, `luasTanah`, `jumlahKamar`, `verifikasi`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            User user = (User) UserSingeltonManager.getInstance().getPerson();
            stmt.setInt(1, getIdUser(user));
            stmt.setInt(2, getIdDaerah(property.getDaerah()));
            stmt.setString(3, property.getAlamat());
            stmt.setString(4, property.getDeskripsiBangunan());
            stmt.setString(5, property.getStatusJualSewa().name());
            stmt.setBigDecimal(6, new BigDecimal(property.getHarga()));
            stmt.setString(7, property.getTipeProperty().name());
            stmt.setInt(8, property.getLuasBangunan());
            stmt.setInt(9, property.getLuasTanah());
            stmt.setInt(10, property.getJumlahKamar());
            stmt.setInt(11, 0);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public int getIdDaerah(Daerah daerah) {
        conn.connect();
        String query = "SELECT * FROM daerah WHERE provinsi='" + daerah.getProvinsi() + "'&& kota='" + daerah.getKota() + "'";
        int id = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt("idDaerah");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public int getIdUser(User user) {
        conn.connect();
        String query = "SELECT * FROM person WHERE email='" + user.getEmail() + "'&& password='" + user.getPassword() + "'";
        int id = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt("idPengguna");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public User getUserById(int idPengguna){
        conn.connect();
        String query = "SELECT * FROM person WHERE idPengguna='" + idPengguna + "'";
        User user = new User();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Member member = Member.valueOf(rs.getString("member"));
                user = new User(rs.getString("nama"), rs.getString("noTelp"), rs.getString("password"), rs.getString("email"), StatusPerson.USER, member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public ArrayList<Property> getListPropertyUser() {
        ArrayList<Property> listProperty = new ArrayList<>();
        conn.connect();
        User user = (User) UserSingeltonManager.getInstance().getPerson();
        String query = "SELECT * FROM properti WHERE idPengguna='" + getIdUser(user) + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                listProperty.add(new Property(rs.getInt("kodeProperti"), user, getDaerah(rs.getInt("idDaerah")), rs.getString("alamat"), rs.getString("deskripsiBangunan"), StatusJualSewa.valueOf(rs.getString("statusJualSewa")), BigInteger.valueOf(rs.getLong("harga")), TipeProperty.valueOf(rs.getString("tipeProperty")), rs.getInt("luasBangunan"), rs.getInt("luasTanah"), rs.getInt("jumlahKamar"), rs.getBoolean("verifikasi")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listProperty;
    }

    public Daerah getDaerah(int idDaerah) {
        Daerah daerah = new Daerah();
        conn.connect();
        String query = "SELECT * FROM daerah WHERE idDaerah='" + idDaerah + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                daerah = new Daerah(rs.getString("provinsi"), rs.getString("kota"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daerah;
    }

    public ArrayList<String> getStringDaerah() {
        String query = "SELECT * FROM daerah";
        ArrayList<String> listDaerah = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                listDaerah.add(rs.getString("kota") + ", " + rs.getString("provinsi"));
            };
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDaerah;
    }

    public int getLastKodeProperti() {
        int kodeProperti = 0;
        conn.connect();
        String query = "SELECT * FROM properti ORDER by kodeProperti desc LIMIT 1";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                kodeProperti = rs.getInt("kodeProperti");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kodeProperti;
    }

    public boolean updateProperty(Property property) {
        conn.connect();
        int verifikasi = property.isVerifikasi() ? 1 : 0;
        String query = "UPDATE properti SET idDaerah='" + getIdDaerah(property.getDaerah()) + "', "
                + "alamat='" + property.getAlamat() + "', "
                + "deskripsiBangunan='" + property.getDeskripsiBangunan() + "', "
                + "statusJualSewa='" + property.getStatusJualSewa().name() + "', "
                + "harga='" + new BigDecimal(property.getHarga()) + "', "
                + "tipeProperty='" + property.getTipeProperty().name() + "', "
                + "luasBangunan='" + property.getLuasBangunan() + "', "
                + "luasTanah='" + property.getLuasTanah() + "', "
                + "jumlahKamar='" + property.getJumlahKamar() + "', "
                + "verifikasi='" + verifikasi + "' "
                + "WHERE kodeProperti='" + property.getKodeProperti() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public boolean verifikasiProperty(Property property){
        conn.connect();
        String query = "UPDATE properti SET verifikasi='" + 1 + "' "
                + "WHERE kodeProperti='" + property.getKodeProperti() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean deleteProperty(Property property) {
        conn.connect();
        String query = "DELETE FROM properti WHERE kodeProperti='" + property.getKodeProperti() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public ArrayList<Property> getListPropertyUseFilter(int idDaerah, BigInteger hargaMax, BigInteger hargaMin, String stringTipeProperty, int luasBangunanMax, int luasBangunanMin, int luasTanahMax, int luasTanahMin, int jumlahKamarMax, int jumlahKamarMin) {
        ArrayList<Property> listProperty = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM properti WHERE idDaerah='" + idDaerah + "' "
                + "AND harga BETWEEN " + new BigDecimal(hargaMin) + " AND " + new BigDecimal(hargaMax)
                + " AND tipeProperty='" + stringTipeProperty + "' "
                + "AND luasBangunan BETWEEN " + luasBangunanMin + " AND " + luasBangunanMax
                + "AND luasTanah BETWEEN " + luasTanahMin + " AND " + luasTanahMax
                + "AND luasBangunan BETWEEN " + jumlahKamarMin + " AND " + jumlahKamarMax
                + "AND verifikasi=" + 1 + " ";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = getUserById(rs.getInt("idPengguna"));
                listProperty.add(new Property(rs.getInt("kodeProperti"), user, getDaerah(rs.getInt("idDaerah")), rs.getString("alamat"), rs.getString("deskripsiBangunan"), StatusJualSewa.valueOf(rs.getString("statusJualSewa")), BigInteger.valueOf(rs.getLong("harga")), TipeProperty.valueOf(rs.getString("tipeProperty")), rs.getInt("luasBangunan"), rs.getInt("luasTanah"), rs.getInt("jumlahKamar"), rs.getBoolean("verifikasi")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listProperty;
    }

    public ArrayList<Property> getListPropertyBelumTerverifikasi() {
        ArrayList<Property> listProperty = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM properti WHERE verifikasi=" + 0 + "";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = getUserById(rs.getInt("idPengguna"));
                listProperty.add(new Property(rs.getInt("kodeProperti"), user, getDaerah(rs.getInt("idDaerah")), rs.getString("alamat"), rs.getString("deskripsiBangunan"), StatusJualSewa.valueOf(rs.getString("statusJualSewa")), BigInteger.valueOf(rs.getLong("harga")), TipeProperty.valueOf(rs.getString("tipeProperty")), rs.getInt("luasBangunan"), rs.getInt("luasTanah"), rs.getInt("jumlahKamar"), rs.getBoolean("verifikasi")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listProperty;
    }
    
    public  ArrayList<Property> getAllProperty(){
        ArrayList<Property> listProperty = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM properti WHERE verifikasi=" + 1 + " ";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = getUserById(rs.getInt("idPengguna"));
                listProperty.add(new Property(rs.getInt("kodeProperti"), user, getDaerah(rs.getInt("idDaerah")), rs.getString("alamat"), rs.getString("deskripsiBangunan"), StatusJualSewa.valueOf(rs.getString("statusJualSewa")), BigInteger.valueOf(rs.getLong("harga")), TipeProperty.valueOf(rs.getString("tipeProperty")), rs.getInt("luasBangunan"), rs.getInt("luasTanah"), rs.getInt("jumlahKamar"), rs.getBoolean("verifikasi")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listProperty;
    }
}
