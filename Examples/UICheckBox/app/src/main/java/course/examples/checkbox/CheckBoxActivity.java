package course.examples.checkbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class CheckBoxActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Получаем ссылку на CheckBox
        final CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox);

        // Устанавливаем OnClickListener для нашего объекта класса CheckBox
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                // Проверяем, выбран ли в настоящий момент CheckBox, установлена ли галка
                // Устанавливаем значение текста для чекбокса соответствующим образом
                if (isChecked) {
                    checkbox.setText(getString(R.string.im_checked));
                } else {
                    checkbox.setText(getString(R.string.im_not_checked));
                }
            }
        });

		// Получаем ссылку на кнопку "Скрыть CheckBox"
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                // Переключаем состояние видимости CheckBox-а
                // Устанавливаем соответствующий текст для кнопки
                if (checkbox.isShown()) {
                    checkbox.setVisibility(View.INVISIBLE);
                    button.setText(getString(R.string.unhide_checkbox));
                } else {
                    checkbox.setVisibility(View.VISIBLE);
                    button.setText(getString(R.string.hide_checkbox));
                }
            }
        });
    }
}