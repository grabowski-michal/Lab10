package pollub.ism.lab10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import pollub.ism.lab10.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ZadanieAsynchroniczne2 zadanie2 = null;
    private ActivityMainBinding okno = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        okno = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(okno.getRoot());

        okno.pasekPostepu.setProgress(0);
        okno.pasekPostepu.setMax(100);
        okno.przycisk3.setEnabled(true);
        okno.przycisk4.setEnabled(false);
    }


    public void przycisk1(View view) {

        new ZadanieAsynchroniczne1(okno.poleTekstowe1).execute();
        okno.poleTekstowe1.setText(R.string.working);
    }


    public void przycisk2(View view) {

        new ZadanieAsynchroniczne1(okno.poleTekstowe2).execute();
        okno.poleTekstowe2.setText(R.string.working);
    }

    public void przycisk3(View view) {
        if (!(okno.poleEdycyjne1.getText().toString().equals("")) && !(okno.poleEdycyjne2.getText().toString().equals(""))) {
            okno.przycisk3.setEnabled(false);
            int powtorzenia = Integer.valueOf(okno.poleEdycyjne1.getText().toString());
            int pauza = Integer.valueOf(okno.poleEdycyjne2.getText().toString());
            zadanie2 = new ZadanieAsynchroniczne2(okno.pasekPostepu, okno.przycisk3, okno.przycisk4);
            zadanie2.execute(powtorzenia, pauza);
            okno.przycisk4.setEnabled(true);
        }
    }

    public void przycisk4(View view) {
        zadanie2.cancel(true);
    }
}