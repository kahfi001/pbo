package com.pbo.dao;

import com.pbo.entity.Siswa;
import com.pbo.util.DaoService;
import com.pbo.util.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SiswaDaoImpl implements DaoService<Siswa> {
    @Override
    public List<Siswa> fetchAll() throws SQLException, ClassNotFoundException {
        List <Siswa> siswas = new ArrayList<>();
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "SELECT id,nama,nis,kelas,alamat,no_hp FROM siswa";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Siswa siswa = new Siswa();
                        siswa.setId(rs.getInt("id"));
                        siswa.setNama(rs.getString("nama"));
                        siswa.setNis(rs.getString("nis"));
                        siswa.setKelas(rs.getString("kelas"));
                        siswa.setAlamat(rs.getString("alamat"));
                        siswas.add(siswa);
                    }
                }
            }
        }
        return siswas;
    }

    @Override
    public int addData(Siswa object) throws SQLException, ClassNotFoundException {
        int result = 0;
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "INSERT INTO siswa(nama,nis,kelas,alamat,no_hp) VAlUES(?,?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1,object.getNama());
                ps.setString(2,object.getNis());
                ps.setString(3,object.getKelas());
                ps.setString(4,object.getAlamat());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                } else {
                    connection.rollback();
                }
            }
        }
        return result;
    }
}
