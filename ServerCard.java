//COMP6601 ASG 1 RDavis |UWI ID: 813117991

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.net.*;
import java.io.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import javax.swing.JPanel;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class ServerCard extends JFrame{

public static int packPos;
public static int HighScore=2;
public static int currentScore;
public static String CurrentName="Raydon";
public static String highName="";



    public static void main(String args[]) throws IOException{


		String[] cardValues = new String[52];
		String[] cardsPlayed = new String[52];
		int packPos=0;
		int counter=0;
		int total=0;
		boolean compy = false;
    	System.out.println("Server Side: Raydon Davis: UWI ID: 813117991\n");

        // Step 1: Establish the socket connection.
        ServerSocket ss = new ServerSocket(4444);
        Socket s = ss.accept();

        // Step 2: Processing the request.
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        while (true){
            String input = dis.readUTF();
              if(input.equalsIgnoreCase("high")){
    				String highName=	highScorechecker(packPos);
    			if(!highName.equalsIgnoreCase("good"))
    				//System.out.print(""+highName);
    				dos.writeUTF(highName);
            }//end if

            if(input.equalsIgnoreCase("quit")){
            				PrintAllCards(cardValues,packPos);
            }else{
				if(!input.equalsIgnoreCase("high")){
							cardValues[packPos]= input;
							packPos++;
				}//end if



				counter=0;// sets counter back to 0
            	for (int i = 0; i < packPos; i++) {
            			if(cardValues[i].equalsIgnoreCase(input))
            				counter++;
            		}//end for
            	    String str= "Card Count: "+ total;
					String made = input+".png";
					String direc = ("PNG/");
					String loc = direc+made;//creates the file address
            		ShowCard(loc,counter);
            }//end if
        	dos.writeUTF(input);//accepts client messages

        }//end while
    }//end main

      static void ShowCard(String direc,int count ) {//method to show the cards

      				if(!direc.equalsIgnoreCase("PNG/high.png")){// if statement to prevent the word high from being printed

      				String counter =   " Played : "+ count+ "time(s)";//the count of each card on the screen
            	    JFrame frame = new JFrame(counter);
  					ImageIcon icon = new ImageIcon(new ImageIcon(direc).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
  					JLabel label = new JLabel(icon);
  					frame.add(label);
  					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//allows each one to be closed individually
  					frame.pack();
  					frame.setVisible(true);
  					frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);// to start the window maximized
  					frame.setSize(300,300);

      				}//end if



  }//end ShowCard






public static void PrintAllCards(String allcards[],int totalLength ) {//method to print all cards
        			int counter=0;
        			int	pos=0;
        	       	for (int i = 0; i < totalLength; i++) {
		        	       		for (int j = 0; j < totalLength; j++) {
		            					if(allcards[i].equalsIgnoreCase(allcards[j]))
		            							counter++;
		            					if(allcards[i].equalsIgnoreCase("quit"))
		            							continue;
		        	       		}//end for
							String made = allcards[i]+".png";
							String direc = ("PNG/");
							String loc = direc+made;
							if(!allcards[i].equalsIgnoreCase("quit")){

									String counter2 =   " Played : "+counter+ " time(s)"; //the count of each card on the screen
									JFrame frame = new JFrame(counter2);
		  							ImageIcon icon = new ImageIcon(new ImageIcon(loc).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		  							JLabel label = new JLabel(icon);
		  							frame.add(label);
		  							frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//allows each one to be closed individually
		  							frame.pack();
		  							frame.setVisible(true);
		  							frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);// to start the window maximized
		  							frame.setSize(300,300);
									counter=0;
							}//end if


        	       	}//end for

  }//end PrintAllCards

public static String highScorechecker(int newScore) throws IOException{//method to check the highscore against the computer

  	String HighNo= new String("");
  	//String currentName="Raydon";

  	if(newScore > HighScore){
  		String newHigh ="You beat the high score!!! with :"+newScore;
  		return  newHigh ;
  		}else{

  		 	HighNo = "The high score still stands with :"+ HighScore;
			return HighNo;
  	}//end if

 }//endHighScore




}//end class