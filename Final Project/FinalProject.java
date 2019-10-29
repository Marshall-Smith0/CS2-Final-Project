/* 
Program Written for CS II
Final Project
Program Written by Marshall Smith
Last Modified on 4/29/2018		
Windows 10
Visual Studio Code
This is the final assignment. Make sure that you read the text document "Read Me.txt" before running this program.   
*/

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
import java.util.*;
import java.io.*;
import java.lang.*;

public class FinalProject extends Application {
    Stage window;
    Scene scene1, scene2, scene3, scene4, scene5, scene6;
    int firstNum1, secondNum1, firstNum2, secondNum2, firstNum3, secondNum3, firstNum4, secondNum4, firstNum5, secondNum5;
    String firstNum1String, secondNum1String, firstNum2String, secondNum2String, firstNum3String, secondNum3String;
    String firstNum4String, secondNum4String, firstNum5String, secondNum5String;
    String returnString1, returnString2, returnString3, returnString4, returnString5;

    public void start (Stage primaryStage) {
        window = primaryStage;
        
        //setting the scenes
    //Scene 1
        window.setTitle("MathBot");
        Pane root1 = new Pane();
        scene1 = new Scene(root1, 750, 500);
        Image backgroundImage = new Image("BackgroundImage.jpg");
        ImageView backGround = new ImageView(backgroundImage);
        backGround.setFitHeight(500);
        backGround.setFitWidth(750);
        window.setResizable(false);
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(5));
        gp.setHgap(10);
        gp.setVgap(10);
    //putting in smily face
        ImageView imgView = new ImageView();
        Image image1 = new Image(FinalProject.class.getResourceAsStream("NormalFace.png"));
        imgView.setImage(image1);
        imgView.setFitHeight(150);
        imgView.setFitWidth(150);        
        HBox pictureRegion = new HBox();
        pictureRegion.getChildren().add(imgView);
        gp.add(pictureRegion, 10, 1);
    //Making MathBot Talk
        Label speech = new Label("\"Hello! Welcome to MathBot, my name is Jaiden.\n" + 
            "I will be helping you through this adventure.\n" + 
            "To start, click the next button below!!\"");
        speech.setFont(new Font("Comic Sans", 20));
        GridPane.setHalignment(speech, HPos.LEFT);
        gp.add(speech, 11, 1);
    //creating the next button
        Button nextButton = new Button("Next");
        nextButton.setOnAction(e -> window.setScene(scene2));
        gp.add(nextButton, 11, 7);
    //End of Scene 1 

    //Scene 2 First math problem
        Pane root2 = new Pane();
        scene2 = new Scene(root2, 750, 500);
        Image backgroundImage2 = new Image("BackgroundImage.jpg");
        ImageView backGround2 = new ImageView(backgroundImage2);
        backGround2.setFitHeight(500);
        backGround2.setFitWidth(750);
        window.setResizable(false);
        GridPane gp2 = new GridPane();
        gp2.setPadding(new Insets(15));
        gp2.setHgap(10);
        gp2.setVgap(10);
    //putting in smily face
        ImageView imgView2_2 = new ImageView();
        Image image2 = new Image(FinalProject.class.getResourceAsStream("NormalFace.png"));
        imgView2_2.setImage(image2);
        imgView2_2.setFitHeight(150);
        imgView2_2.setFitWidth(150);
        HBox pictureRegion2 = new HBox();
        pictureRegion2.getChildren().add(imgView2_2);
        gp2.add(pictureRegion2, 3, 1);
    //Making MathBot Talk
        Label speech2 = new Label("\"Please enter in the answer for the problem below.\n" + 
        "Please clear my message before each try.\n" +
        "When you get the answer correct\n" +
        "hit the next button to go to the next problem\"");
        speech2.setFont(new Font("Comic Sans", 20));
        GridPane.setHalignment(speech2, HPos.LEFT);
        gp2.add(speech2, 5, 1);
    //Doing the math
        firstNum1 = 1 + (int) (Math.random() * 10);
        secondNum1 = 1 + (int) (Math.random() * 10);
        firstNum1String = Integer.toString(firstNum1);
        secondNum1String = Integer.toString(secondNum1);

