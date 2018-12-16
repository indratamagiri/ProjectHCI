package com.example.madeg.projecthci;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment extends Fragment {

    private String names[] = {"Crazy Dough Stuffed Bread", "French Bread", "Garlic Bread", "Iranian Bread"
                                , "Monkey Bread", "Scali Bread", "Sourdough Bread", "White Bread"};
    Integer images[] = {R.drawable.crazy_dough_stuffed_bread, R.drawable.french_bread, R.drawable.garlic_bread, R.drawable.iranian_bread,
                        R.drawable.monkey_bread, R.drawable.scali_bread, R.drawable.sourdough_bread, R.drawable.white_bread};
    String details[] = {};
    View view;
    ListView listView;


    public PopularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_popular, container, false);
        listView = view.findViewById(R.id.listItemPopular);
        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("NAME_ITEM", names[position]);
                intent.putExtra("ITEM_IMAGE", images[position]);
                startActivity(intent);
            }
        });
        return view;
    }

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.all_item, null);
            TextView textView = view.findViewById(R.id.itemName);
            ImageView imageView = view.findViewById(R.id.imageItem);

            textView.setText(names[position]);
            imageView.setImageResource(images[position]);
            return view;
        }
    }

}
