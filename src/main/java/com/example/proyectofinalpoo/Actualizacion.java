package com.example.proyectofinalpoo;

import com.example.proyectofinalpoo.Clases.Usuarios;
import com.example.proyectofinalpoo.Repositorios.DBDatos;
import com.example.proyectofinalpoo.Repositorios.DBUsuarios;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Actualizacion implements Initializable {

    @FXML
    public TextField Direccion;

    @FXML
    public TextField Telefono;

    @FXML
    public TextField Edad;

    @FXML
    public TextField Nombre;

    @FXML
    public TextField ConfiContra;

    @FXML
    public TextField Contra;

    @FXML
    public Label Salario;

    @FXML
    public Label Puesto;

    @FXML
    public Button Salir;

    @FXML
    public Button Guardar;

    private Usuarios cambiar;

    @FXML
    public void Guardar(){
        if(verificarContra() && verificarSalario() && verificarEdad()){
            Usuarios usua = new Usuarios(getNombre(),getContraseña(),getPuesto(),getEdad(),cambiar.getGenero(),getSalario(),getTelefono(),getDireccion());

            DBUsuarios Db = new DBUsuarios();
            Db.updateData(cambiar, usua);

            DBDatos Dd = new DBDatos();
            Dd.addData(usua);

            try {
                Stage stage = (Stage) this.Salir.getScene().getWindow();
                stage.close();
                FXMLLoader cargador = new FXMLLoader(getClass().getResource("TablaEmpleado.fxml"));
                Scene scena = new Scene(cargador.load());
                stage.setScene(scena);
                stage.show();
            }catch (Exception e){
                e.printStackTrace();
            }

        }else{

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Datos No Validos");
            alert.showAndWait();

        }

    }

    @FXML
    public void Salir(){
        try {

            Stage stage = (Stage) this.Salir.getScene().getWindow();
            stage.close();
            FXMLLoader cargador = new FXMLLoader(getClass().getResource("TablaEmpleado.fxml"));
            Scene scena = new Scene(cargador.load());
            stage.setScene(scena);
            stage.show();

        }catch (IOException e) {

            System.out.println(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        recuperarDatos();

    }

    public void recuperarDatos(){
        DBDatos Dd = new DBDatos();
        cambiar = Dd.getListData().getFirst();

        Nombre.setText(cambiar.getNombre());
        Edad.setText(cambiar.getEdad()+"");
        Puesto.setText(cambiar.getPuesto());
        Direccion.setText(cambiar.getDireccion());
        Telefono.setText(cambiar.getTelefono());
        Salario.setText(cambiar.getSalario()+"");
        Contra.setText(cambiar.getContra());
        ConfiContra.setText(cambiar.getContra());
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

    public Boolean verificarContra(){
        if((Contra.getText()).equals(ConfiContra.getText())){
            return true;
        }
        Contra.setText("");
        ConfiContra.setText("");
        return false;
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
        if (Nombre.getText().isEmpty()) {return "No Definido";}
        return this.Nombre.getText();
    }

    public float getSalario(){
        if (Salario.getText().isEmpty()){return (float) 1.0;}
        return Float.parseFloat(Salario.getText());
    }

    public String getContraseña(){
        if (Contra.getText().isEmpty()) {return "Empleado";}
        return this.Contra.getText();
    }

    public String getDireccion(){
        if (Direccion.getText().isEmpty()) {return "No Definido";}
        return this.Direccion.getText();
    }

    public String getTelefono(){
        if (Telefono.getText().isEmpty()) {return "No Definido";}
        return this.Telefono.getText();
    }

}