        TextField firstValue1 = new TextField();
        firstValue1.setText(firstNum1String);
        firstValue1.setPrefWidth(30);
        firstValue1.setEditable(false);
        gp2.add(firstValue1, 1, 10);
        Label addSign = new Label("+");
        addSign.setFont(new Font("Comic Sans", 20));
        gp2.add(addSign, 2, 10);
        TextField secondValue1 = new TextField();
        secondValue1.setText(secondNum1String);
        secondValue1.setPrefWidth(30);
        secondValue1.setEditable(false);
        gp2.add(secondValue1, 3, 10);
        Label equalSign = new Label("=");
        equalSign.setFont(new Font("Comic Sans", 20));
        gp2.add(equalSign, 4, 10);
        Button checkBtn1 = new Button("Check");
        gp2.add(checkBtn1, 5, 12);
        GridPane.setHalignment(checkBtn1, HPos.LEFT);   
        Button clearBtn1 = new Button("Clear");
        gp2.add(clearBtn1, 5, 13);
        GridPane.setHalignment(clearBtn1, HPos.LEFT);
        TextField result1 = new TextField();
        result1.setPrefWidth(10);
        gp2.add(result1, 5, 10);

        checkBtn1.setOnAction(e1 -> {
            returnString1 = mathMethod(result1.getText(), firstNum1, secondNum1);
                
            ImageView imgView3 = new ImageView();
            Image image3 = new Image(FinalProject.class.getResourceAsStream("NormalFace.png"));
            HBox pictureRegion3 = new HBox();
            imgView3.setImage(image3);
            imgView3.setFitHeight(150);
            imgView3.setFitWidth(150);

            ImageView imgView4 = new ImageView();
            HBox pictureRegion4 = new HBox();
            Image image4 = new Image(FinalProject.class.getResourceAsStream("SadFace.png"));
            imgView4.setImage(image4);
            imgView4.setFitHeight(150);
            imgView4.setFitWidth(150);

            ImageView imgView5 = new ImageView();
            HBox pictureRegion5 = new HBox();
            Image image5 = new Image(FinalProject.class.getResourceAsStream("HappyFace.png"));
            imgView5.setImage(image5);
            imgView5.setFitHeight(150);
            imgView5.setFitWidth(150);

            Label returnLabel = new Label(returnString1);
                
            clearBtn1.setOnAction(e1_1 -> {
                pictureRegion3.getChildren().add(imgView3);
                gp2.add(pictureRegion3, 3, 1);
                result1.clear();
                returnLabel.setText("");
            });

            if (returnString1.equals("\"Your answer is Correct! Awesome job!\"")) {
                pictureRegion5.getChildren().add(imgView5);
                gp2.add(pictureRegion5, 3, 1);
                returnLabel.setFont(new Font("Comic Sans", 20));
                gp2.add(returnLabel, 5, 14);
            }
            else {
                pictureRegion4.getChildren().add(imgView4);
                gp2.add(pictureRegion4, 3, 1);
                returnLabel.setFont(new Font("Comic Sans", 20));
                gp2.add(returnLabel, 5, 14);
            }
        });

    //Next Button to Scene 3
        Button nextBtn1 = new Button("Next");
        gp2.add(nextBtn1, 5, 15);
        nextBtn1.setOnAction(e -> window.setScene(scene3));
    
    //SCENE 3 second math scene
        Pane root3 = new Pane();
        scene3 = new Scene(root3, 750, 500);
        Image backgroundImage3 = new Image("BackgroundImage.jpg");
        ImageView backGround3 = new ImageView(backgroundImage3);
        backGround3.setFitHeight(500);
        backGround3.setFitWidth(750);
        window.setResizable(false);
        GridPane gp3 = new GridPane();
        gp3.setPadding(new Insets(15));
        gp3.setHgap(10);
        gp3.setVgap(10);
    //putting in smily face
        ImageView imgView2_3 = new ImageView();
        Image image3 = new Image(FinalProject.class.getResourceAsStream("NormalFace.png"));
        imgView2_3.setImage(image3);
        imgView2_3.setFitHeight(150);
        imgView2_3.setFitWidth(150);
        HBox pictureRegion3 = new HBox();
        pictureRegion3.getChildren().add(imgView2_3);
        gp3.add(pictureRegion3, 3, 1);
    //Making MathBot Talk
        Label speech3 = new Label("\"Please enter in the answer for the problem below.\n" + 
        "Please clear my message before each try.\n" +
        "When you get the answer correct\n" +
        "hit the next button to go to the next problem\"");
        speech3.setFont(new Font("Comic Sans", 20));
        GridPane.setHalignment(speech3, HPos.LEFT);
        gp3.add(speech3, 5, 1);
    //Doing the math
        firstNum2 = 1 + (int) (Math.random() * 10);
        secondNum2 = 1 + (int) (Math.random() * 10);
        firstNum2String = Integer.toString(firstNum2);
        secondNum2String = Integer.toString(secondNum2);

