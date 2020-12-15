package application;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class instructions extends Application{

	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage prime) throws Exception {
		// TODO Auto-generated method stub
		
		VBox v= new VBox(40);
		
		Label welcome= new Label("Welcome to Tetris!");
		Label goal= new Label("The goal of Tetris is to fit falling shapes into a single line without any spaces. "
				+ "\n When a solid line is created, the line is removed and players score points. "
				+ "\n As the game goes on, the shapes fall faster and faster and if the shapes stack \n up to the top of the screen, the game is over.");
		Label insHead= new Label("Instruction: ");
		
		Label ins= new Label("1. Use directional keys to move the blocks. \n\n"
							+"2. Make lines one by one as you progress through the game. \n\n" 
							+"3. Don't let the lines reach up at the top. \n\n"
							+"4. Your score will increase with each block. \n\n"
							+"5. Press the *esc* key to return to the menu screen. \n\n"
							+"6. Enjoy the game and don't forget to give us full marks!");
		
		Button back= new Button("Back to Title Screen");
		back.getStyleClass().add("back");
		///set action here
		back.setOnAction(e->{
			prime.hide();
			TitleScreen title=new TitleScreen();
			Stage stg= new Stage();
			try {
				title.start(stg);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		v.setAlignment(Pos.CENTER);
		welcome.getStyleClass().add("welcome");
		goal.getStyleClass().add("welcome");
		insHead.getStyleClass().add("welcome");
		ins.getStyleClass().add("welcome");
		v.getChildren().addAll(welcome, goal, insHead, ins,back);
		v.getStyleClass().add("vbox");
		v.getStylesheets().add("design.css");
		
		Scene scene= new Scene(v,700,700);
		prime.setTitle("Instructions");
		prime.setScene(scene);
		prime.show();
	}

}
