package course.examples.dynamiclayout;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitlesFragment extends ListFragment {

    @SuppressWarnings("unused")
    private static final String TAG = "TitlesFragment";
    private ListSelectionListener mListener = null;

    // Интерфейс, который позволяет данному Фрагменту уведомить QuoteViewerActivity, когда
    // пользователь щелкает на элемент списка
    public interface ListSelectionListener {
        public void onListSelection(int index);
    }

    // Вызывается, когда пользователь выбирает элемент из Списка
    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {

        // Устанавливаем "выделенный" элемент списка
        getListView().setItemChecked(pos, true);

        // Информируем QuoteViewerActivity, что был вылран элемент в позиции pos
        mListener.onListSelection(pos);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {

            // Устанавливаем ListSelectionListener для коммуникации с QuoteViewerActivity
            mListener = (ListSelectionListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnArticleSelectedListener");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);

        // Устанавливаем адаптер списка для компоненты ListView
        // Подробно разбиралось в теме про классы пользовательского интерфейса
        setListAdapter(new ArrayAdapter<>(getActivity(),
                R.layout.title_item, QuoteViewerActivity.mTitleArray));

        // Устанавливаем режим выбора списка: не более одного выбранного элемента
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }
}