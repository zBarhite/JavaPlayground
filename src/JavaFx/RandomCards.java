package JavaFx;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RandomCards extends Application{
    //Change this value to anything from 1-52
    static int cardsToShow = 7;
    
    private static int cardsShown = 0;
    private static int[] rand;
    @Override
    public void start(Stage primaryStage){
        Pane pane = new FlowPane();
        Image cardBackImg = new Image("backCard.png");
        Button refreshButton = new Button("-DEAL NEW CARDS-");
        pane.getChildren().add(refreshButton);
        for(int a=0;a<cardsToShow;a++)
            {pane.getChildren().add(new ImageView(cardBackImg));}
        Object[] cards = pane.getChildren().toArray();
        for(int b=1;b<cardsToShow+1;b++){
            ((ImageView)cards[b]).setPreserveRatio(true);
            ((ImageView)cards[b]).setFitHeight(300);
        }
        refreshButton.setOnAction(a1->{
            RandomCards.rand = new Random().ints(1,53).distinct().limit(cardsToShow).toArray();
            RandomCards.cardsShown=0;
            for(int c=1;c<cardsToShow+1;c++){
                ((ImageView)cards[c]).setImage(cardBackImg);
                ((ImageView)cards[c]).setOnMousePressed(a->{
                    if((RandomCards.cardsShown<cardsToShow ) && ((ImageView)a.getSource()).getImage().equals(cardBackImg))
                        {((ImageView)a.getSource()).setImage(new Image(String.valueOf(getNextCard()+".png")));}
                });
            }
        });
        refreshButton.fire();
        primaryStage.setScene(new Scene(pane, 175 + 225*cardsToShow, 300));
        primaryStage.show();
    }
    private static int getNextCard()
        {return rand[RandomCards.cardsShown++];}  
    public static void main(String[] args)
        {launch(args);} 
}