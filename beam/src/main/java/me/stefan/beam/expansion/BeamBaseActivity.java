package me.stefan.beam.expansion;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import me.stefan.beam.R;
import me.stefan.beam.bijection.BeamAppCompatActivity;
import me.stefan.beam.bijection.Presenter;

/**
 * Created by Mr.Jude on 2015/8/17.
 */
public class  BeamBaseActivity<T extends Presenter> extends BeamAppCompatActivity<T> {
    //如果使用了ToolBar则自动部署。没有则无影响。
//    private Toolbar toolbar;

//    /**
//     *      视图结构
//     *                    DecorView
//     *                        |
//     *                    LinearLayout
//     *                    /         \
//     *                   /           \
//     *           FrameLayout       FrameLayout
//     *            |             (mContentParent)
//     *            |                   /      \
//     *         TextView     FrameLayout    各种附加View
//     *                      (mContent)
//     *                  (在一开始就装入View树)
//     *                          |
//     *                      setContent()
//     *                  (什么时候装入View不确定)
//     *
//     */
//    private FrameLayout mContent;
//    private FrameLayout mContentParent;
//
//    @Override
//    public void preCreatePresenter() {
//        super.preCreatePresenter();
//        initViewTree();
//    }
//
//    private void initViewTree(){
//        mContentParent = (FrameLayout) findViewById(android.R.id.content);
//        mContent = new FrameLayout(this);
//        super.setContentView(mContent);
//    }
//
//    public FrameLayout getParentView(){
//        return mContentParent;
//    }
//
//    @Override
//    public void setContentView(int layoutResID) {
//        this.setContentView(getLayoutInflater().inflate(layoutResID, mContent, false));
//    }
//
//    @Override
//    public void setContentView(View view) {
//        this.setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//    }
//
//    @Override
//    public void setContentView(View view, ViewGroup.LayoutParams params) {
//        mContent.addView(view, params);
//        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
//        if (toolbar!=null)
//            onSetToolbar(toolbar);
//    }
//
//    public Toolbar getToolbar(){
//        return toolbar;
//    }
//
//    public void onSetToolbar(Toolbar toolbar){
//        setSupportActionBar(toolbar);
//        ActionBar actionBar= getSupportActionBar();
//        if(null==actionBar) return;
//        actionBar.setDisplayHomeAsUpEnabled(true);
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}