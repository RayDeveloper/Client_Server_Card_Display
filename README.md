**Introduction**

The purpose of the program is to obtain card information from the user and display it on screen using graphics. I was unable to get the windows to close before the ‘quit’ option was entered. The program uses a While statement that stays for “While (true)”. An extra feature was implemented, where once ‘high’ is entered it displays the current high score. If during the program execution the high score is beaten, the new high score is registered.
1)  User entering playing card information
The program takes in the following variables for the input of cards: ‘AH’, the first character, indicates the card value, the second character is the suit of the cards. Please note that only card values in the correct format listed below are accepted.

The string array called “acc” below contains all the accepted card values and words of the program.

![image](https://user-images.githubusercontent.com/12537673/119754829-fe79b080-be6e-11eb-9db7-ddee16f2d19b.png)

The method below checks the input for the acceptable characters:
 

![image](https://user-images.githubusercontent.com/12537673/119754855-0a657280-be6f-11eb-805e-cec8dd2b46db.png)


If it is true, it returns true and if it does not match it prints a statement to the CLIENT server.

![image](https://user-images.githubusercontent.com/12537673/119754875-12251700-be6f-11eb-809c-b196b8fda421.png)


The images are displayed using Java JFrame. The method “ShowCard” uses JFrame to launch the card. The size of the window and the picture are all controlled programmatically. Each window can be closed by itself without the programming ending. Below is the method call ‘ShowCard’ that displays the image.

![image](https://user-images.githubusercontent.com/12537673/119754890-194c2500-be6f-11eb-827f-0f21f37f7b4f.png)

The program also checks for the case of each character, that means the user can enter uppercase or lower case and still get the same result. ‘aH’ or ‘ah’ will still print Ace of Hearts.

![image](https://user-images.githubusercontent.com/12537673/119754912-223cf680-be6f-11eb-822d-423856c06501.png)

The name of the card entered and the ignoreCase method was combined it to make the directory for the files. With the string create, it was then passed to a method to display the required card.

![image](https://user-images.githubusercontent.com/12537673/119754924-29fc9b00-be6f-11eb-9c5c-1c585959d013.png)


When more than one card is entered of the same value, the top bar displays the number of times it was played.

![image](https://user-images.githubusercontent.com/12537673/119754937-3123a900-be6f-11eb-800f-3750d1019862.png)


2) When the user enters “quit”.

When the user enters ‘quit’ or any combination of the word in uppercase and lowercase, all the cards that have a count more than zero (> 0) are displayed. The method below offers this aspect. It takes in the array of entered cards and the length of said array.

![image](https://user-images.githubusercontent.com/12537673/119754972-3e409800-be6f-11eb-8197-940e696d8028.png)


![image](https://user-images.githubusercontent.com/12537673/119754979-413b8880-be6f-11eb-8558-e8fb28e575a1.png)

When “quit” is entered, it redisplays all the cards with a count > 0. This time it shows the number of times the cards were played previously. Please refer to the screenshot below.

![image](https://user-images.githubusercontent.com/12537673/119754998-4b5d8700-be6f-11eb-809c-81240fb54ac6.png)


3) Extra Feature

The extra feature that was implemented was the High Score Tracker. The high score is the number of cards entered. The initialized high score is 2. If the user surpasses the number of cards saved, they will receive the String new High ="You beat the high score!!!” with: "+newScore;” If it is not surpassed the user will receive HighNo = "The high score still stands with:"+ HighScore;”. The code below illustrates this.

![image](https://user-images.githubusercontent.com/12537673/119755026-56b0b280-be6f-11eb-9dd1-d6ef10ec3cc0.png)


Example of the extra feature when the high score has been beaten.

![image](https://user-images.githubusercontent.com/12537673/119755044-5e705700-be6f-11eb-8b49-9ebad0e5d04d.png)


Example of the extra feature when the high score has not been beaten.
![image](https://user-images.githubusercontent.com/12537673/119755057-662ffb80-be6f-11eb-9584-8a2f4e8669fb.png)


**END**

[COMP6601 ASG 1 RDavis_RDavis.pdf](https://github.com/RayDeveloper/Client_Server_Card_Display/files/6550622/COMP6601.ASG.1.RDavis_RDavis.pdf)
