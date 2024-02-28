//package com.example.yt;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//import android.widget.Toast;
//
//public class ReportInputActivity extends AppCompatActivity {
//    private EditText editTextName,editTextAge,editTextHeight,editTextWeight,editTextLeukocyte,editTextRBC,editTextHaemoglobin,editTextPlatelets,editTextPVC;
//    private RadioGroup radioGroupRegisterGender;
//    private RadioButton radioButtonGenderSelected;
//    private Button buttonSubmit,buttonback;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_report_input);
//        editTextName=findViewById(R.id.editTextName);
//        editTextAge=findViewById(R.id.editTextAge);
//        editTextHeight=findViewById(R.id.editTextHeight);
//        editTextWeight=findViewById(R.id.editTextWeight);
//        editTextHaemoglobin=findViewById(R.id.editTextHaemoglobin);
//        editTextLeukocyte=findViewById(R.id.editTextLeukocyte);
//        editTextPlatelets=findViewById(R.id.editTextPlatelets);
//        editTextPVC=findViewById(R.id.editTextPVC);
//        editTextRBC=findViewById(R.id.editTextRBC);
//
//        radioGroupRegisterGender = findViewById(R.id.radioGroupGender);
//        radioGroupRegisterGender.clearCheck();
//
//        buttonback=findViewById(R.id.buttonback);
//        buttonback.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(ReportInputActivity.this,HomeActivity.class));
//            }
//        });
//
//        buttonSubmit=findViewById(R.id.buttonSubmit);
//        buttonSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int selectedGenderId = radioGroupRegisterGender.getCheckedRadioButtonId();
//                radioButtonGenderSelected = findViewById(selectedGenderId);
//
//                String name = editTextName.getText().toString();
//                String age = editTextAge.getText().toString();
//                String height = editTextHeight.getText().toString();
//                String weight = editTextWeight.getText().toString();
//                String haemoglobin = editTextHaemoglobin.getText().toString();
//                String leukocyte = editTextLeukocyte.getText().toString();
//                String PC = editTextPlatelets.getText().toString();
//                String PCV = editTextPVC.getText().toString();
//                String RBCcount = editTextRBC.getText().toString();
//                String textGender;
//
//                Database db = new Database(getApplicationContext(), "healthcare", null, 1);
//
//                if (TextUtils.isEmpty(name)) {
//                    Toast.makeText(ReportInputActivity.this, "Please write the Name of the Patient", Toast.LENGTH_SHORT).show();
//                    editTextName.setError("Name is required");
//                    editTextName.requestFocus();
//                } else if (TextUtils.isEmpty((age))) {
//                    Toast.makeText(ReportInputActivity.this, "Please Provide the Age of the Patient", Toast.LENGTH_SHORT).show();
//                    editTextAge.setError("Age is required");
//                    editTextAge.requestFocus();
//                } else if (TextUtils.isEmpty(height)) {
//                    Toast.makeText(ReportInputActivity.this, "Please Provide the Height of the Patient", Toast.LENGTH_SHORT).show();
//                    editTextHeight.setError("Height is required");
//                    editTextHeight.requestFocus();
//                } else if (TextUtils.isEmpty(weight)) {
//                    Toast.makeText(ReportInputActivity.this, "Please Provide the Weight of the Patient", Toast.LENGTH_SHORT).show();
//                    editTextWeight.setError("Weight is required");
//                    editTextWeight.requestFocus();
//                } else if (TextUtils.isEmpty(haemoglobin)) {
//                    Toast.makeText(ReportInputActivity.this, "Please Provide the Haemoglobin of the Patient", Toast.LENGTH_SHORT).show();
//                    editTextHaemoglobin.setError("haemoglobin is required");
//                    editTextHaemoglobin.requestFocus();
//                } else if (TextUtils.isEmpty(leukocyte)) {
//                    Toast.makeText(ReportInputActivity.this, "Please Provide the Leukocyte of the Patient", Toast.LENGTH_SHORT).show();
//                    editTextLeukocyte.setError("Leukocyte is required");
//                    editTextLeukocyte.requestFocus();
//                } else if (TextUtils.isEmpty(PC)) {
//                    Toast.makeText(ReportInputActivity.this, "Please Provide the Platelets of the Patient", Toast.LENGTH_SHORT).show();
//                    editTextPlatelets.setError("Platelets is required");
//                    editTextPlatelets.requestFocus();
//                } else if (TextUtils.isEmpty(RBCcount)) {
//                    Toast.makeText(ReportInputActivity.this, "Please Provide the RBC of the Patient", Toast.LENGTH_SHORT).show();
//                    editTextRBC.setError("RBC is required");
//                    editTextRBC.requestFocus();
//                } else if (TextUtils.isEmpty(PCV)) {
//                    Toast.makeText(ReportInputActivity.this, "Please Provide the PVC of the Patient", Toast.LENGTH_SHORT).show();
//                    editTextPVC.setError("PVC is required");
//                    editTextPVC.requestFocus();
//                } else {
//                    Toast.makeText(getApplicationContext(), "record inserted", Toast.LENGTH_SHORT).show();
//
//                    startActivity(new Intent(ReportInputActivity.this, ResultActivity.class));
//                }
//            }
//        });
//    }
//}

