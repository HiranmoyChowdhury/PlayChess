package com.hiranmoy.eee.sec.playchess.ChessPieceDirectory;

import android.graphics.drawable.Drawable;

import com.hiranmoy.eee.sec.playchess.ChessBoard;
import com.hiranmoy.eee.sec.playchess.ChessPiece;
import com.hiranmoy.eee.sec.playchess.R;

import java.util.ArrayList;

public class Queen implements ChessPiece {
    private String playerName;

    private int playerNo;

    public Queen(String playerName, int playerNo) {
        this.playerName = playerName;
        this.playerNo = playerNo;
    }

    @Override
    public ArrayList<Action> ligalMoves(ChessPiece[][] grid, int x, int y) {
        ArrayList<Action> moves = new ArrayList<>();
        ChessPiece rook = new Rook("Hiran", 2);
        ChessPiece bishop = new Bishop("Hiran", 2);

        ArrayList<Action> tempMoves = rook.ligalMoves(grid, x, y);

        for(int i = 0; i<tempMoves.size(); i++){
            moves.add(tempMoves.get(i));
        }
        tempMoves = bishop.ligalMoves(grid, x, y);
        for(int i = 0; i<tempMoves.size(); i++) moves.add(tempMoves.get(i));

        return moves;
    }

    @Override
    public int getPawnType() {
        return 2;
    }

    @Override
    public Drawable getNormalIcon() {
        Drawable icon;
        if(playerNo==1){
            icon = ChessBoard.context.getResources().getDrawable(R.drawable.queenwhite);
        }
        else icon = ChessBoard.context.getResources().getDrawable(R.drawable.queenblack);
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

        ChessPiece rook = new Rook("Hiran", 2);
        ChessPiece bishop = new Bishop("Hiran", 2);

        boolean[][] temp = rook.canMove(grid, x, y);
        boolean[][] check = bishop.canMove(grid, x, y);

        for(int i = 1; i<=8; i++) for(int j = 1; j<=8; j++) if(temp[i][j]==true) check[i][j] = true;
        check[x][y] = false;
        return check;
    }

    @Override
    public int getPlayerNo() {
        return playerNo;
    }
}
