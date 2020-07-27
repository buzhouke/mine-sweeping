import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Hard extends Button
{
    public static boolean getIt = false;
    public void act() 
    {
        if(MyWorld.easy.getisStarted()||MyWorld.medium.getisStarted()){
           getWorld().removeObject(this); 
           
        }
         Greenfoot  easy1 = new Greenfoot();                     
         if(easy1.mouseClicked(this)){
             isStarted = true;
             getIt = true;
             random();
             getWorld().removeObject(this);
     }
    } 
    public Hard(){
    }
    public Hard(boolean isStarted,int random_count){       
        super(isStarted,random_count);
    }    
}
