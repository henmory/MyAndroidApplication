package com.henmory.test.glidetest.view.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.henmory.test.R;
import com.henmory.test.glidetest.presenter.BookPresenter;
import com.henmory.test.glidetest.view.adapter.ItemBean;
import com.henmory.test.glidetest.view.adapter.MyRecycylerViewAdapter;
import com.henmory.test.glidetest.bean.BookBean;
import com.henmory.test.glidetest.net.APIMethods;
import com.henmory.test.glidetest.net.ObserverOnNextListener;
import com.henmory.test.glidetest.net.ProgressObserver;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;
import static android.widget.AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL;
import static android.widget.NumberPicker.OnScrollListener.SCROLL_STATE_FLING;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @description: fragment与actiivty的声明周期，由于fragment调用形式和log打印的位置不同而不同
 * 1.fragment可以在xml文件中直接定义
 * 2.可以在创建好activity之后再创建fragment（动态添加）
 * 3.可以在其他控件中new fragment
 * <p>
 * 4.这些都导致activity与fragment生命周期不一样
 * 5.同时log语句所在位置不同也会不同，应该把它放到super.start一起才行
 * 6.总而言之，创建的时候fragment要先创建好，销毁的时候fragment要先销毁
 * 7.所以不能断定到底他们的生命周期是怎样的
 **/
public class MyFragment extends Fragment {

    private static final String TAG = MyFragment.class.getSimpleName();
    private Context mContext;
    private static final String TITLE = "title";
    private static final String CONTENT = "content";
    @BindView(R.id.rc)
    RecyclerView rc;
    Unbinder unbinder;

    private String title;
    private MyRecycylerViewAdapter myRecycylerViewAdapter;

    public String getTitle() {
        return title;
    }


    private OnFragmentInteractionListener mListener;


    public MyFragment() {
        // Required empty public constructor
    }

    public static MyFragment newInstance(Context context, String title, String content) {
        MyFragment fragment = new MyFragment();
        fragment.mContext = context;
        fragment.title = title; //关键代码

        Bundle args = new Bundle();
        args.putString(TITLE, title);
        args.putString(CONTENT, content);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
       // this.mContext = getActivity();//可以获取actiivty

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(TITLE);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_my2, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    //fragment定义一个回调接口，以便activity回调，传数据给activity

    /**
     * @param
     * @return
     * @author henmory
     * @date 4/12/18
     * @description 步骤：
     * 1.fragment定义接口
     * 2.并声明一个接口变量
     * 3.在需要回传数据的时候调用这个变量的方法即可，而这个变量其实是只指向activity的
     * 4.因为activity要实现这个接口，从而实现了数据的回传
     */
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);//butterknife记得一定要在加载完view之后调用，否则会出现控件为null 的情况
        initRecyclerView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    /**
     *  @author henmory
     *  @date 4/16/18
     *  @description 界面初始化好了之后初始化数据
     *
     *  @param
     *
     *  @return
    */
    private void initRecyclerView() {

        List<ItemBean> items = new ArrayList<>();

        myRecycylerViewAdapter = new MyRecycylerViewAdapter(null, mContext);

        rc.setAdapter(myRecycylerViewAdapter);
        rc.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));

        rc.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));




        //慢滑动的时候加载数据，快滑动不加载
        rc.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState) {

                    case SCROLL_STATE_IDLE:
                        Log.i("ListView", "视图已经停止滑动");
                        Glide.with(mContext).resumeRequests();
                        break;


                    case SCROLL_STATE_FLING:
                        Log.i("ListView", "用户在手指离开屏幕之前，由于滑了一下，视图仍然依靠惯性继续滑动");
                        Glide.with(mContext).pauseRequests();
                        //刷新
                        break;


                    case SCROLL_STATE_TOUCH_SCROLL:
                        Log.i("ListView", "手指没有离开屏幕，视图正在滑动");
                        Glide.with(mContext).resumeRequests();
                        break;
                }


            }


        });



        myRecycylerViewAdapter.setOnItemClickListener(new MyRecycylerViewAdapter.onItemClickLisenter() {
            @Override
            public void onItemClick(int position) {
                System.out.println("position = " + position);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        System.out.println("fragment - onAttach");
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach() {
        System.out.println("fragment - onDetach");
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    /**
     * @param
     * @return
     * @author henmory
     * @date 4/12/18
     * @description 处理懒加载的问题
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

}
