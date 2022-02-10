package com.bunty.sbnitmofficial.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bunty.sbnitmofficial.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    RecyclerView convoRecyler,sportRecyler,independenceRecyler,otherRecyler;
    GalleryAdapter adapter;
    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_gallery, container, false);

        convoRecyler = view.findViewById(R.id.convoRecyler);
        sportRecyler = view.findViewById(R.id.sportRecyler);
        independenceRecyler = view.findViewById(R.id.independenceRecyler);
        otherRecyler= view.findViewById(R.id.otherRecyler);

        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getconvoimage();
        getotherimage();
        getindependimage();
        getsportimage();

        return view;
    }

    public class SnapHelperOneByOne extends LinearSnapHelper {

        @Override
        public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {

            if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
                return RecyclerView.NO_POSITION;
            }

            final View currentView = findSnapView(layoutManager);

            if (currentView == null) {
                return RecyclerView.NO_POSITION;
            }

            LinearLayoutManager myLayoutManager = (LinearLayoutManager) layoutManager;

            int position1 = myLayoutManager.findFirstVisibleItemPosition();
            int position2 = myLayoutManager.findLastVisibleItemPosition();

            int currentPosition = layoutManager.getPosition(currentView);

            if (velocityX > 400) {
                currentPosition = position2;
            } else if (velocityX < 400) {
                currentPosition = position1;
            }

            if (currentPosition == RecyclerView.NO_POSITION) {
                return RecyclerView.NO_POSITION;
            }

            return currentPosition;
        }
    }

    private void getsportimage() {

        reference.child("sports day").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) dataSnapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(),imageList);
                sportRecyler.setLayoutManager(new GridLayoutManager(getContext(),3));
                sportRecyler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "something went wrong" +
                        "", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getindependimage() {

        reference.child("independence day").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) dataSnapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(),imageList);
                independenceRecyler.setLayoutManager(new GridLayoutManager(getContext(),3));
               independenceRecyler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "something went wrong" +
                        "", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getotherimage() {

        reference.child("others Events").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) dataSnapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(),imageList);
                otherRecyler.setLayoutManager(new GridLayoutManager(getContext(),3));
                otherRecyler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "something went wrong" +
                        "", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getconvoimage() {

        reference.child("convocation").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) dataSnapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(),imageList);
               convoRecyler.setLayoutManager(new GridLayoutManager(getContext(),3));
               convoRecyler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "something went wrong" +
                        "", Toast.LENGTH_SHORT).show();
            }
        });

    }
}