package com.example.mytosbih;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button main_button,reset_button,save_button,pronounciation;
    private Spinner spinner;
    private Adapter adapter;
    private String[] buttons,buttons_meanings;
    private String button_name,target_number, button_name_mraning;
    int a=0,c=0,b=0,d=0,e=0,p=0,q=1,r=1,s=1,t=1,u=1,target_value,target_value_a=-1,target_value_b=-1,target_value_c=-1,target_value_d=-1,target_value_e=-1,w=-1,x;
    private TextView countView,target_textView,saved_target;
    private Typeface typeface1;
    private EditText target;
    private AlertDialog.Builder alertBuilder;
    private String start="true",sound="on";
    private ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("আমার তাসবীহ");




        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#4C9A9A"));
        actionBar.setBackgroundDrawable(colorDrawable);



        main_button= (Button) findViewById(R.id.button1Id);
        reset_button= (Button) findViewById(R.id.reset_button1Id);
        save_button= (Button) findViewById(R.id.save_buttonId);
        pronounciation= (Button) findViewById(R.id.pronounciationId);
        spinner=(Spinner) findViewById(R.id.spinnerId);
        countView=(TextView)findViewById(R.id.countId);
        target_textView=(TextView)findViewById(R.id.targetTextviewId);
        target=(EditText) findViewById(R.id.editTextId);
        saved_target=(TextView) findViewById(R.id.saved_target_view_id);


        typeface1= Typeface.createFromAsset(getAssets(),"fonts/digital_number.ttf");
        target.setTypeface(typeface1);
        target_textView.setTypeface(typeface1);
        countView.setTypeface(typeface1);
        saved_target.setTypeface(typeface1);
        buttons=getResources().getStringArray(R.array.buttons);
        buttons_meanings=getResources().getStringArray(R.array.buttons_meanings);

        adapter= new ArrayAdapter<String>(MainActivity.this,R.layout.spinner_sample,R.id.spinner_sample_textView_Id,buttons);

        spinner.setAdapter((SpinnerAdapter) adapter);




                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @SuppressLint({"SetTextI18n", "ResourceType"})
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        button_name=buttons[position];
                        button_name_mraning=buttons_meanings[position];
                //        spinner.setSelection((Integer) adapter.getItem(position));




                        if(start.equals("true")){

                            start="false";
                        }else{
                            if(!button_name.equals("তাসবীহ নির্ধারণ করুণ")){
                                main_button.setText(button_name_mraning);
                            }


                            if(button_name.equals("তাসবীহ নির্ধারণ করুণ")){

                                view.setBackground(colorDrawable);

                                target_textView.setText(null);
                                saved_target.setText("লক্ষ্যঃ অনির্ধারিত");
                                Toast.makeText(MainActivity.this,R.string.alert,Toast.LENGTH_LONG).show();
                            }
                            if(button_name.equals("সুবহানাল্লাহ")){

                                countView.setText(""+a);
                                if(target_value_a>0){
                                    saved_target.setText("লক্ষ্যঃ "+target_value_a);
                                }else {
                                    target_textView.setText(null);
                                    saved_target.setText("লক্ষ্যঃ অনির্ধারিত");
                                }
                            }
                            if(button_name.equals("আলহামদুলিল্লাহ")){

                                countView.setText(""+b);
                                if(target_value_b>0){
                                    saved_target.setText("লক্ষ্যঃ "+target_value_b);
                                }else {
                                    target_textView.setText(null);
                                    saved_target.setText("লক্ষ্যঃ অনির্ধারিত");
                                }
                            }

                            if(button_name.equals("লা ইলাহা ইল্লাল্লাহ")){

                                countView.setText(""+c);
                                if(target_value_c>0){
                                    saved_target.setText("লক্ষ্যঃ "+target_value_c);
                                }else {
                                    target_textView.setText(null);
                                    saved_target.setText("লক্ষ্যঃ অনির্ধারিত");
                                }
                            }

                            if(button_name.equals("আল্লাহু আকবার")){

                                countView.setText(""+d);
                                if(target_value_d>0){
                                    saved_target.setText("লক্ষ্যঃ "+target_value_d);
                                }else {
                                    target_textView.setText(null);
                                    saved_target.setText("লক্ষ্যঃ অনির্ধারিত");
                                }
                            }
                            if(button_name.equals("আল্লাহ")){

                                countView.setText(""+e);
                                if(target_value_e>0){
                                    saved_target.setText("লক্ষ্যঃ "+target_value_e);
                                }else {
                                    target_textView.setText(null);
                                    saved_target.setText("লক্ষ্যঃ অনির্ধারিত");
                                }
                            }
                        }


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });






      main_button.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View v) {

                            if((!button_name.equals("তাসবীহ নির্ধারণ করুণ"))&&(sound.equals("on"))){
                                MediaPlayer player = MediaPlayer.create(MainActivity.this, R.raw.click);
                                player.start();

                            }

                        if(button_name.equals("তাসবীহ নির্ধারণ করুণ")){



                            Toast.makeText(MainActivity.this,R.string.alert2,Toast.LENGTH_LONG).show();
                        }

                        if(button_name.equals("সুবহানাল্লাহ")){
                            a=a+1;
                            countView.setText(""+a);
                            q=target_value_a-a;
                            if((target_value_a>0)&&(q>=0)){


                                target_textView.setText("লক্ষ্য পূরণে আর বাকি "+q);
                                if(q==0){
                                    target_textView.setText("আপনি আপনার লক্ষ্য পূরণ করেছেন।");
                                    if(sound.equals("on")){
                                        MediaPlayer player = MediaPlayer.create(MainActivity.this, R.raw.mashallah1);
                                        player.start();
                                    }

                                    alertBuilder= new AlertDialog.Builder(MainActivity.this);
                                    alertBuilder.setTitle("মাশাআল্লাহ");
                                    alertBuilder.setMessage("আপনি আপনার লক্ষ্য পূরণ করেছেন");
                                    alertBuilder.setCancelable(false);
                                    alertBuilder.setPositiveButton("আলহামদুলিল্লাহ", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                        }

                                    });
                                    AlertDialog alertDialog= alertBuilder.create();
                                    alertDialog.show();
                                }
                            }

                        }




                        if(button_name.equals("আলহামদুলিল্লাহ")){
                            b=b+1;
                            countView.setText(""+b);
                            r=target_value_b-b;
                            if((target_value>0)&&(r>=0)){


                                target_textView.setText("লক্ষ্য পূরণে আর বাকি "+r);
                                if(r==0){
                                    target_textView.setText("আপনি আপনার লক্ষ্য পূরণ করেছেন।");
                                    if(sound.equals("on")){
                                        MediaPlayer player = MediaPlayer.create(MainActivity.this, R.raw.mashallah1);
                                        player.start();
                                    }
                                    alertBuilder= new AlertDialog.Builder(MainActivity.this);

                                    alertBuilder.setTitle("মাশাআল্লাহ");
                                    alertBuilder.setMessage("আপনি আপনার লক্ষ্য পূরণ করেছেন");
                                    alertBuilder.setCancelable(false);
                                    alertBuilder.setPositiveButton("আলহামদুলিল্লাহ", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    });
                                    AlertDialog alertDialog= alertBuilder.create();
                                    alertDialog.show();
                                }
                            }
                        }




                        if(button_name.equals("লা ইলাহা ইল্লাল্লাহ")){

                            c=c+1;

                            countView.setText(""+c);
                            s=target_value_c-c;
                            if((target_value>0)&&(s>=0)){


                                target_textView.setText("লক্ষ্য পূরণে আর বাকি "+s);
                                if(s==0){
                                    target_textView.setText("আপনি আপনার লক্ষ্য পূরণ করেছেন।");
                                    if(sound.equals("on")){
                                        MediaPlayer player = MediaPlayer.create(MainActivity.this, R.raw.mashallah1);
                                        player.start();
                                    }
                                    alertBuilder= new AlertDialog.Builder(MainActivity.this);

                                    alertBuilder.setTitle("মাশাআল্লাহ");
                                    alertBuilder.setMessage("আপনি আপনার লক্ষ্য পূরণ করেছেন");
                                    alertBuilder.setCancelable(false);
                                    alertBuilder.setPositiveButton("আলহামদুলিল্লাহ", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    });
                                    AlertDialog alertDialog= alertBuilder.create();
                                    alertDialog.show();
                                }
                            }
                        }




                        if(button_name.equals("আল্লাহু আকবার")){
                            d=d+1;

                            countView.setText(""+d);
                            t=target_value_d-d;
                            if((target_value>0)&&(t>=0)){


                                target_textView.setText("লক্ষ্য পূরণে আর বাকি "+t);
                                if(t==0){
                                    target_textView.setText("আপনি আপনার লক্ষ্য পূরণ করেছেন।");
                                    if(sound.equals("on")){
                                        MediaPlayer player = MediaPlayer.create(MainActivity.this, R.raw.mashallah1);
                                        player.start();
                                    }
                                    alertBuilder= new AlertDialog.Builder(MainActivity.this);

                                    alertBuilder.setTitle("মাশাআল্লাহ");
                                    alertBuilder.setMessage("আপনি আপনার লক্ষ্য পূরণ করেছেন");
                                    alertBuilder.setCancelable(false);
                                    alertBuilder.setPositiveButton("আলহামদুলিল্লাহ", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    });
                                    AlertDialog alertDialog= alertBuilder.create();
                                    alertDialog.show();
                                }
                            }
                        }





                        if(button_name.equals("আল্লাহ")){
                            e=e+1;

                            countView.setText(""+e);
                            u=target_value_e-e;
                            if((target_value>0)&&(u>=0)){


                                target_textView.setText("লক্ষ্য পূরণে আর বাকি "+u);
                                if(u==0){
                                    target_textView.setText("আপনি আপনার লক্ষ্য পূরণ করেছেন।");
                                    if(sound.equals("on")){
                                        MediaPlayer player = MediaPlayer.create(MainActivity.this, R.raw.mashallah1);
                                        player.start();
                                    }
                                    alertBuilder= new AlertDialog.Builder(MainActivity.this);

                                    alertBuilder.setTitle("মাশাআল্লাহ");
                                    alertBuilder.setMessage("আপনি আপনার লক্ষ্য পূরণ করেছেন");
                                    alertBuilder.setCancelable(false);
                                    alertBuilder.setPositiveButton("আলহামদুলিল্লাহ", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    });
                                    AlertDialog alertDialog= alertBuilder.create();
                                    alertDialog.show();
                                }
                            }
                        }



                    }
                });

