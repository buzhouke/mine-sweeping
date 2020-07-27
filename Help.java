import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Help extends Actor
{
    /**
     * Act - do whatever the Help wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static boolean isClicked = false;
    public void act() 
    {
        // Add your action code here.
        Greenfoot  a = new Greenfoot(); 
        if(a.mouseClicked(this)&&!isClicked){
            isClicked = true;
            rule();
        }
        else if(a.mouseClicked(this)&&isClicked){
            isClicked = false;
            clear();
        }
    }
    Help(){
        
    }
    public void rule(){
        //Greenfoot  c = new Greenfoot(); 
        getWorld().showText("YOU NEED TO CLICK ALL THE BLOCK WITHOUT MINE",350,200);
        getWorld().showText("YOU CAN CLICK THE FLAG IN THE LOWER RIGHT CORNER ",350,250);
        getWorld().showText("TO SWICTH TO FALG PLACEMENT",350,300);
        getWorld().showText("Basic rule",400,330);
        getWorld().showText("Use the left mouse button to randomly click a square, ",400,350);
        getWorld().showText("the square is opened and displayed the number in the square",400,375);
        getWorld().showText("The Numbers in the grid indicate how many minds hidden in the 8 surrounding squares",400,400);
        }
    public void clear(){
        getWorld().showText(null,350,200);
        getWorld().showText(null,350,250);
        getWorld().showText(null,350,300); 
        getWorld().showText(null,400,330);
        getWorld().showText(null,400,350);
        getWorld().showText(null,400,375); 
        getWorld().showText(null,400,400);
    }
}
