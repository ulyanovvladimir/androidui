package course.examples.cardview;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class CardViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);

        ImageView imageView = (ImageView) findViewById(R.id.flag_image);
        imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(),(R.drawable.us)));

        TextView place = (TextView) findViewById(R.id.place_name);
        place.setText("Вашингтон, ");

        TextView country = (TextView) findViewById(R.id.country_name);
        country.setText("Соединенные Штаты Америки");

        TextView date = (TextView) findViewById(R.id.date_string);
        date.setText("4 июля, 1776");

        TextView location = (TextView) findViewById(R.id.location);
        location.setText("Местоположение: (38.8977,-77.0366)");

    }
}
