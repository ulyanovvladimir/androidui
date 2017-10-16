package course.examples.staticlayout;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitlesFragment extends ListFragment {
    private ListSelectionListener mListener;

    @SuppressWarnings("unused")
    private static final String TAG = "TitlesFragment";

    // Интерфейс, который позволяет этому Фрагменту уведомить QuoteViewerActivity , когда
    // пользователь выберет элемент Списка
    public interface ListSelectionListener {
        public void onListSelection(int index);
    }

    // Вызывается, когда пользователь выбирает элемент из Списка
    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {

        // Обозначает, что выбранный элемент установлен активным
        getListView().setItemChecked(pos, true);

        // Информируем QuoteViewerActivity, что был выбран элемент в позиции pos
        mListener.onListSelection(pos);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {

            // Устанавливает ListSelectionListener для взаимодействия с QuoteViewerActivity
            mListener = (ListSelectionListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnArticleSelectedListener");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);

        // Устанавливает режим для списка вариантов (только один выделенный элемент)
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // Устанавливаем адаптер списка для ListView
        // Подробно обсуждалось в теме компонентов пользовательского интерфейса
        setListAdapter(new ArrayAdapter<>(getActivity(),
                R.layout.title_item, QuoteViewerActivity.sTitleArray));
    }
}