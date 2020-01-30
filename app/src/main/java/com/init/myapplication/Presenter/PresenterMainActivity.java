package com.init.myapplication.Presenter;

import com.init.myapplication.Interfaces.InterfacesMainActivity;
import com.init.myapplication.MainActivity;
import com.init.myapplication.Model.ModelMainActivity;

public class PresenterMainActivity implements InterfacesMainActivity.Presenter {
    InterfacesMainActivity.View view;
    InterfacesMainActivity.Model model;
    public PresenterMainActivity(InterfacesMainActivity.View view) {
        this.view = view;
        this.model = new ModelMainActivity(this);
    }

    @Override
    public void operation_addition(int first_number, int second_number) {
        this.model.addition(first_number, second_number);
    }

    @Override
    public void operation_subtraction(int first_number, int second_number) {
        this.model.subtraction(first_number, second_number);
    }

    @Override
    public void operation_multiplication(int first_number, int second_number) {
        this.model.multiplication(first_number, second_number);
    }

    @Override
    public void operation_division(int first_number, int second_number) {
        this.model.division(first_number, second_number);
    }

    @Override
    public void send_result_operation(int number) {
        this.view.showResult(String.valueOf(number));
    }
}
