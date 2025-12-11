package com.example.ex09112;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etNum1, etNum2;
    TextView solution;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        solution = findViewById(R.id.solution);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public static Double tryParseDecimal(String str) {
        if (str == null || str.isEmpty()) {
                return null;
            }
            if (str.matches("[+-]?(\\d+(\\.\\d*)?|\\.\\d+)")) {
                return Double.parseDouble(str);
            }
            return null;
        }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menuClr)
        {
            clearAll();
        }
        else if(tryParseDecimal(etNum1.getText().toString()) != null && tryParseDecimal(etNum2.getText().toString()) != null)
        {
            if(id == R.id.menuAdd)
            {
                sumNums();
            }
            else if(id == R.id.menuSub)
            {
                subNums();
            }
            else if(id == R.id.menuMul)
            {
                mulNums();
            }
            else if(id == R.id.menuDiv)
            {
                divNums();
            }
        }
        else
        {
            solution.setText("you have to put two numbers before solving");
        }
        return super.onOptionsItemSelected(item);
    }

    private void clearAll() {
        solution.setText("");
        etNum1.setText("");
        etNum2.setText("");
    }

    private void divNums() {
        double num1 = Double.parseDouble(etNum1.getText().toString());
        double num2 = Double.parseDouble(etNum2.getText().toString());
        if(num2 == 0)
        {
            solution.setText("Can't divide by zero");
        }
        else {
            solution.setText(formatDecimal(num1 / num2));
        }
    }

    private void mulNums() {
        double num1 = Double.parseDouble(etNum1.getText().toString());
        double num2 = Double.parseDouble(etNum2.getText().toString());
        solution.setText(formatDecimal((num2*num1)));
    }

    public static String formatDecimal(double number) {
        DecimalFormat simpleFormat = new DecimalFormat("0.####");
        String formattedSimple = simpleFormat.format(number).replaceAll("[^0-9]", "");
        if (formattedSimple.length() <= 5) {
            NumberFormat standardFormat = NumberFormat.getInstance();
            standardFormat.setMaximumFractionDigits(4);
            standardFormat.setGroupingUsed(false);
            return standardFormat.format(number);
        } else {
            DecimalFormat scientificFormat = new DecimalFormat("0.00E0");
            String result = scientificFormat.format(number);
            return result.replace("E", "e");
        }
    }

    private void subNums() {
        double num1 = Double.parseDouble(etNum1.getText().toString());
        double num2 = Double.parseDouble(etNum2.getText().toString());

        solution.setText(formatDecimal(num1 - num2));
    }

    private void sumNums() {
        double num1 = Double.parseDouble(etNum1.getText().toString());
        double num2 = Double.parseDouble(etNum2.getText().toString());
        solution.setText(formatDecimal(num1 + num2));

    }
}