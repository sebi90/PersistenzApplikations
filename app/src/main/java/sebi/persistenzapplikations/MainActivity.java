package sebi.persistenzapplikations;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    public static final String PREFS_NAME = "MyPrefsFile";
    public static final String PREFS_VALUE = "MyStringValue";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void savePreferences(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editText);
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PREFS_VALUE, editText.getText().toString());

        // Commit the edits!
        editor.commit();
    }

    public void getPreferences(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        textView.setText("");
        textView.setText(prefs.getString(PREFS_VALUE,"No Val"));


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

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MyMainActivity" , "onStop");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MyMainActivity" , "onPause");
    }
}
