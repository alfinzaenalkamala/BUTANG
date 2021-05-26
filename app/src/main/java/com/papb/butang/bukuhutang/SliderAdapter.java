package com.papb.butang.bukuhutang;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.papb.butang.bukuhutang.R;
import com.squareup.picasso.Picasso;


public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public  SliderAdapter(Context context){
        this.context = context;
    }


//menyimpan url untuk picaso untuk ditampilkan pada slide view
    public String[] slide_image={
            "https://github.com/alfinzaenalkamala/BUTANG/blob/master/app/src/main/res/drawable/iconbutang.png",
            "https://cdn.pixabay.com/photo/2015/02/27/08/12/members-651819_960_720.png",
            "https://lh3.googleusercontent.com/proxy/Ui753s5vKqKKEnFzVAiE68N5UEmJ9JH-hrJ1ao5aaMyvOK6askmcfy9GOvsmm6Ym2izHaR1vho6KcmuAKs2acmCL4aMJvZU1x9kgC0BoOQ1LV221TrC8fh1LLSpHA2rL"
    };

    //menyimpan text untuk ditampilkan pada slide view
    public String[] slide_headings={
            "Butang (Buku Hutang)",
            "TIM LULUS CEPAT",
            "PAPB B FILKOM UB"
    };

    //menyimpan text untuk ditampilkan pada slide view
    public  String[] slide_descs = {
            "Buku Utang (Butang) adalah Aplikasi untuk pencatatan transaksi secara hutang yang dimana aplikasi ini dapat menyimpan data hutang yang telah dilakukan.",
            "Javier Ardra Figo, Abdiel Wahyu Ramadhyono, Alfin Zaenal Kamala, Ahmad Wildan Jauhari",
            "Jalan Veteran No.8, Ketawanggede, Kecamatan Lowokwaru, Ketawanggede, Kec. Lowokwaru, Kota Malang, Jawa Timur 65145"
    };


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return  view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.imageView);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription= (TextView) view.findViewById(R.id.slide_desc);
        //untuk menampilkan image dari url sesuai posisi
        Picasso.with(context).load(slide_image[position]).placeholder(R.drawable.profil).error(R.drawable.warning).into(slideImageView);
        //untuk mengatur isi teksview dari array yang telah disimpan
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
