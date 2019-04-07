package library.yangshijing;

import library.yangshijing.util.DBOperator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ShowlistActivity extends Activity {
    private ListView listView;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showlist_yangshijing);

        listView = (ListView) this.findViewById(R.id.checkout_listview);
        listView.setOnItemClickListener(new ItemClickListener());

        // get the sql string delivered from the QueryActivity
        Intent intent = this.getIntent();
        String sql = intent.getStringExtra("sql");
        // execute the sql
        Cursor cursor = DBOperator.getInstance().execQuery(sql);
        // bind the data to list
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                getApplicationContext(), R.layout.listitem_yangshijing, cursor,
                new String[] {"stdFirstName", "coDueDate", "lbTitle"}, new int[] {
                R.id.stname, R.id.coduedate, R.id.lbtitle },
                SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE);
        listView.setAdapter(adapter);
    }

    private class ItemClickListener implements OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
            Cursor cursor = (Cursor) listView.getItemAtPosition(position);
            String stid = cursor.getString(0);
            String lbtitle = cursor.getString(1);
            String coduedate = cursor.getString(2);
            String coreturned = cursor.getString(3);
            String cofine = cursor.getString(4);
            String stname = cursor.getString(5);
            Toast.makeText(getApplicationContext(),"Student ID: " + stid + "\nStudent Name: " + stname+ "\nBook Title: " + lbtitle + "\nDue Date: "+ coduedate + "\nReturn State: " + coreturned+ "\nFine: $" + cofine, Toast.LENGTH_LONG).show();
        }
    }
}

