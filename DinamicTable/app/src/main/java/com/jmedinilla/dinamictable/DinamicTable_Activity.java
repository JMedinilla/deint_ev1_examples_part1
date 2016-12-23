package com.jmedinilla.dinamictable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * @author Javier Medinilla
 * @version 1.0
 * Exercise that show how to create view
 * components in Java code
 *
 * Used resources:
 * -LayoutParams
 * -Shape
 * -Color
 * -String-array
 */
public class DinamicTable_Activity extends AppCompatActivity {

    //Components
    private TableLayout tbl_header;
    private TableLayout tbl_body;
    private TableRow.LayoutParams tbr_layout_id;
    private TableRow.LayoutParams tbr_layout_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamic_table);

        tbl_header = (TableLayout)findViewById(R.id.tbl_header);
        tbl_body = (TableLayout)findViewById(R.id.tbl_body);

        //ID row properties
        tbr_layout_id = new TableRow.LayoutParams(120, TableRow.LayoutParams.WRAP_CONTENT);
        tbr_layout_id.setMargins(0, 10, 0, 10);

        //NAME row properties
        tbr_layout_name = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        tbr_layout_name.setMargins(0, 10, 0, 10);

        createHeader();
        createBody();
    }

    /**
     * Method that created the header row
     */
    private void createHeader() {
        //Creation of the row
        TableRow tbrHeader = new TableRow(this);
        //Creation of the Id column
        TextView txtId = new TextView(this);
        //Creation of the Name collumn
        TextView txtName = new TextView(this);

        //ID column properties
        txtId.setText(R.string.txtId);
        txtId.setGravity(Gravity.CENTER);
        txtId.setLayoutParams(tbr_layout_id);
        tbrHeader.addView(txtId);

        //NAME column properties
        txtName.setText(R.string.txtName);
        txtName.setGravity(Gravity.START);
        txtName.setLayoutParams(tbr_layout_name);
        tbrHeader.addView(txtName);

        //Add the row to the layout
        tbl_header.addView(tbrHeader);
        tbl_header.setBackgroundResource(R.drawable.shape_header);
    }

    /**
     * Method that creates the body rows
     */
    private void createBody() {
        //Row for each name
        TableRow tbrBody;
        //Id for each row
        TextView txtId;
        //Name for each row
        TextView txtName;
        //Name's list
        String[] listName = getResources().getStringArray(R.array.listName);

        /*
        Each row has to be created from nothing, so you create
        first all the items needed and then put on them their
        values before adding them to the layout
         */
        for (int i = 0; i < listName.length; i++) {
            tbrBody = new TableRow(this);
            txtId = new TextView(this);
            txtName = new TextView(this);

            txtId.setText(" " + String.valueOf(i + 1) + " ");
            txtId.setGravity(Gravity.CENTER);
            txtId.setLayoutParams(tbr_layout_id);
            tbrBody.addView(txtId);

            txtName.setText(listName[i]);
            txtName.setGravity(Gravity.START);
            txtName.setLayoutParams(tbr_layout_name);
            tbrBody.addView(txtName);

            tbl_body.addView(tbrBody);
            tbl_body.setBackgroundResource(R.drawable.shape_body);
        }
    }
}
