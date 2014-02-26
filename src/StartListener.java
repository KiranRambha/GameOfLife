import java.awt.event.*;
import javax.swing.Timer;

public class StartListener implements ActionListener
{
    LifeFrame lifeframe;
    LifeGrid lifegrid;
    Timer timer;
    
    private int delay=100;
   
    StartListener(LifeFrame lifeframe, LifeGrid lifegrid)
    {
        this.lifeframe=lifeframe;
        this.lifegrid=lifegrid;
        timer = new Timer(delay, this);
    }
     
    public void actionPerformed(ActionEvent e)
    {
        if(!(e.getSource().equals(TestLifeGrid.stop)))
        {
        	lifegrid.run();
        	TestLifeGrid.label.setText("Generation : " + lifegrid.getcugen());
        	lifeframe.repaint();
        	timer.start();
        }
        if(e.getSource().equals(TestLifeGrid.stop))
        {
        	timer.stop();
        } 
     } 
}  

