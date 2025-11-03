package br.com.example.fitopedia.carrossel;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import br.com.example.fitopedia.R;

/* loaded from: classes3.dex */
public class PlantasViewHolder extends RecyclerView.ViewHolder {
    TextView nomeCientificoTextView;
    TextView nomePopularTextView;
    ImageView plantaImageView;

    public PlantasViewHolder(View itemView) {
        super(itemView);
        this.plantaImageView = (ImageView) itemView.findViewById(R.id.list_item_image);
        this.nomePopularTextView = (TextView) itemView.findViewById(R.id.text_title);
        this.nomeCientificoTextView = (TextView) itemView.findViewById(R.id.text_subtitle);
    }

    public ImageView getPlantaImageView() {
        return this.plantaImageView;
    }

    public void setPlantaImageView(ImageView plantaImageView) {
        this.plantaImageView = plantaImageView;
    }

    public TextView getNomePopularTextView() {
        return this.nomePopularTextView;
    }

    public void setNomePopularTextView(TextView nomePopularTextView) {
        this.nomePopularTextView = nomePopularTextView;
    }

    public TextView getNomeCientificoTextView() {
        return this.nomeCientificoTextView;
    }

    public void setNomeCientificoTextView(TextView nomeCientificoTextView) {
        this.nomeCientificoTextView = nomeCientificoTextView;
    }
}
