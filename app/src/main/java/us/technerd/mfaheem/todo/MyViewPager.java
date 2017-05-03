package us.technerd.mfaheem.todo;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MyViewPager extends AppCompatActivity {
    private ViewPager mViewPager;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_pager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(3,this);

        mViewPager = (ViewPager) findViewById(R.id.myViewPager);
        mViewPager.setAdapter(myViewPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                Toast.makeText(MyViewPager.this," onPageScrolled Todo " + position,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(MyViewPager.this," onPageSelected Todo " + position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Toast.makeText(MyViewPager.this," onPageScrollStateChanged Todo state = " + state,Toast.LENGTH_SHORT).show();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public  class  MyViewPagerAdapter extends PagerAdapter{

        private int pageCount;
       // private View myView;
        LayoutInflater inflater ;


//        public View getMyView() {
//            return myView;
//        }
//
//        public void setMyView(View myView) {
//            this.myView = myView;
//        }



        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCountParam) {
            this.pageCount = pageCountParam;
        }

        public MyViewPagerAdapter(int pageCountParam,Context ctx) {
            this.setPageCount(pageCountParam);
            inflater = LayoutInflater.from(ctx);
        }

        @Override
        public int getCount() {
            return this.getPageCount();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
           // View v = (ViewGroup) inflater.inflate(R.layout.view_pager,collection,false);
            ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.view_pager, collection, false);
            collection.addView(layout);

            TextView txtView = (TextView) layout.findViewById(R.id.textView1);
            txtView.setText("Todo " + position);

            return layout;
        }

//        @Override
//        public Object instantiateItem(ViewGroup collection, int position) {
//            CustomPagerEnum customPagerEnum = CustomPagerEnum.values()[position];
//            LayoutInflater inflater = LayoutInflater.from(mContext);
//            ViewGroup layout = (ViewGroup) inflater.inflate(customPagerEnum.getLayoutResId(), collection, false);
//            collection.addView(layout);
//            return layout;
//        }
        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            ((ViewPager) collection).removeView(( View) view);
        }

    }

}
