package application;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TitleScreen extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage prime) throws Exception {
		// TODO Auto-generated method stub
		VBox pane= new VBox(20);
		
		Button play= new Button("Play");
		play.getStyleClass().add("play");
		Button ins= new Button("Instructions");
		ins.getStyleClass().add("ins");
		Button quit= new Button("Quit");
		quit.getStyleClass().add("score");//this score is a name for the css file. dont change it.
		quit.setPrefWidth(120);
		ins.setPrefWidth(120);
		play.setPrefWidth(120);
		ConnectionFile cf = new ConnectionFile();
		String bScore= cf.readFile(); //add score here
		Label score= new Label("Best Score:" + " "+ bScore);
		score.getStyleClass().add("welcome");
		score.setPadding(new Insets(30,10,10,10));
		//set actions here
		
		play.setOnAction(e->{
			Tetrix k = new Tetrix();
			try {
				k.start(prime);
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
		});
		
		ins.setOnAction(e-> {
			instructions inst= new instructions();
			try {
				inst.start(prime);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		
		quit.setOnAction(e->{
			System.exit(0);
		});
		
		VBox paneH= new VBox(20); 
		paneH.setAlignment(Pos.CENTER);
		paneH.getChildren().addAll(play,ins,quit);
		pane.getStyleClass().add("pane");
		
		Label cred= new Label("Created by Hasnain Ali, Pir UbaidUllah Jan Sarhandi, Areeba Azam.");		
		cred.getStyleClass().add("cred");
		cred.setPadding(new Insets(20));
		
		Image img= new Image("file:///F:/Tetrix/tetris.jpg");
		ImageView vImg= new ImageView(img);
		vImg.setFitHeight(200);
		vImg.setFitWidth(400);
		Label logo= new Label("",vImg);
		logo.setAlignment(Pos.CENTER);
		
		VBox boxS= new VBox();
		boxS.getChildren().addAll(logo,paneH,score);
		boxS.setVgrow(boxS, Priority.ALWAYS);
		boxS.setAlignment(Pos.CENTER);
		VBox root= new VBox();
		root.getChildren().addAll(boxS,pane);
		root.getStyleClass().add("root");
		root.getStylesheets().add("design.css");
		pane.getChildren().add(cred);
		
		Scene scene= new Scene(root,500,500);
		prime.setTitle("T E T R I S");
		prime.setScene(scene);
		prime.show();
	}

}