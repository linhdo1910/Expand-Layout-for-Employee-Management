package com.example.k22411casampleproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.utils.BMIStatus;
import com.example.utils.Healthcare;

import org.w3c.dom.Text;

public class EmployeeHealthcareActivity extends AppCompatActivity {
    EditText edtHeight;
    EditText edtWeight;
    TextView txtResult;
    Button btnCalculate;
    Button btnClear;
    Button btnClose;

    View.OnClickListener myClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_healthcare);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addView();
        addEvents();
    }
    private void addEvents(){
        myClick=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xu ly su kien chi tiet
                if (v.equals(btnCalculate))
                {
                    //nut calculate dang dung su kien
                    double h=Double.parseDouble(edtHeight.getText().toString());
                    double w=Double.parseDouble(edtWeight.getText().toString());
                    BMIStatus bmiStatus= Healthcare.calculate_bmi(h,w);
                    txtResult.setText(bmiStatus.getBMI()+"=>"+bmiStatus.getDescription());
                }
                else if (v.equals(btnClear)) {
                    //nut clear dang dung su kien
                    edtHeight.setText("");
                    edtWeight.setText("");
                    txtResult.setText("");
                    edtWeight.requestFocus();
                }
                else if(v.equals(btnClose)){
                    //nut close dang dung su kien
                    finish();
                }
            }
        };
        //gan chia se chung su kien
        btnCalculate.setOnClickListener(myClick);
        btnClear.setOnClickListener(myClick);
        btnClose.setOnClickListener(myClick);
    }
    private void addView(){
        txtResult=findViewById(R.id.txtResult);
        edtHeight=findViewById(R.id.edtHeight);
        edtWeight=findViewById(R.id.edtWeight);
        btnCalculate=findViewById(R.id.btnCalculate);
        btnClear=findViewById(R.id.btnClear);
        btnClose=findViewById(R.id.btnClose);
    }
}