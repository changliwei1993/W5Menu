package menu.arthur.w5menu;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

import menu.arthur.w5menu.viewpagerindicator.CirclePageIndicator;

public class MainActivity extends FragmentActivity {
    private ViewPager menu_viewpager;
    private CirclePageIndicator mIndicator;
    private String[] categoryList=new String[]{"学习","健康娱乐","应用工具"};
    ArrayList<PInfo> apps;
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
        listPackages();

        ArrayList<Fragment> fragmentArrayList=new ArrayList<>();
        for (int i=0;i<3;i++){
            MenuListFragment menuListFragment=new MenuListFragment();
            menuListFragment.setListItemDatas(apps);
            fragmentArrayList.add(menuListFragment);
        }

        MyViewPagerAdapter myViewPagerAdapter=new MyViewPagerAdapter(getSupportFragmentManager(),fragmentArrayList);
        menu_viewpager.setAdapter(myViewPagerAdapter);
        mIndicator.setViewPager(menu_viewpager);
    }

    private void listPackages() {
        apps = getInstalledApps(false);
    }

    private ArrayList<PInfo> getInstalledApps(boolean getSysPackages) {
        ArrayList<PInfo> res = new ArrayList<PInfo>();
        List<PackageInfo> packs = getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < packs.size(); i++) {
            PackageInfo p = packs.get(i);
            if ((!getSysPackages) && (p.versionName == null)) {
                continue;
            }
            PInfo newInfo = new PInfo();
            newInfo.appname = p.applicationInfo.loadLabel(getPackageManager())
                    .toString();
            newInfo.pname = p.packageName;
            newInfo.versionName = p.versionName;
            newInfo.versionCode = p.versionCode;
            newInfo.icon = p.applicationInfo.loadIcon(getPackageManager());
            res.add(newInfo);
        }
        return res;
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