reset_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        if(sound.equals("on")){
            MediaPlayer player = MediaPlayer.create(MainActivity.this, R.raw.alert);
            player.start();
        }
        alertBuilder= new AlertDialog.Builder(MainActivity.this);
        alertBuilder.setTitle("সাবধান!");
        alertBuilder.setMessage("আপনি কি পুনরায় শুরু করতে চাচ্ছেন?");
        alertBuilder.setCancelable(false);
        alertBuilder.setNegativeButton("না", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }

        });

        alertBuilder.setPositiveButton("হ্যাঁ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                if(button_name.equals("সুবহানাল্লাহ")){

                    a=0;
                    countView.setText(""+a);
                }
                if(button_name.equals("আলহামদুলিল্লাহ")){

                    b=0;
                    countView.setText(""+b);
                }


                if(button_name.equals("লা ইলাহা ইল্লাল্লাহ")){

                    c=0;
                    countView.setText(""+c);
                }

                if(button_name.equals("আল্লাহু আকবার")){

                    d=0;
                    countView.setText(""+d);
                }
                if(button_name.equals("আল্লাহ")){

                    e=0;
                    countView.setText(""+e);
                }

            }

        });

        AlertDialog alertDialog= alertBuilder.create();
        alertDialog.show();


    }
});


save_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        try{
            q=1;r=1;s=1;t=1;u=1;

            target_number= target.getText().toString();
            target_value= Integer.parseInt(target_number);
            w=target_value;


            if(button_name.equals("তাসবীহ নির্ধারণ করুণ")){

                Toast.makeText(MainActivity.this,R.string.alert4,Toast.LENGTH_LONG).show();
            }
            if(button_name.equals("সুবহানাল্লাহ")){

               target_value_a=target_value;
                if ((target_value_a <= a)) {
                    Toast.makeText(MainActivity.this, "আপনার লক্ষ্য বড় রাখুন", Toast.LENGTH_LONG).show();
                } else {
                    saved_target.setText("লক্ষ্যঃ "+target_value_a);
                    Toast.makeText(MainActivity.this, "আপনার লক্ষ্য সেভ করা হয়েছে", Toast.LENGTH_LONG).show();
                }
            }
            if(button_name.equals("আলহামদুলিল্লাহ")){

                target_value_b=target_value;
                if ((target_value_b <= b)) {
                    Toast.makeText(MainActivity.this, "আপনার লক্ষ্য বড় রাখুন", Toast.LENGTH_LONG).show();
                } else {
                    saved_target.setText("লক্ষ্যঃ "+target_value_b);
                    Toast.makeText(MainActivity.this, "আপনার লক্ষ্য সেভ করা হয়েছে", Toast.LENGTH_LONG).show();
                }
            }

            if(button_name.equals("লা ইলাহা ইল্লাল্লাহ")){

                target_value_c=target_value;
                if ((target_value_c <= c)) {
                    Toast.makeText(MainActivity.this, "আপনার লক্ষ্য বড় রাখুন", Toast.LENGTH_LONG).show();
                } else {
                    saved_target.setText("লক্ষ্যঃ "+target_value_c);
                    Toast.makeText(MainActivity.this, "আপনার লক্ষ্য সেভ করা হয়েছে", Toast.LENGTH_LONG).show();
                }
            }

            if(button_name.equals("আল্লাহু আকবার")){

                target_value_d=target_value;
                if ((target_value_d <= d)) {

                    Toast.makeText(MainActivity.this, "আপনার লক্ষ্য বড় রাখুন", Toast.LENGTH_LONG).show();
                } else {
                    saved_target.setText("লক্ষ্যঃ "+target_value_d);
                    Toast.makeText(MainActivity.this, "আপনার লক্ষ্য সেভ করা হয়েছে", Toast.LENGTH_LONG).show();
                }
            }
            if(button_name.equals("আল্লাহ")){

                target_value_e=target_value;
                if ((target_value_e <= e)) {
                    Toast.makeText(MainActivity.this, "আপনার লক্ষ্য বড় রাখুন", Toast.LENGTH_LONG).show();
                } else {
                    saved_target.setText("লক্ষ্যঃ "+target_value_e);
                    Toast.makeText(MainActivity.this, "আপনার লক্ষ্য সেভ করা হয়েছে", Toast.LENGTH_LONG).show();
                }
            }




        }catch (Exception e){
            Toast.makeText(MainActivity.this,"সেভ করার আগে লক্ষ্য পূরণ করুণ",Toast.LENGTH_LONG).show();
        }



    }
});

