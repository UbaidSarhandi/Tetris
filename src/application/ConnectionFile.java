package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
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
	static int bull = 0, sheep = 0 , finalscore = 0;

	public void writetofile(String string) throws IOException
	{
		FileWriter f= new FileWriter("Score.txt",true);
		f.write(string);
		f.write("\n");
		f.close();
		
	}
	
	
	 public static void playSound()  { 
			
		 File filestring= new File("C:\\Users\\lenovo\\Downloads\\Linemp3.mp3");
		 Media media= new Media(filestring.toURI().toString());
		 MediaPlayer mPlayer= new MediaPlayer(media);
		 mPlayer.setOnReady(new Runnable() {
			public void run() {
	            mPlayer.play();
			}
			 
		 });
		
	  }
	 
	
	public static String readFile() throws IOException {
		
		FileReader fr = new FileReader(hiscore);
		BufferedReader br = new BufferedReader(fr);
		String line=null;
		String records = null;
		
		
		
		while((line = br.readLine())!=null)
		{
			
			f= new Scanner(line);
			while (f.hasNext()) {		
				for (int i = 0; i <= 2 ; i++) {
					if (i == 1) {
						f.next();
						records	= f.next();
						 bull = Integer.parseInt(records);
						 sheep = Highscore(bull);
					}
				
					
				}
				
			}
		}
		
		records = Integer.toString(sheep);
	
		
		records = freturn(records);
		return records;
		
	}
	
	
	public static String freturn(String k ) throws IOException {
		String line;
		FileReader fr = new FileReader(hiscore);
		BufferedReader br = new BufferedReader(fr);
		
		while((line = br.readLine())!= null) {
			
			if (line.contains(k)) {
				k = line;
			}
		}
		return k;
	}
	
	
	public static int Highscore(int score) {
		if (score > finalscore) {
			finalscore = score;
		}
		
		return finalscore;

		
	}
	
	

	public static void main(String[] args) throws IOException {
		playSound();
		readFile();
	
	
	}}
