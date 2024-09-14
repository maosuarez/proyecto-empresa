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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TablaJefe implements Initializable {

    // Atributos

    @FXML
    private Button Agregar;

    @FXML
    private Button Eliminar;

    @FXML
    private Button Editar;

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

    //Metodos

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DBUsuarios db = new DBUsuarios();
        ArrayList<Usuarios> books = db.getListData();
        this.convertData();
        TablaUsuarios.setAll(books);
        Tabla.setItems(TablaUsuarios);
    }
    private void convertData() {
        this.ColumnaEdad.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getEdad()).asObject());
        this.ColumnaNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        this.ColumnaSalario.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getSalario()).asObject());
        this.ColumnaPuesto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPuesto()));
        this.ColumnaGenero.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero()));
    }

    @FXML
    public void Agregar(){
        try{
            Stage stage = (Stage) this.Editar.getScene().getWindow();
            stage.close();
            FXMLLoader cargador3 = new FXMLLoader(getClass().getResource("DataUsuario.fxml"));
            Scene scena = new Scene(cargador3.load());
            stage.setScene(scena);
            stage.show();

        }catch(Exception e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error de Carga");
            alert.showAndWait();
        }

    }

    @FXML
    public void Eliminar(){
        Usuarios book = Tabla.getSelectionModel().getSelectedItem();
        if(book != null)
        {
            DBUsuarios db = new DBUsuarios();
            db.deleteData(book);
            TablaUsuarios.remove(book);
            Tabla.getSelectionModel().clearSelection();
        }
    }

    @FXML
    public void Editar(){
        Usuarios selectedBook = Tabla.getSelectionModel().getSelectedItem(); // Seleccionado el libro a actualizar
        if (selectedBook != null){ //Se verifica que se haya seleccionado
            try{

                DBDatos Dd = new DBDatos();
                Dd.addData(selectedBook);

                Stage stage = (Stage) this.Editar.getScene().getWindow();
                stage.close();
                FXMLLoader cargador3 = new FXMLLoader(getClass().getResource("DataUsuario.fxml"));
                Scene scena = new Scene(cargador3.load());
                stage.setScene(scena);
                stage.show();

            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("Por favor seleccionar un libro para continuar");
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
