package com.hiranmoy.eee.sec.playchess.ChessPieceDirectory;

import com.hiranmoy.eee.sec.playchess.ChessPiece;

public class Change {
    public int x, y;
    public ChessPiece type;

    public Change(int x, int y, ChessPiece type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}
