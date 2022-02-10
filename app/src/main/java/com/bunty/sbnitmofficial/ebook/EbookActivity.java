package com.bunty.sbnitmofficial.ebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bunty.sbnitmofficial.R;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends AppCompatActivity {

    private RecyclerView ebookRecyler;
    private DatabaseReference reference;
    private List<EbookData> list;
    private EbookAdapter adapter;

    ShimmerFrameLayout shimmerFrameLayout;
    LinearLayout shimmerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ebooks");

        ebookRecyler = findViewById(R.id.ebookRecyler);
        reference = FirebaseDatabase.getInstance().getReference().child("pdf");

        shimmerFrameLayout = findViewById(R.id.shimmer_view_container);
        shimmerLayout = findViewById(R.id.shimmerLayout);

        getData();
    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list = new ArrayList<>();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){

                    EbookData data = dataSnapshot.getValue(EbookData.class);
                    list.add(data);

                }

                adapter = new EbookAdapter(EbookActivity.this,list);
                ebookRecyler.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                ebookRecyler.setAdapter(adapter);
                shimmerFrameLayout.stopShimmer();
                shimmerLayout.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        shimmerFrameLayout.stopShimmer();
        super.onPause();
    }

    @Override
    protected void onResume() {
        shimmerFrameLayout.startShimmer();
        super.onResume();
    }
}