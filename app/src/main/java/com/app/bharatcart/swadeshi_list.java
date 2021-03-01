package com.app.bharatcart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.app.bharatcart.Adapters.MainAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class swadeshi_list extends Fragment {

    ExpandableListView list;
    List<String> listGroup;
    HashMap<String,List<String>> listItem;
    MainAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        View root = inflater.inflate(R.layout.swadeshi_page, container, false);
        list = root.findViewById(R.id.product_list);
        listGroup = new ArrayList<>();
        listItem = new HashMap<>();
        adapter = new MainAdapter(getContext(),listGroup,listItem);
        list.setAdapter(adapter);
        initListData();
        return root;
    }
    private void initListData(){
        listGroup.add(getString(R.string.Group1));
        listGroup.add(getString(R.string.Group2));
        listGroup.add(getString(R.string.Group3));
        listGroup.add(getString(R.string.Group4));
        listGroup.add(getString(R.string.Group5));
        listGroup.add(getString(R.string.Group6));
        listGroup.add(getString(R.string.Group7));
        listGroup.add(getString(R.string.Group8));
        listGroup.add(getString(R.string.Group9));
        listGroup.add(getString(R.string.Group10));
        listGroup.add(getString(R.string.Group11));
        listGroup.add(getString(R.string.Group12));
        listGroup.add(getString(R.string.Group13));
        listGroup.add(getString(R.string.Group14));
        listGroup.add(getString(R.string.Group15));
        listGroup.add(getString(R.string.Group16));
        listGroup.add(getString(R.string.Group17));
        listGroup.add(getString(R.string.Group18));
        listGroup.add(getString(R.string.Group19));
        listGroup.add(getString(R.string.Group20));
        listGroup.add(getString(R.string.Group21));
        String[] array;
        List<String> list1 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group1);
        for (String item: array){
            list1.add(item);
        }

        List<String> list2 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group2);
        for (String item: array){
            list2.add(item);
        }
        List<String> list3 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group3);
        for (String item: array){
            list3.add(item);
        }
        List<String> list4 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group4);
        for (String item: array){
            list4.add(item);
        }
        List<String> list5 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group5);
        for (String item: array){
            list5.add(item);
        }
        List<String> list6 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group6);
        for (String item: array){
            list6.add(item);
        }

        List<String> list7 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group7);
        for (String item: array){
            list7.add(item);
        }

        List<String> list8 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group8);
        for (String item: array){
            list8.add(item);
        }

        List<String> list9 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group9);
        for (String item: array){
            list9.add(item);
        }

        List<String> list10 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group10);
        for (String item: array){
            list10.add(item);
        }

        List<String> list11 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group11);
        for (String item: array){
            list11.add(item);
        }

        List<String> list12 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group12);
        for (String item: array){
            list12.add(item);
        }
        List<String> list13 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group13);
        for (String item: array){
            list13.add(item);
        }
        List<String> list14 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group14);
        for (String item: array){
            list14.add(item);
        }
        List<String> list15 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group15);
        for (String item: array){
            list15.add(item);
        }
        List<String> list16 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group16);
        for (String item: array){
            list16.add(item);
        }

        List<String> list17 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group17);
        for (String item: array){
            list17.add(item);
        }

        List<String> list18 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group18);
        for (String item: array){
            list18.add(item);
        }

        List<String> list19 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group19);
        for (String item: array){
            list19.add(item);
        }

        List<String> list20 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group20);
        for (String item: array){
            list20.add(item);
        }

        List<String> list21 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Group21);
        for (String item: array){
            list21.add(item);
        }

        listItem.put(listGroup.get(0),list1);
        listItem.put(listGroup.get(1),list2);
        listItem.put(listGroup.get(2),list3);
        listItem.put(listGroup.get(3),list4);
        listItem.put(listGroup.get(4),list5);
        listItem.put(listGroup.get(5),list6);
        listItem.put(listGroup.get(6),list7);
        listItem.put(listGroup.get(7),list8);
        listItem.put(listGroup.get(8),list9);
        listItem.put(listGroup.get(9),list10);
        listItem.put(listGroup.get(10),list11);
        listItem.put(listGroup.get(11),list12);
        listItem.put(listGroup.get(12),list13);
        listItem.put(listGroup.get(13),list14);
        listItem.put(listGroup.get(14),list15);
        listItem.put(listGroup.get(15),list16);
        listItem.put(listGroup.get(16),list17);
        listItem.put(listGroup.get(17),list18);
        listItem.put(listGroup.get(18),list19);
        listItem.put(listGroup.get(19),list20);
        listItem.put(listGroup.get(20),list21);
        adapter.notifyDataSetChanged();

}}
