package edu.andrews.kundani.routes;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FEMAFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fema, container, false);

        Button peopleListButton = (Button) v.findViewById(R.id.femaPeopleButton);
        peopleListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(getActivity(), ListActivityTwo.class);
                startActivity(intent);
            }
        });

        Button supplyListButton = (Button) v.findViewById(R.id.femaSuppliesButton);
        /**supplyListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(getActivity(), ListActivity.class);
                startActivity(intent);
            }
        });**/

        return v;

    }
}
