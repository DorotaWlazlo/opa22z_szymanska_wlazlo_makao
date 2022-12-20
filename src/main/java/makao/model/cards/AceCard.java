package makao.model.cards;

import javafx.event.ActionEvent;
import  makao.model.game.Stack;
import  makao.model.game.StateOfRound;

import java.util.Scanner;

public class AceCard extends Card {
    public AceCard(CardColour cardColour, CardValue cardValue, String imagePath){
        super(cardColour, cardValue, imagePath);
    }
    private AceListener listener;

    public void setListener(AceListener listener) {
        this.listener = listener;
    }

    @Override
    public void playCard(StateOfRound stateOfRound, Stack stack){
        super.playCard(stateOfRound, stack);
        CardColour chosenColor = chooseColour();
        stateOfRound.setPossibleNextColour(chosenColor);
        stateOfRound.setChosenColor(chosenColor);
    }

    public CardColour chooseColour(){
        /*System.out.println("Choose colour (1 - Hearts, 2 - Spades, 3 - Clubs, 4 - Diamonds)");
        Scanner scanner = new Scanner(System.in);
        int chosenNumber = scanner.nextInt();
        CardColour chosenColour = null;

        switch (chosenNumber){
            case 1 -> chosenColour = CardColour.HEARTS;
            case 2 -> chosenColour = CardColour.SPADES;
            case 3 -> chosenColour = CardColour.CLUBS;
            case 4 -> chosenColour = CardColour.DIAMONDS;
        }*/
        CardColour chosenColour = listener.aceWasPlayed( new ActionEvent());
        return chosenColour;
    }
}
