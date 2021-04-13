package com.example.unittesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainViewModel mainViewModel;

    private EditText edtWidth, edtHeight, edtLength;
    private TextView tvResult;
    private Button btnCalculateVolume, btnCalculateSurfaceArea, btnCalculateCircumference, btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new MainViewModel(new CuboidModel());

        edtWidth = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        edtLength = findViewById(R.id.edt_length);
        tvResult = findViewById(R.id.tv_result);
        btnSave = findViewById(R.id.btn_save);
        btnCalculateCircumference = findViewById(R.id.btn_calculate_circumference);
        btnCalculateSurfaceArea = findViewById(R.id.btn_calculate_surface_area);
        btnCalculateVolume = findViewById(R.id.btn_calculate_volume);

        btnSave.setOnClickListener(this);
        btnCalculateVolume.setOnClickListener(this);
        btnCalculateSurfaceArea.setOnClickListener(this);
        btnCalculateCircumference.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String length = edtLength.getText().toString().trim();
        String width =edtWidth.getText().toString().trim();
        String height = edtHeight.getText().toString().trim();

        if (TextUtils.isEmpty(length)){
            edtLength.setError("Field ini tidak boleh kosong");
        } else if (TextUtils.isEmpty(width)){
            edtWidth.setError("Field ini tidak boleh kosong");
        } else if (TextUtils.isEmpty(height)){
            edtHeight.setError("Field ini tidak boleh kosong");
        } else {
            double l = Double.parseDouble(length);
            double h = Double.parseDouble(height);
            double w = Double.parseDouble(width);

            if (view.getId() == R.id.btn_save) {
                mainViewModel.save(l, w, h);
                visible();
            } else if (view.getId() == R.id.btn_calculate_circumference){
                tvResult.setText(String.valueOf(mainViewModel.getCircumeference()));
                gone();
            } else if (view.getId() == R.id.btn_calculate_surface_area){
                tvResult.setText(String.valueOf(mainViewModel.getSurfaceArea()));
                gone();
            } else if (view.getId() == R.id.btn_calculate_volume){
                tvResult.setText(String.valueOf(mainViewModel.getVolume()));
                gone();
            }
        }

    }

    private void visible() {
        btnCalculateCircumference.setVisibility(View.VISIBLE);
        btnCalculateSurfaceArea.setVisibility(View.VISIBLE);
        btnCalculateVolume.setVisibility(View.VISIBLE);
        btnSave.setVisibility(View.GONE);
    }

    private void gone() {
        btnCalculateCircumference.setVisibility(View.GONE);
        btnCalculateSurfaceArea.setVisibility(View.GONE);
        btnCalculateVolume.setVisibility(View.GONE);
        btnSave.setVisibility(View.VISIBLE);
    }
}
