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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientCard
{



    public static void main(String[] args) throws IOException{



        InetAddress ip = InetAddress.getLocalHost();
        int port = 4444;
        Scanner sc = new Scanner(System.in);
        String ans=("");
        String acc []= {"quit","ah","as","ad","ac",
        "kh","ks","kd","kc",
         "qh","qs","qd","qc",
         "jh","js","jd","jc",
         "2h","3h","4h","5h","6h","7h","8h","9h","10h",
         "2s","3s","4s","5s","6s","7s","8s","9s","10s",
         "2d","3d","4d","5d","6d","7d","8d","9d","10d",
         "2c","3c","4c","5c","6c","7c","8c","9c","10c","high"};


        // Step 1: Open the socket connection.
        Socket s = new Socket(ip, port);

        // Step 2: Communication-get the input and output stream
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        while (true){
            System.out.print("\nMENU\n");
            System.out.print("---Enter A card, No spaces. e.g AH will print Ace of Hearts , 10H will print 10 of Hearts.\n");
            System.out.print("---Enter the word QUIT to display all cards entered.\n");
            System.out.print("---Enter the word 'High'to get highscore information\n");
            System.out.print("\n");

            String inp = sc.nextLine();
			boolean value= inputChecker(inp,acc);

			if(value== true){
            	dos.writeUTF(inp);
				}else{
					System.out.print("The wrong format was entered, Please follow the format below\n");
					continue ; // continue to the while loop

			}//end if


             ans = dis.readUTF();//reads what the server sent

             boolean highscore= inputChecker(ans,acc);

             if(highscore != true){
             	   System.out.print("\n"+ans);
            	   System.out.print("\n");
             }
        }//end while
    }//end main

private static boolean inputChecker(String userInput, String[] acceptable) {//method to check that the input matches
    for (int i = 0; i < acceptable.length; i++) {
        if (userInput.equalsIgnoreCase(acceptable[i])) {
            return true;
        }
    }
    return false;
}


}//end class