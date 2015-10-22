package ba.bitcamp.android.personapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class PersonActivity extends AppCompatActivity {
    private EditText mName;
    private EditText mSurname;
    private Button mAdd;
    private List<Person> personList = new LinkedList<Person>();
    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        mName = (EditText) findViewById(R.id.name);
        mSurname = (EditText) findViewById(R.id.surname);
        mAdd = (Button) findViewById(R.id.add_button);

        recyclerView = (RecyclerView) findViewById(R.id.person_recycler_view);
        personAdapter = new PersonAdapter(personList);
        recyclerView.setAdapter(personAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = mName.getText().toString();
                String surname = mSurname.getText().toString();

                personList.add(new Person(name, surname));
                personAdapter.notifyDataSetChanged();
            }
        });
    }

    private class PersonHolder extends RecyclerView.ViewHolder {
        public TextView mPersonName;
        public TextView mPersonSurname;
        public TextView mDate;
        private Button mDelete;
        private Person mPerson;

        public PersonHolder(View itemView) {
            super(itemView);
            mPersonName = (TextView) itemView.findViewById(R.id.list_person_name);
            mPersonSurname = (TextView) itemView.findViewById(R.id.list_person_surname);
            mDate = (TextView) itemView.findViewById(R.id.list_date);
            mDelete = (Button) itemView.findViewById(R.id.delete);


            mDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //UUID personId = mPerson.getId();
                    personList.remove(mPerson);
                    updateUI();
                    // personList.remove();
                    //personAdapter.notifyDataSetChanged();
                }
            });

            if (mDelete == null){
                Log.d("person activity", "null mDelete");
            } else {
                Log.d("person activity", "null mDelete not null");
            }
        }


        public void bindPerson(Person person){
            mPerson = person;
            mPersonName.setText(mPerson.getName());
            mPersonSurname.setText(mPerson.getSurname());
            mDate.setText(mPerson.getDate().toString());
        }
    }

    private class PersonAdapter extends RecyclerView.Adapter<PersonHolder>{
        private List<Person> mPersons;

        public PersonAdapter(List<Person> persons){
            mPersons = persons;
        }

        @Override
        public PersonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(PersonActivity.this);
            View view = layoutInflater.inflate(R.layout.list_persons, parent, false);
            return new PersonHolder(view);
        }

        @Override
        public void onBindViewHolder(PersonHolder holder, int position) {
            Person person = mPersons.get(position);
            holder.bindPerson(person);
        }

        @Override
        public int getItemCount() {
            return mPersons.size();
        }
    }

    public void updateUI() {
        List<Person> personsList = personList;
        personAdapter = new PersonAdapter(personsList);
        recyclerView.setAdapter(personAdapter);
    }

}
