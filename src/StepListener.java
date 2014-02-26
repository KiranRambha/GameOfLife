import java.awt.event.*;

public class StepListener implements ActionListener
{
    LifeFrame lifeframe;
    LifeGrid lifegrid;
    
    StepListener(LifeFrame lifeframe,LifeGrid lifegrid)
    {
        this.lifeframe=lifeframe;
        this.lifegrid=lifegrid;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        lifegrid.run();
        TestLifeGrid.label.setText("Generation : "+ lifegrid.getcugen());
        lifeframe.repaint();
    }
}
