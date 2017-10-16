package course.examples.staticlayout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class QuotesFragment extends Fragment {

    @SuppressWarnings("unused")
    private static final String TAG = "QuotesFragment";

    private TextView mQuoteView = null;
    private int mCurrIdx = -1;
    private int mQuoteArrayLen;

    public int getShownIndex() {
        return mCurrIdx;
    }

    // Показывает цитату в указанной позиции
    public void showQuoteAtIndex(int newIndex) {
        if (newIndex < 0 || newIndex >= mQuoteArrayLen)
            return;
        mCurrIdx = newIndex;
        mQuoteView.setText(QuoteViewerActivity.sQuoteArray[mCurrIdx]);
    }

    // Вызывается для создания иерархии UI компонентов по этому Фрагменту
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Наполняем фрагмент, в соответствии с макетом, определенным в quote_fragment.xml
        // Последний параметр false, т.к. возвращает Компонент, который не требуется привязывать к корню контейнера ViewGroup
        return inflater.inflate(R.layout.quote_fragment, container, false);
    }

    // Устанавливаем некоторую информацию для компоненты mQuoteView TextView
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mQuoteView = (TextView) getActivity().findViewById(R.id.quoteView);
        mQuoteArrayLen = QuoteViewerActivity.sQuoteArray.length;
    }
}
