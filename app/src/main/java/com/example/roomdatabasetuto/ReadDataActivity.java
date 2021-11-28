package com.example.roomdatabasetuto;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReadDataActivity extends AppCompatActivity {
    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);
        rv=(RecyclerView)findViewById(R.id.rec);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        getData();
    }

    private void getData() {
        class GetData extends AsyncTask<Void,Void, List<MyDatalist>> {

            @Override
            protected List<MyDatalist> doInBackground(Void... voids) {
                List<MyDatalist>myDataLists=MainActivity.myDatabase.myDao().getMyData();
                return myDataLists;

            }

            @Override
            protected void onPostExecute(List<MyDatalist> myDataList) {
                MyAdapter adapter=new MyAdapter(myDataList);
                rv.setAdapter(adapter);
                super.onPostExecute(myDataList);
            }
        }
        GetData gd=new GetData();
        gd.execute();
    }
}
