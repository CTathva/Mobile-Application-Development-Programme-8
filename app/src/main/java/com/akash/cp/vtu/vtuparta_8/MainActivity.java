package com.akash.cp.vtu.vtuparta_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Base{
    Button call, save, delete;
    Button mButtonZero, mButtonOne, mButtonTwo, mButtonThree, mButtonFour, mButtonFive, mButtonSix, mButtonSeven, mButtonEight, mButtonNine;
    Button  mButtonHash,  mButtonStar;
    EditText editText;
    String number;
    private static final int request_code=100;
    private static final int request_code2=101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        listener();
    }

    @Override
    public void init() {
        editText = (EditText) findViewById(R.id.edit_text);
        call = (Button) findViewById(R.id.call);
        save = (Button) findViewById(R.id.save);
        delete = (Button) findViewById(R.id.delete_btn);
        mButtonZero = (Button) findViewById(R.id.zero);
        mButtonOne = (Button) findViewById(R.id.one);
        mButtonTwo = (Button) findViewById(R.id.two);
        mButtonThree = (Button) findViewById(R.id.three);
        mButtonFour = (Button) findViewById(R.id.four);
        mButtonFive = (Button) findViewById(R.id.five);
        mButtonSix = (Button) findViewById(R.id.six);
        mButtonSeven = (Button) findViewById(R.id.seven);
        mButtonEight = (Button) findViewById(R.id.eight);
        mButtonNine = (Button) findViewById(R.id.nine);
        mButtonHash=(Button)findViewById(R.id.hash);
        mButtonStar=(Button)findViewById(R.id.star);
    }

    @Override
    public void listener() {
        mButtonHash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=editText.getText().toString()+"#";
                editText.setText(number);
                focusCursor(number);

            }
        });
        mButtonStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=editText.getText().toString()+"*";
                editText.setText(number);
                focusCursor(number);

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               editText.setText(delete(editText.getText().toString())) ;
                focusCursor(editText.getText().toString());

            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = editText.getText().toString();
                if (!number.equals("") && number.length()==10){
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            request_code2);
                }
                else {
                    Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editText.getText().toString().equals("") && editText.getText().toString().length()==10)
                {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.WRITE_CONTACTS},
                            request_code);
                }
                else {
                    Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }


            }
        });
        mButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=editText.getText().toString()+"1";
                editText.setText(number);
                focusCursor(number);

            }
        });
        mButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=editText.getText().toString()+"2";
                editText.setText(number);
                focusCursor(number);

            }
        });
        mButtonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=editText.getText().toString()+"3";
                editText.setText(number);
                focusCursor(number);

            }
        });
        mButtonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=editText.getText().toString()+"4";
                editText.setText(number);
                focusCursor(number);

            }
        });
        mButtonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=editText.getText().toString()+"5";
                editText.setText(number);
                focusCursor(number);

            }
        });
        mButtonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=editText.getText().toString()+"6";
                editText.setText(number);
                focusCursor(number);

            }
        });
        mButtonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=editText.getText().toString()+"7";
                editText.setText(number);
                focusCursor(number);

            }
        });
        mButtonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=editText.getText().toString()+"8";
                editText.setText(number);
                focusCursor(number);
            }
        });
        mButtonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=editText.getText().toString()+"9";
                editText.setText(number);
                focusCursor(number);

            }
        });
        mButtonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=editText.getText().toString()+"0";
                editText.setText(number);
                focusCursor(number);
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case request_code: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Intent contactIntent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    contactIntent
                            .putExtra(ContactsContract.Intents.Insert.PHONE, editText.getText().toString())
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.NAME, "Some Name");
                    startActivity(contactIntent);
                }
                return;

            }
            case request_code2: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", number, null));
                    startActivity(intent);
                }
            }
        }
    }
    private void focusCursor(String str)
    {
        if(str.length()<=10) {
            editText.setSelection(str.length());
        }
    }
    private String delete(String str)
    {
        if(!TextUtils.isEmpty(str)) {
            return str.substring(0, str.length() - 1);
        }
        else
        {
            return "";
        }

    }

}

