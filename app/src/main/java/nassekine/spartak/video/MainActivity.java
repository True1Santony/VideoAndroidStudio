package nassekine.spartak.video;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button btnReproducir;
    VideoView vwReproductor;
    MediaController mediaController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReproducir=findViewById(R.id.btnReproducir);
        vwReproductor=findViewById(R.id.vwReproductor);
        mediaController=new MediaController(this);

        btnReproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int aleatorio=(int)Math.floor(Math.random()*2);
                int identidicadorRecurso;

                if(aleatorio==0){

                    identidicadorRecurso=R.raw.dados;

                }else{

                    identidicadorRecurso=R.raw.bacas;

                }

                String rutaVideo="android.resource://"+getPackageName()+"/"+identidicadorRecurso;

                Uri uri= Uri.parse(rutaVideo);

                vwReproductor.setVideoURI(uri);
                vwReproductor.setMediaController(mediaController);
                mediaController.setAnchorView(vwReproductor);
                vwReproductor.start();
            }
        });


    }
}