package com.tanamo.osm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tanamo.osm.R;

public class Adder extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adder);

        init();

    }

    private void init() {

        EditText edit1 = findViewById(R.id.lat1);

        EditText edit2 = findViewById(R.id.lat2);

        EditText edit3 = findViewById(R.id.logi1);

        EditText edit4 = findViewById(R.id.logi2);

        Button next = findViewById(R.id.next);

        next.setOnClickListener(
                v -> {
                    Intent intent = new Intent(Adder.this, MainActivity.class);
                    Bundle b = new Bundle();

                    String text1 = edit1.getText().toString();
                    String text2 = edit2.getText().toString();
                    String text3 = edit3.getText().toString();
                    String text4 = edit4.getText().toString();

                    if (!text1.isEmpty() && !text2.isEmpty() && !text3.isEmpty() && !text4.isEmpty()) {
                        b.putDouble("lat1", Double.parseDouble(text1));
                        b.putDouble("lat2", Double.parseDouble(text2));
                        b.putDouble("logi1", Double.parseDouble(text3));
                        b.putDouble("logi2", Double.parseDouble(text4));
                        intent.putExtras(b);
                        startActivity(intent);


                    } else {
                        Toast.makeText(this, "Field Empty !!!", Toast.LENGTH_LONG).show();
                    }


                }
        );


    }


}
