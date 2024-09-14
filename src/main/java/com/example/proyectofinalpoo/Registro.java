package com.example.proyectofinalpoo;

import com.example.proyectofinalpoo.Clases.Usuarios;
import com.example.proyectofinalpoo.Repositorios.DBDatos;
import com.example.proyectofinalpoo.Repositorios.DBUsuarios;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import com.example.proyectofinalpoo.Clases.Objeto;
import com.example.proyectofinalpoo.Clases.Empleado;

public class Registro implements Initializable {

    //Atributos

    @FXML
    private RadioButton Male;

    @FXML
    private RadioButton Female;

    @FXML
    private Button SaveInfo;

    @FXML
    private Button Salir;

    @FXML
    private TextField NuevoNombre;

    @FXML
    private TextField NuevaContraseña;

    @FXML
    private TextField ConfirmacionContraseña;

    @FXML
    private TextField Edad;

    @FXML
    private TextField Direccion;

    @FXML
    private TextField Puesto;

    @FXML
    private TextField Telefono;

    @FXML
    private AnchorPane anchorPane;

    private ArrayList<Usuarios> ListaUsuarios;
    private String usuario;
    private String contra;

    //Metodos

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DBUsuarios db = new DBUsuarios();
        ListaUsuarios = db.getListData();

        this.recuperarData();

        ToggleGroup tg = new ToggleGroup();
        this.Male.setToggleGroup(tg);
        this.Female.setToggleGroup(tg);
    }

    @FXML
    public void salir(){
        try {

            Stage stage = (Stage) this.Salir.getScene().getWindow();
            stage.close();
            FXMLLoader cargador = new FXMLLoader(getClass().getResource("LogIn.fxml"));
            Scene scena = new Scene(cargador.load());
            stage.setScene(scena);
            stage.show();

        }catch (IOException e){

            System.out.println(e);
        }
    }

    @FXML
    public void saveProfile() {
        boolean agregar = true;

        // Van las acciones del metodo

        try{

            if (verificarContraseña() && verificarEdad()){
                if (!ListaUsuarios.isEmpty()) {
                    for (Usuarios usua : ListaUsuarios) {
                        if (Objects.equals(usua.getNombre(), getNombre())){
                            agregar = false;
                        }
                    }
                }

                if(agregar) {

                    Usuarios newUsua = new Usuarios(getNombre(),getContraseña(),getPuesto(),getEdad(),getGenero(),(float)1.0,getTelefono(),getDireccion());
                    ListaUsuarios.add(newUsua);

                    DBUsuarios DB = new DBUsuarios();
                    DB.addData(newUsua);

                    Stage stage = (Stage) this.SaveInfo.getScene().getWindow();
                    stage.close();

                    try {
                        FXMLLoader cargador1 = new FXMLLoader(Registro.class.getResource("LogIn.fxml"));
                        Scene scene = new Scene(cargador1.load());
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            }

        } catch (Exception e) {

            System.out.println("Error en algun lado");
            e.printStackTrace();

        }
    }

    public void recuperarData(){
        try{
            DBDatos Dd = new DBDatos();
            String texto = Dd.getFila();

            StringTokenizer tokens = new StringTokenizer(texto, "|");

            String nombre = tokens.nextToken();
            String contra = tokens.nextToken();

            NuevoNombre.setText(nombre);
            NuevaContraseña.setText(contra);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Boolean verificarContraseña() {
        String cont1 = this.NuevaContraseña.getText();
        String cont2 = this.ConfirmacionContraseña.getText();
        if (cont2.equals(cont1)) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Las contraseñas con coinciden");
            alert.showAndWait();
            this.NuevaContraseña.clear();
            this.ConfirmacionContraseña.clear();
            return false;
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

    public String getGenero() {
        if (Male.isSelected()) {
            return "Hombre";
        } else {
            if (Female.isSelected()) {
                return "Mujer";
            } else {
                return "Otro";
            }
        }
    }

    public String getDireccion() {
        if (Direccion.getText().equals("")) {return "No Definido";}
        return this.Direccion.getText();
    }

    public String getPuesto() {
        if (Puesto.getText().equals("")) {return "No Definido";}
        return this.Puesto.getText();
    }

    public String getNombre() {
        if (NuevoNombre.getText().equals("")) {return "No Definido";}
        return this.NuevoNombre.getText();
    }

    public String getTelefono() {
        if (Telefono.getText().equals("")) {return "No Definido";}
        return this.Telefono.getText();
    }

    public int getEdad(){
        if (Edad.getText().equals("")) {return 0;}
        return Integer.parseInt(Edad.getText());
    }

    public String getContraseña(){
        if(NuevaContraseña.getText().equals("")) {return "No Definido";}
        return NuevaContraseña.getText();
    }

}
