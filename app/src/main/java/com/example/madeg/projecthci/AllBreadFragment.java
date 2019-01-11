package com.example.madeg.projecthci;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
public class AllBreadFragment extends Fragment {

    private String names[] = {"Crazy Dough Stuffed Bread", "French Bread", "Garlic Bread", "Iranian Bread"
                            , "Monkey Bread", "Scali Bread", "Sourdough Bread", "White Bread"};
    Integer images[] = {R.drawable.crazy_dough_stuffed_bread, R.drawable.french_bread,
                        R.drawable.garlic_bread, R.drawable.iranian_bread, R.drawable.monkey_bread, R.drawable.scali_bread, R.drawable.sourdough_bread, R.drawable.white_bread};
    String details[] = {"Get endless variations of completely different breads, from pizza dough, naan, focaccia, cinnamon rolls and even loafs of cheesy bread just from Crazy Dough.",
                        "Warm, crunchy and fluffy french Baguette, servable with anything, delightful just by itself.",
                        "Italian Bread covered with garlic, olive oil and butter, topped it off with chives. A great side dish for your pasta",
                        "Bread that has become a staple side dish for many Persian culinary",
                        "It is a soft, sweet, sticky pastry sprinkled with cinnamon served for breakfast or as a treat.",
                        "This shiny, mahogany-brown braid is heavily coated with sesame seeds, giving it nutty flavor and a lovely appearance.",
                        "Bread unlike any other, with a mildly sour taste great for your main dish",
                        "Healthy, filling and wholesome, Whole Wheat loafs are essential to anyone's self-concious diet."
    };
    View view;
    ListView listView;

    public AllBreadFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_all_bread, container, false);
        listView = view.findViewById(R.id.listItem);
        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("NAME_ITEM", names[position]);
                intent.putExtra("ITEM_IMAGE", images[position]);
                intent.putExtra("ITEM_DES", details[position]);
                startActivity(intent);
            }
        });

        return view;
    }

    public class MyAdapter extends BaseAdapter{

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
            TextView textDes = view.findViewById(R.id.itemDes);
            textView.setText(names[position]);
            imageView.setImageResource(images[position]);
            textDes.setText(details[position]);
            return view;
        }
    }
}
