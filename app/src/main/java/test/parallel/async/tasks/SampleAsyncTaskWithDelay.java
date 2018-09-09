package test.parallel.async.tasks;

import android.os.AsyncTask;
import android.util.Log;

public class SampleAsyncTaskWithDelay extends AsyncTask<Void, Void, Void> {

    private final String logTag = this.getClass().getSimpleName();
    private int label;

    SampleAsyncTaskWithDelay(int label) {
        this.label = label;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Log.v(logTag, "doInBackground() label:" + label);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.v(logTag, "onPostExecute() label:" + label);
    }
}