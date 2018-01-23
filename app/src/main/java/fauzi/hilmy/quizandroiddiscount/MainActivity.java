package fauzi.hilmy.quizandroiddiscount;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CoordinatorLayout main;
    EditText etSum, etPrice;
    TextView lblBefore, lblAfter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSum = (EditText)findViewById(R.id.editText);
        etPrice = (EditText)findViewById(R.id.editText2);
        lblBefore = (TextView) findViewById(R.id.textView);
        lblAfter = (TextView) findViewById(R.id.textView2);
    }

    public void doBuy(View view) {
        String Jumlah = etSum.getText().toString();
        String Harga = etPrice.getText().toString();
        int nJumlah = Integer.parseInt(Jumlah);
        int nHarga = Integer.parseInt(Harga);

        int Semua = nJumlah * nHarga;
        int diskon = Semua / 2;

        if (nJumlah > 10) {
            lblBefore.setText("Before Diskon is Rp." + Semua);
            lblAfter.setText("After Diskon is Rp." + diskon);
            Toast.makeText(getApplicationContext(), "You get discount 50%", Toast.LENGTH_SHORT).show();
        }else if(nJumlah < 10) {
            lblBefore.setText("Your payment is Rp." + Semua);
            lblAfter.setText("");
            main = (CoordinatorLayout)findViewById(R.id.main);

            //snackbar
            Snackbar snackbar = Snackbar.make(main, "You're not get discount", Snackbar.LENGTH_LONG);
            //menampilkan snackbar
            snackbar.show();
        }
    }
}
