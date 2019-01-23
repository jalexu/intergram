package intergrupo.com.intergram.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.widget.Toolbar;
//se da un nuevo soporte a widget
import android.support.v7.widget.Toolbar;

import intergrupo.com.intergram.R;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        //se llama el toolbar y se llama desde getResources y se pasa a string
        showToolbar(getResources().getString(R.string.toolbar_tittle_createaccount),true);
    }

    public void showToolbar(String title,boolean upBotton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        //en el caso que tenga botton de regreso
        getSupportActionBar().setDisplayHomeAsUpEnabled(upBotton);
    }

}