        TextField firstValue2 = new TextField();
        firstValue2.setText(firstNum2String);
        firstValue2.setPrefWidth(30);
        firstValue2.setEditable(false);
        gp3.add(firstValue2, 1, 10);
        Label addSign3 = new Label("+");
        addSign3.setFont(new Font("Comic Sans", 20));
        gp3.add(addSign3, 2, 10);
        TextField secondValue2 = new TextField();
        secondValue2.setText(secondNum2String);
        secondValue2.setPrefWidth(30);
        secondValue2.setEditable(false);
        gp3.add(secondValue2, 3, 10);
        Label equalSign3 = new Label("=");
        equalSign3.setFont(new Font("Comic Sans", 20));
        gp3.add(equalSign3, 4, 10);
        Button checkBtn2 = new Button("Check");
        gp3.add(checkBtn2, 5, 12);
        GridPane.setHalignment(checkBtn2, HPos.LEFT);   
        Button clearBtn2 = new Button("Clear");
        gp3.add(clearBtn2, 5, 13);
        GridPane.setHalignment(clearBtn2, HPos.LEFT);
        TextField result2 = new TextField();
        result2.setPrefWidth(10);
        gp3.add(result2, 5, 10);

        checkBtn2.setOnAction(e1 -> {
            returnString2 = mathMethod(result2.getText(), firstNum2, secondNum2);
                
            ImageView imgView3_3 = new ImageView();
            Image image3_3 = new Image(FinalProject.class.getResourceAsStream("NormalFace.png"));
            HBox pictureRegion3_3 = new HBox();
            imgView3_3.setImage(image3_3);
            imgView3_3.setFitHeight(150);
            imgView3_3.setFitWidth(150);

            ImageView imgView4_3 = new ImageView();
            HBox pictureRegion4_3 = new HBox();
            Image image4_3 = new Image(FinalProject.class.getResourceAsStream("SadFace.png"));
            imgView4_3.setImage(image4_3);
            imgView4_3.setFitHeight(150);
            imgView4_3.setFitWidth(150);

            ImageView imgView5_3 = new ImageView();
            HBox pictureRegion5_3 = new HBox();
            Image image5_3 = new Image(FinalProject.class.getResourceAsStream("HappyFace.png"));
            imgView5_3.setImage(image5_3);
            imgView5_3.setFitHeight(150);
            imgView5_3.setFitWidth(150);

            Label returnLabel2 = new Label(returnString2);
                
            clearBtn2.setOnAction(e1_2 -> {
                pictureRegion3_3.getChildren().add(imgView3_3);
                gp3.add(pictureRegion3_3, 3, 1);
                result2.clear();
                returnLabel2.setText("");
            });

            if (returnString2.equals("\"Your answer is Correct! Awesome job!\"")) {
                pictureRegion5_3.getChildren().add(imgView5_3);
                gp3.add(pictureRegion5_3, 3, 1);
                returnLabel2.setFont(new Font("Comic Sans", 20));
                gp3.add(returnLabel2, 5, 14);
            }
            else {
                pictureRegion4_3.getChildren().add(imgView4_3);
                gp3.add(pictureRegion4_3, 3, 1);
                returnLabel2.setFont(new Font("Comic Sans", 20));
                gp3.add(returnLabel2, 5, 14);
            }
        });
    //End of scene 3 

    //Next Button to scene 4
        Button nextBtn2 = new Button("Next");
        gp3.add(nextBtn2, 5, 15);
        nextBtn2.setOnAction(e -> window.setScene(scene4));

