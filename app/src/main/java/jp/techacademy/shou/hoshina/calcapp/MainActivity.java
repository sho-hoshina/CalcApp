package jp.techacademy.shou.hoshina.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText text1;
    EditText text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (EditText)findViewById(R.id.text1);
        text2 = (EditText)findViewById(R.id.text2);

        Button btnPuls = (Button)findViewById(R.id.btnPuls);
        btnPuls.setOnClickListener(this);

        Button btnMinus = (Button)findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(this);

        Button btnDivided = (Button)findViewById(R.id.btnDivided);
        btnDivided.setOnClickListener(this);

        Button btnMultiplied = (Button)findViewById(R.id.btnMultiplied);
        btnMultiplied.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        float leftValue;
        float rightValue;
        float ans = 0;

        try {
            leftValue = Float.parseFloat(text1.getText().toString());
            rightValue = Float.parseFloat(text2.getText().toString());
        }catch (NumberFormatException e){
            Log.d("CalcApp", "数値変換エラー");
            return;
        }

        if(v.getId() == R.id.btnPuls)
        {
            ans = leftValue + rightValue;
        }else if(v.getId() == R.id.btnMinus)
        {
            ans = leftValue - rightValue;
        }else if(v.getId() == R.id.btnMultiplied)
        {
            ans = leftValue * rightValue;
        }else if(v.getId() == R.id.btnDivided)
        {
            if(rightValue == 0) {   //0割り
                return;
            }
            ans = leftValue / rightValue;

            /*
            try {
                ans = leftValue / rightValue;
            }catch(ArithmeticException e){
                Log.d("CalcApp", "0割り");
                return;
            }
            */
        }

        Intent intent = new Intent(this, AnsActivity.class);
        intent.putExtra("ANS", ans);
        startActivity(intent);
    }
}