pronounciation.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        if(button_name.equals("তাসবীহ নির্ধারণ করুণ")){

            Toast.makeText(MainActivity.this,R.string.alert3,Toast.LENGTH_LONG).show();
        }

        if(button_name.equals("সুবহানাল্লাহ")){

            MediaPlayer player = MediaPlayer.create(MainActivity.this, R.raw.subhanallah);
            player.start();
        }
        if(button_name.equals("আলহামদুলিল্লাহ")){

            MediaPlayer player = MediaPlayer.create(MainActivity.this, R.raw.alhamdu);
            player.start();
        }


        if(button_name.equals("লা ইলাহা ইল্লাল্লাহ")){

            MediaPlayer player = MediaPlayer.create(MainActivity.this, R.raw.lailaha);
            player.start();
        }

        if(button_name.equals("আল্লাহু আকবার")){

            MediaPlayer player = MediaPlayer.create(MainActivity.this, R.raw.allahuakbar_main);
            player.start();
        }
        if(button_name.equals("আল্লাহ")){

            MediaPlayer player = MediaPlayer.create(MainActivity.this, R.raw.allah_main);
            player.start();
        }


    }
});


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater =getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);


        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

        if(item.getItemId()==R.id.soundId){
            if(sound.equals("on")){
                item.setIcon(R.drawable.sound_off);
                sound="off";
            }else{
                item.setIcon(R.drawable.volumeon);
                sound="on";
            }

            return  true;
        }

        if(item.getItemId()==R.id.shareId){
            Toast.makeText(MainActivity.this,"Share is selected",Toast.LENGTH_SHORT).show();

            return  true;
        }

        if(item.getItemId()==R.id.historyId){
            Intent intent= new Intent(MainActivity.this,datahistory.class);
            intent.putExtra("key1",String.valueOf(a));
            intent.putExtra("key2",String.valueOf(b));
            intent.putExtra("key3",String.valueOf(c));
            intent.putExtra("key4",String.valueOf(d));
            intent.putExtra("key5",String.valueOf(e));

            startActivity(intent);

            return  true;
        }
        if(item.getItemId()==R.id.feedbackId){
            Toast.makeText(MainActivity.this,"Feedback is selected",Toast.LENGTH_SHORT).show();

            return  true;
        }
        if(item.getItemId()==R.id.aboutId){
            Toast.makeText(MainActivity.this,"About Us is selected",Toast.LENGTH_SHORT).show();

            return  true;
        }

        return super.onContextItemSelected(item);
    }

}