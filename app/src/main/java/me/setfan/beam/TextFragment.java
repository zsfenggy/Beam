package me.setfan.beam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.stefan.beam.bijection.BeamFragment;
import me.stefan.beam.bijection.RequiresPresenter;

/**
 * Created by Stefan on 2017/10/11.
 */
@RequiresPresenter(TextPresenter.class)
public class TextFragment extends BeamFragment<TextPresenter> implements View.OnClickListener {

    public static final String INDEX = "index";

    private TextView textView;

    public static TextFragment newInstance(int index) {
        Bundle args = new Bundle();
        TextFragment fragment = new TextFragment();
        args.putInt(INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_text, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.text);
        if (null != textView) {
            Bundle bundle = getArguments();
            int index = bundle.getInt(INDEX);
            textView.setText(String.valueOf(index));
            textView.setOnClickListener(this);
        }
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text:
                getPresenter().goThird();
                break;
        }
    }
}
