package Mr_Dat.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideviewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    private Button mNext;
    private int mCurrentPage;


    private Slider_Adapter sliderAdapter;
//    private CircleIndicator circleIndicator;
//    private PhotoAdapter photoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSlideviewPager = (ViewPager)findViewById(R.id.slideviewpager);
        mDotLayout = (LinearLayout) findViewById(R.id.linearLayout);
        mNext = findViewById(R.id.btn_next);
        sliderAdapter = new Slider_Adapter(this);
        mSlideviewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);
        mSlideviewPager.addOnPageChangeListener(viewListener);

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideviewPager.setCurrentItem(mCurrentPage + 1);
//                String fi = mNext.getText().toString();
//                if(fi == "Finish"){
//                    Intent intent4 = new Intent(MainActivity.this,MainActivity2.class);
//                    startActivity(intent4);
//                }
            }
        });
        
    }
    public void addDotsIndicator(int position){
        mDots = new TextView[3];
        mDotLayout.removeAllViews();
        for (int i = 0 ;i < mDots.length;i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));

            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.white));

            mDotLayout.addView(mDots[i]);

        }

        if(mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.green));
        }
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage = i;
            if(i == 0){
                mNext.setEnabled(true);
                mNext.setText("Next");
            }else if(i == mDots.length -1){
                mNext.setEnabled(true);
                mNext.setText("Finish");

            }else{
                mNext.setEnabled(true);
                mNext.setText("Next");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}