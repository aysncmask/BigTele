package com.eheartcare.docdemo.docdemo.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.eheartcare.docdemo.docdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/3/16 0016.
 */
public class HomeFragment extends Fragment implements ViewPager.OnPageChangeListener {
    View rootView;
    @Bind(R.id.vp_home_adv)
    ViewPager vpHomeAdv;
    int mPosition = 0;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            vpHomeAdv.setCurrentItem(mPosition);
            if(mPosition<4){
            mPosition++;}
            if(mPosition==4){
            mPosition=0;
            }
            sendEmptyMessageDelayed(0,2000);
        }
    };
    @Bind(R.id.rg_home_adv)
    RadioGroup rgHomeAdv;
    @Bind(R.id.rb_home_adv_p1)
    RadioButton rbHomeAdvP1;
    @Bind(R.id.rb_home_adv_p2)
    RadioButton rbHomeAdvP2;
    @Bind(R.id.rb_home_adv_p3)
    RadioButton rbHomeAdvP3;
    @Bind(R.id.rb_home_adv_p4)
    RadioButton rbHomeAdvP4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            rootView = View.inflate(container.getContext(), R.layout.fragment_home, null);
            ButterKnife.bind(this, rootView);
            rgHomeAdv.check(R.id.rb_home_adv_p1);
          //  handler.sendEmptyMessage(0);
            vpHomeAdv.setAdapter(new VpHomeAdvAdapter());
            vpHomeAdv.addOnPageChangeListener(this);



        return rootView;
    }





    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.sendEmptyMessage(0);
    }

    @Override
    public void onStop() {
        super.onStop();
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                rgHomeAdv.check(R.id.rb_home_adv_p1);
                break;
            case 1:
                rgHomeAdv.check(R.id.rb_home_adv_p2);
                break;
            case 2:
                rgHomeAdv.check(R.id.rb_home_adv_p3);
                break;
            case 3:
                rgHomeAdv.check(R.id.rb_home_adv_p4);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("test","destory");
    }

    public class VpHomeAdvAdapter extends PagerAdapter implements View.OnTouchListener {




        int[] color = {Color.BLUE, Color.GREEN, Color.RED, Color.BLACK};

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {


            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView iv = new ImageView(container.getContext());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
            params.height = ViewGroup.LayoutParams.MATCH_PARENT;
            params.width = ViewGroup.LayoutParams.MATCH_PARENT;
            iv.setBackgroundColor(color[position]);
            iv.setLayoutParams(params);
            iv.setOnTouchListener(this);
            container.addView(iv);
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);

        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    handler.removeCallbacksAndMessages(null);
                    System.out.println("手指按下，停止轮播");
                    break;
                case MotionEvent.ACTION_UP:
                    handler.sendMessageDelayed(Message.obtain(), 3000);
                    System.out.println("手指抬起，继续轮播");
                    break;
                case MotionEvent.ACTION_CANCEL:
                    handler.sendMessageDelayed(Message.obtain(), 3000);
                    System.out.println("事件取消，继续轮播");
                    break;

                default:
                    break;
            }
            return true;


        }
    }
}