    //Start of scene 4 3rd math scene
        Pane root4 = new Pane();
        scene4 = new Scene(root4, 750, 500);
        Image backgroundImage4 = new Image("BackgroundImage.jpg");
        ImageView backGround4 = new ImageView(backgroundImage4);
        backGround4.setFitHeight(500);
        backGround4.setFitWidth(750);
        window.setResizable(false);
        GridPane gp4 = new GridPane();
        gp4.setPadding(new Insets(15));
        gp4.setHgap(10);
        gp4.setVgap(10);
    //putting in smily face
        ImageView imgView2_4 = new ImageView();
        Image image4 = new Image(FinalProject.class.getResourceAsStream("NormalFace.png"));
        imgView2_4.setImage(image4);
        imgView2_4.setFitHeight(150);
        imgView2_4.setFitWidth(150);
        HBox pictureRegion4 = new HBox();
        pictureRegion4.getChildren().add(imgView2_4);
        gp4.add(pictureRegion4, 3, 1);
    //Making MathBot Talk
        Label speech4 = new Label("\"Please enter in the answer for the problem below.\n" + 
        "Please clear my message before each try.\n" +
        "When you get the answer correct\n" +
        "hit the next button to go to the next problem\"");
        speech4.setFont(new Font("Comic Sans", 20));
        GridPane.setHalignment(speech4, HPos.LEFT);
        gp4.add(speech4, 5, 1);
    //Doing the math
        firstNum3 = 1 + (int) (Math.random() * 10);
        secondNum3 = 1 + (int) (Math.random() * 10);
        firstNum3String = Integer.toString(firstNum3);
        secondNum3String = Integer.toString(secondNum3);

        TextField firstValue3 = new TextField();
        firstValue3.setText(firstNum3String);
        firstValue3.setPrefWidth(30);
        firstValue3.setEditable(false);
        gp4.add(firstValue3, 1, 10);
        Label addSign4 = new Label("+");
        addSign4.setFont(new Font("Comic Sans", 20));
        gp4.add(addSign4, 2, 10);
        TextField secondValue3 = new TextField();
        secondValue3.setText(secondNum3String);
        secondValue3.setPrefWidth(30);
        secondValue3.setEditable(false);
        gp4.add(secondValue3, 3, 10);
        Label equalSign4 = new Label("=");
        equalSign4.setFont(new Font("Comic Sans", 20));
        gp4.add(equalSign4, 4, 10);
        Button checkBtn3 = new Button("Check");
        gp4.add(checkBtn3, 5, 12);
        GridPane.setHalignment(checkBtn3, HPos.LEFT);   
        Button clearBtn3 = new Button("Clear");
        gp4.add(clearBtn3, 5, 13);
        GridPane.setHalignment(clearBtn3, HPos.LEFT);
        TextField result3 = new TextField();
        result3.setPrefWidth(10);
        gp4.add(result3, 5, 10);

        checkBtn3.setOnAction(e1 -> {
            returnString3 = mathMethod(result3.getText(), firstNum3, secondNum3);
                
            ImageView imgView3_4 = new ImageView();
            Image image3_4 = new Image(FinalProject.class.getResourceAsStream("NormalFace.png"));
            HBox pictureRegion3_4 = new HBox();
            imgView3_4.setImage(image3_4);
            imgView3_4.setFitHeight(150);
            imgView3_4.setFitWidth(150);

            ImageView imgView4_4 = new ImageView();
            HBox pictureRegion4_4 = new HBox();
            Image image4_4 = new Image(FinalProject.class.getResourceAsStream("SadFace.png"));
            imgView4_4.setImage(image4_4);
            imgView4_4.setFitHeight(150);
            imgView4_4.setFitWidth(150);

            ImageView imgView5_4 = new ImageView();
            HBox pictureRegion5_4 = new HBox();
            Image image5_4 = new Image(FinalProject.class.getResourceAsStream("HappyFace.png"));
            imgView5_4.setImage(image5_4);
            imgView5_4.setFitHeight(150);
            imgView5_4.setFitWidth(150);

            Label returnLabel3 = new Label(returnString3);
                
            clearBtn3.setOnAction(e1_3 -> {
                pictureRegion3_4.getChildren().add(imgView3_4);
                gp4.add(pictureRegion3_4, 3, 1);
                result3.clear();
                returnLabel3.setText("");
            });

            if (returnString3.equals("\"Your answer is Correct! Awesome job!\"")) {
                pictureRegion5_4.getChildren().add(imgView5_4);
                gp4.add(pictureRegion5_4, 3, 1);
                returnLabel3.setFont(new Font("Comic Sans", 20));
                gp4.add(returnLabel3, 5, 14);
            }
            else {
                pictureRegion4_4.getChildren().add(imgView4_4);
                gp4.add(pictureRegion4_4, 3, 1);
                returnLabel3.setFont(new Font("Comic Sans", 20));
                gp4.add(returnLabel3, 5, 14);
            }
        });
    //End of scene 4

