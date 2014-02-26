import java.awt.Color; 
import java.awt.Graphics;  
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.FileNotFoundException;
import javax.swing.*;

/** PAINTING **/
public class LifeComponent extends JComponent implements ActionListener 
{
	private static final long serialVersionUID = 1L;
	int squareSize; 
    LifeGrid lifegrid;
    
    LifeComponent(int squareSize, LifeGrid lifegrid) throws FileNotFoundException 
    { 
        this.squareSize=squareSize; 
        this.lifegrid=lifegrid; 
    } 
    protected void paintComponent(Graphics g) 
    { 
    	setBackground(Color.BLACK);
        super.paintComponent(g);
       
        for(int x=0; x<lifegrid.getWidth(); x++) 
        { 
        	for(int y=0; y<lifegrid.getHeight(); y++) 
        	{ 
        		if(lifegrid.instant[y][x] == 1) 
        		{ 
        			g.setColor(Color.GREEN); 
        			g.fillRect(x*squareSize,y*squareSize, squareSize, squareSize); 
        		} 
        	} 
	
        } 
    }
    public void actionPerformed(ActionEvent arg0) { }
}  