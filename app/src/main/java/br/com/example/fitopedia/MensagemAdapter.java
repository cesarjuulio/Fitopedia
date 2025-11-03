package br.com.example.fitopedia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import io.noties.markwon.Markwon;

public class MensagemAdapter extends RecyclerView.Adapter<MensagemAdapter.MensagemViewHolder> {

    private List<Mensagem> mensagens;

    public MensagemAdapter(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    @Override
    public int getItemViewType(int position) {
        return mensagens.get(position).isUsuario() ? 1 : 0;
    }

    @Override
    public MensagemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == 1) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.mensagem_usuario, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.mensagem_ia, parent, false);
        }
        return new MensagemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MensagemViewHolder holder, int position) {
        Mensagem mensagem = mensagens.get(position);

        // Usa Markwon para renderizar Markdown (igual à API)
        Markwon markwon = Markwon.create(holder.textMensagem.getContext());
        markwon.setMarkdown(holder.textMensagem, mensagem.getTexto());
    }

    @Override
    public int getItemCount() {
        return mensagens.size();
    }

    public static class MensagemViewHolder extends RecyclerView.ViewHolder {
        TextView textMensagem;
        public MensagemViewHolder(View itemView) {
            super(itemView);
            textMensagem = itemView.findViewById(R.id.textMensagem);
        }
    }
}
