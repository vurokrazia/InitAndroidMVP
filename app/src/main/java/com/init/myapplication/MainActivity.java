package com.init.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.init.myapplication.Interfaces.InterfacesMainActivity;
import com.init.myapplication.Presenter.PresenterMainActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, InterfacesMainActivity.View {
    EditText editTextNumberFirst, editTextNumberSecond;
    Button button_addition, button_multiplication, button_division, button_subtraction;
    TextView text_view_result;
    InterfacesMainActivity.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.findElement();
        presenter = new PresenterMainActivity(this);
    }

    @Override
    public void onClick(View v) {
        String number_a = editTextNumberFirst.getText().toString(), number_b = editTextNumberSecond.getText().toString();
        if (stepsValidation(number_a) & stepsValidation(number_b)) {
            int first_number = parseNumber(number_a);
            int second_number = parseNumber(number_b);
            switch (v.getId()) {
                case R.id.button_send_number_addition:
                    presenter.operation_addition(first_number, second_number);
                    break;
                case R.id.button_send_number_subtraction:
                    presenter.operation_subtraction(first_number, second_number);
                    break;
                case R.id.button_send_number_multiplication:
                    presenter.operation_multiplication(first_number, second_number);
                    break;
                case R.id.button_send_number_division:
                    presenter.operation_division(first_number, second_number);
                    break;
                case R.id.label_result:
                    String label_result = text_view_result.getText().toString();
                    editTextNumberFirst.setText(label_result);
                    break;
            }
        } else {
            Toast.makeText(getApplicationContext(), R.string.register_numbers, Toast.LENGTH_LONG).show();
        }
    }
    private boolean stepsValidation(String number) {
        return !number.equals("");
    }
    private int parseNumber(String number) {
        return Integer.parseInt((number));
    }
    @Override
    public void findElement() {
        text_view_result = findViewById(R.id.label_result);
        text_view_result.setOnClickListener(this);
        button_addition = findViewById(R.id.button_send_number_addition);
        button_addition.setOnClickListener(this);
        button_multiplication = findViewById(R.id.button_send_number_multiplication);
        button_multiplication.setOnClickListener(this);
        button_division = findViewById(R.id.button_send_number_division);
        button_division.setOnClickListener(this);
        button_subtraction = findViewById(R.id.button_send_number_subtraction);
        button_subtraction.setOnClickListener(this);
        editTextNumberFirst = findViewById(R.id.edit_text_first_number);
        editTextNumberSecond = findViewById(R.id.edit_text_second_number);
    }

    @Override
    public void showResult(String result) {
        text_view_result.setText(result);
    }
}
