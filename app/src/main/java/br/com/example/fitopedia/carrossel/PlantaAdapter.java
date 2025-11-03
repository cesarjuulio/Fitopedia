package br.com.example.fitopedia.carrossel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import br.com.example.fitopedia.R;

public class PlantaAdapter extends RecyclerView.Adapter<PlantasViewHolder> {

    private final Context context;
    private final ArrayList<Planta> listaPlantas;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onClick(ImageView imageView, String urlImagem);
    }

    public PlantaAdapter(Context context, ArrayList<Planta> plantas) {
        this.context = context;
        this.listaPlantas = plantas;
    }

    @Override
    public PlantasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_planta, parent, false);
        return new PlantasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PlantasViewHolder holder, int position) {
        Planta planta = listaPlantas.get(position);
        final String urlImagem = planta.getImagemDemonstracao1();

        // Carrega imagem com Glide
        Glide.with(context)
                .load(urlImagem)
                .into(holder.plantaImageView);

        // Define textos
        holder.nomePopularTextView.setText(planta.getNomePopular());
        holder.nomeCientificoTextView.setText(planta.getNomeCientifico());

        // Clique no item
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onClick(holder.plantaImageView, urlImagem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaPlantas.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
}
