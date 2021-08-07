package Mr_Dat.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class Slider_Adapter  extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public Slider_Adapter(Context context) {
        this.context = context;
    }
    public int[] slide_image ={
            R.drawable.langwid_2,
            R.drawable.langwid_3,
            R.drawable.langwid_4

    };
    public String[] slide_heading={
            "Comprehensive learning resource",
            "Learn by widgets & reminder",
            "Track progress easily"
    };
    public String[] slide_descs={
                    "User-frirndly interface and over 10,000 words/ grammars divided into many topi from beginner to advanced. Help you prepare for JLPT tests and daily communication.",
                   "You can create widgets and learn on home screen without opening the app. Widgets can be customized backgound, font, color according to your style.",
            "You can track yuor learning progress daily, including the number of learned words, remembered words, and hours spent."
    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o ;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_layout,container,false);
        ImageView slideImageView = view.findViewById(R.id.slide_img);
        TextView slideHeading = view.findViewById(R.id.slide_heading);
        TextView slideDescs = view.findViewById(R.id.slide_descs);

        slideImageView.setImageResource(slide_image[position]);
        slideHeading.setText(slide_heading[position]);
        slideDescs.setText(slide_descs[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
