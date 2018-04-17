package com.example.user.HW5.MainActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    Button b1;
    SharedPreferences sharedPreferences;

    public static final String MyPREFERENCES = "MyPreferences" ;
    public static final String Value1 = "value1Key";
    public static final String Value2 = "value2Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.editext1);
        et2 = (EditText) findViewById(R.id.editext2);
        b1 = (Button) findViewById(R.id.button);

        sharedPreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        et1.setText(sharedPreferences.getString(Value1,""));
        et2.setText(sharedPreferences.getString(Value2,""));


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n  = et1.getText().toString();
                String ph  = et2.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(Value1, n);
                editor.putString(Value2, ph);
                editor.commit();
                Toast.makeText(MainActivity.this,"Till Next Time!",Toast.LENGTH_LONG).show();
            }
        });



    }
}
