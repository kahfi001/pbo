package com.pbo.controller;

import com.pbo.dao.SiswaDaoImpl;
import com.pbo.entity.Siswa;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    public TextField txtNama;
    public TextField txtNis;
    public TextField txtAlamat;
    public TextField txtNo_hp;
    public TableView <Siswa> tableSiswa;
    public TableColumn <Siswa,String>colNama;
    public TableColumn <Siswa,String>colNis;
    public TableColumn <Siswa,String>colKelas;
    public TableColumn <Siswa,String>colAlamat;
    public TableColumn <Siswa,String>colNo_hp;

    private ObservableList<Siswa>siswas;
    private SiswaDaoImpl siswaDao;

    public void saveSiswa(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        siswaDao = new SiswaDaoImpl();
        siswas= FXCollections.observableArrayList();

        try {
            siswas.addAll(siswaDao.fetchAll());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        tableSiswa.setItems(siswas);
        colNama.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNama()));
        colNis.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNis()));
        colKelas.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getKelas()));
        colAlamat.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getKelas()));
    }
}
