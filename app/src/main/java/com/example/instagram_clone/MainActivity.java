package com.example.instagram_clone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity {

    private Button submit;
    private EditText name;
    private EditText email;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit=findViewById(R.id.btn01);
        name=findViewById(R.id.field01);
        email=findViewById(R.id.field02);
        pass=findViewById(R.id.field03);

        final ParseObject Registered_Users=new ParseObject("Registered_Users");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registered_Users.put("Username",name.getText().toString());
                Registered_Users.put("Email",email.getText().toString());
                Registered_Users.put("Password",pass.getText().toString());
                Registered_Users.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e==null)
                        {
                            FancyToast.makeText(MainActivity.this,"Successfully Signed",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                        }
                        else
                        {
                            FancyToast.makeText(MainActivity.this,"Registration Failed",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                        }
                    }
                });
            }
        });


    }
}
