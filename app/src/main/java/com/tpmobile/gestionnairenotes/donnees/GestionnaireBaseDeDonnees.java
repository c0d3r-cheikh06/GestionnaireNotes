package com.tpmobile.gestionnairenotes.donnees;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tpmobile.gestionnairenotes.modele.Note;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireBaseDeDonnees extends SQLiteOpenHelper {

    private static final String NOM_BASE_DE_DONNEES = "notes.db";
    private static final int VERSION_BASE_DE_DONNEES = 1;

    private static final String TABLE_NOTES = "notes";
    private static final String COLONNE_IDENTIFIANT = "id";
    private static final String COLONNE_TITRE = "titre";
    private static final String COLONNE_CONTENU = "contenu";
    private static final String COLONNE_COULEUR = "couleur";
    private static final String COLONNE_FAVORI = "favori";
    private static final String COLONNE_DATE = "date";

    public GestionnaireBaseDeDonnees(Context contexte) {
        super(contexte, NOM_BASE_DE_DONNEES, null, VERSION_BASE_DE_DONNEES);
    }

    @Override
    public void onCreate(SQLiteDatabase baseDeDonnees) {
        String requeteCreationTable = "CREATE TABLE " + TABLE_NOTES + " ("
                + COLONNE_IDENTIFIANT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLONNE_TITRE + " TEXT, "
                + COLONNE_CONTENU + " TEXT, "
                + COLONNE_COULEUR + " TEXT, "
                + COLONNE_FAVORI + " INTEGER, "
                + COLONNE_DATE + " TEXT)";
        baseDeDonnees.execSQL(requeteCreationTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase baseDeDonnees, int ancienneVersion, int nouvelleVersion) {
        baseDeDonnees.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        onCreate(baseDeDonnees);
    }

    public long ajouterNote(Note note) {
        SQLiteDatabase baseDeDonnees = getWritableDatabase();
        ContentValues valeurs = construireValeursDepuisNote(note);
        long identifiant = baseDeDonnees.insert(TABLE_NOTES, null, valeurs);
        baseDeDonnees.close();
        return identifiant;
    }

    public void modifierNote(Note note) {
        SQLiteDatabase baseDeDonnees = getWritableDatabase();
        ContentValues valeurs = construireValeursDepuisNote(note);
        baseDeDonnees.update(TABLE_NOTES, valeurs, COLONNE_IDENTIFIANT + " = ?",
                new String[]{String.valueOf(note.getIdentifiant())});
        baseDeDonnees.close();
    }

    public void supprimerNote(long identifiant) {
        SQLiteDatabase baseDeDonnees = getWritableDatabase();
        baseDeDonnees.delete(TABLE_NOTES, COLONNE_IDENTIFIANT + " = ?", new String[]{String.valueOf(identifiant)});
        baseDeDonnees.close();
    }

    public Note recupererNoteParIdentifiant(long identifiant) {
        SQLiteDatabase baseDeDonnees = getReadableDatabase();
        Cursor curseur = baseDeDonnees.query(TABLE_NOTES, null, COLONNE_IDENTIFIANT + " = ?",
                new String[]{String.valueOf(identifiant)}, null, null, null);

        Note note = null;
        if (curseur.moveToFirst()) {
            note = lireNoteDepuisCurseur(curseur);
        }
        curseur.close();
        baseDeDonnees.close();
        return note;
    }

    public List<Note> recupererToutesLesNotes() {
        List<Note> notes = new ArrayList<>();
        SQLiteDatabase baseDeDonnees = getReadableDatabase();
        Cursor curseur = baseDeDonnees.query(TABLE_NOTES, null, null, null, null, null, COLONNE_IDENTIFIANT + " DESC");

        while (curseur.moveToNext()) {
            notes.add(lireNoteDepuisCurseur(curseur));
        }
        curseur.close();
        baseDeDonnees.close();
        return notes;
    }

    private ContentValues construireValeursDepuisNote(Note note) {
        ContentValues valeurs = new ContentValues();
        valeurs.put(COLONNE_TITRE, note.getTitre());
        valeurs.put(COLONNE_CONTENU, note.getContenu());
        valeurs.put(COLONNE_COULEUR, note.getCouleur());
        valeurs.put(COLONNE_FAVORI, note.estFavori() ? 1 : 0);
        valeurs.put(COLONNE_DATE, note.getDate());
        return valeurs;
    }

    private Note lireNoteDepuisCurseur(Cursor curseur) {
        Note note = new Note();
        note.setIdentifiant(curseur.getLong(curseur.getColumnIndexOrThrow(COLONNE_IDENTIFIANT)));
        note.setTitre(curseur.getString(curseur.getColumnIndexOrThrow(COLONNE_TITRE)));
        note.setContenu(curseur.getString(curseur.getColumnIndexOrThrow(COLONNE_CONTENU)));
        note.setCouleur(curseur.getString(curseur.getColumnIndexOrThrow(COLONNE_COULEUR)));
        note.setFavori(curseur.getInt(curseur.getColumnIndexOrThrow(COLONNE_FAVORI)) == 1);
        note.setDate(curseur.getString(curseur.getColumnIndexOrThrow(COLONNE_DATE)));
        return note;
    }
}
