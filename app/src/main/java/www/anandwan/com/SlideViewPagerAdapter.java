package www.anandwan.com;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlideViewPagerAdapter extends PagerAdapter {

    Context ctx;
    public SlideViewPagerAdapter(Context ctx){
        this.ctx = ctx;
    }



    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater layoutInflater= (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_screen,container,false);


        ImageView logo=view.findViewById(R.id.im);
        ImageView log=view.findViewById(R.id.ima);
        ImageView lo=view.findViewById(R.id.imag);

        TextView title = view.findViewById(R.id.tx);
        TextView des = view.findViewById(R.id.an);

        final ImageView next = view.findViewById(R.id.butd);
        final ImageView back = view.findViewById(R.id.but);


        next.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                ActivityVolunteer.viewPager.setCurrentItem(position+1);
                next.setBackgroundResource(R.drawable.btnback);
                back.setBackgroundResource(R.drawable.button);

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {

                ActivityVolunteer.viewPager.setCurrentItem(position-1);
                back.setBackgroundResource(R.drawable.btnback);
                next.setBackgroundResource(R.drawable.button);

            }
        });






        switch (position)
        {
            case 0:
                logo.setImageResource(R.drawable.ab);
                log.setImageResource(R.drawable.rrrr);
                lo.setImageResource(R.drawable.ssss);

                title.setText(R.string.ucn);
                des.setText(R.string.uc);
                back.setVisibility(View.INVISIBLE);




                break;
            case 1:
                logo.setImageResource(R.drawable.poo);
                log.setImageResource(R.drawable.ssss);
                lo.setImageResource(R.drawable.rrrr);
                title.setText(R.string.ucn2);
                des.setText(R.string.uc2);
                next.setVisibility(View.INVISIBLE);

                break;
        }

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

