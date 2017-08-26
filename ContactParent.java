package anaaya.anaayalearningapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by examsh on 2016-08-12.
 */
public class ContactParent extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.contact);
        ImageView view = (ImageView) this.findViewById(R.id.imageView);
        TextView text = (TextView) this.findViewById(R.id.textView);
        Drawable papaContact = this.getResources().getDrawable(R.drawable.contactpapa);
        Drawable mummaContact = this.getResources().getDrawable(R.drawable.contactmumma1);
        String str = getIntent().getExtras().getString("parent");
        if(str.equalsIgnoreCase("papa")) {
            view.setImageDrawable(papaContact);
            text.setText("My Papa : Nidhish Jain - 0767086783");
        }else if(str.equalsIgnoreCase("mumma")) {
            view.setImageDrawable(mummaContact);
            text.setText("My Mumma : Samiksha Jain - 0762327071");
        }
        super.onCreate(savedInstanceState);
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
                Intent intentPapa = new Intent(ContactParent.this, ContactParent.class);
                intentPapa.putExtra("parent","papa");
                startActivity(intentPapa);
                return true;

            case R.id.contact_mumma:

                Intent intentMumma = new Intent(ContactParent.this, ContactParent.class);
                intentMumma.putExtra("parent","mumma");
                startActivity(intentMumma);
                return true;

        }

        return super.onOptionsItemSelected(item);

    }
}
