package Btap_them;

import java.util.Scanner;

public class Dam_keo_bao {
    String getComputerChoice(){
        String computerChoice;
        int randomNumber = (int) (Math.random()*3 + 1);
        if (randomNumber == 1){
            computerChoice = "rock";
        }
        else if (randomNumber == 2){
            computerChoice = "paper";
        }
        else {
            computerChoice = "scissors";
        }
        return computerChoice;
    }

    String getUserInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rock, paper or scissors");
        String userInput = sc.nextLine();
        userInput = userInput.toLowerCase();
        return userInput;
    }

    String getResult(String userInput, String computerChoice) {
        if (userInput.equals(computerChoice)){
            return "draw";
        }
        else if (userInput.equals("paper") && computerChoice.equals("rock")) {
            return "win";
        }

        else if (userInput.equals("rock") && computerChoice.equals("scissors")) {
            return "win";
        }

        else if (userInput.equals("scissors") && computerChoice.equals("paper")) {
            return "win";
        }
        else {
            return "lose";
        }
    }

    public static void main(String[] args) {
        Dam_keo_bao obj = new Dam_keo_bao();

        // get user input
        String userInput;
        while(true) {
            userInput = obj.getUserInput();

            if (userInput.equals("rock") || userInput.equals("paper") || userInput.equals("scissors")) {
                break;
            }
        }

        // get computers choice
        String computerChoice = obj.getComputerChoice();

        // get results
        String result = obj.getResult(userInput, computerChoice);

        System.out.println("User Input: " + userInput);
        System.out.println("Computer Choice: " + computerChoice);
        System.out.println(result);
    }
}

