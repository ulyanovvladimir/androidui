package course.examples.gridview;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class GridLayoutActivity extends Activity {

	static final String EXTRA_RES_ID = "POS";
	
	private final ArrayList<Integer> mThumbIdsFlowers = new ArrayList<>(
			Arrays.asList(R.drawable.image1, R.drawable.image2,
					R.drawable.image3, R.drawable.image4, R.drawable.image5,
					R.drawable.image6, R.drawable.image7, R.drawable.image8,
					R.drawable.image9, R.drawable.image10, R.drawable.image11,
					R.drawable.image12));

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		GridView gridview = (GridView) findViewById(R.id.gridview);

		// Создаем новый ImageAdapter и задаем его в качестве адаптера для GridView
		gridview.setAdapter(new ImageAdapter(this, mThumbIdsFlowers));

		// Добавляем setOnItemClickListener для GridView
		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				
				//Создаем Интент для перехода к ImageViewActivity
				Intent intent = new Intent(GridLayoutActivity.this,
						ImageViewActivity.class);
				
				// Добавляем ID изображения для отображения с помощью Extra-поля Интента.
				intent.putExtra(EXTRA_RES_ID, (int) id);
				
				// Стартуем ImageViewActivity
				startActivity(intent);
			}
		});
	}
}