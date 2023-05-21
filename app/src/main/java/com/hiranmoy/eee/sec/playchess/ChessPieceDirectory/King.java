package com.hiranmoy.eee.sec.playchess.ChessPieceDirectory;

import android.graphics.drawable.Drawable;

import com.hiranmoy.eee.sec.playchess.ChessBoard;
import com.hiranmoy.eee.sec.playchess.ChessPiece;
import com.hiranmoy.eee.sec.playchess.PositionAttackedByOpponent;
import com.hiranmoy.eee.sec.playchess.R;

import java.util.ArrayList;

public class King implements ChessPiece {
    private String playerName;

    private int playerNo;

    public King(String playerName, int playerNo) {
        this.playerName = playerName;
        this.playerNo = playerNo;
    }

    @Override
    public ArrayList<Action> ligalMoves(ChessPiece[][] grid, int x, int y) {
        ArrayList<Action> moves = new ArrayList<>();

        int[] inc = new int[]{1, -1, 0};

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                int tempx = x+inc[i], tempy = inc[j]+y;
                if(tempx>0 && tempx<9 && tempy>0 && tempy<9){
                    if(grid[x][y].getPlayerNo()==grid[tempx][tempy].getPlayerNo()) continue;
                    if(grid[tempx][tempy].getPlayerNo()==3){
                        Action temp = new Action(tempx, tempy, 0);
                        temp.willChange.add(new Change(x, y, grid[tempx][tempy]));
                        temp.willChange.add(new Change(tempx, tempy, grid[x][y]));
                        if(PositionAttackedByOpponent.ifPossible(grid, grid[x][y].getPlayerNo(), temp) == true) moves.add(temp);
                    }
                    else{
                        Action temp = new Action(tempx, tempy, 1);
                        temp.willChange.add(new Change( x, y, new Empty("Hiranmoy", 3)  ));
                        temp.willChange.add(new Change(tempx, tempy, grid[x][y]));
                        if(PositionAttackedByOpponent.ifPossible(grid, grid[x][y].getPlayerNo(), temp) == true) moves.add(temp);
                    }
                }
            }
        }

        if(ChessBoard.entryOfGrid[x][y]==false && ChessBoard.entryOfGrid[x][8]==false){
            boolean isCheck = false, isAnyPiece = false;
            for(int i = y; i<=8; i++){
                if(PositionAttackedByOpponent.attacked(grid, grid[x][y].getPlayerNo()^1, x, i)==true) isCheck = true;
            }
            for(int i = y+1; i<8; i++){
                if(grid[x][i].getPawnType()>0) isAnyPiece = true;
            }
            if(isCheck==false && isAnyPiece==false){
                Action temp = new Action(x, y+2, 0);
                temp.willChange.add(new Change(x, y+2, grid[x][y]));
                temp.willChange.add(new Change(x, y+1, grid[x][8]));
                temp.willChange.add(new Change(x, y, new Empty("Hiran", 3)));
                temp.willChange.add(new Change(x, 8, new Empty("Hiran", 3)));
                moves.add(temp);
            }



        }

        if(ChessBoard.entryOfGrid[x][y]==false && ChessBoard.entryOfGrid[x][1]==false){
            boolean isCheck = false, isAnyPiece = false;
            for(int i = 1; i<=y; i++){
                if(PositionAttackedByOpponent.attacked(grid, grid[x][y].getPlayerNo()^1, x, i)==true) isCheck = true;
            }
            for(int i = 2; i<y; i++){
                if(grid[x][i].getPawnType()>0) isAnyPiece = true;
            }
            if(isCheck==false && isAnyPiece==false){
                Action temp = new Action(x, y-2, 0);
                temp.willChange.add(new Change(x, y-2, grid[x][y]));
                temp.willChange.add(new Change(x, y-1, grid[x][1]));
                temp.willChange.add(new Change(x, y, new Empty("Hiran", 3)));
                temp.willChange.add(new Change(x, 1, new Empty("Hiran", 3)));
                moves.add(temp);
            }
        }
        return moves;
    }

    @Override
    public int getPawnType() {
        return 1;
    }

    @Override
    public Drawable getNormalIcon() {
        Drawable icon;
        if(playerNo==1){
            icon = ChessBoard.context.getResources().getDrawable(R.drawable.kingwhite);
        }
        else icon = ChessBoard.context.getResources().getDrawable(R.drawable.kingblack);
        return icon;
    }

    @Override
    public Drawable getAttackedIcon() {
        Drawable icon;
        if(playerNo==1){
            icon = ChessBoard.context.getResources().getDrawable(R.drawable.kingwhiteattack);
        }
        else icon = ChessBoard.context.getResources().getDrawable(R.drawable.kingblackattack);
        return icon;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public boolean[][] canMove(ChessPiece[][] grid, int x, int y) {
        boolean[][] check = new boolean[9][9];
        check[x][y] = true;
        int[] inc = new int[]{1, -1, 0};

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                int tempx = x+inc[i], tempy = inc[j]+y;
                if(tempx>0 && tempx<9 && tempy>0 && tempy<9){
                    check[tempx][tempy] = true;
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
