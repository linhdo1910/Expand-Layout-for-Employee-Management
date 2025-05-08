package com.example.k22411casampleproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmployeeManagementActivity extends AppCompatActivity {

    EditText edtName, edtAge, edtDepartment, edtSkills, edtSelfdes;
    LinearLayout employeeListLayout;
    Button btnAddEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_management);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        edtDepartment = findViewById(R.id.edtDepartment);
        edtSkills = findViewById(R.id.edtSkills);
        edtSelfdes = findViewById(R.id.edtSelfdes);
        btnAddEmployee = findViewById(R.id.btnAddEmployee);
        employeeListLayout = findViewById(R.id.employeeListLayout);


        btnAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString().trim();
                String age = edtAge.getText().toString().trim();
                String department = edtDepartment.getText().toString().trim();
                String skills = edtSkills.getText().toString().trim();
                String description = edtSelfdes.getText().toString().trim();

                if (name.isEmpty() || age.isEmpty()) {
                    Toast.makeText(EmployeeManagementActivity.this,
                            "Please enter at least Name and Age!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Tạo để hiển thị thông tin nhân viên mới
                TextView newEmployeeView = new TextView(EmployeeManagementActivity.this);
                newEmployeeView.setText("👤 " + name + "\nAge: " + age + "\nDept: " + department + "\nSkills: " + skills + "\nDesc: " + description);
                newEmployeeView.setBackgroundColor(0xFFEFEFEF);
                newEmployeeView.setPadding(12, 12, 12, 12);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(0, 12, 0, 0);
                newEmployeeView.setLayoutParams(params);


                employeeListLayout.addView(newEmployeeView);


                edtName.setText("");
                edtAge.setText("");
                edtDepartment.setText("");
                edtSkills.setText("");
                edtSelfdes.setText("");
            }
        });
    }
}
