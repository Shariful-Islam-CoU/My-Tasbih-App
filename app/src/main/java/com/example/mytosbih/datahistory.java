package com.example.mytosbih;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

public class datahistory extends AppCompatActivity {

    private TextView av,bv,cv,dv,ev;
    private String a,b,c,d,e;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datahistory);

        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#4C9A9A"));
        actionBar.setBackgroundDrawable(colorDrawable);

        av=(TextView) findViewById(R.id.subhanallah_history_Id);
        bv=(TextView) findViewById(R.id.alhamdulillah_history_Id);
        cv=(TextView) findViewById(R.id.lailaha_history_Id);
        dv=(TextView) findViewById(R.id.allahuakbar_history_Id);
        ev=(TextView) findViewById(R.id.allah_history_Id);


        Bundle bundle= getIntent().getExtras();

        if(bundle!=null){
            a=bundle.getString("key1");
            b=bundle.getString("key2");
            c=bundle.getString("key3");
            d=bundle.getString("key4");
            e=bundle.getString("key5");




        }
        av.setText("সুবহানাল্লাহঃ "+a+" বার");
        bv.setText("আলহামদুলিল্লাহঃ "+b+" বার");
        cv.setText("লা ইলাহা ইল্লাল্লাহঃ "+c+" বার");
        dv.setText("আল্লাহু আকবারঃ "+d+" বার");
        ev.setText("আল্লাহঃ "+e+" বার");

    }
}