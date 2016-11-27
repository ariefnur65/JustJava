package id.co.blogspot.blogmozink.justjava;

import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button on = (Button) findViewById(R.id.button);
        on.setOnClickListener(oneforall);

        Button increment = (Button) findViewById(R.id.in);
        Button decrement = (Button) findViewById(R.id.dec);
        increment.setOnClickListener(oneforall);
        decrement.setOnClickListener(oneforall);
    }


    private View.OnClickListener oneforall = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View view) {


            TextView re = (TextView) findViewById(R.id.result);
            TextView quantity = (TextView) findViewById(R.id.quantity);
            Integer x = Integer.parseInt(quantity.getText().toString());
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
            switch (view.getId()){
                case  R.id.dec:
                    x-=1;
                    quantity.setText(x.toString());
                    break;
                case R.id.in:
                    x +=1;
                    quantity.setText(x.toString());
                    break;
                case R.id.button:
                    x = x*3;
                    re.setText(numberFormat.format(x));
                    break;
            }

            if (x<0){
                Toast.makeText(getApplicationContext(),"Jangan Sampai 0 Yaa",Toast.LENGTH_SHORT).show();
                x=0;
                quantity.setText(x.toString());
            }
        }
    };


/*
    private View.OnClickListener order = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView re = (TextView) findViewById(R.id.result);
            TextView quantity = (TextView) findViewById(R.id.quantity);
            Integer x = Integer.parseInt(quantity.getText().toString());
            x = x*3;
            re.setText("$ " + x.toString());
        }
    };


    private View.OnClickListener incre = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView x = (TextView) findViewById(R.id.quantity);
            Integer y = Integer.parseInt(x.getText().toString());
            y+=1;
            x.setText(y.toString());
        }
    };

    private View.OnClickListener decre = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView x = (TextView) findViewById(R.id.quantity);
            Integer y = Integer.parseInt(x.getText().toString());
            y-=1;
            x.setText(y.toString());
        }
    };



    public void submitOrder(View view){
        display(1);
    }

    public void display(Integer num){
        TextView quantity = (TextView) findViewById(R.id.quantity);

        Integer x= Integer.parseInt(quantity.getText().toString());
        x += num;
        quantity.setText(x);
    }*/

}
