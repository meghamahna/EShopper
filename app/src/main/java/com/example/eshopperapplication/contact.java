package com.example.eshopperapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class contact extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contact_frag, container, false);


    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {

        ImageView facebook = (ImageView) getView().findViewById(R.id.facebbok);
        ImageView gmail = view.findViewById(R.id.gmail);
        ImageView twitter = view.findViewById(R.id.twitter);





        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Contact_Link.class);
                String link = "https://www.facebook.com/?ref=tn_tnmn";
                i.putExtra("link",link);
                startActivity(i);
            }
        });


        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Contact_Link.class);
                String link = "https://mail.google.com/mail/u/0/#inbox?compose=CllgCKCHVCdRPFKgMvBcBTRrnMqThDHzbHNQWLhQpsXdPGNLcTMrkWCjmDLPkTFhFfBvWMdxCKg";
                i.putExtra("link",link);
                startActivity(i);
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Contact_Link.class);
                String link = "https://www.youtube.com/watch?v=TUXui5ItBkM";
                i.putExtra("link",link);
                startActivity(i);
            }
        });




    }
}
