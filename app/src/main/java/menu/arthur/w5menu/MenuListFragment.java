package menu.arthur.w5menu;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by arthur on 16-1-25.
 */


public class MenuListFragment extends Fragment {
    private View mMainView;
    private ArrayList<PInfo> listItemDatas=new ArrayList<>();
    private ListView menu_listview;


    public MenuListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        initView();
    }
    private void initView() {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        mMainView = inflater.inflate(R.layout.menu_list_fragment, (ViewGroup) getActivity().findViewById(R.id.menu_viewpager), false);
        menu_listview=(ListView)mMainView.findViewById(R.id.menu_listview);
        MainListAdapter mainListAdapter=new MainListAdapter(getActivity());
        menu_listview.setAdapter(mainListAdapter);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        ViewGroup p = (ViewGroup) mMainView.getParent();
        if (p != null) {
            p.removeAllViewsInLayout();
        }
        return mMainView;
    }


    public void setListItemDatas(ArrayList<PInfo> listItemDatas) {
        this.listItemDatas = listItemDatas;
    }



    private class MainListAdapter extends BaseAdapter {

        private LayoutInflater mInflater = null;
        private Context context;
        public MainListAdapter(Context context) {
            this.context = context;
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return listItemDatas.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.menu_list_item, null);
                holder.appName = (TextView) convertView.findViewById(R.id.appName);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.appName.setText(listItemDatas.get(position).appname
            );
            return convertView;
        }

        @Override
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
        }

        class ViewHolder {
            public TextView appName;
        }
    }
}
