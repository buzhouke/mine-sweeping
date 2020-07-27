import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class Thunder extends Actor
{
    private int x ;
    private int y ;
    private boolean isClicked;
    private int countBlock;   
    private boolean[][] array;
    private boolean started = false;
    private Thunder[][] block = MyWorld.MyBlock;
    private long startTime;
    public void act() 
    {
         Greenfoot  a = new Greenfoot();   
         if(Easy.getIt){            
             countBlock = MyWorld.easy.getrandom_count(); 
             array = MyWorld.easy.getArray();
             started = true;            
             getWorld().showText("easy level",200,15);
             startTime = System.currentTimeMillis(); 
        }
         else if(Medium.getIt){
             array = MyWorld.medium.getArray();
             countBlock = MyWorld.medium.getrandom_count();            
              started = true;            
              getWorld().showText("medium level",200,15);
             startTime = System.currentTimeMillis(); 
            }
         else if(Hard.getIt){
               array =MyWorld.hard.getArray(); 
               countBlock = MyWorld.hard.getrandom_count();             
                started = true;             
                getWorld().showText("hard level",200,15);
                startTime = System.currentTimeMillis(); 
            }
            if(a.mouseClicked(this)&&Flag.getClicked()){
                setImage("BlockFlagged.png");
            }
         if(a.mouseClicked(this)&&!isClicked&&started&&!Flag.getClicked()){
             isClicked = true;           
             if(success()){
                GreenfootSound success = new GreenfootSound("win.wav");
                success.play();               
                long endTime = System.currentTimeMillis(); 
                //程序结束记录时间 
                long TotalTime = endTime - startTime; 
                //总消耗时间
                System.out.println(TotalTime);
                String b = "you success in ";
                b+= String.valueOf(TotalTime);
                b+="s";
                getWorld().showText(b,350,250);           
            }
             if(array[x][y] == true){
               
                setImage("Bomb.png");
                GreenfootSound fail = new GreenfootSound("bomb.wav");
                for(int i = 0;i < 30;i++){
            for(int j = 0;j < 20;j++){
                if(array[i][j])
                    block[i][j].setImage("Bomb.png");                  
            }
        }
                fail.play();
                a.stop();              
            }
            else{                
             switch(count(x,y)){
             case 0:
             search(x,y);
             setImage("BlockClicked[0].png");
             break;
             case 1:
             setImage("BlockClicked[1].png");
             break;
             case 2:
             setImage("BlockClicked[2].png");
             break;
             case 3:
             setImage("BlockClicked[3].png");
             break;
             case 4:
             setImage("BlockClicked[4].png");
             break;
             case 5:
             setImage("BlockClicked[5].png");
             break;
             case 6:
             setImage("BlockClicked[6].png");
             break;
             case 7:
             setImage("BlockClicked[7].png");
             break;
             case 8:
             setImage("BlockClicked[8].png");
             break;
            }
            }           
        }
    } 
    public boolean success(){       
        int num = 600-countBlock;
        int t = 0;
        for(int i = 0;i < 30;i++){
            for(int j = 0;j < 20;j++){
                if(block[i][j].getisClicked())
                  t++;  
            }
        }
        if(t == 1&&array[x][y] == true){ //确保第一个点到的不是雷
            array[x][y]= false;
            if(!array[x+1][y])
                array[x+1][y]= true;
        }
        if(t == num)
        return true;
        else{
            int num1 = num-t;
            String a = String.valueOf(num1);
            a+="blocks needed to clicked";
            getWorld().showText(a,500,15);
            return false;
    }
    }       
    public Thunder(int i ,int j,boolean isClicked){
        setImage("Block.png");
        x = i;
        y = j;
        this.isClicked = isClicked;
    }
    public void hint(int x,int y){
        block[x][y].isClicked = true;
        switch(count(x,y)){ 
             case 0: 
             search(x,y);
             
             block[x][y].setImage("BlockClicked[0].png");
             break;
             case 1:
             block[x][y].setImage("BlockClicked[1].png");
             break;
             case 2:
              block[x][y].setImage("BlockClicked[2].png");
             break;
             case 3:
              block[x][y].setImage("BlockClicked[3].png");
             break;
             case 4:
             block[x][y].setImage("BlockClicked[4].png");
             break;
             case 5:
              block[x][y].setImage("BlockClicked[5].png");
             break;
             case 6:
              block[x][y].setImage("BlockClicked[6].png");
             break;
             case 7:
              block[x][y].setImage("BlockClicked[7].png");
             break;
             case 8:
              block[x][y].setImage("BlockClicked[8].png");
             break;
            }
    }
    public int count(int x,int y){
        int count = 0;
    
        if(bound(x-1,y-1)){
            if(array[x-1][y-1])
                count++;          
        }
         if(bound(x,y-1)){
            if(array[x][y-1])
                count++;          
        }
         if(bound(x+1,y-1)){
             if(array[x+1][y-1])
                count++;          
        }
         if(bound(x+1,y)){
             if(array[x+1][y])
                count++;          
        } if(bound(x+1,y+1)){
             if(array[x+1][y+1])
                count++;          
        }
         if(bound(x-1,y)){
            if(array[x-1][y])
                count++;          
        }
        if(bound(x-1,y+1)){
            if(array[x-1][y+1])
                count++;          
        }
         if(bound(x,y+1)){
            if(array[x][y+1])
                count++;          
        }
        //System.out.println("count"+count);
        return count;
    }
    public boolean bound(int test1,int test2){
        boolean checked1 = false;
        boolean checked2 = false;
        if(test1>=0&&test1<30)
            checked1 = true;
        if(test2>=0&&test2<20)
            checked2 = true;
        return checked1&&checked2;
    }
    public boolean getisClicked(){
        return isClicked;
    }
    public void search(int x,int y){
        
        if(bound(x-1,y-1)){
            if(!array[x-1][y-1]){
                if(!block[x-1][y-1].getisClicked())
                   hint(x-1,y-1); 
            }
        }
         if(bound(x,y-1)){
            if(!array[x][y-1])
                if(!block[x][y-1].getisClicked())
                  hint(x,y-1);  
        }
         if(bound(x+1,y-1)){
             if(!array[x+1][y-1])
              if(!block[x+1][y-1].getisClicked())
                   hint(x+1,y-1);        
        }
         if(bound(x+1,y)){
             if(!array[x+1][y])
              if(!block[x+1][y].getisClicked())
                   hint(x+1,y);   
        } 
        if(bound(x+1,y+1)){
             if(!array[x+1][y+1])
              if(!block[x+1][y+1].getisClicked())
                   hint(x+1,y+1);   
        }
         if(bound(x-1,y)){
            if(!array[x-1][y])
             if(!block[x-1][y].getisClicked())
                   hint(x-1,y);
        }
        if(bound(x-1,y+1)){
            if(!array[x-1][y+1])
              if(!block[x-1][y+1].getisClicked())
                    hint(x-1,y+1);         
        }
         if(bound(x,y+1)){
            if(!array[x][y+1])
             if(!block[x][y+1].getisClicked())
                    hint(x,y+1);           
        }
    }
}
