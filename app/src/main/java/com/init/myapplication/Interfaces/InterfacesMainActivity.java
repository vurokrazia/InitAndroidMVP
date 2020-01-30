package com.init.myapplication.Interfaces;

public interface InterfacesMainActivity {
    interface View {
        void findElement();
        void showResult(String result);
    }

    interface Presenter {
        void operation_addition(int first_number, int second_number);
        void operation_subtraction(int first_number, int second_number);
        void operation_multiplication(int first_number, int second_number);
        void operation_division(int first_number, int second_number);
        void send_result_operation(int number);
    }

    interface Model {
        void addition(int first_number, int second_number);
        void subtraction(int first_number, int second_number);
        void multiplication(int first_number, int second_number);
        void division(int first_number, int second_number);
    }
}
