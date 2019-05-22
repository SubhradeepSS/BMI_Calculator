package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView result;
    private LinearLayout bg;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);

    }

    public void calculateBMI(View v)
    {

    String heightStr = height.getText().toString();
    String weightStr = weight.getText().toString();
        String invalid="Please enter the weight value";
        String invalid2="Please enter the height value";
        String invalid3="Please enter height and weight value";

    if(!"".equals(heightStr)&&!"".equals(weightStr))
    {
        float heightValue = Float.parseFloat(heightStr) / 100;
        float weightValue = Float.parseFloat(weightStr);
        float bmi = weightValue / (heightValue * heightValue);
        displayBMI(bmi,heightValue,weightValue);
    }
    else if("".equals(heightStr)&&!"".equals(weightStr))
        result.setText(invalid2);
    else if(!"".equals(heightStr)&&"".equals(weightStr))
        result.setText(invalid);
    else
        result.setText(invalid3);

}
private void displayBMI(float bmi,float heightvalue,float weightvalue)
{
    String bmiLabel="";
    if(Float.compare(heightvalue,0f)!=0&&Float.compare(weightvalue,0f)!=0) {
        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = getString(R.string.very_severely_underweight);
        } else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0) {
            bmiLabel = getString(R.string.severely_underweight);
        } else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.underweight);
        } else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0) {
            bmiLabel = getString(R.string.normal);
        } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0) {
            bmiLabel = getString(R.string.overweight);
        } else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0) {
            bmiLabel = getString(R.string.obese_class_i);
        } else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0) {
            bmiLabel = getString(R.string.obese_class_ii);
        } else {
            bmiLabel = getString(R.string.obese_class_iii);
        }
        bmiLabel = bmi + "\n\n" + bmiLabel;
    }
    else if(Float.compare(heightvalue,0f)!=0&&Float.compare(weightvalue,0f)==0)
        bmiLabel="Please enter a valid (non-zero) weight";
    else if(Float.compare(heightvalue,0f)==0&&Float.compare(weightvalue,0f)!=0)
        bmiLabel="Please enter a valid (non-zero) height";
    else
        bmiLabel="Please enter valid (non-zero) weight and height";
    result.setText(bmiLabel);
}
}

