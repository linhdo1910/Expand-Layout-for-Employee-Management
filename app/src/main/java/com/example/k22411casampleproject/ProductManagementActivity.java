package com.example.k22411casampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.models.Category;
import com.example.models.Product;
import com.example.models.ListCategory;

import java.util.ArrayList;

public class ProductManagementActivity extends AppCompatActivity {

    Spinner spinnerCategory;
    ListView lvProduct;
    ArrayAdapter<Category> categoryAdapter;
    ArrayAdapter<Product> productAdapter;
    ListCategory listCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_management);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addView();
        addEvents();
    }

    private void addView() {
        spinnerCategory = findViewById(R.id.spinnerCategory);
        lvProduct = findViewById(R.id.lvProduct);

        categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(categoryAdapter);

        productAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        lvProduct.setAdapter(productAdapter);

        listCategory = new ListCategory();
        listCategory.generate_sample_dataset();
        categoryAdapter.addAll(listCategory.getCategories());
    }

    private void addEvents() {
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Category selectedCategory = categoryAdapter.getItem(position);
                if (selectedCategory != null) {
                    ArrayList<Product> products = selectedCategory.getProducts();
                    productAdapter.clear();
                    productAdapter.addAll(products);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                productAdapter.clear();
            }
        });

        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = productAdapter.getItem(position);
                openProductDetailActivity(product);
            }
        });
    }

    private void openProductDetailActivity(Product product) {
        Intent intent = new Intent(ProductManagementActivity.this, ProductDetailActivity.class);
        intent.putExtra("SELECTED_PRODUCT", product);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu_product, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_new_product) {
            Toast.makeText(ProductManagementActivity.this, "Mở màn hình thêm sản phẩm mới", Toast.LENGTH_SHORT).show();
            openNewProductActivity();
        } else if (item.getItemId() == R.id.menu_broadcast_advertising) {
            Toast.makeText(ProductManagementActivity.this, "Mở màn hình gửi quảng cáo", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.menu_help) {
            Toast.makeText(ProductManagementActivity.this, "Mở màn hình trợ giúp", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void openNewProductActivity() {
        // hôm sau làm (26/05)
    }
}
