package com.hiranmoy.eee.sec.playchess.ChessPieceDirectory;

import android.graphics.drawable.Drawable;

import com.hiranmoy.eee.sec.playchess.ChessBoard;
import com.hiranmoy.eee.sec.playchess.ChessPiece;
import com.hiranmoy.eee.sec.playchess.PositionAttackedByOpponent;
import com.hiranmoy.eee.sec.playchess.R;

import java.util.ArrayList;

public class Pawn implements ChessPiece {
    private String playerName;

    private int playerNo;

    public Pawn(String playerName, int playerNo) {
        this.playerName = playerName;
        this.playerNo = playerNo;
    }

    @Override
    public ArrayList<Action> ligalMoves(ChessPiece[][] grid, int x, int y) {
        ArrayList<Action> moves = new ArrayList<>();
        int inc = -1;
        if(grid[x][y].getPlayerNo()==0) inc = 1;


        int tempx = x + inc, tempy = y-1;
        if(tempx>0 && tempx<9 && tempy>0 && tempy<9 && (grid[tempx][tempy].getPlayerNo()^1)==grid[x][y].getPlayerNo()){
            Action temp = new Action(tempx, tempy, 1);
            temp.willChange.add(new Change(tempx, tempy, grid[x][y]));
            temp.willChange.add(new Change(x, y, new Empty("Hiran", 3)));
            if(PositionAttackedByOpponent.ifPossible(grid, grid[x][y].getPlayerNo(), temp)==true) moves.add(temp);
        }
        tempx = x + inc; tempy = y+1;
        if(tempx>0 && tempx<9 && tempy>0 && tempy<9 && (grid[tempx][tempy].getPlayerNo()^1)==grid[x][y].getPlayerNo()){
            Action temp = new Action(tempx, tempy, 1);
            temp.willChange.add(new Change(tempx, tempy, grid[x][y]));
            temp.willChange.add(new Change(x, y, new Empty("Hiran", 3)));
            if(PositionAttackedByOpponent.ifPossible(grid, grid[x][y].getPlayerNo(), temp)==true) moves.add(temp);
        }
        tempx = x+inc; tempy = y;
        if(tempx>0 && tempx<9 && tempy>0 && tempy<9 && grid[tempx][tempy].getPlayerNo()==3){
            Action temp = new Action(tempx, tempy, 0);
            temp.willChange.add(new Change(tempx, tempy, grid[x][y]));
            temp.willChange.add(new Change(x, y, grid[tempx][tempy]));
            if(PositionAttackedByOpponent.ifPossible(grid, grid[x][y].getPlayerNo(), temp)==true) moves.add(temp);

            tempx+=inc;

            if(tempx>0 && tempx<9 && tempy>0 && tempy<9 && grid[tempx][tempy].getPlayerNo()==3 && ChessBoard.entryOfGrid[x][y]==false){
                temp = new Action(tempx, tempy, 0);
                temp.willChange.add(new Change(tempx, tempy, grid[x][y]));
                temp.willChange.add(new Change(x, y, grid[tempx][tempy]));
                if(PositionAttackedByOpponent.ifPossible(grid, grid[x][y].getPlayerNo(), temp)==true) moves.add(temp);
            }


        }


        return moves;
    }

    @Override
    public int getPawnType() {
        return 5;
    }

    @Override
    public Drawable getNormalIcon() {
        Drawable icon;
        if(playerNo==1){
            icon = ChessBoard.context.getResources().getDrawable(R.drawable.pawnwhite);
        }
        else icon = ChessBoard.context.getResources().getDrawable(R.drawable.pawnblack);
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
        boolean[][] check = new boolean[10][10];
        if(playerNo==1){
            check[x-1][y-1] = check[x-1][y+1] = true;
        }
        else check[x+1][y-1] = check[x+1][y+1] = true;

        return check;
    }

    @Override
    public int getPlayerNo() {
        return playerNo;
    }
}
