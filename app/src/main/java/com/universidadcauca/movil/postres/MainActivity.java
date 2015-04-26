package com.universidadcauca.movil.postres;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.universidadcauca.movil.postres.adapters.PostreAdapter;
import com.universidadcauca.movil.postres.models.Postre;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    ListView list;
    List<Postre> data;
    PostreAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);

        data = new ArrayList<Postre>();
        adapter = new PostreAdapter(this, data);

        list.setAdapter(adapter);
        loadPostres();
    }

    private void loadPostres() {

        data.clear();
        String postres[] = getResources().getStringArray(R.array.postres);

        for(int i=0;i< postres.length;i++){
            String postreData[] = postres[i].split("#");
            Postre postre =  new Postre();
            postre.setNombre(postreData[0]);
            postre.setDescripcion(postreData[1]);
            postre.setTiempo(postreData[2]);
            postre.setPrecio(postreData[3]);
            data.add(postre);
        }
        adapter.notifyDataSetChanged();




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
