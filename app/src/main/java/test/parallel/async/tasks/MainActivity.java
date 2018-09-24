package test.parallel.async.tasks;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String logTag = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button startAsyncTasks = findViewById(R.id.button_StartAsyncTasks);
        startAsyncTasks.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_StartAsyncTasks) {/*request to start multiple parallel async tasks using a loop*/
            Snackbar.make(view, R.string.Starting, Snackbar.LENGTH_LONG)
                    .setAction(android.R.string.ok, null).show();
            for (int i = 0; i < 10; i++) {
                SampleAsyncTaskWithDelay sampleAsyncTaskWithDelay = new SampleAsyncTaskWithDelay(i);
                sampleAsyncTaskWithDelay.execute(); // to run async tasks in serial fashion, one at a time.
//                sampleAsyncTaskWithDelay.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);// to run multiple async tasks in parallel
            }
            Log.v(logTag, "after for loop of AsyncTasks");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
