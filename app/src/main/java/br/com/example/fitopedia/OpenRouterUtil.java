package br.com.example.fitopedia;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.IOException;

public class OpenRouterUtil {

    // Substitua pela sua chave de API Poe
    private static final String POE_API_KEY = "";
    private static final String BASE_URL = "https://api.poe.com/v1/chat/completions";
    private static final String MODEL = "Fitopedia";

    private final OkHttpClient client = new OkHttpClient();

    public interface PoeCallback {
        void onResponse(String resposta);
        void onError(String erro);
    }

    public void enviarMensagem(String mensagem, PoeCallback callback) {
        try {
            // Monta a mensagem do usuário no formato OpenAI-style
            JSONObject userMessage = new JSONObject();
            userMessage.put("role", "user");
            userMessage.put("content", mensagem);

            JSONArray messages = new JSONArray();
            messages.put(userMessage);

            JSONObject body = new JSONObject();
            body.put("model", MODEL);
            body.put("messages", messages);

            // Cria o RequestBody com charset UTF-8
            RequestBody requestBody = RequestBody.create(
                    body.toString(),
                    MediaType.parse("application/json; charset=utf-8")
            );

            Request request = new Request.Builder()
                    .url(BASE_URL)
                    .addHeader("Authorization", "Bearer " + POE_API_KEY) // CORRETO
                    .addHeader("Content-Type", "application/json")
                    .post(requestBody)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    String respostaJson = response.body().string();
                    System.out.println("DEBUG: Resposta Poe: " + respostaJson); // Log para debug

                    if (!response.isSuccessful()) {
                        callback.onError("Erro HTTP: " + response.code() + " - " + respostaJson);
                        return;
                    }

                    try {
                        // Garante que é JSON
                        JSONObject json = new JSONObject(new JSONTokener(respostaJson));

                        JSONArray choices = json.getJSONArray("choices");
                        JSONObject message = choices.getJSONObject(0).getJSONObject("message");
                        String conteudo = message.getString("content");

                        callback.onResponse(conteudo);

                    } catch (Exception e) {
                        callback.onError("Erro ao processar JSON: " + e.getMessage() + "\nResposta: " + respostaJson);
                    }
                }

                @Override
                public void onFailure(Call call, IOException e) {
                    callback.onError("Falha na conexão: " + e.getMessage());
                }
            });

        } catch (Exception e) {
            callback.onError("Erro geral: " + e.getMessage());
        }
    }
}
