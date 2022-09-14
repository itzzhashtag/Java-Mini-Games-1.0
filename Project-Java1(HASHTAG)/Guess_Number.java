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
class Guess_Number
{
    public static void guessnumber()
    {
        int computerNumber = (int) (Math.random()*100 + 1);
        int userAnswer = 0;
        //System.out.println("The correct guess would be " + computerNumber);
        int count = 1;
        
        while (userAnswer != computerNumber)
        {
            String response = JOptionPane.showInputDialog(null,"Enter a guess between 1 and 100", "Guessing Game", 3);
            //response.toFront();
            try
            {
                userAnswer = Integer.parseInt(response);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Invalid INPUT!  \nShutting Down!","Alert",JOptionPane.WARNING_MESSAGE); 
                break;
            }
            JOptionPane.showMessageDialog(null, ""+ determineGuess(userAnswer, computerNumber, count));
            count++;
        }
    }
    public static String determineGuess(int userAnswer, int computerNumber, int count)
    {
        if (userAnswer <=0 || userAnswer >100) 
        {
            return"Your guess is invalid";
        }
        else if (userAnswer == computerNumber )
        {
            return"Correct!\nTotal Guesses: " + count;
        }
        else if (userAnswer > computerNumber) 
        {
            return"Your guess is too high, try again.\nTry Number: " + count;
        }
        else if (userAnswer < computerNumber) 
        {
            return"Your guess is too low, try again.\nTry Number: " + count;
        }
        else 
        {
            return"Your guess is incorrect\nTry Number: " + count;
        }
    }
    public static void guess_num() 
    {
        guessnumber();
    }
}