package com.hiranmoy.eee.sec.playchess;

public class CheckMate {
    public static boolean check(ChessPiece[][] grid, int move){
        if(!PositionAttackedByOpponent.check(grid, move)) return false;

        for(int i = 1; i<=8; i++){
            for(int j = 1; j<=8; j++){
                if(grid[i][j].getPlayerNo()==(move^1)){
                    if(grid[i][j].ligalMoves(grid, i, j).size()>0) return false;
                }
            }
        }
       return true;
    }
}
