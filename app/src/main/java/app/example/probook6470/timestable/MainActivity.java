package app.example.probook6470.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView timesTableListView;


    public final void generateTimesTable(int timesTableNumber){
        ArrayList<String> timesTableContent = new ArrayList <String>();

        for(int i = 1; i <= 10; i++){
            timesTableContent.add(Integer.toString(i * timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        timesTableListView.setAdapter(arrayAdapter);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTablesSeekBar = findViewById(R.id.timesTableSeekBar);
        timesTableListView = findViewById(R.id.timesTableListView);
        int max = 20;
        int startPosition = 10;

        timesTablesSeekBar.setMax(max);
        timesTablesSeekBar.setProgress(startPosition);

        generateTimesTable(startPosition);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;

                if(progress < min){
                    timesTableNumber = min;
                    timesTablesSeekBar.setProgress(min);
                }else{
                    timesTableNumber = progress;
                }
                Log.i("SeekBar Value: ", Integer.toString(timesTableNumber));
                generateTimesTable(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
