package edu.andrews.kundani.routes;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by resident_bluejay on 11/26/17.
 */

public class UserFragment extends Fragment {
    Session session;

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void logout(){
        session.setLoggedin(false);
        getActivity().finish();
        startActivity(new Intent(getActivity(),LoginActivity.class));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);


        Button busDriverButton = (Button) view.findViewById (R.id.truckDriverButton);
        busDriverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                //Intent intent = new Intent (getActivity(), UserActivity.class);
                Intent intent = new Intent(getActivity(), UserActivityTwo.class);
                startActivity(intent);
            }
        });


        Button volunteerButton = (Button) view.findViewById (R.id.volunteerButton);
        volunteerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent (getActivity(), UserActivityTwo.class);
                startActivity(intent);
            }
        });

       Button communityCenter = (Button) view.findViewById(R.id.comCenterButton);
        communityCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(getActivity(), CenterActivity.class);
                startActivity(intent);
            }
        });

        session = new Session(getActivity());
        if(!session.loggedin()){
            logout();
        }

         Button btnLogout = (Button) view.findViewById(R.id.userLogoutButton);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
