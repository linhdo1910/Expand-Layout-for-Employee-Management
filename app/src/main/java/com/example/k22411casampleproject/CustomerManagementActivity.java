package com.example.k22411casampleproject;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.models.Customer;
import com.example.models.ListCustomer;
import com.example.models.ListEmployee;

public class CustomerManagementActivity extends AppCompatActivity {
    ListView lvCustomer;
    ArrayAdapter<Customer> adapter;
    ListCustomer lc = new ListCustomer();
    MenuItem menu_new_customer;
    MenuItem menu_new_broadcast_advertising;
    MenuItem menu_new_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();

    }

    private void addEvents() {
        lvCustomer.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Customer customer = adapter.getItem(position);
                openNewCustomerDetailActivity(customer);
            }
        });
    }

    private void openNewCustomerDetailActivity(Customer customer) {
        Intent intent = new Intent(CustomerManagementActivity.this, CustomerDetailActivity.class);
        intent.putExtra("SELECTED_CUSTOMER", customer);
        startActivity(intent);
    }


    private void addViews() {
        lvCustomer = findViewById(R.id.lvCustomer);
        adapter = new ArrayAdapter<>(CustomerManagementActivity.this, android.R.layout.simple_list_item_1);
        lc.generate_sample_dataset();
        adapter.addAll(lc.getCustomers());
        lvCustomer.setAdapter(adapter);

        menu_new_customer=findViewById(R.id.menu_new_customer);
        menu_new_broadcast_advertising=findViewById(R.id.menu_broadcast_advertising);
        menu_new_help=findViewById(R.id.menu_help);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu_customer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       if (item.getItemId()==R.id.menu_new_customer) {
           Toast.makeText(CustomerManagementActivity.this, "Mở màn hình thêm khách hàng mới", Toast.LENGTH_SHORT).show();
           openNewCustomerActivity();
       }
       else if (item.getItemId()==R.id.menu_broadcast_advertising) {
           Toast.makeText(CustomerManagementActivity.this, "Mở màn hình gửi quảng cáo", Toast.LENGTH_SHORT).show();
       }
       else if (item.getItemId()==R.id.menu_help) {
           Toast.makeText(CustomerManagementActivity.this, "Mở màn hình trợ giúp", Toast.LENGTH_SHORT).show();
       }
        return super.onOptionsItemSelected(item);
    }

    private void openNewCustomerActivity() {
        //hôm sau làm (26/05)

    }
}