package sebi.persistenzapplikations;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2Activity extends Activity {

    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String PREFS_VALUE = "MyStringValue";
    private static final String FILE = "File1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    public void getSharedPreferences(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView2);
        // aufgabe e = MODE_MULTI_PROCESS setzen
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_MULTI_PROCESS);
        textView.setText("");
        textView.setText(prefs.getString(PREFS_VALUE,"No Val"));
    }

    public void readFile (View view) throws IOException
    {

        String result = "", line;
        FileInputStream fis;
        fis = openFileInput(FILE);

        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

        while ((line = reader.readLine()) != null)
        {
            result = result + line;
        }

        reader.close();
        fis.close();

        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(result);

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
