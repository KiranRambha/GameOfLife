import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class TestLifeGrid
{ 
    static JButton start = new JButton("Start");
    static JButton stop = new JButton("Stop");
    static JLabel label = new JLabel("Generation : 0");
    static JButton step = new JButton("Step");
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException, FileNotFoundException
    {
        int x,y;
        int squaresize = 15;
       
        System.out.println("enter the row length");
        x=scanner.nextInt();
        System.out.println("enter the coloumn length");
        y=scanner.nextInt();
        
        LifeGrid lifegrid = new LifeGrid(x,y);
        
        System.out.println("do you want to randomise the grid : Y/N");
        String r1 =scanner.next();
        if(r1 == "N" || r1 == "n")
        {
        	lifegrid = new LifeGrid(x,y,"kiran.txt");
        }
        else if(r1 == "Y" || r1 == "y")
        {
        	lifegrid = new LifeGrid(x,y);
        }
        
        LifeFrame lifeframe = new LifeFrame();
        Container container = new Container();
        LifeComponent lifeComponent = new LifeComponent(squaresize, lifegrid);
        lifeframe.setSize(600,600);
        
        StartListener StopListener = new StartListener(lifeframe,lifegrid);
      
        start.addActionListener(StopListener);
        stop.addActionListener(StopListener);
        step.addActionListener(new StepListener(lifeframe,lifegrid));
      
        container.setLayout(new GridLayout(2,4));
        container.add(start);
        container.add(step);
        container.add(stop);
        container.add(label);
        
        lifeframe.add(lifeComponent);
        lifeframe.getContentPane().setBackground(Color.GRAY);
        lifegrid.show();
        lifeframe.add(container,BorderLayout.SOUTH);

       } 

}
