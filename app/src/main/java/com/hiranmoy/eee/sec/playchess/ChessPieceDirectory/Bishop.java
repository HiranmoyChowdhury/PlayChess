package com.hiranmoy.eee.sec.playchess.ChessPieceDirectory;

import android.graphics.drawable.Drawable;
import android.util.Log;

import com.hiranmoy.eee.sec.playchess.ChessBoard;
import com.hiranmoy.eee.sec.playchess.ChessPiece;
import com.hiranmoy.eee.sec.playchess.PositionAttackedByOpponent;
import com.hiranmoy.eee.sec.playchess.R;

import java.util.ArrayList;

public class Bishop implements ChessPiece {
    private String playerName;
    private int playerNo;

    public Bishop(String playerName, int playerNo) {
        this.playerName = playerName;
        this.playerNo = playerNo;
    }

    @Override
    public ArrayList<Action> ligalMoves(ChessPiece[][] grid, int x, int y) {
        ArrayList<Action> moves = new ArrayList<>();
        int[] inc = new int[]{1, -1};
        for(int i = 0; i<2; i++){
            for(int j = 0; j<2; j++){
                int tempx = x+inc[i], tempy = y+inc[j];
                while(tempx>0 && tempx<9 && tempy>0 && tempy<9){

                    if(grid[tempx][tempy].getPlayerNo()==grid[x][y].getPlayerNo()) break;
                    if(grid[tempx][tempy].getPlayerNo()==3){
                        Action temp = new Action(tempx, tempy, 0);
                        temp.willChange.add(new Change(x, y, grid[tempx][tempy]));
                        temp.willChange.add(new Change(tempx, tempy, grid[x][y]));
                        if(PositionAttackedByOpponent.ifPossible( grid, grid[x][y].getPlayerNo(), temp )==true) moves.add(temp);
                    }
                    else{
                        Action temp = new Action(tempx, tempy, 1);
                        temp.willChange.add(new Change( x, y, new Empty("Hiranmoy", 3)  ));
                        temp.willChange.add(new Change(tempx, tempy, grid[x][y]));
                        if(PositionAttackedByOpponent.ifPossible(grid, grid[x][y].getPlayerNo(), temp)) moves.add(temp);
                        break;
                    }
                    tempx+=inc[i]; tempy+=inc[j];
                }
            }
        }


        return moves;
    }

    @Override
    public int getPawnType() {
        return 4;
    }

    @Override
    public Drawable getNormalIcon() {
        Drawable icon;
        if(playerNo==1){
            icon = ChessBoard.context.getResources().getDrawable(R.drawable.bishopwhite);
        }
        else icon = ChessBoard.context.getResources().getDrawable(R.drawable.bishopblack);
        return icon;
    }

    @Override
    public Drawable getAttackedIcon() {
        return null;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public boolean[][] canMove(ChessPiece[][] grid, int x, int y) {
       // Log.d("knight", "canMove: "+x+"  "+y);
        boolean[][] check = new boolean[9][9];
        int[] inc = new int[]{1, -1};
        for(int i = 0; i<2; i++){
            for(int j = 0; j<2; j++){
                int tempx = x, tempy = y;
                while(tempx>0 && tempx<9 && tempy>0 && tempy<9){

                    check[tempx][tempy] = true;
                    if(grid[tempx][tempy].getPlayerNo()!=3) break;
                    tempx+=inc[i]; tempy+=inc[j];
                }
            }
        }
        check[x][y] = false;
        return check;


    }

    @Override
    public int getPlayerNo() {
        return this.playerNo;
    }

}
