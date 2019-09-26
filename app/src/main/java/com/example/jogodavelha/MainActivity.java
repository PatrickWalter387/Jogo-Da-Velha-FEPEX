package com.example.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    char[][] jogoDaVelha = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
    char[] vezJogar = {'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X'};
    int numJogadas=0;
    char vencedor=' ';

    Button btn0_0;
    Button btn0_1;
    Button btn0_2;
    Button btn1_0;
    Button btn1_1;
    Button btn1_2;
    Button btn2_0;
    Button btn2_1;
    Button btn2_2;
    Button btnJogarNovamente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0_0 = findViewById(R.id.btn_0_0);
        btn0_1 = findViewById(R.id.btn_0_1);
        btn0_2 = findViewById(R.id.btn_0_2);
        btn1_0 = findViewById(R.id.btn_1_0);
        btn1_1 = findViewById(R.id.btn_1_1);
        btn1_2 = findViewById(R.id.btn_1_2);
        btn2_0 = findViewById(R.id.btn_2_0);
        btn2_2 = findViewById(R.id.btn_2_2);
        btn2_1 = findViewById(R.id.btn_2_1);
        btnJogarNovamente = findViewById(R.id.btnJogarNovamente);

        btnJogarNovamente.setVisibility(View.GONE);
    }

    public String jogar(int linha, int coluna){
        jogoDaVelha[linha][coluna] = vezJogar[numJogadas];
        numJogadas++;

        testeVelha();


        if(vencedor == 'X' || vencedor == 'O'){
            ganhou();

            Toast.makeText(MainActivity.this,
                    "Parabens Jogador " + vencedor + ", voce ganhou!", Toast.LENGTH_SHORT).show();
        }

        return String.valueOf(jogoDaVelha[linha][coluna]);
    }

    private void testeVelha() {
        //Testes na Horizontal
        if(jogoDaVelha[0][0] == jogoDaVelha[0][1] && jogoDaVelha[0][1] == jogoDaVelha[0][2]){
            vencedor=jogoDaVelha[0][0];
        }
        if(jogoDaVelha[1][0] == jogoDaVelha[1][1] && jogoDaVelha[1][1] == jogoDaVelha[1][2]){
            vencedor=jogoDaVelha[1][0];
        }
        if(jogoDaVelha[2][0] == jogoDaVelha[2][1] && jogoDaVelha[2][1] == jogoDaVelha[2][2]){
            vencedor=jogoDaVelha[2][0];
        }

        //Testes na Vertical
        if(jogoDaVelha[0][0] == jogoDaVelha[1][0] && jogoDaVelha[1][0] == jogoDaVelha[2][0]){
            vencedor=jogoDaVelha[0][0];
        }
        if(jogoDaVelha[0][1] == jogoDaVelha[1][1] && jogoDaVelha[1][1] == jogoDaVelha[2][1]){
            vencedor=jogoDaVelha[0][1];
        }
        if(jogoDaVelha[0][2] == jogoDaVelha[1][2] && jogoDaVelha[1][2] == jogoDaVelha[2][2]){
            vencedor=jogoDaVelha[0][2];
        }

        //Testes na Diagonal
        if(jogoDaVelha[0][0] == jogoDaVelha[1][1] && jogoDaVelha[1][1] == jogoDaVelha[2][2]){
            vencedor=jogoDaVelha[0][0];
        }

        if(jogoDaVelha[0][2] == jogoDaVelha[1][1] && jogoDaVelha[1][1] == jogoDaVelha[2][0]){
            vencedor=jogoDaVelha[0][2];
        }
    }

    public void ganhou(){
        btn2_2.setEnabled(false);
        btn2_1.setEnabled(false);
        btn2_0.setEnabled(false);
        btn1_2.setEnabled(false);
        btn1_1.setEnabled(false);
        btn1_0.setEnabled(false);
        btn0_2.setEnabled(false);
        btn0_1.setEnabled(false);
        btn0_0.setEnabled(false);

        btnJogarNovamente.setVisibility(View.VISIBLE);
    }

    public void jogar0_0(View view) {

        btn0_0.setText(jogar(0, 0));
        btn0_0.setEnabled(false);

    }

    public void jogar0_1(View view) {
        btn0_1.setText(jogar(0, 1));
        btn0_1.setEnabled(false);
    }

    public void jogar0_2(View view) {
        btn0_2.setText(jogar(0, 2));
        btn0_2.setEnabled(false);
    }

    public void jogar1_0(View view) {
        btn1_0.setText(jogar(1, 0));
        btn1_0.setEnabled(false);
    }

    public void jogar1_1(View view) {
        btn1_1.setText(jogar(1, 1));
        btn1_1.setEnabled(false);
    }

    public void jogar1_2(View view) {
        btn1_2.setText(jogar(1, 2));
        btn1_2.setEnabled(false);
    }

    public void jogar2_0(View view) {
        btn2_0.setText(jogar(2, 0));
        btn2_0.setEnabled(false);
    }

    public void jogar2_1(View view) {
        btn2_1.setText(jogar(2, 1));
        btn2_1.setEnabled(false);
    }

    public void jogar2_2(View view) {
        btn2_2.setText(jogar(2, 2));
        btn2_2.setEnabled(false);
    }

    public void jogarNovamente(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        finish();
        startActivity(intent);
    }
}
