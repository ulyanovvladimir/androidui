package course.examples.staticlayout;

import android.app.Activity;
import android.os.Bundle;

import course.examples.staticlayout.TitlesFragment.ListSelectionListener;

public class QuoteViewerActivity extends Activity implements
        ListSelectionListener {

    static String[] sTitleArray;
    static String[] sQuoteArray;
    private QuotesFragment mDetailsFragment;

    @SuppressWarnings("unused")
    private static final String TAG = "QuoteViewerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Получаем массивы строк для заглавий и цитат
        sTitleArray = getResources().getStringArray(R.array.Titles);
        sQuoteArray = getResources().getStringArray(R.array.Quotes);

        setContentView(R.layout.main);

        // Получаем ссылку на QuotesFragment
        mDetailsFragment = (QuotesFragment) getFragmentManager()
                .findFragmentById(R.id.details);
    }

    // Вызывается, когда пользователь выбирает элемент во фрагменте TitlesFragment
    @Override
    public void onListSelection(int index) {
        if (mDetailsFragment.getShownIndex() != index) {

            // Сообщаем фрагменту QuoteFragment, что нужно показать цитату в нужной позиции
            mDetailsFragment.showQuoteAtIndex(index);
        }
    }
}