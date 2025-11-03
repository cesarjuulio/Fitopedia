package br.com.example.fitopedia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ConsultarIA extends AppCompatActivity {

    private ImageButton homeImageButton;
    private EditText inputMensagem;
    private Button enviarButton;
    private RecyclerView mensagemRecyclerView;
    private MensagemAdapter mensagemAdapter;
    private ArrayList<Mensagem> mensagem;
    private OpenRouterUtil openRouterUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_consultar_ia);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Botão home
        homeImageButton = findViewById(R.id.homeImageButton);
        homeImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });

        // Campos do chat
        inputMensagem = findViewById(R.id.promptEditText);
        enviarButton = findViewById(R.id.enviarButton);
        mensagemRecyclerView = findViewById(R.id.mensagemRecyclerView);
        openRouterUtil = new OpenRouterUtil();

// Lista de mensagens e adapter
        List<Mensagem> mensagens = new ArrayList<>();
        MensagemAdapter mensagemAdapter = new MensagemAdapter(mensagens);
        mensagemRecyclerView.setAdapter(mensagemAdapter);
        mensagemRecyclerView.setLayoutManager(new LinearLayoutManager(this));

// Enviar mensagem
        enviarButton.setOnClickListener(v -> {
            String texto = inputMensagem.getText().toString().trim();
            if (texto.isEmpty()) {
                Toast.makeText(this, "Digite algo para enviar", Toast.LENGTH_SHORT).show();
                return;
            }

            // Adiciona a mensagem do usuário
            mensagens.add(new Mensagem(texto, true));
            mensagemAdapter.notifyItemInserted(mensagens.size() - 1);
            mensagemRecyclerView.scrollToPosition(mensagens.size() - 1);
            inputMensagem.setText("");

            // Adiciona mensagem de carregamento
            mensagens.add(new Mensagem("⏳ Enviando...", false));
            mensagemAdapter.notifyItemInserted(mensagens.size() - 1);
            mensagemRecyclerView.scrollToPosition(mensagens.size() - 1);

            // Envia para a IA
            openRouterUtil.enviarMensagem(texto, new OpenRouterUtil.PoeCallback() {
                @Override
                public void onResponse(String resposta) {
                    runOnUiThread(() -> {
                        mensagens.set(mensagens.size() - 1, new Mensagem(resposta, false));
                        mensagemAdapter.notifyItemChanged(mensagens.size() - 1);
                        mensagemRecyclerView.scrollToPosition(mensagens.size() - 1);
                    });
                }

                @Override
                public void onError(String erro) {
                    runOnUiThread(() -> {
                        mensagens.set(mensagens.size() - 1, new Mensagem("❌ Erro: " + erro, false));
                        mensagemAdapter.notifyItemChanged(mensagens.size() - 1);
                        mensagemRecyclerView.scrollToPosition(mensagens.size() - 1);
                    });
                }
            });
        });

    }
}
