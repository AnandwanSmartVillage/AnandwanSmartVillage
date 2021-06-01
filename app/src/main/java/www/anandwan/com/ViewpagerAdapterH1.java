package www.anandwan.com;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewpagerAdapterH1 extends PagerAdapter {

    private Context mContext;
    private LayoutInflater layoutInflater;
    private int[] mImageIds = new int[] {
            R.drawable.hemalkasa6, R.drawable.hemalkasa1, R.drawable.hemalkasa2, R.drawable.hemalkasa3, R.drawable.hemalkasa4, R.drawable.hemalkasa5
    };


    ViewpagerAdapterH1(Context context){
        mContext = context;
    }


    @Override
    public int getCount() {
        return mImageIds.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slideshow_layout,null);

        ImageView imageView = (ImageView) view.findViewById(R.id.slideshowIMG);

        imageView.setImageResource(mImageIds[position]);


        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }


}