package taras;

import com.google.gson.Gson;
import okhttp3.*;
import java.io.IOException;
import org.json.JSONObject;
import java.nio.charset.StandardCharsets;

public class OrderEndPoint {

    public Order getOrderId (Long orderId) throws IOException {
        Gson gson = new Gson();
        Request getRequest = new Request.Builder()
                .get()
                .url("https://petstore.swagger.io/v2/store/order/" + orderId)
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(getRequest).execute();
        Order newOrder = gson.fromJson(response.body().string(), Order.class);
        return newOrder;
    }

//Вариант 1
    public Order createOrder(Order order) throws IOException {
        Gson gson = new Gson();
        String jsonString = gson.toJson(order);

        RequestBody requestBody = RequestBody.create(jsonString, MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .post(requestBody)
                .url("https://petstore.swagger.io/v2/store/order/")
                .build();

        Response response = new OkHttpClient().newCall(request).execute();
        if (response.code() != 200) {
            throw new RuntimeException("Request failed: " + response.body().string());
        }
        Order myOrder = gson.fromJson(response.body().string(), Order.class);
        return myOrder;
    }

    //Вариант 2
/*    public void createOrder(Long orderId, Long petId, int quantity) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("orderId", orderId);
        jsonObject.put("petId", petId);
        jsonObject.put("quantity", quantity);

        RequestBody requestBody = RequestBody.create(jsonObject.toString().getBytes(StandardCharsets.UTF_8), MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .post(requestBody)
                .url("https://petstore.swagger.io/v2/store/order/")
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = new OkHttpClient().newCall(request).execute();
        if (response.code() != 200) {
            throw new RuntimeException("Request failed: " + response.body().string());
        }

        System.out.println(response.body().string());
    }*/

    public void deleteOrder(Long orderId) throws IOException {
        Request request = new Request.Builder()
                .delete()
                .url("https://petstore.swagger.io/v2/store/order/" + orderId)
                .build();

        new OkHttpClient().newCall(request).execute();
    }

    public Inventory getInventory () throws IOException {
        Gson gson = new Gson();
        Request getRequest = new Request.Builder()
                .get()
                .url("https://petstore.swagger.io/v2/store/inventory")
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(getRequest).execute();
        Inventory newInventory = gson.fromJson(response.body().string(), Inventory.class);
        System.out.println(newInventory);

        return newInventory;
    }
}
