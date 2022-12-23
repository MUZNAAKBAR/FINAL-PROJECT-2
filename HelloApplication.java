package com.example.project;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


import java.util.List;
import java.util.Scanner;

import static com.example.project.LoggedIn.passWord;
import static com.example.project.LoggedIn.userName;
import static javafx.scene.text.Font.font;

//serialization
public class HelloApplication extends Application implements Serializable {


    public static void main(String[] args) throws IOException {
        launch();


    }
//arraylist of items name and their prices
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
        List<String> list = new ArrayList<String>();
        list.add(0, "Burger               :500");
        list.add(1, "Chicken Piece        :400");
        list.add(2, "Fries                :200");
        list.add(3, "Pepsi                :100");
        System.out.println(list);
        File file = new File("data.dat");
        FileOutputStream fout = new FileOutputStream("data.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fout);
        outputStream.writeObject(list);



        FileInputStream fin = new FileInputStream("data.txt");
        ObjectInputStream oin = new ObjectInputStream(fin);
        ArrayList<String> list2 = (ArrayList<String>) oin.readObject();



        //SCENE 1
        //main project name

        stage.setTitle(" KFC BILLING SYSTEM");
        GridPane gridpane = new GridPane();
        Scene scene = new Scene(gridpane, 700, 700);
        stage.setScene(scene);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setAlignment(Pos.CENTER);

//sign up and login page(first page)
        Text text = new Text("Enter your Username and Password to Login: ");
        gridpane.add(text, 0, 0);
        Label username = new Label("Username=");
        username.setFont(Font.font("Callibri", FontWeight.BOLD,FontPosture.REGULAR, 15));
        username.setTextFill(Color.RED);
        gridpane.add(username, 0, 1);
        TextField textfield = new TextField();
        gridpane.add(textfield, 1, 1);
        Label password = new Label("Password=");
        password.setFont(Font.font("Callibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
        password.setTextFill(Color.BLUE);
        gridpane.add(password, 0, 2);
        PasswordField passwordField = new PasswordField();
        gridpane.add(passwordField, 1, 2);
        Button login = new Button("Login");
        login.setFont(Font.font("Callibri",FontWeight.BOLD, FontPosture.REGULAR, 15 ));
        login.setTextFill(Color.BLACK);
        gridpane.add(login, 2, 3);
        Button signUpNow = new Button("SignUp Now");
        signUpNow.setFont(Font.font("Callibri",FontWeight.BOLD,  FontPosture.REGULAR, 15));
        signUpNow.setTextFill(Color.BLACK);
        gridpane.add(signUpNow, 2, 4);


        //sign up page
        //second page in case user is not logged in
        //SCENE 2
        GridPane grid1 = new GridPane();
        grid1.setHgap(12);
        grid1.setVgap(12);
        grid1.setPadding(new Insets(12, 12, 12, 12));
        grid1.setAlignment(Pos.CENTER);
        Text text1 = new Text("Enter your Username and Password to SignUp: ");
        grid1.add(text1, 0, 0);
        Scene scene1 = new Scene(grid1, 700, 700);
        Label username1 = new Label("Username=");
        username1.setFont(Font.font("Callibri", FontWeight.BOLD,FontPosture.REGULAR, 15));
        username1.setTextFill(Color.RED);
        grid1.add(username1, 0, 1);
        TextField textfield1 = new TextField();
        grid1.add(textfield1, 1, 1);
        Label password1 = new Label("Password=");
        password1.setFont(Font.font("Callibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
        password1.setTextFill(Color.BLUE);
        grid1.add(password1, 0, 2);
        PasswordField passwordField1 = new PasswordField();
        grid1.add(passwordField1, 1, 2);
        Button signUp = new Button("SignUp");
        signUp.setFont(Font.font("Callibri",FontWeight.BOLD,  FontPosture.REGULAR, 15));
        signUp.setTextFill(Color.BLACK);
        grid1.add(signUp, 2, 3);


        //items and their prices
        //bill is also form in this
        //SCENE 3
        GridPane grid2 = new GridPane();
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setAlignment(Pos.CENTER);
        Text line = new Text("Select your Item here and press ENTER: ");
        grid2.add(line, 0, 0);
        Scene scene2 = new Scene(grid2, 700, 700);
        Button burgerButton = new Button("Burger");
        burgerButton.setFont(Font.font("Callibri",FontWeight.BOLD, FontPosture.REGULAR, 10 ));
        burgerButton.setTextFill(Color.BLACK);
        grid2.add(burgerButton, 0, 1);
        Button chickenButton = new Button("Chicken Piece");
        chickenButton.setFont(Font.font("Callibri",FontWeight.BOLD, FontPosture.REGULAR, 10 ));
        chickenButton.setTextFill(Color.BLACK);
        grid2.add(chickenButton, 1, 1);
        Button friesButton = new Button("Fries");
        friesButton.setFont(Font.font("Callibri",FontWeight.BOLD, FontPosture.REGULAR, 10 ));
        friesButton.setTextFill(Color.BLACK);
        grid2.add(friesButton, 0, 2);
        Button pepsiButton = new Button("Pepsi");
        pepsiButton.setFont(Font.font("Callibri",FontWeight.BOLD, FontPosture.REGULAR, 10 ));
        pepsiButton.setTextFill(Color.BLACK);
        grid2.add(pepsiButton, 1, 2);
        TextField t1 = new TextField();
        grid2.add(t1, 2, 3);
        Text text3 = new Text("For more options CLICK HERE:");
        grid2.add(text3, 0, 16);
        Button moreOptions = new Button("MORE OPTIONS");
        grid2.add(moreOptions, 0, 17);
        Text t2 = new Text();
        grid2.add(t2, 0, 4);
        Text t3 = new Text();
        grid2.add(t3, 0, 5);
        Text t4 = new Text();
        grid2.add(t4, 0, 6);
        Text t5 = new Text();
        grid2.add(t5, 0, 7);
        Text t6 = new Text();
        grid2.add(t6, 0, 8);
        Text t7 = new Text();
        grid2.add(t7, 0, 9);
        Text t8 = new Text();
        grid2.add(t8, 0, 10);
        Text t9 = new Text();
        grid2.add(t9, 0, 11);
        TextField t11 = new TextField();
        grid2.add(t11, 2, 13);


        //create any item
        //delete any existing item
        //SCENE 4
        GridPane grid3 = new GridPane();
        grid3.setHgap(10);
        grid3.setVgap(10);
        grid3.setAlignment(Pos.CENTER);
        grid3.setPadding(new Insets(10, 10, 10, 10));
        Scene scene3 = new Scene(grid3, 700, 700);
        Text text4 = new Text("Click on CREATE to create a new food item:");
        Button createButton = new Button("Create Item");
        grid3.add(text4, 0, 0);
        grid3.add(createButton, 1, 0);
        Text text5 = new Text("Click on REMOVE to remove a food item:");
        Button removeButton = new Button("Remove Item");
        grid3.add(text5, 0, 6);
        grid3.add(removeButton, 1, 6);


        //action on sign up and login button
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                for (int i = 0; i < userName.length; i++)
                    if (textfield.getText().equals(userName[i]) && passwordField.getText().equals(passWord[i])) {
                        stage.setScene(scene2);
                    } else {
                        Text text1 = new Text("You are not Logged in. Click on SignupNow Button to Sign Up");
                        gridpane.add(text1, 0, 4);
                    }
            }
        });
        //action pon sign up
        signUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(userName));
                arrayList.add(textfield1.getText());
                userName = arrayList.toArray(userName);
                Arrays.toString(userName);
                ArrayList<String> arrayList1 = new ArrayList<String>(Arrays.asList(passWord));
                arrayList.add(passwordField1.getText());
                passWord = arrayList1.toArray(passWord);
                Arrays.toString(passWord);
                stage.setScene(scene2);
            }
        });
        //action on second sign up button
        signUpNow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(scene1);

            }
        });

       //burger button
        burgerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                t1.setText(list.get(0).toString());
            }
        });
        //chicken button
        chickenButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                t1.setText(list.get(1).toString());
            }
        });
        //fries button
        friesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                t1.setText(list.get(2).toString());
            }
        });
        //action on button of pepsi
        pepsiButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                t1.setText(list.get(3).toString());
            }
        });
        //more options button
        moreOptions.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(scene3);
            }
        });

        // event handler
        EventHandler<KeyEvent> enter = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (t2.getText().isEmpty()) {
                    t2.setText(t1.getText());
                    t11.setText(t2.getText());

                } else if (t3.getText().isEmpty()) {
                    t3.setText(t1.getText());
                    String s2;
                    s2 = t2.getText().substring(22);
                    int i2 = Integer.parseInt(s2);
                    t11.setText(String.valueOf(i2));
                    String s3;
                    s3 = t3.getText().substring(22);
                    int i3 = Integer.parseInt(s3);
                    t11.setText(String.valueOf(i2 + i3));
                } else if (t4.getText().isEmpty()) {
                    t4.setText(t1.getText());
                    String s2;
                    s2 = t2.getText().substring(22);
                    int i2 = Integer.parseInt(s2);
                    t11.setText(String.valueOf(i2));
                    String s3;
                    s3 = t3.getText().substring(22);
                    int i3 = Integer.parseInt(s3);
                    t11.setText(String.valueOf(i2 + i3));
                    String s4;
                    s4 = t4.getText().substring(22);
                    int i4 = Integer.parseInt(s3);
                    t11.setText(String.valueOf(i2 + i3 + i4));
                } else if (t5.getText().isEmpty()) {
                    t5.setText(t1.getText());
                    String s2;
                    s2 = t2.getText().substring(22);
                    int i2 = Integer.parseInt(s2);
                    t11.setText(String.valueOf(i2));
                    String s3;
                    s3 = t3.getText().substring(22);
                    int i3 = Integer.parseInt(s3);
                    t11.setText(String.valueOf(i2 + i3));
                    String s4;
                    s4 = t4.getText().substring(22);
                    int i4 = Integer.parseInt(s3);
                    t11.setText(String.valueOf(i2 + i3 + i4));
                    String s5;
                    s5 = t5.getText().substring(22);
                    int i5 = Integer.parseInt(s5);
                    t11.setText(String.valueOf(i2 + i3 + i4 + i5));
                } else if (t6.getText().isEmpty()) {
                    t6.setText(t1.getText());
                    String s2;
                    s2 = t2.getText().substring(22);
                    int i2 = Integer.parseInt(s2);
                    t11.setText(String.valueOf(i2));
                    String s3;
                    s3 = t3.getText().substring(22);
                    int i3 = Integer.parseInt(s3);
                    t11.setText(String.valueOf(i2 + i3));
                    String s4;
                    s4 = t4.getText().substring(22);
                    int i4 = Integer.parseInt(s3);
                    t11.setText(String.valueOf(i2 + i3 + i4));
                    String s5;
                    s5 = t5.getText().substring(22);
                    int i5 = Integer.parseInt(s5);
                    t11.setText(String.valueOf(i2 + i3 + i4 + i5));
                    String s6;
                    s6 = t6.getText().substring(22);
                    int i6 = Integer.parseInt(s6);
                    t11.setText(String.valueOf(i2 + i3 + i4 + i5 + 16));
                } else if (t7.getText().isEmpty()) {
                    t7.setText(t1.getText());
                    String s2;
                    s2 = t2.getText().substring(22);
                    int i2 = Integer.parseInt(s2);
                    t11.setText(String.valueOf(i2));
                    String s3;
                    s3 = t3.getText().substring(22);
                    int i3 = Integer.parseInt(s3);
                    t11.setText(String.valueOf(i2 + i3));
                    String s4;
                    s4 = t4.getText().substring(22);
                    int i4 = Integer.parseInt(s3);
                    t11.setText(String.valueOf(i2 + i3 + i4));
                    String s5;
                    s5 = t5.getText().substring(22);
                    int i5 = Integer.parseInt(s5);
                    t11.setText(String.valueOf(i2 + i3 + i4 + i5));
                    String s6;
                    s6 = t6.getText().substring(22);
                    int i6 = Integer.parseInt(s6);
                    t11.setText(String.valueOf(i2 + i3 + i4 + i5 + i6));
                    String s7;
                    s7 = t7.getText().substring(22);
                    int i7 = Integer.parseInt(s7);
                    t11.setText(String.valueOf(i2 + i3 + i4 + i5 + i6 + i7));
                } else if (t8.getText().isEmpty()) {
                    t8.setText(t1.getText());
                    String s2;
                    s2 = t2.getText().substring(22);
                    int i2 = Integer.parseInt(s2);
                    t11.setText(String.valueOf(i2));
                    String s3;
                    s3 = t3.getText().substring(22);
                    int i3 = Integer.parseInt(s3);
                    t11.setText(String.valueOf(i2 + i3));
                    String s4;
                    s4 = t4.getText().substring(22);
                    int i4 = Integer.parseInt(s3);
                    t11.setText(String.valueOf(i2 + i3 + i4));
                    String s5;
                    s5 = t5.getText().substring(22);
                    int i5 = Integer.parseInt(s5);
                    t11.setText(String.valueOf(i2 + i3 + i4 + i5));
                    String s6;
                    s6 = t6.getText().substring(22);
                    int i6 = Integer.parseInt(s6);
                    t11.setText(String.valueOf(i2 + i3 + i4 + i5 + i6));
                    String s7;
                    s7 = t7.getText().substring(22);
                    int i7 = Integer.parseInt(s7);
                    t11.setText(String.valueOf(i2 + i3 + i4 + i5 + i6 + i7));
                    String s8;
                    s8 = t8.getText().substring(22);
                    int i8 = Integer.parseInt(s8);
                    t11.setText(String.valueOf(i2 + i3 + i4 + i5 + i6 + i7 + i8));
                } else if (t9.getText().isEmpty()) {
                    t9.setText(t1.getText());
                    String s2;
                    s2 = t2.getText().substring(22);
                    int i2 = Integer.parseInt(s2);
                    t11.setText(String.valueOf(i2));
                    String s3;
                    s3 = t3.getText().substring(22);
                    int i3 = Integer.parseInt(s3);
                    t11.setText(String.valueOf(i2 + i3));
                    String s4;
                    s4 = t4.getText().substring(22);
                    int i4 = Integer.parseInt(s3);
                    t11.setText(String.valueOf(i2 + i3 + i4));
                    String s5;
                    s5 = t5.getText().substring(22);
                    int i5 = Integer.parseInt(s5);
                    t11.setText(String.valueOf(i2 + i3 + i4 + i5));
                    String s6;
                    s6 = t6.getText().substring(22);
                    int i6 = Integer.parseInt(s6);
                    t11.setText(String.valueOf(i2 + i3 + i4 + i5 + i6));
                    String s7;
                    s7 = t7.getText().substring(22);
                    int i7 = Integer.parseInt(s7);
                    t11.setText(String.valueOf(i2 + i3 + i4 + i5 + i6 + i7));
                    String s8;
                    s8 = t8.getText().substring(22);
                    int i8 = Integer.parseInt(s8);
                    t11.setText(String.valueOf(i2 + i3 + i4 + i5 + i6 + i7 + i8));
                    String s9;
                    s9 = t9.getText().substring(22);
                    int i9 = Integer.parseInt(s9);
                    t11.setText(String.valueOf(i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9));
                } else {
                    Text t = new Text("You have selected enough Items.");
                    grid2.add(t, 0, 14);

                }
            }
        };
        grid2.addEventHandler(KeyEvent.ANY, enter);

        // create button
        //4th page
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Text text6 = new Text("Enter product name:");
                TextField text7 = new TextField();
                Text text8 = new Text("Enter product price:");
                TextField text9 = new TextField();
                Text text10 = new Text("Enter food and price and press Enter");
                grid3.add(text6, 0, 2);
                grid3.add(text7, 1, 2);
                grid3.add(text8, 0, 3);
                grid3.add(text9, 1, 3);
                grid3.add(text10, 0, 4);

                Button done = new Button("Done");
                grid3.add(done, 1, 4);
                done.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        String s = text7.getText();
                        String ss = "                :";
                        String sss = text9.getText();
                        String s1 = s.concat(ss);
                        String s2 = s1.concat(sss);
                        list.add(4, s2);
                        stage.setScene(scene2);
                        Button newButton = new Button(text7.getText());
                        grid2.add(newButton, 0, 3);
                        newButton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                t1.setText(list.get(4));
                            }
                        });
                    }
                });
                System.out.println(list);
            }
        });

        //remove button
        //last page
        removeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Text text13 = new Text("Enter product name:");
                TextField text14 = new TextField();
                grid3.add(text13, 0, 7);
                grid3.add(text14, 1, 7);
                Button done1 = new Button("Done");
                grid3.add(done1, 1, 8);
                done1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (text14.getText().equals(burgerButton.getText())) {
                            stage.setScene(scene2);
                            burgerButton.setVisible(false);
                        } else if (text14.getText().equals(chickenButton.getText())) {
                            stage.setScene(scene2);
                            chickenButton.setVisible(false);
                        } else if (text14.getText().equals(friesButton.getText())) {
                            stage.setScene(scene2);
                            friesButton.setVisible(false);
                        } else if (text14.getText().equals(pepsiButton.getText())) {
                            stage.setScene(scene2);
                            pepsiButton.setVisible(false);
                        } else {
                            Text notFound = new Text("Product entered not found in menu");
                            grid3.add(notFound, 0, 7);
                        }
                    }

                });
            }
        });


        stage.show();
    }


}