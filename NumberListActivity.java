package anaaya.anaayalearningapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by examsh on 2016-08-10.
 */
public class NumberListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<LCNumber> lcList = AnaayaApplication.mLCListNumber;
        ListAdapter lcTypeAdapter = new LCTypeNumberAdapter(this,lcList);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(lcTypeAdapter);



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

        Drawable papaContact = this.getResources().getDrawable(R.drawable.contactpapa);
        Drawable mummaContact = this.getResources().getDrawable(R.drawable.contactmumma);
//        Bitmap bitmapPapa = ((BitmapDrawable) papaContact).getBitmap();

        switch (item.getItemId()){

            case R.id.logout_menu:


                int pid = android.os.Process.myPid();
                android.os.Process.killProcess(pid);
                System.exit(0);
                return true;


            case R.id.contact_papa:
                Intent intentPapa = new Intent(NumberListActivity.this, ContactParent.class);
                intentPapa.putExtra("parent","papa");
                startActivity(intentPapa);
                return true;

            case R.id.contact_mumma:

                Intent intentMumma = new Intent(NumberListActivity.this, ContactParent.class);
                intentMumma.putExtra("parent","mumma");
                startActivity(intentMumma);
                return true;

        }

        return super.onOptionsItemSelected(item);

    }



}
