package menu.arthur.w5menu;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.ArrayList;

import menu.arthur.w5menu.viewpagerindicator.CirclePageIndicator;

public class MainActivity extends FragmentActivity {
    private ViewPager menu_viewpager;
    private CirclePageIndicator mIndicator;
    private String[] categoryList=new String[]{"学习","健康娱乐","应用工具"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        menu_viewpager=(ViewPager)findViewById(R.id.menu_viewpager);
        mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
        ArrayList<Fragment> fragmentArrayList=new ArrayList<>();
        for (int i=0;i<3;i++){
            ArrayList<ItemDatas> listItemDatas=new ArrayList<>();
            ItemDatas itemDatas=new ItemDatas();
            itemDatas.setName(categoryList[i]);
            listItemDatas.add(itemDatas);
            listItemDatas.add(itemDatas);
            listItemDatas.add(itemDatas);
            listItemDatas.add(itemDatas);
            MenuListFragment menuListFragment=new MenuListFragment();
            menuListFragment.setListItemDatas(listItemDatas);
            fragmentArrayList.add(menuListFragment);
        }

        MyViewPagerAdapter myViewPagerAdapter=new MyViewPagerAdapter(getSupportFragmentManager(),fragmentArrayList);
        menu_viewpager.setAdapter(myViewPagerAdapter);
        mIndicator.setViewPager(menu_viewpager);
    }



    private class MyViewPagerAdapter extends FragmentPagerAdapter {
        private  ArrayList<Fragment> fragmentArrayList=null;

        private MyViewPagerAdapter(FragmentManager fm,ArrayList<Fragment> fragmentArrayList) {
            super(fm);
            // TODO Auto-generated constructor stub
            this.fragmentArrayList=fragmentArrayList;
        }

        @Override
        public Fragment getItem(int arg0) {
            return fragmentArrayList.get(arg0);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }

        @Override
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
        }


    }
}
