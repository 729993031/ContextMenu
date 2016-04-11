package com.example.ContextMenu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import org.apache.http.impl.io.ContentLengthOutputStream;

public class MyActivity extends Activity {
    final int MENU1=0x111;
    final int MENU2=0x112;
    final int MENU3=0x113;
    private TextView text;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        text=(TextView)findViewById(R.id.txt);
        registerForContextMenu(text);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View source , ContextMenu.ContextMenuInfo menuInfo)
    {
        menu.add(0,MENU1,0,"红色");
        menu.add(0,MENU2,0,"绿色");
        menu.add(0,MENU3,0,"蓝色");
        menu.setGroupCheckable(0,true,true);
        menu.setHeaderIcon(R.drawable.tools);
        menu.setHeaderTitle("选择背景色");


    }
    @Override
    public boolean onContextItemSelected(MenuItem mi)
    {
        switch (mi.getItemId())
        {
            case MENU1:
                mi.setChecked(true);
                text.setBackgroundColor(Color.RED);
                break;
            case MENU2:
                mi.setChecked(true);
                text.setBackgroundColor(Color.GREEN);
                break;
            case  MENU3:
                mi.setChecked(true);
                text.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;
    }
}
