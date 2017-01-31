package com.example.rndroid.customadapter_ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edSno, edName, edSal;
    Button btAdd;
    ListView lv;
    ArrayList<Employee> al;
    MyAdapter myAdapter;

    public class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return al.size();
        }
        @Override
        public Object getItem(int i) {
            return null;
        }
        @Override
        public long getItemId(int i) {
            return 0;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Employee e = al.get(i);
            View v = getLayoutInflater().inflate(R.layout.row, null);
            TextView tv1 = (TextView) v.findViewById(R.id.tvSno);
            TextView tv2 = (TextView) v.findViewById(R.id.tvSname);
            TextView tv3 = (TextView) v.findViewById(R.id.tvSal);
            Log.d("Log.Count",""+i);
            tv1.setText(e.geteSNo());
            tv2.setText(e.geteName());
            tv3.setText(e.geteSal());

            return v;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edSno = (EditText) findViewById(R.id.edSno);
        edName = (EditText) findViewById(R.id.edName);
        edSal = (EditText) findViewById(R.id.edSal);
        btAdd = (Button) findViewById(R.id.btAdd);
        lv = (ListView) findViewById(R.id.lv1);

        al = new ArrayList<Employee>();
        myAdapter = new MyAdapter();

        lv.setAdapter(myAdapter);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee e = new Employee();

                String no = edSno.getText().toString().trim();
                String name = edName.getText().toString().trim();
                String sal = edSal.getText().toString().trim();

                if (no.isEmpty() || name.isEmpty() || sal.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Fill All Details", Toast.LENGTH_SHORT).show();
                }else {
                    e.seteSNo(no);
                    e.seteName("Name - " + name);
                    e.seteSal("Salary - " + sal);
                    al.add(e);

                    myAdapter.notifyDataSetChanged();
                    edSno.setText("");
                    edSal.setText("");
                    edName.setText("");
                    edSno.requestFocus();
                }
            }
        });
    }
}
