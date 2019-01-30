package intergrupo.com.intergram.adapter;

//esta clase trabaja los views que componen al cardview

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import intergrupo.com.intergram.R;
import intergrupo.com.intergram.model.Picture;

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

    //se trabaja con toda la lista de elementos
    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder pictureViewHolder, int i) {
        Picture picture=pictures.get(i);
        pictureViewHolder.usernameCard.setText(picture.getUserName());
        pictureViewHolder.timeCard.setText(picture.getTime());
        pictureViewHolder.likeNumerCard.setText((picture.getLike_numer()));
        Picasso.get().load(picture.getPicture()).into(pictureViewHolder.pictureCard);
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

            pictureCard     =(ImageView) itemView.findViewById(R.id.pictureCard);
            usernameCard    =(TextView) itemView.findViewById(R.id.usernamecard);
            timeCard        =(TextView) itemView.findViewById(R.id.timeCard);
            likeNumerCard   =(TextView) itemView.findViewById(R.id.likeNumberCard);

        }
    }
}
