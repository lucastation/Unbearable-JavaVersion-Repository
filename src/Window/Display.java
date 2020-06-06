package Window;

import javax.swing.JFrame;

public class Display {

	private JFrame frame;
	
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
		
		
	}
}
