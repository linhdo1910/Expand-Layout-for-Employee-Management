package com.example.k22411casampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.models.Customer;

public class CustomerDetailActivity extends AppCompatActivity {
    EditText edt_customer_id;
    EditText edt_customer_name;
    EditText edt_customer_email;
    EditText edt_customer_phone;
    EditText edt_customer_username;
    EditText edt_customer_password;
    Button btnNew;
    Button btnSave;
    Button btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
    }

    private void addViews() {
        edt_customer_id = findViewById(R.id.edt_customer_id);
        edt_customer_name = findViewById(R.id.edt_customer_name);
        edt_customer_email = findViewById(R.id.edt_customer_email);
        edt_customer_phone = findViewById(R.id.edt_customer_phone);
        edt_customer_username = findViewById(R.id.edt_customer_username);
        edt_customer_password = findViewById(R.id.edt_customer_password);
        display_customer_details();
    }

    private void display_customer_details() {
        //lay intent ben kia gui qua
        Intent intent = getIntent();
        //lay ten bien ma ta doc trong intent:
        Customer customer = (Customer) intent.getSerializableExtra("SELECTED_CUSTOMER");
        edt_customer_id.setText(customer.getId() + "");
        edt_customer_name.setText(customer.getName());
        edt_customer_email.setText(customer.getEmail());
        edt_customer_phone.setText(customer.getPhone());
        edt_customer_username.setText(customer.getUsername());
        edt_customer_password.setText(customer.getPassword());
    }
}