package germangirod.goldcoastevents.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import germangirod.goldcoastevents.R;
import germangirod.goldcoastevents.data.model.EventResponse;
import germangirod.goldcoastevents.data.presenter.EventsPresenter;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements EventsPresenter, AdapterView.OnItemSelectedListener,
        com.wdullaer.materialdatetimepicker.time.TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    private Spinner spinner;
    private LinearLayout dateButton;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setWidgets();
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(MainActivity.this, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });
    }

    private void setWidgets(){
        spinner = (Spinner) findViewById(R.id.planets_spinner);
        dateButton = (LinearLayout) findViewById(R.id.dateButton);
    }

    @Override protected void onResume() {
        super.onResume();
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
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

    @Override public void showEvents(EventResponse eventResponse) {
    }

    @Override public void showError(Throwable throwable) {
    }

    @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override public void onDateSet(DatePickerDialog datePickerDialog, int i, int i1, int i2) {

        Log.e("mirar esto ","mirar "+i);
        Log.e("mirar esto ","mirar "+i1);
        Log.e("mirar esto ","mirar "+i2);

    }

    @Override public void onTimeSet(RadialPickerLayout radialPickerLayout, int i, int i1, int i2) {

    }
}
