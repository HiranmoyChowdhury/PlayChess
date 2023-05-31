package com.hiranmoy.eee.sec.playchess;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hiranmoy.eee.sec.playchess.ChessPieceDirectory.Action;
import com.hiranmoy.eee.sec.playchess.ChessPieceDirectory.Bishop;
import com.hiranmoy.eee.sec.playchess.ChessPieceDirectory.Empty;
import com.hiranmoy.eee.sec.playchess.ChessPieceDirectory.Knight;
import com.hiranmoy.eee.sec.playchess.ChessPieceDirectory.Queen;
import com.hiranmoy.eee.sec.playchess.ChessPieceDirectory.Rook;

import java.util.ArrayList;

public class ChessBoard extends AppCompatActivity {
    public static String[] playerName = new String[2];
    public static int move = 0;
    public static TextView name1, name2, message;
    public static ImageView[] button = new ImageView[70];

    public static ChessPiece[][] grid = new ChessPiece[10][10];

    public static Context context;
    public static int pawnx, pawny;

    public static ArrayList<Action> allMoves = new ArrayList<>();

    public static boolean[][] entryOfGrid = new boolean[10][10];

    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess_board);
        name1 = findViewById(R.id.one);
        name2 = findViewById(R.id.two);
        name1.setText("Player 1: "+playerName[1]);
        name2.setText("Player 2: "+playerName[0]);

        context = this;

        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#029587"));
        actionBar.setBackgroundDrawable(colorDrawable);


        button[1] = findViewById(R.id.button1);         button[2] = findViewById(R.id.button2);
        button[3] = findViewById(R.id.button3);         button[4] = findViewById(R.id.button4);
        button[5] = findViewById(R.id.button5);         button[6] = findViewById(R.id.button6);
        button[7] = findViewById(R.id.button7);         button[8] = findViewById(R.id.button8);
        button[9] = findViewById(R.id.button9);         button[10] = findViewById(R.id.button10);
        button[11] = findViewById(R.id.button11);         button[12] = findViewById(R.id.button12);
        button[13] = findViewById(R.id.button13);         button[14] = findViewById(R.id.button14);
        button[15] = findViewById(R.id.button15);         button[16] = findViewById(R.id.button16);
        button[17] = findViewById(R.id.button17);         button[18] = findViewById(R.id.button18);
        button[19] = findViewById(R.id.button19);         button[20] = findViewById(R.id.button20);
        button[21] = findViewById(R.id.button21);         button[22] = findViewById(R.id.button22);
        button[23] = findViewById(R.id.button23);         button[24] = findViewById(R.id.button24);
        button[25] = findViewById(R.id.button25);         button[26] = findViewById(R.id.button26);
        button[27] = findViewById(R.id.button27);         button[28] = findViewById(R.id.button28);
        button[29] = findViewById(R.id.button29);         button[30] = findViewById(R.id.button30);
        button[31] = findViewById(R.id.button31);         button[32] = findViewById(R.id.button32);
        button[33] = findViewById(R.id.button33);         button[34] = findViewById(R.id.button34);
        button[35] = findViewById(R.id.button35);         button[36] = findViewById(R.id.button36);
        button[37] = findViewById(R.id.button37);         button[38] = findViewById(R.id.button38);
        button[39] = findViewById(R.id.button39);         button[40] = findViewById(R.id.button40);
        button[41] = findViewById(R.id.button41);         button[42] = findViewById(R.id.button42);
        button[43] = findViewById(R.id.button43);         button[44] = findViewById(R.id.button44);
        button[45] = findViewById(R.id.button45);         button[46] = findViewById(R.id.button46);
        button[47] = findViewById(R.id.button47);         button[48] = findViewById(R.id.button48);
        button[49] = findViewById(R.id.button49);         button[50] = findViewById(R.id.button50);
        button[51] = findViewById(R.id.button51);         button[52] = findViewById(R.id.button52);
        button[53] = findViewById(R.id.button53);         button[54] = findViewById(R.id.button54);
        button[55] = findViewById(R.id.button55);         button[56] = findViewById(R.id.button56);
        button[57] = findViewById(R.id.button57);         button[58] = findViewById(R.id.button58);
        button[59] = findViewById(R.id.button59);         button[60] = findViewById(R.id.button60);
        button[61] = findViewById(R.id.button61);         button[62] = findViewById(R.id.button62);
        button[63] = findViewById(R.id.button63);         button[64] = findViewById(R.id.button64);

        button[65] = findViewById(R.id.button65);
        button[66] = findViewById(R.id.button66);
        button[67] = findViewById(R.id.button67);
        button[68] = findViewById(R.id.button68);

        /// lastdigit    pawn
         //    1    -    king

        //     2     -   queen

         //    3     -   rook

         //    4     -   bishop

         //    5    -    pawn

         //    6    -    knight

        message = findViewById(R.id.message);
        message.setText(playerName[move]+"'s turn");
        SetChessBoard.set();









    }
    public void performMove(Action move){
        for(int i = 0; i<move.willChange.size(); i++){
            int x = move.willChange.get(i).x, y = move.willChange.get(i).y;
            entryOfGrid[x][y] = true;
            grid[x][y] = move.willChange.get(i).type;
        }
    }

    public void move(int row, int col){

        int pos = -1;
        for(int i = 0; i<allMoves.size(); i++){
            if(allMoves.get(i).x==row && allMoves.get(i).y==col){
                pos = i;
                break;
            }
        }
        if(pos>=0){
            performMove(allMoves.get(pos));
        }
        SetChessBoard.set();
        allMoves = new ArrayList<>();
        if(pos==-1 && grid[row][col].getPlayerNo()!=move){
            return;
        }
        else if(pos==-1){
            allMoves = grid[row][col].ligalMoves(grid, row, col);
           // Log.d("Move bug", "move: "+pos);
            for(int i = 0; i<allMoves.size(); i++){
                int x = allMoves.get(i).x, y = allMoves.get(i).y, flag = allMoves.get(i).flag;
                int buttonNo = ((x-1)*8) + y;
                button[buttonNo].setImageDrawable(grid[x][y].getAttackedIcon());
            }

            return;
        }

        for(int i = 1; i<=8; i++){
            if(grid[1][i].getPawnType()==5){
                pawnx = 1; pawny = i;
                button[65].setImageResource(R.drawable.queenwhiteattack);
                button[66].setImageResource(R.drawable.knightwhiteattack);
                button[67].setImageResource(R.drawable.bishopwhiteattack);
                button[68].setImageResource(R.drawable.rookwhiteattack);
                message.setText(playerName[move]+", please choose something");
                return;
            }
            if(grid[8][i].getPawnType()==5){
                pawnx =8; pawny = i;
                button[65].setImageResource(R.drawable.queenwhiteattack);
                button[66].setImageResource(R.drawable.knightwhiteattack);
                button[67].setImageResource(R.drawable.bishopwhiteattack);
                button[68].setImageResource(R.drawable.rookwhiteattack);
                message.setText(playerName[move]+", please choose something");
                return;
            }

        }

        aftermove();







    }
    public void aftermove(){
        if(CheckMate.check(grid, move)==true){
            String message;
            message = playerName[move]+" is the Winner";
            builder = new AlertDialog.Builder(this);
            builder.setMessage(message)
                    .setCancelable(false)
                    .setPositiveButton("back", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.setTitle("Congratulations");
            alert.show();

        }
        if(Draw.check(grid, move)==true){
            String message;
            message = "Draw";
            builder = new AlertDialog.Builder(this);
            builder.setMessage(message)
                    .setCancelable(false)
                    .setPositiveButton("back", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.setTitle("Play Chess");
            alert.show();
        }


        move^=1;
        message.setText(playerName[move]+"'s turn");
    }

    public void clicked(int pos){
        if(pawnx!=-1) return;
        int row = (pos-1)/8;
        int col = pos%8;
        if(col==0) col = 8;
        row++;
        move(row, col);
    }
    public void Button1(View view){
        clicked(1);
    }
    public void Button2(View view){
        clicked(2);
    }
    public void Button3(View view){
        clicked(3);
    }
    public void Button4(View view){
        clicked(4);
    }
    public void Button5(View view){
        clicked(5);
    }
    public void Button6(View view){
        clicked(6);
    }
    public void Button7(View view){
        clicked(7);
    }
    public void Button8(View view){
        clicked(8);
    }
    public void Button9(View view){
        clicked(9);
    }
    public void Button10(View view){
        clicked(10);
    }
    public void Button11(View view){
        clicked(11);
    }
    public void Button12(View view){
        clicked(12);
    }
    public void Button13(View view){
        clicked(13);
    }
    public void Button14(View view){
        clicked(14);
    }
    public void Button15(View view){
        clicked(15);
    }
    public void Button16(View view){
        clicked(16);
    }
    public void Button17(View view){
        clicked(17);
    }
    public void Button18(View view){
        clicked(18);
    }
    public void Button19(View view){
        clicked(19);
    }
    public void Button20(View view){
        clicked(20);
    }
    public void Button21(View view){
        clicked(21);
    }
    public void Button22(View view){
        clicked(22);
    }
    public void Button23(View view){
        clicked(23);
    }
    public void Button24(View view){
        clicked(24);
    }
    public void Button25(View view){
        clicked(25);
    }
    public void Button26(View view){
        clicked(26);
    }
    public void Button27(View view){
        clicked(27);
    }
    public void Button28(View view){
        clicked(28);
    }
    public void Button29(View view){
        clicked(29);
    }
    public void Button30(View view){
        clicked(30);
    }
    public void Button31(View view){
        clicked(31);
    }
    public void Button32(View view){
        clicked(32);
    }
    public void Button33(View view){
        clicked(33);
    }
    public void Button34(View view){
        clicked(34);
    }
    public void Button35(View view){
        clicked(35);
    }
    public void Button36(View view){
        clicked(36);
    }
    public void Button37(View view){
        clicked(37);
    }
    public void Button38(View view){
        clicked(38);
    }
    public void Button39(View view){
        clicked(39);
    }
    public void Button40(View view){
        clicked(40);
    }
    public void Button41(View view){
        clicked(41);
    }
    public void Button42(View view){
        clicked(42);
    }
    public void Button43(View view){
        clicked(43);
    }
    public void Button44(View view){
        clicked(44);
    }
    public void Button45(View view){
        clicked(45);
    }
    public void Button46(View view){
        clicked(46);
    }
    public void Button47(View view){
        clicked(47);
    }
    public void Button48(View view){
        clicked(48);
    }
    public void Button49(View view){
        clicked(49);
    }
    public void Button50(View view){
        clicked(50);
    }
    public void Button51(View view){
        clicked(51);
    }
    public void Button52(View view){
        clicked(52);
    }
    public void Button53(View view){
        clicked(53);
    }
    public void Button54(View view){
        clicked(54);
    }
    public void Button55(View view){
        clicked(55);
    }
    public void Button56(View view){
        clicked(56);
    }
    public void Button57(View view){
        clicked(57);
    }
    public void Button58(View view){
        clicked(58);
    }
    public void Button59(View view){
        clicked(59);
    }
    public void Button60(View view){
        clicked(60);
    }
    public void Button61(View view){
        clicked(61);
    }
    public void Button62(View view){
        clicked(62);
    }
    public void Button63(View view){
        clicked(63);
    }
    public void Button64(View view){
        clicked(64);
    }
    public void Button65(View view){
        if(pawnx==-1) return;
        for(int i = 65; i<=68; i++) button[i].setImageDrawable(null);
        grid[pawnx][pawny] = new Queen(grid[pawnx][pawny].getPlayerName(), grid[pawnx][pawny].getPlayerNo());
        pawny = pawnx = -1;
        SetChessBoard.set();
        aftermove();

    }
    public void Button66(View view){
        if(pawnx==-1) return;
        for(int i = 65; i<=68; i++) button[i].setImageDrawable(null);
        grid[pawnx][pawny] = new Knight(grid[pawnx][pawny].getPlayerName(), grid[pawnx][pawny].getPlayerNo());
        pawny = pawnx = -1;
        SetChessBoard.set();
        aftermove();
    }
    public void Button67(View view){
        if(pawnx==-1) return;
        for(int i = 65; i<=68; i++) button[i].setImageDrawable(null);
        grid[pawnx][pawny] = new Bishop(grid[pawnx][pawny].getPlayerName(), grid[pawnx][pawny].getPlayerNo());
        pawny = pawnx = -1;
        SetChessBoard.set();
        aftermove();
    }
    public void Button68(View view){
        if(pawnx==-1) return;
        for(int i = 65; i<=68; i++) button[i].setImageDrawable(null);
        grid[pawnx][pawny] = new Rook(grid[pawnx][pawny].getPlayerName(), grid[pawnx][pawny].getPlayerNo());
        pawny = pawnx = -1;
        SetChessBoard.set();
        aftermove();
    }


}