package course.examples.dynamiclayout;

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
    private int mQuoteArrLen;

    int getShownIndex() {
        return mCurrIdx;
    }

    // Показать строку Цитаты в указанной позиции newIndex
    void showQuoteAtIndex(int newIndex) {
        if (newIndex < 0 || newIndex >= mQuoteArrLen)
            return;
        mCurrIdx = newIndex;
        mQuoteView.setText(QuoteViewerActivity.mQuoteArray[mCurrIdx]);
    }

    // Вызывается для создания контента, иерархии компонентов UI для этого фрагмента
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Наполняем макет, заданный в файле quote_fragment.xml
        // Последний параметр false, т.к. для возвращаемого View не требуется,
        // чтобы он был прикреплен к контейнеру ViewGroup
        return inflater.inflate(R.layout.quote_fragment, container, false);
    }

    // Устанавливаем некоторую информацию по mQuoteView TextView
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mQuoteView = (TextView) getActivity().findViewById(R.id.quoteView);
        mQuoteArrLen = QuoteViewerActivity.mQuoteArray.length;
    }
}
