package com.hiranmoy.eee.sec.playchess;

import android.util.Log;

import com.hiranmoy.eee.sec.playchess.ChessPieceDirectory.Action;

public class PositionAttackedByOpponent {
    public static boolean check(ChessPiece[][] grid, int opponent){

       // Log.d("knight", "check: "+opponent);
        for(int i =1; i<=8; i++){
            for(int j = 1; j<=8; j++){
                if(grid[i][j].getPlayerNo()<3 && grid[i][j].getPlayerNo()!=opponent && grid[i][j].getPawnType()==1){
                  //  Log.d("knight", "attacked: "+i+"  "+j+" ");
                    return attacked(grid, opponent, i, j);
                }
            }
        }
        return true;
    }
    public static boolean attacked(ChessPiece[][] grid, int opponent, int x, int y){
        boolean[][] tempGrid;
       // Log.d("knight", "attacked: "+x+"  "+y+" "+opponent);

        for(int i = 1; i<=8; i++){
            for(int j = 1; j<=8; j++){
                if(grid[i][j].getPlayerNo()==opponent){
                  //  Log.d("knight", "attacked: "+i+" "+j);
                    tempGrid = grid[i][j].canMove(grid, i, j);
                    if(tempGrid[x][y]==true) return true;
                }
            }
        }
        return false;
    }
    public static boolean ifPossible(ChessPiece[][] grid , int currentPlayer, Action action){
        int opponent = currentPlayer^1;


        ChessPiece[][] tempGrid = new ChessPiece[9][9];

        for(int i = 1; i<= 8; i++) for(int j = 1; j<=8; j++) tempGrid[i][j] = grid[i][j];

        int siz = action.willChange.size();
        for(int i = 0; i<siz; i++){
            int x = action.willChange.get(i).x, y = action.willChange.get(i).y;
            tempGrid[x][y] = action.willChange.get(i).type;
        }
     //   Log.d("knight", "check: "+opponent);
        if(check(tempGrid, opponent)==true) return false;
        else return true;




    }
}
