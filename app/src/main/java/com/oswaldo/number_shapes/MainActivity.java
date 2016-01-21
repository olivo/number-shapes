package com.oswaldo.number_shapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public boolean isTriangular(int number) {

        Log.i("Start", "Starting Triangular!");
        int res = 0, i = 1;
        while (res < number) {

            res+=i;
            i++;
        }
        Log.i("End", "Ending Triangular");
        return res == number;
    }

    public boolean isSquare(int number) {

        int sqrt = (int)Math.sqrt(number);

        return sqrt*sqrt == number;
    }

    public void checkShape (View view) {

        int number = 0;
        String str = ((EditText)findViewById(R.id.number)).getText().toString();

        try {
            number = Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Please enter a valid number",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isTri = isTriangular(number);
        boolean isSqr = isSquare(number);

        Toast.makeText(getApplicationContext(), "The number is " + (isTri ? "" : "not " )
                + "triangular. The number is " + (isSqr ? "" : "not ") + "square."
                , Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
