package ba.bitcamp.android.personapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by Kristina Pupavac on 10/22/2015.
 */
public class EditPersonActivity extends AppCompatActivity {
    private Button mUpdate;
    private EditText mEditName;
    private EditText mEditSurname;
    private int position;

    PersonList personList = PersonList.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_person);
        Person p = (Person) getIntent().getExtras().getSerializable("asd");

        mUpdate = (Button) findViewById(R.id.update_button);
        mEditName = (EditText) findViewById(R.id.edit_name);
        mEditSurname = (EditText) findViewById(R.id.edit_surname);
        position = personList.findPosition(p);
        Log.d("pozicija", position + "");
        mEditName.setText(p.getName());
        mEditSurname.setText(p.getSurname());

        mUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PersonList.getInstance().getPersons().get(position).setName(mEditName.getText().toString());
                PersonList.getInstance().getPersons().get(position).setName(mEditSurname.getText().toString());
//
//                p.setName(mEditName.getText().toString());
//                p.setSurname(mEditSurname.getText().toString());

            }
        });

    }



}
