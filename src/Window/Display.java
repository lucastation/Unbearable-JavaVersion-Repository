package Window;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	
	public Display(String title,int width,int height) { //contructor Display
		this.title=title;
		this.width=width;
		this.height=height;
		
		
		createDisplay();
	}
	
	private void createDisplay() { // Cream Display-ul
		
		frame=new JFrame(title); //titlu 
		frame.setSize(width,height); //dimensiune 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X on close
		frame.setResizable(false); //redimensionare 
		frame.setLocationRelativeTo(null); //centrare in mijloc
		frame.setVisible(true); //vizibilitate
		
		createCanvas();
		
	}
	
	private void createCanvas() { //Cream Canvas
		
		canvas=new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		
		frame.add(canvas); // adaugam canvas la frame
		frame.pack(); // redimensioneaza sa vedem tot canvas-ul
	}
}
