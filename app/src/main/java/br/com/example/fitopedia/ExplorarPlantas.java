package br.com.example.fitopedia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.ArrayList;

import br.com.example.fitopedia.carrossel.Planta;
import br.com.example.fitopedia.carrossel.PlantaAdapter;

public class ExplorarPlantas extends AppCompatActivity {
    private ImageButton homeImageButton;
    private ArrayList<Planta> listaPlantas;
    private String nomePlanilha;
    private RecyclerView plantasRecyclerView;
    private MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_explorar_plantas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new OnApplyWindowInsetsListener() {
            @Override
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return ExplorarPlantas.onCreate(view, windowInsetsCompat);
            }
        });
        this.homeImageButton = findViewById(R.id.homeImageButton);
        this.homeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExplorarPlantas.this.getApplicationContext(), (Class<?>) MainActivity.class);
                ExplorarPlantas.this.startActivity(intent);
            }
        });
        this.listaPlantas = new ArrayList<>();
        String urlPadrao = "https://docs.google.com/spreadsheets/d/e/2PACX-1vTQuvR4PrLT5oRpaKi6MqGV0i7VrmYt0rKisGs0rxRd_-ubbgNYR6qL9ObzFpiwQA-0jGS9-yVQkrmo/pub?output=csv";
        SharedPreferences prefs = getSharedPreferences("app_dados", 0);
        String dadosPlanilha = prefs.getString("planilhaCategoria", null);
        if (dadosPlanilha != null) {
            Log.d("CSV", "Dados carregados: " + dadosPlanilha);
            String[] linhas = dadosPlanilha.split(" \\| ");
            int quantLinhas = linhas.length;
            for (int i = 0; i < quantLinhas; i++) {
                String[] colunas = linhas[i].split(",");
                if (i != 0) {
                    Planta planta = Planta.fromCSVColumns(colunas);
                    if (planta == null) {
                        Log.w("CSV", "Linha " + i + " ignorada por ter menos de 17 colunas.");
                    } else {
                        this.listaPlantas.add(planta);
                    }
                }
            }
        } else {
            Log.d("CSV", "Nenhum dado salvo encontrado.");
        }

        listaPlantas.add(new Planta("Macela", "Achyrocline satureioides", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Macela.JPG/1200px-Macela.JPG"));
        listaPlantas.add(new Planta("Macela", "Achyrocline satureioides", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Macela.JPG/1200px-Macela.JPG"));

        this.plantasRecyclerView = (RecyclerView) findViewById(R.id.plantasRecyclerView);
        this.toolbar = (MaterialToolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        PlantaAdapter adapter = new PlantaAdapter(this, this.listaPlantas);
        this.plantasRecyclerView.setAdapter(adapter);
    }

    static WindowInsetsCompat onCreate(View v, WindowInsetsCompat insets) {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    }
}
