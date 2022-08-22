package taras;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class PetEndpoint {
    public void getPetById(int id) throws IOException {
        Request request = new Request.Builder()
                .get()
                .url("https://petstore.swagger.io/v2/pet/" + id)
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
