package anaaya.anaayalearningapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by examsh on 2016-08-13.
 */
public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.home);
        super.onCreate(savedInstanceState);

        LinearLayout layoutAlphabet = (LinearLayout) findViewById(R.id.layout_alphabet);
        layoutAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout layoutNumber = (LinearLayout) findViewById(R.id.layout_number);
        layoutNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this, NumberListActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout layoutChuChu = (LinearLayout) findViewById(R.id.layout_playing);
        layoutChuChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this, ChuChu.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        RelativeLayout main_view = (RelativeLayout) findViewById(R.id.main_menu);


//        Bitmap bitmapPapa = ((BitmapDrawable) papaContact).getBitmap();

        switch (item.getItemId()){

            case R.id.logout_menu:


                int pid = android.os.Process.myPid();
                android.os.Process.killProcess(pid);
                System.exit(0);
                return true;


            case R.id.contact_papa:
                Intent intentPapa = new Intent(HomeActivity.this, ContactParent.class);
                intentPapa.putExtra("parent","papa");
                startActivity(intentPapa);
                return true;

            case R.id.contact_mumma:

                Intent intentMumma = new Intent(HomeActivity.this, ContactParent.class);
                intentMumma.putExtra("parent","mumma");
                startActivity(intentMumma);
                return true;

        }

        return super.onOptionsItemSelected(item);

    }


}
