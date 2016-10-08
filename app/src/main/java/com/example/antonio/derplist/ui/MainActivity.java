package com.example.antonio.derplist.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.antonio.derplist.R;
import com.example.antonio.derplist.adapter.DerpAdapter;
import com.example.antonio.derplist.model.DerpData;
import com.example.antonio.derplist.model.ListItem;

import java.util.ArrayList;

//listactivity
public class MainActivity extends AppCompatActivity implements DerpAdapter.itemClickCallback{
private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";

    private RecyclerView mRecView;
    private DerpAdapter mAdapter;
private ArrayList ListData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListData = (ArrayList) DerpData.getListData();

        mRecView = (RecyclerView)findViewById(R.id.rec_list); //encontrar a recycler view
        //layoutmanager/gridlayoutmanager/staggeredlayoutmanager (estilo windows phone)
        mRecView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new DerpAdapter(DerpData.getListData(), this);
        mRecView.setAdapter(mAdapter);

        mAdapter.setItemClickCallback(this); //gestão do item clicks aqui
    }

    @Override
    public void onItemClick(int p) {
        ListItem item = (ListItem)ListData.get(p);

        Intent i = new Intent(this, DetailActivity.class);

        Bundle extras = new Bundle();
        extras.putString(EXTRA_QUOTE, item.getTitle());
        extras.putString(EXTRA_ATTR, item.getSubtitle());

        i.putExtra(BUNDLE_EXTRAS, extras);
        startActivity(i);
    }

    @Override
    public void onSecondaryIconClick(int p) {
            ListItem item = (ListItem) ListData.get(p);
        if(item.isFavorite())
        {
            item.setFavorite(false);
        }else{
            item.setFavorite(true);
        }
        mAdapter.setListData(ListData);
        mAdapter.notifyDataSetChanged();
    }
}
