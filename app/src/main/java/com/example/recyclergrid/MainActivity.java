package com.example.recyclergrid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Book> listCard;

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createBookList();
        buildRecyclerView();

        EditText editText = findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

    }

    private void filter(String text) {
        ArrayList<Book> filteredList = new ArrayList<>();

        for (Book item : listCard) {
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        mAdapter.filterList(filteredList);
    }

    private void createBookList() {
        listCard = new ArrayList<>();
        listCard.add(new Book("Aerodactyl","Rock","A ferocious prehistoric Pokemon that goes for the enemy's throat with its serrated saw-like fangs.",R.drawable.aerodactyl));
        listCard.add(new Book("Alakazam","Psychic","Its brain can outperform a supercomputer. Its intelligence quotient is said to be 5000.",R.drawable.alakazam));
        listCard.add(new Book("Arboks","Poison","It is rumored that the ferocious warning markings on its belly differ from area to area.",R.drawable.arboks));
        listCard.add(new Book("Articuno","Ice","A legendary bird Pokemon that is said to appear to doomed people who are lost in icy mountains.",R.drawable.articuno));
        listCard.add(new Book("Bellsprout","Grass","A carnivorous Pokemon that traps and eats bugs. It uses its root foot to soak up needed moisture.",R.drawable.bellsprout));
        listCard.add(new Book("Bulbasaur","Grass","A strange seed was planted on its back at birth. Thus, a plant sprouted and now grows with this Pokemon.",R.drawable.bulbasaur));
        listCard.add(new Book("Caterpie","Bug","It is covered with green skin. When it grows, it shed the skin, covers itself with silk, and becomes a cocoon.",R.drawable.caterpie));
        listCard.add(new Book("Charizard","Fire","Its wings can carry this Pokemon close to an altitude of 4,600 feet.  It blows out fire at very high temperature.",R.drawable.charizard));
        listCard.add(new Book("Charmander","Fire","Obviously prefers hot places. If it get caught in the rain steam is said to spout from the tip of its tail.",R.drawable.charmander));
        listCard.add(new Book("Clefable","Fairy","A timid Fairy Pokemon that is rarely seen. It will run and hide the moment it senses people.",R.drawable.clefable));
        listCard.add(new Book("Clefairy","Fairy","Its magical and cute appeal has many admirers. It is rare and found only in certain areas.",R.drawable.clefairy));
        listCard.add(new Book("Doduo","Normal","A bird that makes up for its poor flying with its fast foot speed. leaves giant footprints.",R.drawable.doduo));
        listCard.add(new Book("Dragonair","Dragon","A mystical Pokemon that exudes a gentle aura. Has the ability to change climate conditions.",R.drawable.dragonair));
        listCard.add(new Book("Dragonite","Dragon","An extremely rarely seen marine Pokemon. Its intelligence is said to match that of humans.",R.drawable.dragonite));
        listCard.add(new Book("Drowzee","Psychic","Puts enemies to sleep, then eats their dreams. Occasionally gets sick from eating bad dreams.",R.drawable.drowzee));
        listCard.add(new Book("Ekans","Poison","A carnivore that swallows its prey whole. Pidgeys and Spearows are its favorite food.",R.drawable.ekans));
        listCard.add(new Book("Gastly","Ghost","Almost invisible, this gaseous Pokemon cloaks the target and puts it to sleep without notice.",R.drawable.gastly));
        listCard.add(new Book("Gengar","Ghost","Under a full moon, this Pokemon likes to mimic the shadows of people and laugh at their fright.",R.drawable.gengar));
        listCard.add(new Book("Hitmonlee","Fighting","When in a hurry, its legs lengthen progressively. It runs smoothly with extra long, loping strides.",R.drawable.hitmonlee));
        listCard.add(new Book("Jynx","Ice","Merely by meditating, the Pokemon launches a powerful psychic energy attack.",R.drawable.jynx));
        listCard.add(new Book("Lickitung","Normal","Its tongue can be extended like a chameleon's. It leaves a stinging sensation when it Licks enemies.",R.drawable.lickitung));
        listCard.add(new Book("Machamp","Fighting","Using its amazing muscles, it throws a powerful punches that can knock its victim clear over the horizon.",R.drawable.machamp));
        listCard.add(new Book("Magnemite","Electric","Uses anti-gravity to stay suspended. Appears without warning and uses attacks like Thunder wave.",R.drawable.magnemite));
        listCard.add(new Book("Omanyte","Rock","Although long extinct, in rare cases, it can be genetically resurrected from fossils.",R.drawable.omanyte));
        listCard.add(new Book("Pikachu","Electric","When several of these Pokemon gather, their electricity can build and cause lightning storms.",R.drawable.pikachu));
        listCard.add(new Book("Rhyhorn","Ground","Its massive bones are 1,000 harder than human bones. It can easily knock a trailer flying.",R.drawable.rhyhorn));
        listCard.add(new Book("Sandshrew","Ground","Burrows deep underground in arid locations far from water, It only emerges to hunt for food.",R.drawable.sandshrew));
        listCard.add(new Book("Scyther","Bug","With ninja-like agility and speed, it can create the illusion that there is more than one of it.",R.drawable.scyther));
        listCard.add(new Book("Squirtle","Water","After birth, its back swells and hardens into a shell. its powerfully sprays foam from its mouth.",R.drawable.squirtle));
        listCard.add(new Book("Tentacool","Water","Drifts in shallow seas. Anglers who hook them by accident are often punished by its stinging acid.",R.drawable.tentacool));
    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerview_id);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this,3);
        mAdapter = new RecyclerViewAdapter(this,listCard);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_Alphabet:
                Collections.sort(listCard, Book.CardAlphabetComparator);
                Toast.makeText(MainActivity.this, "Sort by Alphabet", Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();
                return true;
            case R.id.menu_Type:
                Collections.sort(listCard, Book.CardTypeComparator);
                Toast.makeText(MainActivity.this, "Sort by Type", Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}