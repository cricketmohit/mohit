package anaaya.anaayalearningapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by examsh on 2016-08-08.
 */
public class LCTypeNumberAdapter extends BaseAdapter{

    Context mContext;
    List<LCNumber> listMain = new ArrayList<LCNumber>();
    File cacheDir;
    File appDir;
    TextToSpeech tts;



    public LCTypeNumberAdapter() {
    }

    public LCTypeNumberAdapter(Context context, List<LCNumber> list) {
        mContext = context;
        listMain = list;
        cacheDir = context.getCacheDir();
        appDir = new File(cacheDir.getParent());
    }

    @Override
    public int getCount() {
        return listMain.size();
    }

    @Override
    public Object getItem(int i) {
        return listMain.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    ImageView lcImage;
    Drawable lcImaageraw;
    Bitmap lcImaageFinal;
    @Override
    public View getView(int i, View convertView, final ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.lc_type, parent, false);
        final LCNumber returnObj = (LCNumber) getItem(i);
        Log.d("MyApp", returnObj.getLcType().toString());

        TextView lcType = (TextView) customView.findViewById(R.id.lcTypeName);
        lcImage = (ImageView) customView.findViewById(R.id.lcTypeImage);
        lcType.setText(returnObj.getLcType().toString());
        lcImage.setImageBitmap(loadlcTypeImageBit("numbers"+returnObj.getId()));
        final TextView lcTypeText = lcType;
        ImageView lcImagetemp1 = (ImageView) customView.findViewById(R.id.lcTypeImage);
        lcImagetemp1.setImageBitmap(loadlcTypeImageBit("numbers"+returnObj.getId()));
        final ImageView lcImagetemp = lcImagetemp1;
        lcType.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                loadPhoto(lcImagetemp,0,0,parent,lcTypeText);
            }
        });
        lcImage.setOnClickListener(new View.OnClickListener(){



            @Override
            public void onClick(View view) {
                loadPhoto(lcImagetemp,0,0,parent,lcTypeText);
            }
        });
        //lcImage.setImageBitmap();
        return customView;
    }

    public Drawable loadlcTypeImage(String imageName) {

            String uri = "@drawable/"+imageName;

            int imageResource = mContext.getResources().getIdentifier(uri, null, mContext.getPackageName());

            Drawable draw = mContext.getResources().getDrawable(imageResource);
            return draw;

    }

    public Bitmap loadlcTypeImageBit(String imageName) {

        String uri = "@drawable/"+imageName;
        Log.d("My App","uri "+uri);
        int imageResource = mContext.getResources().getIdentifier(uri, null, mContext.getPackageName());
        Log.d("My App","imageResource "+imageResource);
        Bitmap draw = BitmapFactory.decodeResource(mContext.getResources(),imageResource);
        return draw;

    }
    private void loadPhoto(ImageView imageView, int width, int height, final ViewGroup parent,final TextView textToSpeak) {

        ImageView tempImageView = imageView;

        tts = new TextToSpeech(mContext, new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int status) {
                // TODO Auto-generated method stub
                if(status == TextToSpeech.SUCCESS){
                    int result=tts.setLanguage(Locale.ENGLISH);
                    if(result==TextToSpeech.LANG_MISSING_DATA ||
                            result==TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("error", "This Language is not supported");
                    }
                    else{
                        tts.speak(textToSpeak.getText().toString().toLowerCase(), TextToSpeech.QUEUE_FLUSH, null);
                    }
                }
                else
                    Log.e("error", "Initilization Failed!");
            }
        });


        AlertDialog.Builder imageDialog = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.custom_fullimage_dialogue, parent, false);

        ImageView image = (ImageView) layout.findViewById(R.id.fullimage);
        image.setImageDrawable(tempImageView.getDrawable());
        imageDialog.setView(layout);
        imageDialog.setPositiveButton(mContext.getResources().getString(R.string.ok_button), new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }

        });


        imageDialog.create();
        imageDialog.show();
    }


}
