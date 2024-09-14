package com.example.proyectofinalpoo;

import com.example.proyectofinalpoo.Clases.Usuarios;
import com.example.proyectofinalpoo.Repositorios.DBDatos;
import com.example.proyectofinalpoo.Repositorios.DBUsuarios;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TablaEmpleado implements Initializable {

    @FXML
    private Button Modificar;

    @FXML
    private Label Nombre;

    @FXML
    private Label Puesto;

    @FXML
    public Label Salario;

    @FXML
    private Label Edad;

    @FXML
    private Label Telefono;

    @FXML
    private Button Salir;

    @FXML
    private TableView<Usuarios> Tabla;

    @FXML
    private TableColumn<Usuarios, String> ColumnaNombre;

    @FXML
    private TableColumn<Usuarios, String> ColumnaPuesto;

    @FXML
    private TableColumn<Usuarios, Integer> ColumnaEdad;

    @FXML
    private TableColumn<Usuarios, Float> ColumnaSalario;

    @FXML
    private TableColumn<Usuarios, String> ColumnaGenero;

    @FXML
    private final ObservableList<Usuarios> TablaUsuarios = FXCollections.observableArrayList();

    private Usuarios usuaActual;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBUsuarios db = new DBUsuarios();
        ArrayList<Usuarios> books = db.getListData();
        this.convertData();
        TablaUsuarios.setAll(books);
        Tabla.setItems(TablaUsuarios);

        setTextos();

    }

    public void setTextos(){
        DBDatos Dd = new DBDatos();
        ArrayList<Usuarios> usuas = Dd.getListData();
        usuaActual = usuas.getFirst();

        Nombre.setText("Nombre: "+usuaActual.getNombre());
        Puesto.setText("Puesto: "+usuaActual.getPuesto());
        Salario.setText("Salario: "+usuaActual.getSalario());
        Edad.setText("Edad: "+usuaActual.getEdad());
        Telefono.setText("Tel: "+usuaActual.getTelefono());

    }

    private void convertData() {
        this.ColumnaEdad.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getEdad()).asObject());
        this.ColumnaNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        this.ColumnaSalario.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getSalario()).asObject());
        this.ColumnaPuesto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPuesto()));
        this.ColumnaGenero.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero()));
    }

    @FXML
    public void Modificar(){
        DBDatos Dd = new DBDatos();
        Dd.addData(usuaActual);

        try{
            Stage stage = (Stage) this.Salir.getScene().getWindow();
            stage.close();
            FXMLLoader cargador = new FXMLLoader(getClass().getResource("Actualizacion.fxml"));
            Scene scena = new Scene(cargador.load());
            stage.setScene(scena);
            stage.show();
        }catch (IOException e) {

        System.out.println(e);

        }

    }

    @FXML
    public void Salir(){
        try {

            Stage stage = (Stage) this.Salir.getScene().getWindow();
            stage.close();
            FXMLLoader cargador = new FXMLLoader(getClass().getResource("LogIn.fxml"));
            Scene scena = new Scene(cargador.load());
            stage.setScene(scena);
            stage.show();

        }catch (IOException e) {

            System.out.println(e);
        }
    }

}
