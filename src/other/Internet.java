package other;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class Internet {
    public static void main(String[] args) {
        // Create OkHttpClient instance
        OkHttpClient client = new OkHttpClient();

        // Construct the GET re with custom headers
        Request re = new Request.Builder()
                .url("https://www.w3schools.com/")  // UUID generation URL
                .get()  // GET method, no body
//                .addHeader("Cookie", "__cf_bm=LpRQvZ713fwkXVNTuwwrraqsxwoz5NEr95Q5NvCfWx4-1737947702-1.0.1.1-yXR9Hki1Mr64O7zlr_djHmQad3cFXe2_tqw8A5t4w6IVnjFJpyXN9pxidnYKwUxOHIJspExGqAagqZJOcBzhhw; __cflb=0H28vzvP5FJafnkHxj4WqVXo9aUyxGrrWSYEopDVd3B; _cfuvid=MUzrlkhIvYVh34zvVZBq.XjvPxK7DzFlgiv3ZVa.uD8-1737947702213-0.0.1.1-604800000")  // Custom cookie header
                .build();

        // Make the re and handle the response
        try (Response response = client.newCall(re).execute()) {
            if (response.isSuccessful()) {
                // Print response code and body if re was successful
                System.out.println("Response Code: " + response.code());
                System.out.println("Response Body: " + response.body().string());
            } else {
                // Print status code if the re failed
                System.out.println("Request failed : " + response.code());
            }
        } catch (IOException e) {
            // Handle network or IO errors
            System.err.println("Error occurred while making the re: " + e.getMessage());
            e.printStackTrace();
        }
    }
}