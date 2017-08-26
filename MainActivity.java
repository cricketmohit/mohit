package anaaya.anaayalearningapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    public static final String BASE_URL = "http://se-t2.ica.ia-hc.net/rest/Store_Receiving_RS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        ImageView imageSplash = (ImageView)this.findViewById(R.id.splashImage);
        imageSplash.setScaleType(ImageView.ScaleType.FIT_XY);
        requestData();
        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
        Log.d("MyApp","I am closed no error");
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
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
                Intent intentPapa = new Intent(MainActivity.this, ContactParent.class);
                intentPapa.putExtra("parent","papa");
                startActivity(intentPapa);
                return true;

            case R.id.contact_mumma:

                Intent intentMumma = new Intent(MainActivity.this, ContactParent.class);
                intentMumma.putExtra("parent","mumma");
                startActivity(intentMumma);
                return true;

        }

        return super.onOptionsItemSelected(item);

    }




    private void requestData(){
                List<LCAlphabet> lcList = new ArrayList<LCAlphabet>();
        List<LCNumber> lcListNumber = new ArrayList<LCNumber>();
        String alphabetString = "A for Apple:\n" +
                "B for Boy:\n" +
                "C for Cat:\n" +
                "D for Dog:\n" +
                "E for Egg:\n" +
                "F for Fish: \n" +
                "G for Girl:\n" +
                "H for Hand:\n" +
                "I for Ice-cream:\n" +
                "J for Jet:\n" +
                "K for Kite:\n" +
                "L for Lamp:\n" +
                "M for Man:\n" +
                "N for Nose: \n" +
                "O for Orange:\n" +
                "P for Pen:\n" +
                "Q for Queen:\n" +
                "R for Rain:\n" +
                "S for Sugar:\n" +
                "T for Tree:\n" +
                "U for Umbrella:\n" +
                "V for Van:\n" +
                "W for Water: \n" +
                "X for X'mas:\n" +
                "Y for Yellow:\n" +
                "Z for Zoo";
        String arrayAlphabet[] = alphabetString.split(":");
        for (int i = 0; i<=25;i++) {
            LCAlphabet alphabet = new LCAlphabet();
            alphabet.setId(i);
            alphabet.setLcType(String.valueOf(arrayAlphabet[i]).toUpperCase());
            lcList.add(alphabet);
        }

        String numbers = "Zero:One:\n" +
                "Two:\n" +
                "Three:\n" +
                "Four:\n" +
                "Five:\n" +
                "Six:\n" +
                "Seven:\n" +
                "Eight:\n" +
                "Nine:\n" +
                "Ten";
        String number []  = numbers.split(":");
        for (int i = 0; i<=10;i++) {
            LCNumber numberlist = new LCNumber();
            numberlist.setId(i);
            numberlist.setLcType(String.valueOf(number[i]).toUpperCase());
            lcListNumber.add(numberlist);
        }
        AnaayaApplication.setLcListAndMap(lcList,lcListNumber);


        }






}
