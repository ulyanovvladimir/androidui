package course.examples.button;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ButtonActivity extends Activity {
	private int count = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
            
        // Получаем ссылку на кнопку "Press Me"
        final Button button = (Button) findViewById(R.id.button);
        
        // Устанавливаем OnClickListener на эту кнопку
        // Вызывается каждый раз, когда пользователь нажимает на кнопку, объект класса Button
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// Управляем количество нажатий пользователя
				// Отображаем количество нажатий в виде текста на кнопке
				button.setText("Количество нажатий:" + ++count);
				
			}
		});
    }
}
