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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment extends Fragment {

    private String names[] = {"White Bread", "French Bread", "Garlic Bread"
                                , "Monkey Bread", "Sourdough Bread"};
    Integer images[] = {R.drawable.white_bread, R.drawable.french_bread, R.drawable.garlic_bread, R.drawable.monkey_bread,
                        R.drawable.sourdough_bread};
    String details[] = {"Healthy, filling and wholesome, Whole Wheat loafs are essential to anyone's self-concious ",
                        "Warm, crunchy and fluffy french Baguette, servable with anything, delightful just by itsel",
                        "Italian Bread covered with garlic, olive oil and butter, topped it off with chives. A great side d",
                        "It is a soft, sweet, sticky pastry sprinkled with cinnamon served for breakfast or as a treat.",
                        "Bread unlike any other, with a mildly sour taste great for your main dish"};
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
                intent.putExtra("ITEM_DES", details[position]);
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
            view = getLayoutInflater().inflate(R.layout.popular_item, null);
            TextView textView = view.findViewById(R.id.itemNamePopular);
            ImageView imageView = view.findViewById(R.id.imageItemPopular);
            TextView textDes = view.findViewById(R.id.itemDesPopular);
            textView.setText(names[position]);
            imageView.setImageResource(images[position]);
            textDes.setText(details[position]);
            return view;
        }
    }

}
