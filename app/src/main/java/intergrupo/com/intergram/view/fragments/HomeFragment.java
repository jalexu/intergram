package intergrupo.com.intergram.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import intergrupo.com.intergram.R;
import intergrupo.com.intergram.adapter.PictureAdapterRecycleView;
import intergrupo.com.intergram.model.Picture;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar("Home", false, view);

        RecyclerView picturesRecycle = (RecyclerView) view.findViewById(R.id.pictureRecycle);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycle.setLayoutManager(linearLayoutManager);

        PictureAdapterRecycleView pictureAdapterRecycleView = new PictureAdapterRecycleView(buildPictures(), R.layout.cardview_picture, getActivity());

        picturesRecycle.setAdapter(pictureAdapterRecycleView);

        return view;
    }

    //metodo que devuelve un arraylis de pictures
    public ArrayList<Picture> buildPictures() {
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://2.bp.blogspot.com/-uNFR4JIdoAU/UUK-CtzWUJI/AAAAAAAADzU/eLe6qFm_Y3w/s640/paisajes+02.jpg", "Jaime Uribe", "4 días", "3"));
        pictures.add(new Picture("http://eldiario.com.co/uploads/userfiles/20150103/image/P%C3%81G3-copia.jpg", "Tatiana Lopez", "1 días", "50"));
        pictures.add(new Picture("https://cdn.logitravel.com/wsimgresize/resize/crop/450/330/cdn.logitravel.com/contenidos/fotos/CIRCUITOS/900_900/1003312.jpg", "Liliana Tamaño", "17 días", "21"));
        pictures.add(new Picture("https://www.france-voyage.com/visuals/photos/paisajes-litoral-costa-azul-6509_w600.jpg", "Juan Lopez", "10 días", "15"));

        return pictures;
    }

    public void showToolbar(String title, boolean upBotton, View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);

        /*por trabajar con soporte...getActivity se castea a lo appComponenteActivity
        y traeme un elemento igualito al del conteiner*/
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);

        //en el caso que tenga botton de regreso
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upBotton);
    }

}
