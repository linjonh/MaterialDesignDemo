package com.material.mao.materialstudy;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.material.mao.materialstudy.adapter.MyAdapter;
import com.material.mao.materialstudy.anim.MyItemAnimation;
import com.material.mao.materialstudy.entity.BaseHouseEntity;
import com.material.mao.materialstudy.view.DividerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MyActivity extends ActionBarActivity implements SwipeRefreshLayout.OnRefreshListener {
    @InjectView(R.id.my_recycler_view)
    RecyclerView mMyRecyclerView;
    @InjectView(R.id.left_drawer)
    ListView mLeftDrawer;
    @InjectView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @InjectView(R.id.tv_del)
    TextView mTvDel;
    @InjectView(R.id.tv_add)
    TextView mTvAdd;
    @InjectView(R.id.fl_content)
    FrameLayout mFlContent;
    @InjectView(R.id.srl_flush)
    SwipeRefreshLayout mSrlFlush;
    private MyAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private String[] mPlanetTitles;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ButterKnife.inject(this);
        initMainContent();
        initDrawerLayout();

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        Drawable myDrawable = getResources().getDrawable(R.color.primary);
        getSupportActionBar().setBackgroundDrawable(myDrawable);

        mSrlFlush.setOnRefreshListener(this);
        mSrlFlush.setProgressBackgroundColor(R.color.white_bg);
        mSrlFlush.setColorScheme(
                android.R.color.holo_blue_light,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private void initMainContent() {
        mMyRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mMyRecyclerView.setLayoutManager(mLayoutManager);

        DividerView dividerView = new DividerView(this);
        mMyRecyclerView.addItemDecoration(dividerView);

        //mMyRecyclerView.setItemAnimator(new MyItemAnimation());

        mAdapter = new MyAdapter(getInitData());
        mMyRecyclerView.setAdapter(mAdapter);

        mMyRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    mTvDel.setVisibility(View.INVISIBLE);
                } else {
                    mTvDel.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private List<BaseHouseEntity> getInitData() {
        List<BaseHouseEntity> datas = new ArrayList<BaseHouseEntity>();
        datas.add(new BaseHouseEntity("Chow"));
        datas.add(new BaseHouseEntity("58"));
        datas.add(new BaseHouseEntity("WeChat"));
        datas.add(new BaseHouseEntity("MiChat"));
        datas.add(new BaseHouseEntity("WeiBo"));
        datas.add(new BaseHouseEntity("Google+"));
        datas.add(new BaseHouseEntity("Google+"));
        datas.add(new BaseHouseEntity("Google+"));
        datas.add(new BaseHouseEntity("Chow"));
        datas.add(new BaseHouseEntity("58"));
        datas.add(new BaseHouseEntity("WeChat"));
        datas.add(new BaseHouseEntity("MiChat"));
        datas.add(new BaseHouseEntity("WeiBo"));
        datas.add(new BaseHouseEntity("Google+"));
        datas.add(new BaseHouseEntity("Google+"));
        datas.add(new BaseHouseEntity("Google+"));
        datas.add(new BaseHouseEntity("Chow"));
        datas.add(new BaseHouseEntity("58"));
        datas.add(new BaseHouseEntity("WeChat"));
        datas.add(new BaseHouseEntity("MiChat"));
        datas.add(new BaseHouseEntity("WeiBo"));
        datas.add(new BaseHouseEntity("Google+"));
        datas.add(new BaseHouseEntity("Google+"));
        datas.add(new BaseHouseEntity("Google+"));
        return datas;
    }

    private void initDrawerLayout() {
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.string.abc_action_bar_home_description,
                R.string.abc_action_bar_up_description) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle(R.string.app_name);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Menu");
            }

        };

        mPlanetTitles = getResources().getStringArray(R.array.planets_array);
        mLeftDrawer.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, R.id.tv_action, mPlanetTitles));


        //mLeftDrawer.setOnItemClickListener();
    }

    @OnClick(R.id.tv_add)
    public void onClickAdd(View view) {
        int position = mLayoutManager.findFirstCompletelyVisibleItemPosition();
        if (position >= 0) {
            mAdapter.addItem(position);
        }
    }

    @OnClick(R.id.tv_del)
    public void onClickDel(View view) {
        int position = mLayoutManager.findLastCompletelyVisibleItemPosition() - 3;
        if (position >= 0) {
            mAdapter.removeItem(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private boolean isRefresh = false;
    @Override
    public void onRefresh() {
        if(!isRefresh){
            isRefresh = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mSrlFlush.setRefreshing(false);
                    mAdapter.addItem(0);
                    isRefresh = false;
                }
            },2000);
        }

    }
}
