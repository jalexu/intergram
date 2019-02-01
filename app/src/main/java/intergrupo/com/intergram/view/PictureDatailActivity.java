package intergrupo.com.intergram.view;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;

import intergrupo.com.intergram.R;

public class PictureDatailActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_datail);

        showToolbar("",true);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setEnterTransition(new Fade());

            getWindow().setStatusBarColor(getColor(android.R.color.transparent));

        }
    }


    //no necesitamos un view por que estamos dentro de la actividad
    public void showToolbar(String title, boolean upBotton) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(title);

        //en el caso que tenga botton de regreso
        getSupportActionBar().setDisplayHomeAsUpEnabled(upBotton);
        CollapsingToolbarLayout collapsingToolbarLayout= (CollapsingToolbarLayout) findViewById(R.id.collapsingTollbar);
    }
}


