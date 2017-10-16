package course.examples.dynamiclayout;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import course.examples.dynamiclayout.TitlesFragment.ListSelectionListener;

public class QuoteViewerActivity extends Activity implements
        ListSelectionListener {

    public static String[] mTitleArray;
    public static String[] mQuoteArray;


    private final QuotesFragment mQuoteFragment = new QuotesFragment();
    private FragmentManager mFragmentManager;
    private FrameLayout mTitleFrameLayout, mQuotesFrameLayout;

    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;

    @SuppressWarnings("unused")
    private static final String TAG = "QuoteViewerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Получить массивы строк для заголовков и цитат
        mTitleArray = getResources().getStringArray(R.array.Titles);
        mQuoteArray = getResources().getStringArray(R.array.Quotes);

        setContentView(R.layout.main);

        // Получаем указатели на TitleFragment и на QuotesFragment
        mTitleFrameLayout = (FrameLayout) findViewById(R.id.title_fragment_container);
        mQuotesFrameLayout = (FrameLayout) findViewById(R.id.quote_fragment_container);


        // Получаем ссылку на  FragmentManager
        mFragmentManager = getFragmentManager();

        // Стартуем новую транзакцию FragmentTransaction
        FragmentTransaction fragmentTransaction = mFragmentManager
                .beginTransaction();

        // Добавляем TitleFragment к макету
        fragmentTransaction.add(R.id.title_fragment_container,
                new TitlesFragment());

        // Сохраняем изменения FragmentTransaction, делаем commit.
        fragmentTransaction.commit();

        // Добавляем OnBackStackChangedListener для переустановки макета в момент изменения бэкстэка
        mFragmentManager
                .addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        setLayout();
                    }
                });
    }

    private void setLayout() {

        // Определяем, был ли добавлен QuoteFragment
        if (!mQuoteFragment.isAdded()) {

            // Делаем так, чтобы TitleFragment занимал все пространство
            mTitleFrameLayout.setLayoutParams(
                    new LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT));
            mQuotesFrameLayout.setLayoutParams(
                    new LinearLayout.LayoutParams(0, MATCH_PARENT));
        } else {

            // Делаем так, чтобы TitleFragment занимал 1/3 от ширины макета
            mTitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                    MATCH_PARENT, 1f));

            // Делаем так, чтобы QuoteFragment занимал 2/3 от ширины макета
            mQuotesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                    MATCH_PARENT, 2f));
        }
    }

    // Вызывается, когда пользователь выбирает элемент в TitlesFragment
    @Override
    public void onListSelection(int index) {

        // Если QuoteFragment не был добавлен, добавляем его
        if (!mQuoteFragment.isAdded()) {

            // Стартуем новую транзакцию FragmentTransaction
            FragmentTransaction fragmentTransaction = mFragmentManager
                    .beginTransaction();

            // Добавляем макет для QuoteFragment
            fragmentTransaction.add(R.id.quote_fragment_container,
                    mQuoteFragment);

            // Добавляем эту транзакцию к бэкстэку
            fragmentTransaction.addToBackStack(null);

            // Коммитим FragmentTransaction
            fragmentTransaction.commit();

            // Заставляем Андроид запустить закоммиченную транзакцию FragmentTransaction
            mFragmentManager.executePendingTransactions();
        }

        if (mQuoteFragment.getShownIndex() != index) {

            // Говорим QuoteFragment показать цитату в заданной позиции.
            mQuoteFragment.showQuoteAtIndex(index);
        }
    }
}