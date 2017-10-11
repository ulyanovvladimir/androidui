package course.examples.gridview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageViewActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		// Получаем Интент, использованный для старта этой Активности
		Intent intent = getIntent();
		
		// Создаем новый ImageView
		ImageView imageView = new ImageView(getApplicationContext());
		
		// Получаем ID изображения для отображения и устанавливаем его в качестве изображения для компоненты ImageView
		imageView.setImageResource(intent.getIntExtra(GridLayoutActivity.EXTRA_RES_ID, 0));
		
		setContentView(imageView);
	}
}