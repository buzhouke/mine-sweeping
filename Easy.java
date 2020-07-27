import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class Easy extends Button
{
    public static boolean getIt = false;
    public void act() 
    {      
        if(MyWorld.hard.getisStarted()||MyWorld.medium.getisStarted()){
           getWorld().removeObject(this);             
        }
        Greenfoot  easy = new Greenfoot();                     
         if(easy.mouseClicked(this)){
             System.out.println(random_count);
             random();
             isStarted = true;
             getIt = true;
             getWorld().removeObject(this);
            }
    } 
   public Easy(boolean isStarted,int random_count){
      super(isStarted,random_count);
    }   
}
