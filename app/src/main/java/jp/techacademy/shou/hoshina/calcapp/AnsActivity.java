package jp.techacademy.shou.hoshina.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ans);

        Intent intent = getIntent();
        float ans = intent.getFloatExtra("ANS", 0);

        TextView textView = (TextView)findViewById(R.id.txtAns);
        textView.setText(String.valueOf(ans));
    }
}