    //Next button to scene 5 
        Button nextBtn3 = new Button("Next");
        gp4.add(nextBtn3, 5, 15);
        nextBtn3.setOnAction(e -> window.setScene(scene5));

    //Start of scene 5 4th math scene
        Pane root5 = new Pane();
        scene5 = new Scene(root5, 750, 500);
        Image backgroundImage5 = new Image("BackgroundImage.jpg");
        ImageView backGround5 = new ImageView(backgroundImage5);
        backGround5.setFitHeight(500);
        backGround5.setFitWidth(750);
        window.setResizable(false);
        GridPane gp5 = new GridPane();
        gp5.setPadding(new Insets(15));
        gp5.setHgap(10);
        gp5.setVgap(10);
    //putting in smily face
        ImageView imgView2_5 = new ImageView();
        Image image5 = new Image(FinalProject.class.getResourceAsStream("NormalFace.png"));
        imgView2_5.setImage(image5);
        imgView2_5.setFitHeight(150);
        imgView2_5.setFitWidth(150);
        HBox pictureRegion5 = new HBox();
        pictureRegion5.getChildren().add(imgView2_5);
        gp5.add(pictureRegion5, 3, 1);
    //Making MathBot Talk
        Label speech5 = new Label("\"Please enter in the answer for the problem below.\n" + 
        "Please clear my message before each try.\n" +
        "When you get the answer correct\n" +
        "hit the next button to go to the next problem\"");
        speech5.setFont(new Font("Comic Sans", 20));
        GridPane.setHalignment(speech5, HPos.LEFT);
        gp5.add(speech5, 5, 1);
    //Doing the math
        firstNum4 = 1 + (int) (Math.random() * 10);
        secondNum4 = 1 + (int) (Math.random() * 10);
        firstNum4String = Integer.toString(firstNum4);
        secondNum4String = Integer.toString(secondNum4);

        TextField firstValue4 = new TextField();
        firstValue4.setText(firstNum4String);
        firstValue4.setPrefWidth(30);
        firstValue4.setEditable(false);
        gp5.add(firstValue4, 1, 10);
        Label addSign5 = new Label("+");
        addSign5.setFont(new Font("Comic Sans", 20));
        gp5.add(addSign5, 2, 10);
        TextField secondValue4 = new TextField();
        secondValue4.setText(secondNum4String);
        secondValue4.setPrefWidth(30);
        secondValue4.setEditable(false);
        gp5.add(secondValue4, 3, 10);
        Label equalSign5 = new Label("=");
        equalSign5.setFont(new Font("Comic Sans", 20));
        gp5.add(equalSign5, 4, 10);
        Button checkBtn4 = new Button("Check");
        gp5.add(checkBtn4, 5, 12);
        GridPane.setHalignment(checkBtn4, HPos.LEFT);   
        Button clearBtn4 = new Button("Clear");
        gp5.add(clearBtn4, 5, 13);
        GridPane.setHalignment(clearBtn4, HPos.LEFT);
        TextField result4 = new TextField();
        result4.setPrefWidth(10);
        gp5.add(result4, 5, 10);

