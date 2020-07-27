import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public static Thunder[][] MyBlock = new Thunder[30][20];
    public static Easy easy = new Easy(false,50);
    public static Medium medium = new Medium(false,100);
    public static Hard hard = new Hard(false,150);
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 550, 1); 
        setBackground("Background.png");
        //System.out.println("win!!");
        long start = System.currentTimeMillis();
        for(int i = 0;i < 30;i++){
            for(int j = 0;j < 20;j++){
                Thunder a = new Thunder(i,j,false);
                addObject(a,i*25+38,j*25+38);
                MyBlock[i][j] = a;                
            }
        }                
        addObject(easy,200,230);       
        addObject(medium,400,230);        
        addObject(hard,600,230);
        addObject(new Flag(),15,535);
        addObject(new Help(),785,535);     
        easy.isStarted = false;
        hard.isStarted = false;
        medium.isStarted = false;
        easy.getIt = false;
        medium.getIt = false;
        hard.getIt = false;  
    }        
    static Thunder[][] getClicked() {
        return MyBlock;
    }
}
