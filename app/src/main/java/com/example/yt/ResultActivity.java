package com.example.yt;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

private Button buttonback,buttonfind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age", 0);
        float height = intent.getFloatExtra("height", 0.0f);
        float weight = intent.getFloatExtra("weight", 0.0f);
        float haemoglobin = intent.getFloatExtra("haemoglobin", 0.0f);
        float leukocyte = intent.getFloatExtra("leukocyte", 0.0f);
        float platelets = intent.getFloatExtra("platelets", 0.0f);
        float pvc = intent.getFloatExtra("pvc", 0.0f);
        float rbccount = intent.getFloatExtra("rbccount", 0.0f);

        TextView textViewName = findViewById(R.id.editTextName);
        TextView textViewAge = findViewById(R.id.editTextAge);
        TextView textViewHeight = findViewById(R.id.editTextHeight);
        TextView textViewWeight = findViewById(R.id.editTextWeight);
        TextView textViewHaemoglobin = findViewById(R.id.editTextHaemoglobin);
        TextView textViewLeukocyte = findViewById(R.id.editTextLeukocyte);
        TextView textViewPlatelets = findViewById(R.id.editTextPlatelets);
        TextView textViewPVC = findViewById(R.id.editTextPCV);
        TextView textViewRBCCount = findViewById(R.id.editTextRBC);

        textViewName.setText(name);
        textViewAge.setText(String.valueOf(age));
        textViewHeight.setText(String.valueOf(height));
        textViewWeight.setText(String.valueOf(weight));
        textViewHaemoglobin.setText(String.valueOf(haemoglobin));
        textViewLeukocyte.setText(String.valueOf(leukocyte));
        textViewPlatelets.setText(String.valueOf(platelets));
        textViewPVC.setText(String.valueOf(pvc));
        textViewRBCCount.setText(String.valueOf(rbccount));
    int color;
        // Define thresholds and messages for RBCCount
        String messageRBCCount = "";
        if (rbccount < 4) {
            messageRBCCount = rbccount + " You may have Anemia";
            color = Color.RED;
        } else if (rbccount > 5.5) {
            messageRBCCount = rbccount + " You may have Polycythemia";
            color = Color.RED;
        } else {
            messageRBCCount = rbccount + "Your RBC count is within the normal range.";
            color = Color.GREEN;
        }

        // Define thresholds and messages for Haemoglobin
        String messageHaemoglobin = "";
        if (haemoglobin < 12.1) {
            messageHaemoglobin = haemoglobin + " You may have Anemia";
            color = Color.RED;
        } else if (haemoglobin > 17.2) {
            messageHaemoglobin = haemoglobin + " You may have Polycythemia";
            color = Color.RED;
        } else {
            messageHaemoglobin = haemoglobin + "Your haemoglobin is within the normal range.";
            color = Color.GREEN;
        }

        // Define thresholds and messages for Leukocyte
        String messageLeukocyte = "";
        if (leukocyte < 4500) {
            messageLeukocyte = leukocyte + " You have a low leukocyte count.";
            color = Color.RED;
        } else if (leukocyte > 11000) {
            messageLeukocyte = leukocyte + " You have a high leukocyte count.";
            color = Color.RED;
        } else {
            messageLeukocyte = leukocyte + " Your leukocyte count is within the normal range.";
            color = Color.GREEN;
        }

        // Define thresholds and messages for Platelets
        String messagePlatelets = "";
        if (platelets < 150000) {
            messagePlatelets = platelets + " You have a low platelet count.";
            color = Color.RED;
        } else if (platelets > 450000) {
            messagePlatelets = platelets + " You have a high platelet count.";
            color = Color.RED;
        } else {
            messagePlatelets = platelets + " Your platelet count is within the normal range.";
            color = Color.GREEN;
        }

        // Define thresholds and messages for PCV
        String messagePCV = "";
        if (pvc < 35.5) {
            messagePCV = pvc + " You have a low PCV.";
            color = Color.RED;
        } else if (pvc > 48.6) {
            messagePCV = pvc + " You have a high PCV.";
            color = Color.RED;
        } else {
            messagePCV = pvc + " Your PCV is within the normal range.";
            color = Color.GREEN;
        }

        // Find TextViews for messages and set their values
        TextView messageRBCCountTextView = findViewById(R.id.editTextRBC);
        messageRBCCountTextView.setText(messageRBCCount);
        textViewRBCCount.setTextColor(color);

        TextView messageHaemoglobinTextView = findViewById(R.id.editTextHaemoglobin);
        messageHaemoglobinTextView.setText(messageHaemoglobin);
        textViewHaemoglobin.setTextColor(color);

        TextView messageLeukocyteTextView = findViewById(R.id.editTextLeukocyte);
        messageLeukocyteTextView.setText(messageLeukocyte);
        textViewLeukocyte.setTextColor(color);

        TextView messagePlateletsTextView = findViewById(R.id.editTextPlatelets);
        messagePlateletsTextView.setText(messagePlatelets);
        textViewPlatelets.setTextColor(color);

        TextView messagePCVTextView = findViewById(R.id.editTextPCV);
        messagePCVTextView.setText(messagePCV);
        textViewPVC.setTextColor(color);



        buttonback=findViewById(R.id.buttonback);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ResultActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        buttonfind=findViewById(R.id.ButtonFindDoctor);
        buttonfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ResultActivity.this,FindDoctorActivity.class);
                startActivity(intent);
            }
        });
    }


}