        checkBtn4.setOnAction(e1 -> {
            returnString4 = mathMethod(result4.getText(), firstNum4, secondNum4);
                
            ImageView imgView3_5 = new ImageView();
            Image image3_5 = new Image(FinalProject.class.getResourceAsStream("NormalFace.png"));
            HBox pictureRegion3_5 = new HBox();
            imgView3_5.setImage(image3_5);
            imgView3_5.setFitHeight(150);
            imgView3_5.setFitWidth(150);

            ImageView imgView4_5 = new ImageView();
            HBox pictureRegion4_5 = new HBox();
            Image image4_5 = new Image(FinalProject.class.getResourceAsStream("SadFace.png"));
            imgView4_5.setImage(image4_5);
            imgView4_5.setFitHeight(150);
            imgView4_5.setFitWidth(150);

            ImageView imgView5_5 = new ImageView();
            HBox pictureRegion5_5 = new HBox();
            Image image5_5 = new Image(FinalProject.class.getResourceAsStream("HappyFace.png"));
            imgView5_5.setImage(image5_5);
            imgView5_5.setFitHeight(150);
            imgView5_5.setFitWidth(150);

            Label returnLabel4 = new Label(returnString4);
                
            clearBtn4.setOnAction(e1_4 -> {
                pictureRegion3_5.getChildren().add(imgView3_5);
                gp5.add(pictureRegion3_5, 3, 1);
                result4.clear();
                returnLabel4.setText("");
            });

            if (returnString4.equals("\"Your answer is Correct! Awesome job!\"")) {
                pictureRegion5_5.getChildren().add(imgView5_5);
                gp5.add(pictureRegion5_5, 3, 1);
                returnLabel4.setFont(new Font("Comic Sans", 20));
                gp5.add(returnLabel4, 5, 14);
            }
            else {
                pictureRegion4_5.getChildren().add(imgView4_5);
                gp5.add(pictureRegion4_5, 3, 1);
                returnLabel4.setFont(new Font("Comic Sans", 20));
                gp5.add(returnLabel4, 5, 14);
            }
        });
    //End of scene 5

    //Button to scene 6 
        Button nextBtn4 = new Button("Next");
        gp5.add(nextBtn4, 5, 15);
        nextBtn4.setOnAction(e -> window.setScene(scene6));

    //Start of scene 6 5th math scene
        Pane root6 = new Pane();
        scene6 = new Scene(root6, 750, 500);
        Image backgroundImage6 = new Image("BackgroundImage.jpg");
        ImageView backGround6 = new ImageView(backgroundImage6);
        backGround6.setFitHeight(500);
        backGround6.setFitWidth(750);
        window.setResizable(false);
        GridPane gp6 = new GridPane();
        gp6.setPadding(new Insets(15));
        gp6.setHgap(10);
        gp6.setVgap(10);
    //putting in smily face
        ImageView imgView2_6 = new ImageView();
        Image image6 = new Image(FinalProject.class.getResourceAsStream("NormalFace.png"));
        imgView2_6.setImage(image6);
        imgView2_6.setFitHeight(150);
        imgView2_6.setFitWidth(150);
        HBox pictureRegion6 = new HBox();
        pictureRegion6.getChildren().add(imgView2_6);
        gp6.add(pictureRegion6, 3, 1);
    //Making MathBot Talk
        Label speech6 = new Label("\"Please enter in the answer for the problem below.\n" + 
        "Please clear my message before each try.\n" +
        "When you get the answer correct\n" +
        "hit the next button to go to the next problem\"");
        speech6.setFont(new Font("Comic Sans", 20));
        GridPane.setHalignment(speech6, HPos.LEFT);
        gp6.add(speech6, 5, 1);
    //Doing the math
        firstNum5 = 1 + (int) (Math.random() * 10);
        secondNum5 = 1 + (int) (Math.random() * 10);
        firstNum5String = Integer.toString(firstNum5);
        secondNum5String = Integer.toString(secondNum5);

