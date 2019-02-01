package intergrupo.com.intergram.adapter;

//esta clase trabaja los views que componen al cardview

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import intergrupo.com.intergram.R;
import intergrupo.com.intergram.model.Picture;
import intergrupo.com.intergram.view.PictureDatailActivity;

//Adpater permite
public class PictureAdapterRecycleView extends RecyclerView.Adapter<PictureAdapterRecycleView.PictureViewHolder> {

    //arreglo de datos que permite recibir los elementos que vengan
    private ArrayList<Picture> pictures;
    //recurso layout que se realizó el cardView
    private int resource;
    //Actividad de donde se está llamando
    private Activity activity;

    public PictureAdapterRecycleView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    //crea la clase PictureViewHolder
    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(resource,viewGroup,false);
        return new PictureViewHolder(view);
    }

    //se trabaja con toda la lista de elementos trabaja todos los datos ... trabaja los lisTeners
    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder pictureViewHolder, int i) {
        Picture picture=pictures.get(i);
        pictureViewHolder.usernameCard.setText(picture.getUserName());
        pictureViewHolder.timeCard.setText(picture.getTime());
        pictureViewHolder.likeNumerCard.setText((picture.getLike_numer()));
        Picasso.get().load(picture.getPicture()).into(pictureViewHolder.pictureCard);


        //cuando alguien de clic sobre la imagen, se abre otra la actividad PictureDatailActivity
        pictureViewHolder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity, PictureDatailActivity.class);

                //para efecto de entrada
                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){

                    Explode explode = new Explode();
                    explode.setDuration(100);
                    activity.getWindow().setExitTransition(explode);

                    activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation
                            (activity, v, activity.getString(R.string.transationname_picture)).toBundle());
                }else{
                    //no se pone star, por encontrarme en una actividad
                    activity.startActivity(intent);

                }


            }
        });
    }

    //saber cuantas veces recorre el arrayList
    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder{

        private ImageView pictureCard;
        private TextView usernameCard;
        private TextView timeCard;
        private TextView likeNumerCard;

        public PictureViewHolder(@NonNull View itemView) {
            super(itemView);

            pictureCard     =(ImageView) itemView.findViewById(R.id.picture_Card);
            usernameCard    =(TextView) itemView.findViewById(R.id.usernamecard);
            timeCard        =(TextView) itemView.findViewById(R.id.timeCard);
            likeNumerCard   =(TextView) itemView.findViewById(R.id.likeNumberCard);

        }
    }
}
