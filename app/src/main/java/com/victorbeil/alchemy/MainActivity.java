package com.victorbeil.alchemy;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    ElementContent elementContent = new ElementContent();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    TextView element1;
    TextView element2;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.button2);
        builder = new AlertDialog.Builder(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        element1 = (TextView) findViewById(R.id.textElement1);
        element2 = (TextView) findViewById(R.id.textElement2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kombinierbar1 = (element1.getText().length() > 0) ? element1.getText().toString() : "";
                String kombinierbar2 = (element2.getText().length() > 0) ? element2.getText().toString() : "";
                // check if user input maps a second element
                UserInput input = new UserInput(element1.getText().toString(),element2.getText().toString());
                int index = elementContent.getMappingIndex(input);
                if (index == -1) {
                    builder.setMessage(getString(R.string.failure));
                } else {
                    builder.setMessage(getString(R.string.success) + elementContent.getSecondElement(index));
                }
                AlertDialog dialog = builder.create();
                dialog.show();
                // empty fields
                element1.setText(new String(""));
                element2.setText(new String(""));
            }
        });

    }

    public void addElement(CharSequence element) {
        if (this.element1.getText().length() == 0) {
            this.element1.setText(element);
        } else if (this.element2.getText().length() == 0) {
            this.element2.setText(element);
        }
    }

    public void onClick(View v) {
        if (this.element1.getText().length() == 1 || this.element2.getText().length() == 1) {
            // empty fields
            this.element1.setText(new String(""));
            this.element2.setText(new String(""));
        }
    }
}