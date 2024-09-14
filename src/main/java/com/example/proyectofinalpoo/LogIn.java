package com.example.proyectofinalpoo;

import com.example.proyectofinalpoo.Clases.Empleado;
import com.example.proyectofinalpoo.Clases.Objeto;
import com.example.proyectofinalpoo.Clases.Usuarios;
import com.example.proyectofinalpoo.Repositorios.DBDatos;
import com.example.proyectofinalpoo.Repositorios.DBUsuarios;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

//fx:controller="com.example.aplicacionproyectopoo.HelloController"
//stylesheets="@../../../../../estilos/estilo2.css"

public class LogIn implements Initializable {

    // Atributos

    @FXML
    private TextField NombreUsuario;

    @FXML
    private TextField Contraseña;

    @FXML
    private Button registerButton;

    @FXML
    private Button loginButton;

    private Usuarios UsuarioEntra;

    private ArrayList<Usuarios> usuarios;

    // Metodos

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DBUsuarios DB = new DBUsuarios();
        usuarios = DB.getListData();
    }

    @FXML
    protected void LogIn() {

        boolean confirm = false;

        try {
            String usuario = NombreUsuario.getText();
            String contrasena = Contraseña.getText();

            for (int i = 0; i < usuarios.size(); i++) {
                Usuarios usua = usuarios.get(i);
                if(usua.getNombre().equals(usuario) && usua.getContra().equals(contrasena)){
                    UsuarioEntra = usua;
                    confirm = true;
                    break;
                }
            }

            if(confirm){
                Stage stage = (Stage) this.loginButton.getScene().getWindow();
                stage.close();
                if((UsuarioEntra.getPuesto()).equalsIgnoreCase("jefe")){
                    try {
                        FXMLLoader cargador2 = new FXMLLoader(Registro.class.getResource("TablaJefe.fxml"));
                        Scene scene = new Scene(cargador2.load());
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }else{
                    DBDatos Db = new DBDatos();
                    Db.addData(UsuarioEntra);
                    try {
                        FXMLLoader cargador2 = new FXMLLoader(Registro.class.getResource("TablaEmpleado.fxml"));
                        Scene scene = new Scene(cargador2.load());
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }

            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Cuenta no Existente");
                alert.showAndWait();
            }

        } catch( Exception e ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error de lectura");
            alert.showAndWait();
        }
    }

    @FXML
    protected void Registrer() {
        try{
            String usuario = NombreUsuario.getText();
            String contraseña = Contraseña.getText();

            // Daria paso a la nueva pestaña donde se ingresa el nuevo usuario

            String texto = usuario+"|"+contraseña;
            DBDatos Dd = new DBDatos();
            Dd.addData(texto);

            Stage stage = (Stage) registerButton.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Registro.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();

        }catch (Exception e){

            System.out.println(e);

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error de lectura");
            alert.showAndWait();

        }

    }

}