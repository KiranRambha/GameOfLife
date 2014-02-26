import java.io.*;
import java.util.*;

public class LifeGrid
{
    public int[][] instant;
    
    private int cugen;
    
    //constructor
    public LifeGrid(int x,int y,String filename)throws FileNotFoundException
    {
        instant = new int[x][y];
        cugen=0;
        File myfile = new File(filename);
        Scanner scanner = new Scanner(myfile);
  
        for(x=0;scanner.hasNextLine()&&(x<getHeight());x++)
        {
        	String line = scanner.nextLine();
        	for(y=0;y<line.length()&&(y<getWidth());y++)
	        {
        		instant[x][y]=(line.charAt(y)=='*') ?1 :0 ;
		
	        }
        }
        scanner.close();
      }
      
      public LifeGrid(int x, int y)throws FileNotFoundException
      {
        instant = new int[x][y];
        cugen=0;
        Random generator = new Random();
        for(x=0;x<getHeight();x++)
        {
        	for(y=0;y<getWidth();y++)
        	{
        		instant[x][y]=generator.nextInt(2);
        	}
        }
      }
    //methods
    
    public void show()
    {
    
        for(int x=0;x<getHeight();x++)
        {
        	for(int y=0;y<getWidth();y++)
	        {
	            int cell=instant[x][y];
	            System.out.print((cell==1) ?"*" :"-");
	        }
        	System.out.println("\n");
        }
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("the current generation is" + getcugen());
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }
    
