package course.examples.gridview;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

class ImageAdapter extends BaseAdapter {
	private static final int PADDING = 8;
	private static final int WIDTH = 360;
	private static final int HEIGHT = 480;
	private final Context mContext;
	private final List<Integer> mThumbIds;

	// Сохраняем список идентификаторов (ID) изображений в конструкторе
	public ImageAdapter(Context c, List<Integer> ids) {
		mContext = c;
		this.mThumbIds = ids;
	}

	// Возвращает количество элементов в адаптере
	@Override
	public int getCount() {
		return mThumbIds.size();
	}

	// Возващает элемент данных в указанной позиции (номер по порядку)
	@Override
	public Object getItem(int position) {
		return mThumbIds.get(position);
	}

	// Будет вызван, чтобы предоставить ID для передачи
	// в метод OnItemClickListener.onItemClick()
	@Override
	public long getItemId(int position) {
		return mThumbIds.get(position);
	}

	// Возвращает ImageView для каждого элемента, на который ссылается Adapter
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ImageView imageView = (ImageView) convertView;

		// Если convertView не повторно используемый, создаем новый, инициализируем некоторые параметры
		if (imageView == null) {
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(WIDTH, HEIGHT));
			imageView.setPadding(PADDING, PADDING, PADDING, PADDING);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
		}

		imageView.setImageResource(mThumbIds.get(position));
		return imageView;
	}
}
