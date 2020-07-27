import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Flag extends Actor
{
    private static boolean getClicked = false;
    public void act() 
    {      
        Actor Flag = new Flag();        
        Greenfoot  a = new Greenfoot(); 
        if(a.mouseClicked(this)&&!getClicked){
            getClicked = true;
        }
        else if(a.mouseClicked(this)&&getClicked){
            getClicked = false;
        }             
    } 
    public static boolean getClicked(){
        return getClicked;
    }
}
