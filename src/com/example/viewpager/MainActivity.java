package com.example.viewpager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnPageChangeListener {

	private List<ImageView> imageviewList;
	private ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		prepareData();
		ViewPagerAdapter adapter = new ViewPagerAdapter();
		mViewPager.setAdapter(adapter);
		mViewPager.setOnPageChangeListener(this);
	}

	private void prepareData() {
		imageviewList = new ArrayList<ImageView>();
		int[] imageResIDs = getImageResIDs();
		ImageView iv;
		for (int i = 0; i < imageResIDs.length; i++) {
			iv = new ImageView(this);
			iv.setBackgroundResource(imageResIDs[i]);
			imageviewList.add(iv);
		}
	}

	private int[] getImageResIDs() {
		return new int[] {
 R.drawable.app_start_5,
				R.drawable.app_start_1,
				R.drawable.app_start_2,
				R.drawable.app_start_3,
				R.drawable.app_start_4,
				R.drawable.app_start_5,
 R.drawable.app_start_1,
		};
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int positon) {
		if(imageviewList.size()>1){
			if (positon < 1) {
				positon = 5;
				//取消滑动动画
				mViewPager.setCurrentItem(5, false);
			} else if (positon > 5) {
				positon = 1;
				//取消滑动动画
				mViewPager.setCurrentItem(1, false);
			}
		}
	}

	class ViewPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return imageviewList.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(imageviewList.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(imageviewList.get(position));
			return imageviewList.get(position);
		}

	}
}
