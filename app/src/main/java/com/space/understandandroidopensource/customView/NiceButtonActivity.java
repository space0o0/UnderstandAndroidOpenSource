package com.space.understandandroidopensource.customView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.space.understandandroidopensource.R;

public class NiceButtonActivity extends AppCompatActivity {

    NiceButton niceButton;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nice_button);

        niceButton = findViewById(R.id.niceButton);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                niceButton.calculatePath();
            }
        });

    }
}
