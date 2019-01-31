package intergrupo.com.intergram.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


import intergrupo.com.intergram.R;
import intergrupo.com.intergram.view.fragments.HomeFragment;
import intergrupo.com.intergram.view.fragments.ProfileFragment;
import intergrupo.com.intergram.view.fragments.SearchFragment;

public class ConteinerActivity extends AppCompatActivity {

    private boolean viewIsAtHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteiner);


        BottomNavigationView bottomNavigationView= (BottomNavigationView ) findViewById(R.id.bottombar);

//        Se busca el botton de home para poder que se ejecute al momento de pinchar sobre el
        bottomNavigationView.setSelectedItemId(R.id.searh_home);

//        Va estar atendo a cuendo se de click en una de las tap
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.searh_home:
                        addFragment(new HomeFragment());
                        break;
                    case R.id.searh_profile:
                        addFragment(new ProfileFragment());
                        break;
                    case R.id.search_item:
                        addFragment(new SearchFragment());
                        break;
                }
                return false;
            }
        });


    }

    private void addFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().replace(R.id.conteiner, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null).commit();
    }



}
