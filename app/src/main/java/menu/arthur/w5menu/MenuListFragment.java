package menu.arthur.w5menu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by arthur on 16-1-25.
 */


public class MenuListFragment extends Fragment {
    private View mMainView;


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


}
