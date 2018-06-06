package edu.andrews.kundani.routes;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class FirebaseHelper {

    DatabaseReference bd;
    Boolean saved = null;
    ArrayList<Information> mInformationArrayList = new ArrayList<>();

    public FirebaseHelper(DatabaseReference db) {
        this.bd = db;
    }

    public Boolean save(Information information) {

        if (information == null) {
            saved = false;
        } else {
            try {
                bd.child("Information").push().setValue(information);
                saved = true;
            } catch (DatabaseException dbException) {
                dbException.printStackTrace();
                saved = false;
            }
        }

        return saved;
    }

    private void fetchData (DataSnapshot dataSnapshot) {

        mInformationArrayList.clear();

        for(DataSnapshot ds: dataSnapshot.child("Information").getChildren()){
            Information information = ds.getValue(Information.class);
            mInformationArrayList.add(information);
        }
    }

    public ArrayList<Information> retreive () {
        bd.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return mInformationArrayList;
    }
}
