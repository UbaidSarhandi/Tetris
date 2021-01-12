package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.TargetDataLine;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import sun.audio.AudioPlayer;

public class ConnectionFile {
	static String hiscore = "Score.txt";
	public static String[][] data = new String[10][2];
	private static Scanner f;
	static int linecount = 0;
	 int bull = 0, sheep = 0;
	String finalscore ;

	public  Connection getConnection() throws Exception {
		 

		Connection c = null;
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			c= DriverManager.getConnection("jdbc:sqlite:Scores.db");
			System.out.println("SQLite Db is connected");
		} catch(Exception e){
			System.out.println(e);
			
		}
		
		
		return c;
		 
	}
	
	
	 
	public void saveScore( String playerName, int score) throws Exception {

		
		try {
			
			Connection c = getConnection();
			PreparedStatement post = c.prepareStatement("INSERT INTO PlayerScore (playerName,playerScore) VALUES ('"+playerName+"' ,'"+score+"')");
			post.executeUpdate();
			c.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public String getHighscore()  {
		try {
			Connection c = getConnection();
			
			PreparedStatement post = c.prepareStatement("SELECT * FROM PlayerScore WHERE playerScore=(SELECT max(playerScore)FROM PlayerScore)");
			ResultSet result = post.executeQuery() ;
			
				ArrayList<String> list = new ArrayList<String>();
				
				list.add(result.getString("playerName"));
				list.add(result.getString("playerScore"));
				finalscore = list.get(0) + " " + list.get(1);
			c.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return finalscore;
	}
	
	
	
	public void createTables() {
		try {
			Connection c = getConnection();
			PreparedStatement post = c.prepareStatement("CREATE TABLE IF NOT EXISTS PlayerScore (\n"+
					"	playerName TEXT,\n" + 
					"	playerScore	INTEGER)" 
					);
			post.executeUpdate();
			
			c.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	



}
	
	
