package anaaya.anaayalearningapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


/**
 * Created by examsh on 2016-08-15.
 */
public class ChuChu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chuchu);
        //This will help to get rtsp url "http://m.youtube.com/watch?v=JZHJ2679XMc&app=m")); right click on mobile youtube page and click copy link address and set as below

        VideoView chuchuVideo= (VideoView)findViewById(R.id.chuchuVideoView);
        MediaController media = new MediaController(this);
        media.setAnchorView(chuchuVideo);
        chuchuVideo.setVideoURI(Uri.parse("rtsp://r14---sn-5hnednlz.googlevideo.com/Cj0LENy73wIaNAnHXP2u28mRJRMYDSANFC1L9LFXMOCoAUIASARgsN-a6PW10dlWigELWk9IMVRtODBKN0kM/13E7DCF9C98E22DBE65D36C18878F1DB638C7BC8.7B28A747AE4027E10390886AD9AEE8DF1A9934E9/yt6/1/video.3gp"));
       chuchuVideo.setMediaController(media);
        chuchuVideo.requestFocus();
        chuchuVideo.start();
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
                Intent intentPapa = new Intent(ChuChu.this, ContactParent.class);
                intentPapa.putExtra("parent","papa");
                startActivity(intentPapa);
                return true;

            case R.id.contact_mumma:

                Intent intentMumma = new Intent(ChuChu.this, ContactParent.class);
                intentMumma.putExtra("parent","mumma");
                startActivity(intentMumma);
                return true;

        }

        return super.onOptionsItemSelected(item);

    }
/*
    protected static String extractYoutubeId(String url) throws MalformedURLException
    {
        String id = null;
        try
        {
            String query = new URL(url).getQuery();
            if (query != null)
            {
                String[] param = query.split("&");
                for (String row : param)
                {
                    String[] param1 = row.split("=");
                    if (param1[0].equals("v"))
                    {
                        id = param1[1];
                    }
                }
            }
            else
            {
                if (url.contains("embed"))
                {
                    id = url.substring(url.lastIndexOf("/") + 1);
                }
            }
        }
        catch (Exception ex)
        {
            Log.e("Exception", ex.toString());
        }
        return id;
    }

    public static String getUrlVideoRTSP(String urlYoutube)
    {
        try
        {
            String gdy = "http://gdata.youtube.com/feeds/api/videos/";
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String id = extractYoutubeId(urlYoutube);
            Log.d("id",id);
            URL url = new URL(gdy + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            Document doc = documentBuilder.parse(connection.getInputStream());
            Element el = doc.getDocumentElement();
            NodeList list = el.getElementsByTagName("media:content");///media:content
            String cursor = urlYoutube;
            for (int i = 0; i < list.getLength(); i++)
            {
                Node node = list.item(i);
                if (node != null)
                {
                    NamedNodeMap nodeMap = node.getAttributes();
                    HashMap<String, String> maps = new HashMap<String, String>();
                    for (int j = 0; j < nodeMap.getLength(); j++)
                    {
                        Attr att = (Attr) nodeMap.item(j);
                        maps.put(att.getName(), att.getValue());
                    }
                    if (maps.containsKey("yt:format"))
                    {
                        String f = maps.get("yt:format");
                        if (maps.containsKey("url"))
                        {
                            cursor = maps.get("url");
                        }
                        if (f.equals("1"))
                            Log.e("cursor", cursor.toString());
                            return cursor;
                    }
                }
            }
            return cursor;
        }
        catch (Exception ex)
        {
            Log.e("Get Url Video", ex.toString());
        }
        Log.e("urlYoutubereturn", urlYoutube.toString());
        return urlYoutube;

    } */
}
