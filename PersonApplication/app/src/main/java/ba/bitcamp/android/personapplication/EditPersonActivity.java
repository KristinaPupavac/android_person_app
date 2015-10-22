package ba.bitcamp.android.personapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_person);

        Person p = (Person) getIntent().getSerializableExtra("asd");

        mUpdate = (Button) findViewById(R.id.update_button);
        mEditName = (EditText) findViewById(R.id.edit_name);
        mEditSurname = (EditText) findViewById(R.id.edit_surname);

        mUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditPersonActivity.this, PersonActivity.class);
                startActivity(intent);
            }
        });

    }



}
