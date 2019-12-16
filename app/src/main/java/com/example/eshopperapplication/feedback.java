package com.example.eshopperapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class feedback extends Fragment {
    String nametext;
    String feedbacktext;
    EditText name1;
    EditText email1;
    TextView feedback1;
    ArrayList<String > name = new ArrayList<>();
    ArrayList<String > feedback = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.feed_frag, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button button = (Button)getView().findViewById(R.id.send);
        name1 = (EditText) getView().findViewById(R.id.nametext);
        email1 = (EditText)getView().findViewById(R.id.emailtxt);
        feedback1 = (TextView)getView().findViewById(R.id.feedback);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nametext = name1.getText().toString();
                feedbacktext = feedback1.getText().toString();

                feedback.add(feedbacktext);
                name.add(nametext);

                new AlertDialog.Builder(getActivity()).setTitle(" Thank you for your feedback").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();









                name1.setText("");
                feedback1.setText("");
                email1.setText("");
            }
        });


    }
}

