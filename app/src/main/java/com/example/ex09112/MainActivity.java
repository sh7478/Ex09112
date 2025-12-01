package com.example.ex09112;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
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
        else if(id == R.id.menuClr)
        {
            clearAll();
        }
        return super.onOptionsItemSelected(item);
    }

    private void sumNums() {
        if(!etNum1.getText().equals(""))
        {
            if(!etNum2.getText().equals(""))
            {
                long num1 = Integer.parseInt(etNum1.getText().toString());
                long num2 = Integer.parseInt(etNum2.getText().toString());
                solution.setText("" + (num1 + num2));
            }
            else
            {
                //TODO: add an error output to solution
            }
        }
        else
        {
            //TODO: add an error output to solution
        }

    }
}