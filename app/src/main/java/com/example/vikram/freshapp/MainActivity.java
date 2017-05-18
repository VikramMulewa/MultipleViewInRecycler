package com.example.vikram.freshapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Itemclick {
    public List<Model> mainList;
    RecyclerView recycler;
    RecyclerAdaper adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = (RecyclerView)findViewById(R.id.recycler);
        mainList = new ArrayList<>();
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdaper(MainActivity.this,mainList);
        recycler.setAdapter(adapter);

        Model m1 = new Model();
        m1.setId("1");
        m1.setName("a");
        m1.setColor("red");
        m1.setType(1);
        mainList.add(m1);
        Model m8 = new Model();
        m8.setId("1");
        m8.setName("a");
        m8.setColor("red");
        m8.setType(2);
        mainList.add(m8);
        Model m2 = new Model();
        m2.setId("1");
        m2.setName("a");
        m2.setColor("red");
        m2.setType(1);
        mainList.add(m2);
        Model m3 = new Model();
        m3.setId("1");
        m3.setName("a");
        m3.setColor("red");
        m3.setType(1);
        mainList.add(m3);
        Model m4 = new Model();
        m4.setId("1");
        m4.setName("a");
        m4.setColor("red");
        m4.setType(1);
        mainList.add(m4);
        Model m5 = new Model();
        m5.setId("1");
        m5.setName("a");
        m5.setColor("red");
        m5.setType(2);
        mainList.add(m5);
        Model m6 = new Model();
        m6.setId("1");
        m6.setName("a");
        m6.setColor("red");
        m6.setType(2);
        mainList.add(m6);
        Model m7 = new Model();
        m7.setId("1");
        m7.setName("a");
        m7.setColor("red");
        m7.setType(2);
        mainList.add(m7);

        adapter.notifyDataSetChanged();
        adapter.setClickListener(this);
    }

    @Override
    public void onclick(int position) {

        Model a = mainList.get(position);
        if(a.getType()==1)
        {
            a.setType(2);
        }
        else
        {
            a.setType(1);
        }
        adapter.notifyItemChanged(position);
    }
}
