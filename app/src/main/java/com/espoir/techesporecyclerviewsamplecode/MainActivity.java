package com.espoir.techesporecyclerviewsamplecode;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecycler;
    RecyclerView.LayoutManager linearLayoutManager;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> itemList= new ArrayList<>();
        itemList.add("Android");
        itemList.add("iOS");
        itemList.add("Windows");
        itemList.add("Mac");

        mRecycler = (RecyclerView) findViewById( R.id.recyclerView);
        linearLayoutManager   = new GridLayoutManager(this,2);
        mRecycler.setLayoutManager(linearLayoutManager);

        mAdapter  = new MyAdapter(itemList);
        mRecycler.setAdapter(mAdapter);


    }

    public class MyAdapter extends  RecyclerView.Adapter<MyAdapter.MyViewHolder>{

       ArrayList<String> items;
        public MyAdapter(ArrayList<String> items){
            this.items = items;
        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View  v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_item_row_layout, parent, false);
            MyViewHolder  holder = new MyViewHolder(v);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            holder.textview.setText(items.get(position));

        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder{
            TextView textview;
            public MyViewHolder(View itemView) {
                super(itemView);
                textview =  (TextView) itemView.findViewById(R.id.textView);
            }
        }
    }
}
