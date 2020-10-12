package com.example.labo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<Joueur> listeJoueur = new ArrayList<Joueur>();
    public List<TextView> listeTextViewNom = new ArrayList<TextView>();
    public List<TextView> listeTextViewStrike = new ArrayList<TextView>();
    public List<TextView> listeTextViewPoint = new ArrayList<TextView>();
    public int tour = 0;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRecommencer:
                nouvellePartie();
                return true;
            case R.id.subitemFacile:

                return true;
            case R.id.subitemDifficile:

                return true;
            case R.id.subitem0:
                Toast.makeText(this, "0 point pour " + listeJoueur.get(tour).nom, Toast.LENGTH_SHORT).show();
                strike();
                return true;
            case R.id.subitem1:
                ajoutPoint(1);
                Toast.makeText(this, "1 point pour " + listeJoueur.get(tour).nom, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem2:
                ajoutPoint(2);
                Toast.makeText(this, "2 point pour " + listeJoueur.get(tour).nom, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem3:
                ajoutPoint(3);
                Toast.makeText(this, "3 point pour " + listeJoueur.get(tour).nom, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem4:
                ajoutPoint(4);
                Toast.makeText(this, "4 point pour " + listeJoueur.get(tour).nom, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem5:
                ajoutPoint(5);
                Toast.makeText(this, "5 point pour " + listeJoueur.get(tour).nom, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem6:
                ajoutPoint(6);
                Toast.makeText(this, "6 point pour " + listeJoueur.get(tour).nom, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem7:
                ajoutPoint(7);
                Toast.makeText(this, "7 point pour " + listeJoueur.get(tour).nom, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem8:
                ajoutPoint(8);
                Toast.makeText(this, "8 point pour " + listeJoueur.get(tour).nom, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem9:
                ajoutPoint(9);
                Toast.makeText(this, "9 point pour " + listeJoueur.get(tour).nom, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem10:
                ajoutPoint(10);
                Toast.makeText(this, "10 point pour " + listeJoueur.get(tour).nom, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem11:
                ajoutPoint(11);
                Toast.makeText(this, "11 point pour " + listeJoueur.get(tour).nom, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem12:
                ajoutPoint(12);
                Toast.makeText(this, "12 point pour " + listeJoueur.get(tour).nom, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void ajoutPoint(int point) {
        listeJoueur.get(tour).point += point;
        listeTextViewPoint.get(tour).setText(Integer.toString(listeJoueur.get(tour).getPoint()));
        implementerTour();
    }

    private void strike() {

        switch (listeJoueur.get(tour).getStrike()) {
            case 0:
                listeJoueur.get(tour).strike++;
                listeTextViewStrike.get(tour).setText("x");
                Toast.makeText(this, " Strike pour " + listeJoueur.get(tour).getNom(), Toast.LENGTH_SHORT).show();
                break;
            case 1:
                listeJoueur.get(tour).strike++;
                listeTextViewStrike.get(tour).setText("xx");
                Toast.makeText(this, " Strike pour " + listeJoueur.get(tour).getNom(), Toast.LENGTH_SHORT).show();
                break;
            case 2:
                listeJoueur.get(tour).strike++;
                listeTextViewStrike.get(tour).setText("xxx");
                Toast.makeText(this, listeJoueur.get(tour).getNom() + " est eliminé!", Toast.LENGTH_LONG).show();
                listeJoueur.remove(listeJoueur.get(tour));
                //mettre en rouge le textView
                break;
        }

        implementerTour();

    }


    public void implementerTour(){
        if(tour == 4){
            tour = 0;
        } else {
            tour++;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        creerJoueur();



    }

    private void creerJoueur(){
        listeJoueur.add(new Joueur("Gérard", 0, 0));
        listeJoueur.add(new Joueur("Jean", 0, 0));
        listeJoueur.add(new Joueur("Jacques", 0, 0));
        listeJoueur.add(new Joueur("Gilles", 0, 0));
        Collections.shuffle(listeJoueur);
        initaliserTextView();
    }

    private void nouvellePartie() {
        for(int i=0; i<4; i++){
            listeJoueur.get(i).point = 0;
            listeJoueur.get(i).strike = 0;
        }
        Collections.shuffle(listeJoueur);
        initaliserTextView();
    }

    void initaliserTextView() {
        TextView txtViewNom1 = (TextView) findViewById(R.id.txtView1);
        TextView txtViewNom2 = (TextView) findViewById(R.id.txtView2);
        TextView txtViewNom3 = (TextView) findViewById(R.id.txtView3);
        TextView txtViewNom4 = (TextView) findViewById(R.id.txtView4);

        if(listeTextViewNom.size()==0){
            listeTextViewNom.addAll(Arrays.asList(txtViewNom1, txtViewNom2, txtViewNom3, txtViewNom4));
        }


        TextView txtViewStrike1 = (TextView) findViewById(R.id.txtStrike1);
        TextView txtViewStrike2 = (TextView) findViewById(R.id.txtStrike2);
        TextView txtViewStrike3 = (TextView) findViewById(R.id.txtStrike3);
        TextView txtViewStrike4 = (TextView) findViewById(R.id.txtStrike4);

        if(listeTextViewStrike.size() == 0){
            listeTextViewStrike.addAll(Arrays.asList(txtViewStrike1, txtViewStrike2, txtViewStrike3, txtViewStrike4));
        }


        TextView txtViewPoint1 = (TextView) findViewById(R.id.txtPoint1);
        TextView txtViewPoint2 = (TextView) findViewById(R.id.txtPoint2);
        TextView txtViewPoint3 = (TextView) findViewById(R.id.txtPoint3);
        TextView txtViewPoint4 = (TextView) findViewById(R.id.txtPoint4);

        if(listeTextViewPoint.size() == 0){
            listeTextViewPoint.addAll(Arrays.asList(txtViewPoint1, txtViewPoint2, txtViewPoint3, txtViewPoint4));
        }


        for (int i = 0; i < listeTextViewNom.size(); i++) {
            listeTextViewNom.get(i).setText(listeJoueur.get(i).getNom());
            listeTextViewPoint.get(i).setText(Integer.toString(listeJoueur.get(i).getPoint()));
            listeTextViewStrike.get(i).setText(Integer.toString(listeJoueur.get(i).getStrike()));
        }
    }


}
