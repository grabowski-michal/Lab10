package pollub.ism.lab10;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class ZadanieAsynchroniczne1 extends AsyncTask<Void, Void, String> {

    private WeakReference<TextView> mTextView;

    public ZadanieAsynchroniczne1(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }


    @Override
    protected String doInBackground(Void... voids) {

        Random r = new Random();
        int n = r.nextInt(11);
        int s = n * 200;

        try {
            Thread.sleep(s);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        return "Zadanie zakończone po " + s + " ms";
    }


    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }

}
