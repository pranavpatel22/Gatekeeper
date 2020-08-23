package com.example.d1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.d1.puser.Puser;
import com.example.d1.puser.PuserDao;
import com.example.d1.puser.PuserDatabase;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class ventry extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageView img;
    Bitmap myimage;
    EditText name,number,place,member,vd;
    PuserDao puserDao;
    UserDao userDAO;
    Button btn;
    RadioButton r1,r2;
    Spinner reason;
    String gender,pr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventry);
        img =findViewById(R.id.image);

        name = findViewById(R.id.editText);
        number = findViewById(R.id.editText2);

        place = findViewById(R.id.editText4);
        member = findViewById(R.id.editText5);
        vd=findViewById(R.id.editText6);
        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);
        if(r2.isChecked()){
             gender=r2.getText().toString();
        }

        btn=findViewById(R.id.pbtn);
        reason = findViewById(R.id.spin);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.reasone,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reason.setAdapter(adapter);
        reason.setOnItemSelectedListener(this);


        userDAO=UserDatabase.getDBInstance(this).userDao();
        puserDao= PuserDatabase.getDBInstance(this).puserDao();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name.getText().toString().isEmpty() || number.getText().toString().isEmpty()  || place.getText().toString().isEmpty() || member.getText().toString().isEmpty()
                        || myimage==null){
                    Toast.makeText(ventry.this, "User data missing" , Toast.LENGTH_LONG).show();
                }
                else{
                    Puser puser = new Puser();
                    puser.setName(name.getText().toString());
                    puser.setNumber(number.getText().toString());
                    puser.setReason(pr);
                    puser.setPlace(place.getText().toString());
                    puser.setMember(member.getText().toString());
                    puser.setImage(DataConveter.convertImage2ByteArray(myimage));
                    puser.setVehicalD(vd.getText().toString());
                    puserDao.insertUser(puser);
                    Toast.makeText(ventry.this, "Visitor is added to permanent" , Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    public void save(View view) {


        if(name.getText().toString().isEmpty() || number.getText().toString().isEmpty()  || place.getText().toString().isEmpty() || member.getText().toString().isEmpty()
        || myimage==null || vd.getText().toString().isEmpty()){
            Toast.makeText(ventry.this, "User data missing" , Toast.LENGTH_LONG).show();
        }
        else{
            User user = new User();
            user.setName(name.getText().toString());
            user.setNumber(number.getText().toString());
            user.setReason(pr);
            user.setPlace(place.getText().toString());
            user.setMember(member.getText().toString());
            user.setVehicalD(vd.getText().toString());
            user.setImage(DataConveter.convertImage2ByteArray(myimage));

            userDAO.insertUser(user);
            Toast.makeText(ventry.this, "Visitor is added" , Toast.LENGTH_LONG).show();

        }

    }
    public void capture(View view) {

        Intent myintent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(myintent, 0);
        Toast.makeText(ventry.this, "Opening Camera" + "", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        myimage = (Bitmap) data.getExtras().get("data");
        img.setImageBitmap(myimage);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();
        pr=text;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}