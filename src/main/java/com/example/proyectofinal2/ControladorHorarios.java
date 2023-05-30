package com.example.proyectofinal2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.*;

public class ControladorHorarios implements Initializable {
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TextField tAula;

    @FXML
    private TextField tHorario;

    @FXML
    private TableColumn<Horarios, String> colHorario;

    @FXML
    private TableColumn<Horarios, Integer> colId;

    @FXML
    private TableColumn<Horarios, String> colNprofesor;

    @FXML
    private TableColumn<Horarios, String> colaula;

    @FXML
    private TextField tID;

    @FXML
    private TextField tNombreProfesor;

    @FXML
    private TableView<Horarios> table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showHorarios();

    }

    public ObservableList<Horarios> getHorario(){
        ObservableList<Horarios> horarios = FXCollections.observableArrayList();

        String query = "select* from horarios";
        con = DBConnexion.getCon();
        try {
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while(rs.next()){
                Horarios st = new Horarios();
                st.setId(rs.getInt("id"));
                st.setNombreprofesor(rs.getString("NombreProfesor"));
                st.setAula(rs.getString("Aula"));
                st.setHorario(rs.getString("Horario"));
                horarios.add(st);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return horarios;
    }

    public void showHorarios(){
        ObservableList<Horarios> list = getHorario();
        table.setItems(list);
        colId.setCellValueFactory(new PropertyValueFactory<Horarios, Integer>("id"));
        colNprofesor.setCellValueFactory(new PropertyValueFactory<Horarios, String>("nombreProfesor"));
        colaula.setCellValueFactory(new PropertyValueFactory<Horarios, String>("aula"));
        colHorario.setCellValueFactory(new PropertyValueFactory<Horarios, String>("horarios"));
    }

    @FXML
    void clearField(ActionEvent event) {

    }

    @FXML
    void createHorarios(ActionEvent event) {

    }

    @FXML
    void deleteHorarios(ActionEvent event) {

    }

    @FXML
    void updateHorarios(ActionEvent event) {

    }


}
