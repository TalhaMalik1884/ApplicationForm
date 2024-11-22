package com.example.applicform;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ApplicationForm extends Application {

    @Override
    public void start(Stage Stage) {

        Label banner = new Label("APPLICATION FORM");
        banner.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: black;");
        HBox bannerBox = new HBox(banner);
        bannerBox.setAlignment(Pos.CENTER);
        bannerBox.setPadding(new Insets(10, 0, 20, 0));
        bannerBox.setStyle("-fx-background-color: SKYBLUE; -fx-padding: 20px;");


        Label nameLabel = new Label("Name");
        TextField nameField = new TextField();

        Label fatherNameLabel = new Label("Father Name");
        TextField fatherNameField = new TextField();

        Label cnicLabel = new Label("CNIC");
        TextField cnicField = new TextField();

        Label dateLabel = new Label("Date of Birth");
        DatePicker datePicker = new DatePicker();

        Label genderLabel = new Label("Gender");
        RadioButton maleRadio = new RadioButton("Male");
        RadioButton femaleRadio = new RadioButton("Female");
        ToggleGroup genderGroup = new ToggleGroup();
        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);

        HBox genderBox = new HBox(10, maleRadio, femaleRadio);

        Label cityLabel = new Label("City");
        ComboBox<String> cityComboBox = new ComboBox<>();
        cityComboBox.getItems().addAll("Lahore", "Karachi", "Islamabad");


        Label imageLabel = new Label("Image");
        ImageView imageView = new ImageView();
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);
        imageView.setStyle("-fx-border-color: black; -fx-border-width:2px; -fx-padding:5px");

        Button fileChooserButton = new Button("Upload Image");
        fileChooserButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(Stage);
            if (selectedFile != null) {
                try {
                    Image image = new Image(new FileInputStream(selectedFile));
                    imageView.setImage(image);
                }
                catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });


        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");


        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);

        gridPane.add(fatherNameLabel, 0, 1);
        gridPane.add(fatherNameField, 1, 1);

        gridPane.add(cnicLabel, 0, 2);
        gridPane.add(cnicField, 1, 2);

        gridPane.add(dateLabel, 0, 3);
        gridPane.add(datePicker, 1, 3);

        gridPane.add(genderLabel, 0, 4);
        gridPane.add(genderBox, 1, 4);

        gridPane.add(cityLabel, 0, 5);
        gridPane.add(cityComboBox, 1, 5);

        gridPane.add(saveButton, 1, 6);
        saveButton.setAlignment(Pos.CENTER_RIGHT);
        gridPane.add(cancelButton,2,6);
        cancelButton.setAlignment(Pos.CENTER_RIGHT);
        cancelButton.setOnAction(e-> Stage.hide());

        VBox imageBox = new VBox(10, imageLabel, imageView, fileChooserButton);
        imageBox.setAlignment(Pos.CENTER);
        imageBox.setStyle("-fx-border-color: black; -fx-border-width:1px; -fx-padding:3px");

        HBox Layout = new HBox(20, gridPane, imageBox);
        Layout.setPadding(new Insets(20));

        VBox border = new VBox(10, bannerBox, Layout);
        border.setPadding(new Insets(10));

        Scene scene = new Scene(border, 800, 600);
        Stage.setTitle("Application Form");
        Stage.setScene(scene);
        Stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}