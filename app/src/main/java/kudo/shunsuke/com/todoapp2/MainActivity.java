package kudo.shunsuke.com.todoapp2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText editText;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        editText = (EditText)findViewById(R.id.editText);
        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1);

        class tag{

        }


        listView.setAdapter(adapter);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick (AdapterView < ? > parent, View view,int position, long id) {


                    ArrayAdapter adapter = (ArrayAdapter) listView.getAdapter();
                    String item = (String) adapter.getItem(position);

                        //タッチして消しているとこはlistViewではなく、adapterって部分なんだよ～
                        Toast.makeText(getText(), item + "を消去しましたよ～", Toast.LENGTH_SHORT).show();
                        adapter.remove(item);

                    return false;
                }
         });
    };

    public void add (View v){


        String text;
        text = editText.getText().toString();

        if (text.equals( "")) {
            // do nothing
        }else {
            Toast.makeText(this, text + "を追加しましたよ", Toast.LENGTH_SHORT).show();
            adapter.add(text);
            editText.getText().clear();
        }
    }

    public Context getText(){return this;}
}