//package com.example.yt;
//
//import androidx.appcompat.app.AppCompatActivity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.RadioGroup;
//import android.widget.Toast;
//
//public class ReportInputActivity extends AppCompatActivity {
//    private EditText editTextName, editTextAge, editTextHeight, editTextWeight, editTextLeukocyte, editTextRBC, editTextHaemoglobin, editTextPlatelets, editTextPVC;
//    private Button buttonSubmit, buttonBack;
//    private RadioGroup radioGroupRegisterGender;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_report_input);
//
//        editTextName = findViewById(R.id.editTextName);
//        editTextAge = findViewById(R.id.editTextAge);
//        editTextHeight = findViewById(R.id.editTextHeight);
//        editTextWeight = findViewById(R.id.editTextWeight);
//        editTextHaemoglobin = findViewById(R.id.editTextHaemoglobin);
//        editTextLeukocyte = findViewById(R.id.editTextLeukocyte);
//        editTextPlatelets = findViewById(R.id.editTextPlatelets);
//        editTextPVC = findViewById(R.id.editTextPVC);
//        editTextRBC = findViewById(R.id.editTextRBC);
//
//        radioGroupRegisterGender = findViewById(R.id.radioGroupGender);
//        radioGroupRegisterGender.clearCheck();
//
//        buttonBack = findViewById(R.id.buttonback);
//        buttonBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(ReportInputActivity.this, HomeActivity.class));
//            }
//        });
//
//        buttonSubmit = findViewById(R.id.buttonSubmit);
//        buttonSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name = editTextName.getText().toString();
//                String age = editTextAge.getText().toString();
//                String height = editTextHeight.getText().toString();
//                String weight = editTextWeight.getText().toString();
//                String haemoglobin = editTextHaemoglobin.getText().toString();
//                String leukocyte = editTextLeukocyte.getText().toString();
//                String PC = editTextPlatelets.getText().toString();
//                String PCV = editTextPVC.getText().toString();
//                String RBCcount = editTextRBC.getText().toString();
//
//                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(age) || TextUtils.isEmpty(height) || TextUtils.isEmpty(weight) ||
//                        TextUtils.isEmpty(haemoglobin) || TextUtils.isEmpty(leukocyte) || TextUtils.isEmpty(PC) || TextUtils.isEmpty(RBCcount) || TextUtils.isEmpty(PCV)) {
//                    Toast.makeText(ReportInputActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
//                } else {
//                    // Create a new Database instance and insert the report data into the database
//                    Database db = new Database(getApplicationContext(),"healthcare",null,1);
//                    db.report_input(name, Integer.parseInt(age), Float.parseFloat(height), Float.parseFloat(weight),
//                            Float.parseFloat(haemoglobin), Float.parseFloat(RBCcount), Float.parseFloat(PCV),
//                            Float.parseFloat(leukocyte), Float.parseFloat(PC));
//
//                    Toast.makeText(getApplicationContext(), "Record inserted", Toast.LENGTH_SHORT).show();
//
//                    // Now, you can navigate to the next activity
//                    startActivity(new Intent(ReportInputActivity.this, ResultActivity.class));
//                }
//            }
//        });
//    }
//}
package com.example.yt;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ReportInputActivity extends AppCompatActivity {
    private EditText editTextName, editTextAge, editTextHeight, editTextWeight, editTextLeukocyte, editTextRBC, editTextHaemoglobin, editTextPlatelets, editTextPVC;
    private Button buttonSubmit, buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_input);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHaemoglobin = findViewById(R.id.editTextHaemoglobin);
        editTextLeukocyte = findViewById(R.id.editTextLeukocyte);
        editTextPlatelets = findViewById(R.id.editTextPlatelets);
        editTextPVC = findViewById(R.id.editTextPVC);
        editTextRBC = findViewById(R.id.editTextRBC);


        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonBack = findViewById(R.id.buttonback);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReportInputActivity.this, HomeActivity.class));
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String ageStr = editTextAge.getText().toString();
                String heightStr = editTextHeight.getText().toString();
                String weightStr = editTextWeight.getText().toString();
                String haemoglobinStr = editTextHaemoglobin.getText().toString();
                String leukocyteStr = editTextLeukocyte.getText().toString();
                String plateletsStr = editTextPlatelets.getText().toString();
                String pvcStr = editTextPVC.getText().toString();
                String rbccountStr = editTextRBC.getText().toString();

                // Get the selected gender


                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(ageStr) || TextUtils.isEmpty(heightStr) || TextUtils.isEmpty(weightStr) ||
                        TextUtils.isEmpty(haemoglobinStr) || TextUtils.isEmpty(leukocyteStr) || TextUtils.isEmpty(plateletsStr) ||
                        TextUtils.isEmpty(rbccountStr) || TextUtils.isEmpty(pvcStr) ) {
                    Toast.makeText(ReportInputActivity.this, "Please fill in all the fields correctly", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int age = Integer.parseInt(ageStr);
                        float height = Float.parseFloat(heightStr);
                        float weight = Float.parseFloat(weightStr);
                        float haemoglobin = Float.parseFloat(haemoglobinStr);
                        float leukocyte = Float.parseFloat(leukocyteStr);
                        float platelets = Float.parseFloat(plateletsStr);
                        float pvc = Float.parseFloat(pvcStr);
                        float rbccount = Float.parseFloat(rbccountStr);

                        // Pass data using Intent
                        Intent intent = new Intent(ReportInputActivity.this, ResultActivity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("age", age);
                        intent.putExtra("height", height);
                        intent.putExtra("weight", weight);
                        intent.putExtra("haemoglobin", haemoglobin);
                        intent.putExtra("leukocyte", leukocyte);
                        intent.putExtra("platelets", platelets);
                        intent.putExtra("pvc", pvc);
                        intent.putExtra("rbccount", rbccount);
                        startActivity(intent);
                    } catch (NumberFormatException e) {
                        Toast.makeText(ReportInputActivity.this, "Please enter valid numeric values", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
