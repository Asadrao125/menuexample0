package com.example.asadrao.menuexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    EditText edtText;
    private ActionMode mActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        edtText = findViewById(R.id.edtText);

        registerForContextMenu(tv1);
        registerForContextMenu(edtText);

        TextView textView = findViewById(R.id.textView);
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mActionMode != null)
                {
                    return false;
                }
                mActionMode = startSupportActionMode(mActionModeCallback);
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case R.id.menu1:
                Toast.makeText(this, "Menu 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2:
                Toast.makeText(this, "Menu 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu3:
                Toast.makeText(this, "Menu 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.color:
                Toast.makeText(this, "Color", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
     }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menulongpress,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.long1:
                Toast.makeText(this, "Long 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.long12:
                Toast.makeText(this, "Long 2", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.menulongpress,menu);
            actionMode.setTitle("Choose Your Option");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId())
            {
                case R.id.long1:
                    Toast.makeText(MainActivity.this, "Option 1", Toast.LENGTH_SHORT).show();
                    actionMode.finish();
                    return true;
                case R.id.long12:
                    Toast.makeText(MainActivity.this, "Option 2", Toast.LENGTH_SHORT).show();
                    actionMode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            mActionMode = null;
        }
    };
}
