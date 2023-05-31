package com.hiranmoy.eee.sec.playchess.ChessPieceDirectory;

import android.graphics.drawable.Drawable;

import com.hiranmoy.eee.sec.playchess.ChessBoard;
import com.hiranmoy.eee.sec.playchess.ChessPiece;
import com.hiranmoy.eee.sec.playchess.R;

import java.util.ArrayList;

public class Empty implements ChessPiece {
    private String PlayerName;

    private int playerNo;

    public Empty(String playerName, int playerNo) {
        this.PlayerName = playerName;
        this.playerNo = playerNo;
    }

    @Override
    public ArrayList<Action> ligalMoves(ChessPiece[][] grid, int x, int y) {
        return new ArrayList<Action>();
    }

    @Override
    public int getPawnType() {
        return 0;
    }

    @Override
    public Drawable getNormalIcon() {
        return null;
    }

    @Override
    public Drawable getAttackedIcon() {
        Drawable icon = ChessBoard.context.getResources().getDrawable(R.drawable.dotattack);
        return icon;
    }

    @Override
    public String getPlayerName() {
        return PlayerName;
    }

    @Override
    public boolean[][] canMove(ChessPiece[][] grid, int x, int y) {
        return new boolean[9][9];
    }

    @Override
    public int getPlayerNo() {
        return this.playerNo;
    }
}
