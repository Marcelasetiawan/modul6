//Marcela Setiawan
package com.example.codelab6;

// Importasi kelas-kelas yang dibutuhkan
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

// Kelas utama yang diturunkan dari kelas Application
public class HelloApplication extends Application {

    // Method start() yang akan dipanggil saat aplikasi dimulai
    @Override
    public void start(Stage primaryStage) {
        // Membuat objek GridPane dengan posisi tengah, jarak horizontal, dan jarak vertikal tertentu
        GridPane loginForm = new GridPane();
        loginForm.setAlignment(Pos.CENTER);
        loginForm.setHgap(10);
        loginForm.setVgap(10);

        // Membuat label dengan teks "Halaman Login" dan font tertentu
        Label titleLabel = new Label("Halaman Login");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        // Menambahkan label ke GridPane
        loginForm.add(titleLabel, 0, 0, 2, 1);

        // Membuat label dan textfield untuk username
        Label usernameLabel = new Label("User Name:");
        loginForm.add(usernameLabel, 0, 1);
        TextField usernameField = new TextField();
        loginForm.add(usernameField, 1, 1);

        // Membuat label dan textfield untuk password
        Label passwordLabel = new Label("Password:");
        loginForm.add(passwordLabel, 0, 2);
        PasswordField passwordField = new PasswordField();
        loginForm.add(passwordField, 1, 2);

        // Membuat tombol dengan teks "Sign in" dan menambahkannya ke HBox
        Button loginButton = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(loginButton);
        // Menambahkan HBox ke GridPane
        loginForm.add(hbBtn, 1, 4);

        // Membuat label untuk menampilkan pesan error dan menambahkannya ke GridPane
        Label errorMessage = new Label("");
        errorMessage.setTextFill(Color.RED);
        loginForm.add(errorMessage, 1, 3);

        // Menambahkan event listener pada tombol "Sign in"
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.equals("marcela") && password.equals("393")) {
                // Membuat objek Stage dan VBox
                Stage mainStage = new Stage();
                VBox mainPage = new VBox(10);
                mainPage.setAlignment(Pos.CENTER); // Add this line

                // Membuat label dengan teks "Halo Marcela" dan menambahkannya ke VBox
                Label welcomeLabel = new Label("Halo Marcela");
                welcomeLabel.setAlignment(Pos.CENTER); // Add this line

                // Membuat tombol "Kembali" dan menambahkannya ke VBox
                Button backButton = new Button("Kembali");
                backButton.setOnAction(e -> mainStage.close());
                mainPage.getChildren().addAll(welcomeLabel, backButton);
                Scene mainScene = new Scene(mainPage, 300, 150);
                mainStage.setScene(mainScene);
                mainStage.show();

                primaryStage.close();
            } else {
                errorMessage.setText("Password Atau Username Salah");
            }
        });

        // Membuat scene baru dengan ukuran 300x250 dan menambahkan loginForm ke dalamnya
        Scene scene = new Scene(loginForm, 300, 250);

        // Menetapkan judul pada stage utama
        primaryStage.setTitle("Login Application");

        // Menambahkan scene ke stage utama
        primaryStage.setScene(scene);

        // Menampilkan stage utama
        primaryStage.show();
    }

    // Method main yang digunakan untuk menjalankan aplikasi
    public static void main(String[] args) {
        // Menjalankan aplikasi dengan memanggil method launch
        launch(args);
    }
}