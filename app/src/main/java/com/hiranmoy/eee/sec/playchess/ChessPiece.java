package com.hiranmoy.eee.sec.playchess;

import android.graphics.drawable.Drawable;

import com.hiranmoy.eee.sec.playchess.ChessPieceDirectory.Action;

import java.util.ArrayList;

public interface ChessPiece {
    public ArrayList<Action> ligalMoves(ChessPiece grid[][], int x, int y);
    public int getPawnType();
    public Drawable getNormalIcon();
    public Drawable getAttackedIcon();
    public String getPlayerName();
    public boolean[][] canMove(ChessPiece[][] grid, int x, int y);
    public int getPlayerNo();

}
