import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.awt.Color;
import javax.swing.*;
import java.lang.Math;
import java.awt.*;  
import java.awt.event.*;  
import java.util.Scanner;
import javax.swing.JOptionPane;
class Gaming_World
{ 
    public static void main(String[] args)
    {
        
        Scanner hash=new Scanner(System.in);
        System.out.println("\n\t\tWelcome to Hashtag's Mini-Games Foundation.");
        System.out.println("\n   0. For Knowing Time\n   1. Guess The Number Game(CAN YOU???)\n   2. Mind Game(Calulator with twist)\n   3. Number Puzzle(BEAT ME IF YOUR CAN)\n   4. Rock, Paper, Scissor(CANNOT BEAT)\n   5. Snake GAME (LATEST) \n   6. Tic Tac Toe (2P)\n   7. Ice Breaker(Can you?)");
        System.out.print("\nEnter your Fun-Choice : ");
        int a=hash.nextInt();
        System.out.println();
        switch(a)
        {
            case 0:
                DTime class0=new DTime(); 
                break;
            case 1:
                Guess_Number c1=new Guess_Number();
                Guess_Number.guess_num();
                break;
            case 2:
                Calcula c2=new Calcula();
                break;
            case 3:
                puzzle c3=new puzzle();
                break;
            case 4:
                RPS_Games c4=new RPS_Games();
                RPS_Games.RPS();
                break;
            case 5:
                SnakeGame c5=new SnakeGame();
                SnakeGame.main();
                break;
            case 6:
                TicTacToeGame c6=new TicTacToeGame();
                break;
            case 7:
                Ice_Breaker c7=new Ice_Breaker();
                Ice_Breaker.main();
                break;
                
            default:
                System.out.println("Get new Eye Lens!\nShutting Down!");
                break;
        
        }
        hash.close();     
    }
}
