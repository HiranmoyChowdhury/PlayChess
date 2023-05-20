package com.hiranmoy.eee.sec.playchess.ChessPieceDirectory;
import java.util.ArrayList;

public class Action {
    public int x, y, flag;  ///flag==0 means green
    public ArrayList<Change> willChange;

    public Action(int x, int y, int flag) {
        this.x = x;
        this.y = y;
        this.flag = flag;
        this.willChange = new ArrayList<>();
    }
}
