package com.hiranmoy.eee.sec.playchess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hiranmoy.eee.sec.playchess.ChessPieceDirectory.Bishop;
import com.hiranmoy.eee.sec.playchess.ChessPieceDirectory.Empty;
import com.hiranmoy.eee.sec.playchess.ChessPieceDirectory.King;
import com.hiranmoy.eee.sec.playchess.ChessPieceDirectory.Knight;
import com.hiranmoy.eee.sec.playchess.ChessPieceDirectory.Pawn;
import com.hiranmoy.eee.sec.playchess.ChessPieceDirectory.Queen;
import com.hiranmoy.eee.sec.playchess.ChessPieceDirectory.Rook;

public class MainActivity extends AppCompatActivity {
    public static EditText player1, player2;
    public static TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1 = findViewById(R.id.onename);
        player2 = findViewById(R.id.twoname);
        message = findViewById(R.id.message);

    }
    public void go(View view){
        String playerOneName = player1.getText().toString();
        String playerTwoName = player2.getText().toString();
        if(playerOneName.length()==0){
            message.setText("*Player 1 doesn't have any name");
        } else if (playerTwoName.length()==0) {
            message.setText("*Player 2 doesn't have any name");
        }
        else{
            ChessBoard.move = 1;
            ChessBoard.playerName[1] = playerOneName;
            ChessBoard.playerName[0] = playerTwoName;

            for(int i = 0; i<10; i++) for(int j = 0; j<10; j++) ChessBoard.grid[i][j] = new Empty(null, 3);
            for(int i = 0; i<9; i++) for(int j = 0; j<9; j++) ChessBoard.entryOfGrid[i][j] = false;

            for(int i = 1; i<=8; i++){
                ChessBoard.grid[7][i] = new Pawn(playerOneName, 1); //pawn
                ChessBoard.grid[2][i] = new Pawn(playerTwoName, 0);
            }
            ChessBoard.grid[8][1] = ChessBoard.grid[8][8] = new Rook(playerOneName, 1);
            ChessBoard.grid[8][2] = ChessBoard.grid[8][7] = new Knight(playerOneName, 1);
            ChessBoard.grid[8][3] = ChessBoard.grid[8][6] = new Bishop(playerOneName, 1);
            ChessBoard.grid[8][4] = new Queen(playerOneName, 1);
            ChessBoard.grid[8][5] = new King(playerOneName, 1);

            ChessBoard.grid[1][1] = ChessBoard.grid[1][8] = new Rook(playerTwoName, 0);
            ChessBoard.grid[1][2] = ChessBoard.grid[1][7] = new Knight(playerTwoName, 0);
            ChessBoard.grid[1][3] = ChessBoard.grid[1][6] = new Bishop(playerTwoName, 0);
            ChessBoard.grid[1][4] = new Queen(playerTwoName, 0);
            ChessBoard.grid[1][5] = new King(playerTwoName, 0);

            ChessBoard.pawnx = ChessBoard.pawny = -1;
            message.setText(" ");

            Intent i = new Intent(getApplicationContext(),ChessBoard.class);
            startActivity(i);
        }

    }
}