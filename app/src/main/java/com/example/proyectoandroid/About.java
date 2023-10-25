package com.example.proyectoandroid;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.preference.PreferenceManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.Polyline;

public class About extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));

        MapView mapView = findViewById(R.id.mapView);
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);

        //Coordenadas de Santiago, Chile
        double centralLatitude = -33.557572;
        double centralLongitude = -70.604956;

        //Crear objetos GeoPoint para los marcadores
        GeoPoint centralPoint = new GeoPoint(centralLatitude, centralLongitude);

        //Crear marcadores con títulos y descripciones
        Marker centralMarker = new Marker(mapView);
        centralMarker.setPosition(centralPoint);
        centralMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        centralMarker.setTitle("Central de Lucs");
        centralMarker.setSnippet("aqui estamos ubicados");

        //Agregar marcadores al mapa
        mapView.getOverlays().add(centralMarker);

        // Centrar el mapa en Santiago, Chile
        IMapController mapController = mapView.getController();
        mapController.setCenter(centralPoint);
        mapController.setZoom(14);  // Puedes ajustar el nivel de zoom según sea necesario

        VideoView mivideo = findViewById(R.id.video1);

        // Crea la URI del video desde la ruta del recurso "R.raw.juego"
        String video= "android.resource://" + getPackageName() + "/" + R.raw.ilu;
        Uri uri = Uri.parse(video);

        // Establece la URI del video en el VideoView
        mivideo.setVideoURI(uri);

        // Crea un objeto MediaController para controlar la reproducción del video
        MediaController mediaController = new MediaController(this);

        // Asocia el MediaController con el VideoView
        mivideo.setMediaController(mediaController);

        // Establece la vista a la que se ancla el MediaController (en este caso, el VideoView)
        mediaController.setAnchorView(mivideo);

        // Aplica una animación de escala al VideoView para que aparezca gradualmente
        Animation animation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(1000); // Duración de la animación en milisegundos
        mivideo.startAnimation(animation);

        // Aplica una animación de desplazamiento al VideoView
        // Animation animation = new TranslateAnimation(0, 0, 100, 0);
        // animation.setDuration(1000); // Duración de la animación en milisegundos
        //
        // mivideo.startAnimation(animation);

        // Establece un listener para el evento de preparación del MediaPlayer
        mivideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mivideo.start(); // Inicia la reproducción del video cuando está preparado
            }
        });
    }

    public void onClickVolver(View view)
    {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }


}