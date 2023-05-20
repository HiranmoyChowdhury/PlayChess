package com.hiranmoy.eee.sec.playchess;

import androidx.core.content.ContextCompat;

public class SetChessBoard {
    /// lastdigit    pawn
    //    1    -    king

    //     2     -   queen

    //    3     -   rook

    //    4     -   bishop

    //    5    -    pawn

    //    6    -    knight
    public static void set(){
        for(int i = 1; i<=8; i++){
            for(int j = 1; j<=8; j++){
                int buttonNo = ((i-1)*8) + j;
                ChessBoard.button[buttonNo].setImageDrawable(ChessBoard.grid[i][j].getNormalIcon());
                if((i+j)%2==0){
                    ChessBoard.changeGrey(buttonNo);
                }
                else{
                    ChessBoard.changeBrown(buttonNo);
                }
            }
        }
    }
}
