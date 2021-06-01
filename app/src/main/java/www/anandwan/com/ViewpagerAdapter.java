package www.anandwan.com;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;



public class ViewpagerAdapter extends PagerAdapter{


    public String[] Headings1;

    public String[] Descriptions1;

    public String[] Headings2;

    public String[] Descriptions2;




    Dialog myDialog;

    private Context mContext;
    private LayoutInflater layoutInflater;

    private int[] mImageIds = new int[] {
            R.drawable.big_50,R.drawable.big_60,R.drawable.big_70,R.drawable.big_80,R.drawable.big_90,R.drawable.big_00,R.drawable.big_10,R.drawable.tilldatebig
    };

    private int[] nImageIds = new int[] {
            R.drawable.s50,R.drawable.s60, R.drawable.emptytransparent,R.drawable.s80,R.drawable.s90,R.drawable.s00, R.drawable.emptytransparent,R.drawable.tilldates
    };


    ViewpagerAdapter(Context context){
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

        Resources resources = mContext.getResources();

        Headings1 = resources.getStringArray(R.array.TLhead1);
        Headings2 = resources.getStringArray(R.array.TLhead2);
        Descriptions1 = resources.getStringArray(R.array.TLDescription1);
        Descriptions2 = resources.getStringArray(R.array.TLDescription2);

        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.timeline_layout,null);

        ImageView imageView1 = (ImageView) view.findViewById(R.id.Image1);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.Image2);

        imageView1.setImageResource(mImageIds[position]);
        imageView2.setImageResource(nImageIds[position]);

        //popup
        myDialog = new Dialog(mContext);


        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup(v,1,position);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup(v,2,position);
            }
        });


        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0,position);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }

    public void ShowPopup(View v, int ID,int pos){
        TextView txtclose,heading,description;
        ImageView ImageTapped;
        myDialog.setContentView(R.layout.custompopup);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        heading = (TextView) myDialog.findViewById(R.id.PopUpHeading);
        description = (TextView) myDialog.findViewById(R.id.PopUpDescription);
        ImageTapped = (ImageView) myDialog.findViewById(R.id.PopUpImage);

        if (ID == 1) {
            ImageTapped.setImageResource(mImageIds[pos]);
            heading.setText(Headings1[pos]);
            description.setText(Descriptions1[pos]);
        }else if (ID == 2){
            ImageTapped.setImageResource(nImageIds[pos]);
            heading.setText(Headings2[pos]);
            description.setText(Descriptions2[pos]);
        }


        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

}
