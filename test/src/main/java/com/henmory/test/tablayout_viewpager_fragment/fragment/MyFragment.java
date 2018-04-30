package com.henmory.test.tablayout_viewpager_fragment.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.henmory.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @description: fragment与actiivty的声明周期，由于fragment调用形式和log打印的位置不同而不同
 *              1.fragment可以在xml文件中直接定义
 *              2.可以在创建好activity之后再创建fragment（动态添加）
 *              3.可以在其他控件中new fragment
 *
 *              4.这些都导致activity与fragment生命周期不一样
 *              5.同时log语句所在位置不同也会不同，应该把它放到super.start一起才行
 *              6.总而言之，创建的时候fragment要先创建好，销毁的时候fragment要先销毁
 *              7.所以不能断定到底他们的生命周期是怎样的
 *
 **/
public class MyFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TITLE = "title";
    private static final String CONTENT = "content";



    private String title;
    private String content;

    public String getTitle() {
        return title;
    }


    public String getContent() {
        return content;
    }

    private OnFragmentInteractionListener mListener;

    @BindView(R.id.fragment_textview)
    TextView textView;
    public MyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title Parameter 1.
     * @param content Parameter 2.
     * @return A new instance of fragment MyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyFragment newInstance(String title, String content) {
        MyFragment fragment = new MyFragment();
        fragment.title = title; //关键代码
        fragment.content = content;//关键代码
        Bundle args = new Bundle();
        args.putString(TITLE, title);
        args.putString(CONTENT, content);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(TITLE);
            content = getArguments().getString(CONTENT);
            System.out.println(this.toString());
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    //fragment定义一个回调接口，以便activity回调，传数据给activity
    /**
     *  @author henmory
     *  @date 4/12/18
     *  @description 步骤：
     *                  1.fragment定义接口
     *                  2.并声明一个接口变量
     *                  3.在需要回传数据的时候调用这个变量的方法即可，而这个变量其实是只指向activity的
     *                  4.因为activity要实现这个接口，从而实现了数据的回传
     *
     *  @param
     *
     *  @return
    */
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        System.out.println("fragment - onCreateView");
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);//butterknife记得一定要在加载完view之后调用，否则会出现控件为null 的情况

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        System.out.println("fragment - onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        textView.setText(content);
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
     *  @author henmory
     *  @date 4/12/18
     *  @description 处理懒加载的问题
     *
     *  @param
     *
     *  @return
    */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }


    @Override
    public String toString() {
        return "MyFragment{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