   /*getters*/
     public int getHeight()
     {
        return instant.length;
     }
     public int getWidth()
     {
        return instant[0].length;
     }
     public int getcugen()
     {
        return cugen;
     }
     public int getContent(int x,int y)
     {
        return instant[x][y];
     }
   /*methods*/ 
     public int neighbours(int x, int y)
     {
        int neighbours=0;
        
        //checking side neighbours in the edges
        if(x==0 && y==0 && instant[x][y+1]==1) //this is for left top corner to count right
        {
        	neighbours++;
        }
        if(x==0 && y==0 && instant[x+1][y]==1) //this is for left top corner to count down
        {
        	neighbours++;
        }
        if(x==0 && y!=0 && y<getWidth()-1 && instant[x][y-1]==1) //this is for top edge center to count left 
        {
        	neighbours++;
        }
        if(x==0 && y!=0 && y<getWidth()-1 && instant[x][y+1]==1) //this is for top edge center to count right
        {
        	neighbours++;
        }
        if(x==0 && y!=0 && y<getWidth()-1 && instant[x+1][y]==1) //this is for top edge center to count down
        {
        	neighbours++;
        }
        if(x==0 && y==getWidth()-1 && instant[x][y-1]==1) //this is for top right corner to count left
        {
        	neighbours++;
        }
        if(x==0 && y==getWidth()-1 && instant[x+1][y]==1) //this is for top right corner to count down
        {
        	neighbours++;
        }
        if(x==0 && y==0 && instant[x+1][y+1]==1) //this is for top left corner to count diagonal
        {
        	neighbours++;
        }
        if(x==0  && y!=0 && y==getWidth()-1 && instant[x+1][y-1]==1) //this is for top right corner to count diagonal
        {
        	neighbours++;
        }
        if(x==0 && y!=0 && y<getWidth()-1  && instant[x+1][y-1]==1) //this is for top edge diagonals
        {
        	neighbours++;
        }
        if(x==0 && y<getWidth()-1 && instant[x+1][y+1]==1) //this is for top edge diagonals
        {
        	neighbours++;
        }
        if(x<getHeight()-1 && x!=0 && y==0 && instant[x][y+1]==1) //this is for left edge to count right
        {
        	neighbours++;
        }
        if(x<getHeight()-1 && x!=0 && y==0 && instant[x-1][y]==1) //this is for left edge to count up
        {
        	neighbours++;
        }
        if(x<getHeight()-1 && x!=0 && y==0 && instant[x+1][y]==1) //this is for left edge to count down
        {
        	neighbours++;
        }
        if(x<getHeight()-1 && x!=0 && y==0 && instant[x-1][y+1]==1) //this is for left edge to count diagonal
        {
        	neighbours++;
        }
        if(x<getHeight()-1 && x!=0 && y==0 && instant[x+1][y+1]==1) //this is for left edge to count diagonal
        {
        	neighbours++;
        }
        if(x<getHeight()-1 && x!=0 && y==getWidth()-1 && instant[x][y-1]==1) //this is for right edge to count left
        {
        	neighbours++;
        }
        if(x<getHeight()-1 && x!=0 && y==getWidth()-1 && instant[x+1][y]==1) //this is for right edge to count down
        {
        	neighbours++;
        }
        if(x<getHeight()-1 && x!=0 && y==getWidth()-1 && instant[x-1][y]==1) //this is for right edge to count up
        {
        	neighbours++;
        }
        if(x<getHeight()-1 && x!=0 && y==getWidth()-1 && instant[x-1][y-1]==1) //this is for right edge to count diagonals
        {
        	neighbours++;
        }
        if(x<getHeight()-1 && x!=0 && y==getWidth()-1 && instant[x+1][y-1]==1) //this is for right edge to count diagonals
        {
        	neighbours++;
        }
        if(x==getHeight()-1 && y==0 && instant[x][y+1]==1) //from this it is for bottom two corners
        {
        	neighbours++;
        }
        if(x==getHeight()-1 && y==0 && instant[x-1][y]==1)
        {
        	neighbours++;
        }
        if(x==getHeight()-1 && y==0 && instant[x-1][y+1]==1)
        {
        	neighbours++;
        }
        if(x==getHeight()-1 && y==getWidth()-1 && instant[x][y-1]==1)
        {
        	neighbours++;
        }
        if(x==getHeight()-1 && y==getWidth()-1 && instant[x-1][y]==1)
        {
        	neighbours++;
        }
        if(x==getHeight()-1 && y==getWidth()-1 && instant[x-1][y-1]==1)
        {
        	neighbours++;
        }
        if(x==getHeight()-1 && y!=0 && y<getWidth()-1 && instant[x][y+1]==1) // tis is for bottom edge
        {
        	neighbours++;
        }
        if(x==getHeight()-1 && y!=0 && y<getWidth()-1 && instant[x][y-1]==1)
        {
        	neighbours++;
        }
        if(x==getHeight()-1 && y!=0 && y<getWidth()-1 && instant[x-1][y+1]==1)
        {
        	neighbours++;
        }
        if(x==getHeight()-1 && y!=0 && y<getWidth()-1 && instant[x-1][y-1]==1)
        {
        	neighbours++;
        }
        if(x==getHeight()-1 && y!=0 && y<getWidth()-1 && instant[x-1][y]==1)
        {
        	neighbours++;
        }
        if(x>0 && x<getHeight()-1 && y>0 && y<getWidth()-1 && instant[x][y+1]==1)
        {
        	neighbours++;
        }
        if(x>0 && x<getHeight()-1 && y>0 && y<getWidth()-1 && instant[x][y-1]==1)
        {
        	neighbours++;
        }
        if(x>0 && x<getHeight()-1 && y>0 && y<getWidth()-1 && instant[x+1][y+1]==1)
        {
        	neighbours++;
        }
        if(x>0 && x<getHeight()-1 && y>0 && y<getWidth()-1 && instant[x+1][y-1]==1)
        {
        	neighbours++;
        }
        if(x>0 && x<getHeight()-1 && y>0 && y<getWidth()-1 && instant[x-1][y+1]==1)
        {
        	neighbours++;
        }
        if(x>0 && x<getHeight()-1 && y>0 && y<getWidth()-1 && instant[x-1][y-1]==1)
        {
        	neighbours++;
        }
        if(x>0 && x<getHeight()-1 && y>0 && y<getWidth()-1 && instant[x-1][y]==1)
        {
        	neighbours++;
        }
        if(x>0 && x<getHeight()-1 && y>0 && y<getWidth()-1 && instant[x+1][y]==1)
        {
        	neighbours++;
        }
        
        return neighbours; 
    }
   public void run()
   {
        int[][] oldgrid = instant;
        int[][] newgrid = new int[getHeight()][getWidth()];
        for(int x=0;x<getHeight();x++)
        {
        	for(int y=0;y<getWidth();y++)
        	{
        		boolean checking = (oldgrid[x][y]==1);
        		int neighbours = neighbours(x,y);
        		if(checking && neighbours==2 || neighbours==3)
        		{
        			newgrid[x][y]=1;
	        
        		}
        		else if(checking && neighbours<2)
			    {
			        newgrid[x][y]=0;
			       
			    }
        		else if(checking && neighbours>3)
        		{
        			newgrid[x][y]=0;
	       
        		}
        		else if(checking!=true && neighbours==3) 
        		{
        			newgrid[x][y]=1;
	       
        		}
        		else
        		{
        			newgrid[x][y]=0;
	       
        		}
        	} 
        }   
        instant=newgrid;
        cugen++;
        show();
    }
}