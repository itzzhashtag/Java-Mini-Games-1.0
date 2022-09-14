import java.util.Scanner;
import java.util.List;
//import java.util.random.*;
import java.util.Random;
import java.util.ArrayList;
public class RPS_Game 
{	
	public static void RPS() 
	{
		int key =1;
		System.out.println("\n0.Exit\n1.Stone\n2.Paper\n3.Sizzers");
		System.out.print("Enter your choice : ");
		do 
		{
                    //comp();
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(1);
                    list.add(2);
                    list.add(3);
                    Random rn = new Random();
                    int answer = rn.nextInt(3) + 1;
                    //player();
                    Scanner sc =  new Scanner(System.in);
                    int playerinput = sc.nextInt();
                    int flag = 0;
        		switch(playerinput) 
           		{
        			case 1:
        				flag =1;
        				compare(answer,flag);
        				break;
        			case 2:
        				flag=2;
        				compare(answer,flag);
        				break;
        			case 3:
        				flag = 3;
        				compare(answer,flag);
        				break;
        			case 0:
        				key = 0;
        				System.out.println("Thankyou! Visit again.");
        				break;
        			default:
        				System.out.print("Wrong Choice!\n Try Again : ");
                                    	continue;
                    }
        	}while(key>0);		
	}	
	public static void compare(int c1,int p1) 
	{
		int c,p;
		c=c1;
		p=p1;
		System.out.print("Comp ->"+c+" : You ->"+p);
		if(c == p) 
		{
			System.out.print("\n\tDraw\n Retry : ");
		
		}
		else if(c==1 && p ==2 || c==2 && p==3 || c==3 && p==1) 
		{
			System.out.print("\n\tYou  win!\n Retry : ");	
		}else if(c==1 && p==3 || c==3 && p==2 || c==2 && p==1) 
		{
			System.out.print("\n\tYou  lose :)\n Retry : ");
		}
	}
}