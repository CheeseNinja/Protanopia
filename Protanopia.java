import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//First intesection- The circle has to match the corresponding color of the square
//Second intersection- The circle has to go against the corresponding color of the square
//More negative, circle is winning, more positive, square is winning
public class Protanopia extends JFrame{
  int x, y, recX, recY, colorCode, upCode;
  private Image dbImage;
  private Graphics dbg;
  boolean shoot;
  Font font = new Font("Arial",Font.BOLD |Font.ITALIC, 30);
  Font font1 = new Font("Arial",Font.BOLD,20);
  boolean gameStatus = true;
  int happiness = 0;
  Color purple = new Color(108,1,133);
  Color darkblue = new Color(0,62,135);
  Color brown = new Color(139,87,58);
  int colorCode2;

  
  public class AL extends KeyAdapter{
    
    public void keyPressed(KeyEvent e){
      int keyCode = e.getKeyCode();
      if (keyCode == e.VK_DOWN){ //Green
        colorCode = 1;
      }
      else if(keyCode == e.VK_LEFT){ //Cyan
        colorCode = 2;
      }
      else if(keyCode == e.VK_RIGHT){ //Purple
        colorCode = 3;
      }
      else if(keyCode ==e.VK_A){ //Blue
        colorCode2 = 4;}
      else if(keyCode ==e.VK_S){ //Yellow
        colorCode2 = 5;}
      else if(keyCode ==e.VK_D){ //White
        colorCode2 = 6;}
      }
    }
  
    public void keyReleased(KeyEvent e){
    }
    
  
  public Protanopia(){
    addKeyListener(new AL());
    setTitle("Protanopia");
    setSize(700,500);
    setResizable(true);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBackground(Color.darkGray);
    
    x = 350;
    y = 415;
    recX = 400;
    recY = 400;
    
  }
  
  public void paint(Graphics g){
    dbImage = createImage(getWidth(),getHeight());
    dbg = dbImage.getGraphics();
    paintComponent(dbg);
    g.drawImage(dbImage,0,0,this);
  }

  
  public void paintComponent(Graphics g){
    g.setColor(brown);
    g.fillRect(363,0,800,800);
    //TITLE
    g.setFont(font);
    g.setColor(Color.MAGENTA);
    g.drawString("PROTANOPIA",250,100);
    
    //(X,Y)
    g.setColor(Color.green);
    g.setFont(font1);
    g.drawString("(" + recX + ","+ recY +")", 585,60);
    
    //HAPPINESS
    g.setColor(Color.pink);
    g.drawString("Score: "+happiness, 30, 60);

    //GROUND
    g.setColor(Color.gray);
    g.fillRect(0,440,700,300);
    repaint();
    //OBSTACLEX2
    g.setColor(Color.gray);
    if (colorCode == 1){
      g.setColor(Color.green);
    }
    else if (colorCode == 2){
      g.setColor(Color.cyan);
    }
    else if (colorCode == 3){
      g.setColor(purple);
    }
    else{
    }
    g.fillOval(8,415,25,25);
    g.fillOval(8,395,25,25);
    if(recX == 8 && colorCode==1 && colorCode2 ==5){/////////////////////////////
      happiness++;}
    else if(recX == 8 && colorCode==2 && colorCode2 ==6){
      happiness++;}
    else if(recX == 8 && colorCode==3 && colorCode2 ==4){
      happiness++;}
    else if(recX == 8){
      happiness--;}
    if(recX == -10){
      recX = 800;}
    
    
    //OBSTACLEX
    if (colorCode2 == 4){
      g.setColor(darkblue);
      colorCode2 = 4;
    }
    else if (colorCode2 == 5){
      g.setColor(Color.yellow);
      colorCode2 = 5;
    }
    else if (colorCode2 == 6){
      g.setColor(Color.white);
      colorCode2 = 6;
    }
    else{g.setColor(Color.gray);}
    recX -=1;
    g.fillRect(recX, recY, 40, 40);
    if(recX == x && colorCode==1 && colorCode2 ==5){
      happiness--;}
    else if(recX == x && colorCode==2 && colorCode2 ==6){
      happiness--;}
    else if(recX == x && colorCode==3 && colorCode2 ==4){
      happiness--;}
    else if(recX == x){
      happiness++;}
    if(recX == -10){
      recX = 800;}
    
    //CHARACTER
    g.setColor(Color.gray);
    if (colorCode == 1){
      g.setColor(Color.green);
    }
    else if (colorCode == 2){
      g.setColor(Color.cyan);
    }
    else if (colorCode == 3){
      g.setColor(purple);
    }
    else{
    }
    g.fillOval(x,y,25,25); //(positionX,positionY, width, length)
    g.fillOval(x,y-20,25,25);
    //Desciption
    g.setFont(font1);
    g.setColor(Color.red);
    g.drawString("-a condition that causes severe red colour blindness",120,125);
       //Directions
    g.setColor(Color.green);
    g.fillOval(120,160,20,20);
    g.setColor(Color.yellow);
    g.fillOval(140,160,20,20);
    
    g.setColor(Color.cyan);
    g.fillOval(355,160,20,20);//more negative double circle wining
    g.setColor(Color.white);
    g.fillOval(375,160,20,20);
    
    g.setColor(purple);
    g.fillOval(575,160,20,20);
    g.setColor(Color.blue);
    g.fillOval(595,160,20,20);
    
    
    if(happiness < 0){
      g.drawString("Double Cirlce is winning!",250,250);
    }
    else if(happiness>0){
      g.drawString("Rectangle is winning!",250,250);
    }
    else{
      g.drawString("Tie!",350,250);
    }
    g.setColor(Color.cyan);
    g.drawString("Each player is allowed to press once in each domain!",130,300);

  }


  public static void main(String[] args){
      new Protanopia();
  }
}
