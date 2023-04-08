package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class UserRowFragment extends Fragment {
    private final String TAG = this.getClass().getSimpleName();

    public UserRowFragment(){
        super(R.layout.fragment_user_row);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        Bundle data = this.getArguments();

        View view = inflater.inflate(R.layout.fragment_user_row, container, false);

        LinearLayout userRow = view.findViewById(R.id.userRow);
        TextView userName = view.findViewById(R.id.userNameTextView);
        ImageView userAvatar = view.findViewById(R.id.userAvatarImageView);
        TextView userPosition = view.findViewById(R.id.userPositionTextView);


        userName.setText(data.getString("user_name"));
        userAvatar.setImageResource(data.getInt("user_avatar"));
        userPosition.setText(data.getString("user_position"));

        return view;
    }


}