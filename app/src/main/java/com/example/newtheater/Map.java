package com.example.newtheater;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends Fragment {
    private Button btnFrag;

    MapView mMapView;
    private GoogleMap googleMap;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.map_lay, container, false);

//        ImageView img = (ImageView)view.findViewById(R.id.imageViewRec);
        ImageView img = (ImageView) view.findViewById(R.id.imageView14);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.example.newtheater.MainActivity) getActivity()).setViewPager(0);
            }
        });


        btnFrag = (Button) view.findViewById(R.id.btnBack);

        btnFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.example.newtheater.MainActivity) getActivity()).setViewPager(0);
            }
        });

        // Map
        final TextView userMap = (TextView) view.findViewById(R.id.adres);

        final CharSequence text = userMap.getText();
        final SpannableString spannableString = new SpannableString( text );
        spannableString.setSpan(new URLSpan(""), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        userMap.setText(spannableString, TextView.BufferType.SPANNABLE);

        userMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent geoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="
                        +userMap.getText().toString()));
                startActivity(geoIntent);
            }
        });
        // Map window
        mMapView = (MapView) view.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

//                // For showing a move to my location button
//                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
//                        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
//                {
//                    ActivityCompat.requestPermissions(this,
//                            new String[]{
//                                    Manifest.permission.ACCESS_FINE_LOCATION},
//                                    FINE_LOCATION_PERMISSION_REQUEST);
//                }
//                googleMap.setMyLocationEnabled(true);

                // For dropping a marker at a point on the Map
                LatLng theater = new LatLng(51.776750, 19.449924);
                googleMap.addMarker(new MarkerOptions().position(theater).title("Teatr").snippet("Opis teatru"));

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(theater).zoom(15).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });



        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}



