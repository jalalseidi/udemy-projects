package com.jalal.game;

import java.util.Random;

public class GuessingGame {
  private final int randomNumber = new Random().nextInt(10) + 1;
  private int counter = 0;
  public String guess(int guessedNumber) {
    counter++;
    String tryText = counter == 1 ? "try" : "tries";
    String winningMsg = String.format("You got it in %d %s", counter, tryText);
    String response = null;
    if (counter == 4 && guessedNumber != getRandomNum()) {
      response = String.format("You didn't get it and you've had %d %s. Game over.", counter, tryText);
    } else if (counter > 4) {
      response = "Sorry, you are limited to 4 tries. Your game is over.";
    } else {
      String tooHighLowText = null;
      if (guessedNumber < getRandomNum()) {
        tooHighLowText = "- you're too low";
      } else if (guessedNumber > getRandomNum()) {
        tooHighLowText = "- you're too high";
      } else {
        tooHighLowText = "";
      }
      String loseText = String.format("You didn't get it %s", tooHighLowText).trim();
      response = guessedNumber == getRandomNum() ? winningMsg : loseText;
    }
    return response;
  }
  public int getRandomNum() {
    return randomNumber;
  }

  public static void main(String[] args) {
    GuessingGame game = new GuessingGame();
    boolean loopShouldContinue = true;
    do {
      String input = System.console().readLine("Enter a number:");
      if ("q".equals(input)) {
        return;
      }
      String output = game.guess(Integer.parseInt(input));
      System.out.println(output);
      if (output.contains("You got it") || output.contains("over")) {
        loopShouldContinue = false;
      }
    } while (loopShouldContinue);
  }
}