        TextField firstValue5 = new TextField();
        firstValue5.setText(firstNum5String);
        firstValue5.setPrefWidth(30);
        firstValue5.setEditable(false);
        gp6.add(firstValue5, 1, 10);
        Label addSign6 = new Label("+");
        addSign6.setFont(new Font("Comic Sans", 20));
        gp6.add(addSign6, 2, 10);
        TextField secondValue5 = new TextField();
        secondValue5.setText(secondNum5String);
        secondValue5.setPrefWidth(30);
        secondValue5.setEditable(false);
        gp6.add(secondValue5, 3, 10);
        Label equalSign6 = new Label("=");
        equalSign6.setFont(new Font("Comic Sans", 20));
        gp6.add(equalSign6, 4, 10);
        Button checkBtn5 = new Button("Check");
        gp6.add(checkBtn5, 5, 12);
        GridPane.setHalignment(checkBtn5, HPos.LEFT);   
        Button clearBtn5 = new Button("Clear");
        gp6.add(clearBtn5, 5, 13);
        GridPane.setHalignment(clearBtn5, HPos.LEFT);
        TextField result5 = new TextField();
        result5.setPrefWidth(10);
        gp6.add(result5, 5, 10);

        checkBtn5.setOnAction(e1 -> {
            returnString5 = mathMethod(result5.getText(), firstNum5, secondNum5);
                
            ImageView imgView3_6 = new ImageView();
            Image image3_6 = new Image(FinalProject.class.getResourceAsStream("NormalFace.png"));
            HBox pictureRegion3_6 = new HBox();
            imgView3_6.setImage(image3_6);
            imgView3_6.setFitHeight(150);
            imgView3_6.setFitWidth(150);

            ImageView imgView4_6 = new ImageView();
            HBox pictureRegion4_6 = new HBox();
            Image image4_6 = new Image(FinalProject.class.getResourceAsStream("SadFace.png"));
            imgView4_6.setImage(image4_6);
            imgView4_6.setFitHeight(150);
            imgView4_6.setFitWidth(150);

            ImageView imgView5_6 = new ImageView();
            HBox pictureRegion5_6 = new HBox();
            Image image5_6 = new Image(FinalProject.class.getResourceAsStream("HappyFace.png"));
            imgView5_6.setImage(image5_6);
            imgView5_6.setFitHeight(150);
            imgView5_6.setFitWidth(150);

            Label returnLabel5 = new Label(returnString5);
            Label finishedLabel = new Label("\"Congratulations!!\n" +
            "You have completed all the problems!!!\n" +
            "Exit the program to restart.\"");
            
                
            clearBtn5.setOnAction(e1_5 -> {
                pictureRegion3_6.getChildren().add(imgView3_6);
                gp6.add(pictureRegion3_6, 3, 1);
                result5.clear();
                returnLabel5.setText("");
            });

            if (returnString5.equals("\"Your answer is Correct! Awesome job!\"")) {
                pictureRegion5_6.getChildren().add(imgView5_6);
                gp6.add(pictureRegion5_6, 3, 1);
                returnLabel5.setFont(new Font("Comic Sans", 20));
                gp6.add(returnLabel5, 5, 14);
                finishedLabel.setFont(new Font("Comic Sans", 20));
                gp6.add(finishedLabel, 5, 7);
            }
            else {
                pictureRegion4_6.getChildren().add(imgView4_6);
                gp6.add(pictureRegion4_6, 3, 1);
                returnLabel5.setFont(new Font("Comic Sans", 20));
                gp6.add(returnLabel5, 5, 14);
            }
        });
    //End of scene 6

    //Showing things
        root1.getChildren().add(backGround);
        root1.getChildren().add(gp);
        root2.getChildren().add(backGround2);
        root2.getChildren().add(gp2);
        root3.getChildren().add(backGround3);
        root3.getChildren().add(gp3);
        root4.getChildren().add(backGround4);
        root4.getChildren().add(gp4);
        root5.getChildren().add(backGround5);
        root5.getChildren().add(gp5);
        root6.getChildren().add(backGround6);
        root6.getChildren().add(gp6);
        window.setScene(scene1);
        window.show();
    }

    public static String mathMethod(String input, int RNG1, int RNG2) {
        int theAnswer;
        String theAnswerString;
        String answerReturnCorrect = "\"Your answer is Correct! Awesome job!\"";
        String answerReturnWrong = "\"Your answer is Incorrect... Please try again.\"";
        theAnswer = RNG1 + RNG2;
        theAnswerString = Integer.toString(theAnswer);

        if (theAnswerString.equals(input)) {
            return answerReturnCorrect;
        }
        else {
            return answerReturnWrong;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}