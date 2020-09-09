package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ActTwo extends AppCompatActivity {

    private static final int CM_DELETE_ID = 1;


    Button btnAddNewTask;
    List<String> toDoList;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    EditText editText;

    final int MENU_EDIT = 1;
    final int MENU_DELETE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_two);

        toDoList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this,R.layout.list_view_layout,toDoList);
        listView = findViewById(R.id.id_list_view);

        listView.setAdapter(arrayAdapter);
        registerForContextMenu(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });

        editText = findViewById(R.id.id_edit_text);
    }

    public void AddItemToList(View view){
        toDoList.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();
        editText.setText("");
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, CM_DELETE_ID, 0, "Delete");
       
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == CM_DELETE_ID) {
            // получаем инфу о пункте списка
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            // удаляем Map из коллекции, используя позицию пункта в списке
            toDoList.remove(acmi.position);
            // уведомляем, что данные изменились
            arrayAdapter.notifyDataSetChanged();
            return true;
        }

        return super.onContextItemSelected(item);
    }
}

