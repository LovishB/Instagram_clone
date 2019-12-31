package com.example.instagram_clone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button submit;
    private EditText name;
    private EditText email;
    private EditText pass;
    private TextView get_name;
    private TextView get_email;
    private TextView get_password;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit=findViewById(R.id.btn01);
        name=findViewById(R.id.field01);
        email=findViewById(R.id.field02);
        pass=findViewById(R.id.field03);

        get_name=findViewById(R.id.view01);
        get_email=findViewById(R.id.view02);
        get_password=findViewById(R.id.view03);
        message="";

        //final ParseObject Registered_Users=new ParseObject("Registered_Users");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseQuery<ParseObject> query=ParseQuery.getQuery("Registered_Users");

                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        if(e==null){
                            if(objects.size()>0){
                                for(ParseObject parseObject : objects)
                                {
                                    message=message+ parseObject.get("Username") + "\n";
                                    FancyToast.makeText(MainActivity.this,message,FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                                }


                            }
                        }

                    }
                });

               /* query.getInBackground("PliqsFHwMY", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {
                        if(e==null && object!=null)
                        {
                            FancyToast.makeText(MainActivity.this,"HOLA",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                            get_name.setText("Username: "+object.get("Username").toString());
                            get_password.setText("Password: "+object.get("Password").toString());
                            get_email.setText("Email: "+object.get("Email").toString());
                        }
                    }
                });

                */

            }
        });


    }
}
