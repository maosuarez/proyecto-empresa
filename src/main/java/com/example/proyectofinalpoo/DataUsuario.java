package com.example.proyectofinalpoo;

import com.example.proyectofinalpoo.Clases.Usuarios;
import com.example.proyectofinalpoo.Repositorios.DBDatos;
import com.example.proyectofinalpoo.Repositorios.DBUsuarios;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DataUsuario implements Initializable {

    @FXML
    private Button Salir;

    @FXML
    private Button Editar;

    @FXML
    private AnchorPane marco;

    @FXML
    private TextField Nombre;

    @FXML
    private TextField Puesto;

    @FXML
    private TextField Edad;

    @FXML
    private TextField Salario;

    private Usuarios oldUsuario;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.recuperarDatos();
    }

    public void recuperarDatos() {
        DBDatos Dd = new DBDatos();
        ArrayList<Usuarios> list = Dd.getListData();
        if(!list.isEmpty()){
            oldUsuario = list.getFirst();
            Nombre.setText(oldUsuario.getNombre());
            Puesto.setText(oldUsuario.getPuesto());
            Edad.setText(oldUsuario.getEdad()+"");
            Salario.setText(oldUsuario.getSalario()+"");
        }
    }

    @FXML
    public void Salir(){
        try {

            Stage stage = (Stage) this.Salir.getScene().getWindow();
            stage.close();
            FXMLLoader cargador3 = new FXMLLoader(getClass().getResource("TablaJefe.fxml"));
            Scene scena = new Scene(cargador3.load());
            stage.setScene(scena);
            stage.show();

        }catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void Editar(){
        DBUsuarios Db = new DBUsuarios();
        if(verificarEdad() && verificarSalario()){
            if (oldUsuario != null){
                Usuarios cambio = new Usuarios(getNombre(),oldUsuario.getContra(),getPuesto(),getEdad(),oldUsuario.getGenero(),getSalario(),oldUsuario.getTelefono(),oldUsuario.getDireccion());
                Db.updateData(oldUsuario,cambio);
            }else{
                Usuarios adicionar = new Usuarios(getNombre(),"Empleado",getPuesto(),getEdad(),"undefined",getSalario(),"undefined","undefined");
                Db.addData(adicionar);
            }
            try{
                Stage stage = (Stage) this.Editar.getScene().getWindow();
                stage.close();
                FXMLLoader cargador3 = new FXMLLoader(getClass().getResource("TablaJefe.fxml"));
                Scene scena = new Scene(cargador3.load());
                stage.setScene(scena);
                stage.show();
            }catch(Exception e){
                System.out.println("Ha ocurrido un error");
            }

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Datos No Validos");
            alert.showAndWait();
        }

    }

    public Boolean verificarEdad() {
        try {
            int edad = Integer.parseInt(Edad.getText());
            return true;

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Edad no valida");
            alert.showAndWait();
            return false;
        }
    }

    public Boolean verificarSalario(){
        try {
            Float edad = Float.parseFloat(Salario.getText());
            return true;

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Salario no valido");
            alert.showAndWait();
            return false;
        }
    }

    public int getEdad(){
        if (Edad.getText().isEmpty()) {return 0;}
        return Integer.parseInt(Edad.getText());
    }

    public String getPuesto() {
        if (Puesto.getText().isEmpty()) {return "No Definido";}
        return this.Puesto.getText();
    }

    public String getNombre() {
        if (Nombre.getText().equals("")) {return "No Definido";}
        return this.Nombre.getText();
    }

    public float getSalario(){
        if (Salario.getText().isEmpty()){return (float) 1.0;}
        return Float.parseFloat(Salario.getText());
    }





}
