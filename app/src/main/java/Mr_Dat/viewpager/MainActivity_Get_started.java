package Mr_Dat.viewpager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity_Get_started extends AppCompatActivity {
ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__get_started);
        imageButton = findViewById(R.id.btn_getstarted);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_Get_started.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}