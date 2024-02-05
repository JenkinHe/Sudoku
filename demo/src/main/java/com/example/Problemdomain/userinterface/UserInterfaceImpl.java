package com.example.Problemdomain.userinterface;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.HashMap;

import com.example.Problemdomain.Coordinates;
import com.example.Problemdomain.SudokuGame;

public class UserInterfaceImpl implements IUserInterfaceContract.View,EventHandler<KeyEvent>{
    
    private final Stage stage;
    private final Group root;

    //how doe we keep track of 81 text fields?
    private HashMap<Coordinates,SudokuTextField> textFieldCoordinates;
    
    
    private static final double WINDOW_Y=732;
    private static final double WINDOW_X=668;
    private static final double BOARD_PADDING = 50;
    private static final double BOARD_X_AND_Y = 576;

    private static final Color WINDOW_BACKGROUND_COLOR = Color.rgb(0, 150, 136);
    private static final Color BOARD_BACKGROUND_COLOR = Color.rgb(224, 242, 241);
    private static final String SUDOKU = "Sudoku";

    public UserInterfaceImpl(Stage stage){
        this.stage =stage;
        this.root=new Group();
        this.textFieldCoordinates= new HashMap<>();
        initializeUserInterface();

    }

    private void initializeUserInterface(){
        drawBackground(root);
        drawTitle(root);
        drawSudokuBoard(root);
        drawTextFields(root);
        drawGridLines(root);
        stage.show();
    }

    private void drawGridLines(Group root){
        int xAndy =114;
        int index=0;
        while(index<8){
            int thickness;
            if(index == 2 || index==5){
                thickness=3;
            } else{
                thickness=2;
            }

            Rectangle verticalLine =getLine(
                xAndy+64*index,
                BOARD_PADDING,
                BOARD_X_AND_Y,
                thickness
            );

            Rectangle horizontalLine =getLine(
                BOARD_PADDING,
                xAndy+64*index,
                thickness,
                BOARD_X_AND_Y
            );

            root.getChildren().addAll(verticalLine,horizontalLine);
            
            index++;
        }
        
    }

    private Rectangle getLine(double x, double y,double height, double width){
        Rectangle line = new Rectangle();
        line.setX(x);
        line.setY(y);
        line.setHeight(height);
        line.setWidth(width);

        line.setFill(Color.BLACK);
        return line;
    }

    @Override
    public void drawTextFields(Group root){
        final int xOrigin =50;
        final int yOrigin =50;

        final int xAndyDelta=64;

        //O(n^2) Runtime Complexity
        for(int xIndex =0; xIndex<9;xIndex++){
            for(int yIndex=0; yIndex<9; yIndex++){
                int x = xOrigin+xIndex *xAndyDelta;
                int y = yOrigin+yIndex*xAndyDelta;

                SudokuTextField tile=new SudokuTextField((xIndex), yIndex);

                styleSudokuTile(tile,x,y);
            }
        }
    }


}
