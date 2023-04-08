package com.example.myproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserListSelectorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserListSelectorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UserListSelectorFragment() {
        // Required empty public constructor
    }

    public static UserListSelectorFragment newInstance(String param1, String param2) {
        UserListSelectorFragment fragment = new UserListSelectorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_list_selector, container, false);

        Button listViewSelectButton = view.findViewById(R.id.listViewSelectButton);
        Button recyclerViewSelectButton = view.findViewById(R.id.recyclerViewSelectButton);

        listViewSelectButton.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.contentFragmentContainer,
                    new UserListViewFragment(DataBase.users), "UsersListViewFragment").commit();
        });

        recyclerViewSelectButton.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.contentFragmentContainer,
                    new UserRecyclerViewFragment(DataBase.users), "UsersrecyclerViewFragment").commit();
        });

        return view;
    }



}