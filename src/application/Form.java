package application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class Form {
	Rectangle a;
	Rectangle b;	
	Rectangle c;
	Rectangle d;	
	Color color;
	private String name;
	public int form = 1;
	
	public Form(Rectangle a,Rectangle b,Rectangle c,Rectangle d) {
		this.a  = a;
		this.b  = b;
		this.c  = c;
		this.d  = d;
	}
	
	public Form(Rectangle a,Rectangle b,Rectangle c,Rectangle d , String name) {
		this.a  = a;
		this.b  = b;
		this.c  = c;
		this.d  = d;
		this.name = name;
	
	
	if(name.equals("j")) {
		color = Color.SLATEGRAY;
	}else if(name.equals("l")) {
		color = Color.DARKGOLDENROD;
	}else if(name.equals("o")) {
		color = Color.INDIANRED;
	}else if(name.equals("s")) {
		color = Color.FORESTGREEN;
	}else if(name.equals("t")) {
		color = Color.CADETBLUE;
	}else if(name.equals("z")) {
		color = Color.HOTPINK;
	}else if(name.equals("i")) {
		color = Color.SANDYBROWN;
	}
	
	
	this.a.setFill(color);
	this.b.setFill(color);
	this.c.setFill(color);
	this.d.setFill(color);
	}
	
	
	public String getName() {
		return name;
	}
	
	public void changeForm() {
		
		if (form != 4) {
			form ++;
		} else {
			form =1;
		}
		
		
		
	}
	
}
