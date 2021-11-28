package com.example.roomdatabasetuto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteDataActivity extends AppCompatActivity {
    EditText etText;
    Button deleteBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);

        etText=findViewById(R.id.int_data);
        deleteBtn=findViewById(R.id.btn_delete);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatalist md = new MyDatalist();
                String data=etText.getText().toString();
                int id=Integer.parseInt(data);
                MainActivity.myDatabase.myDao().delete(md);
            }
        });
    }
}
