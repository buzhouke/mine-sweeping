import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Medium extends Button
{
    public static boolean getIt = false;
    public void act() 
    {
        if(MyWorld.easy.getisStarted()||MyWorld.hard.getisStarted()){
           getWorld().removeObject(this);  
           
        }
         Greenfoot  easy2 = new Greenfoot();                     
         if(easy2.mouseClicked(this)){
             random();
             isStarted = true;
             getIt = true;
             getWorld().removeObject(this);
            }
    }   
    public Medium(){
    }
    public Medium(boolean isStarted,int random_count){
     super(isStarted,random_count);
    }    
}
