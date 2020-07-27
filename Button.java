import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class Button extends Actor
{
    public boolean isStarted;
    public boolean[][] array = new boolean[30][20];
    public int random_count;
    public void act() 
    {
    } 
    public void random(){
       Random r = new Random();
       for(int i = 0; i < random_count; i++){
        int b1 = r.nextInt(30);
        int b2 = r.nextInt(20);
        array[b1][b2] = true;        
    }
}
    public Button(){
    }
    public Button(boolean isStarted,int random_count){
        this.isStarted = isStarted;
        this.random_count = random_count;
    }
    boolean[][] getArray() {
        return array;
    }
    public  boolean getisStarted(){
        return isStarted;
    }  
     public  int getrandom_count(){
        return random_count;
    }  
}
