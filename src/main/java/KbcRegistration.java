import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;



public class KbcRegistration {
    public static void main(String[] args) {

        try{


            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost post = new HttpPost("http://devapi.thedoko.com/api/kbc-registration");

            post.addHeader("Content-Type","application/json");

            JSONObject json = new JSONObject();
            json.put("fullName","Binod Nakhan");
            json.put("email","binod@gmail.com");
            json.put("phone","9860876238");
            json.put("countryCode","+977");
            json.put("quantity","100");

            post.setEntity(new StringEntity(json.toString()));
            CloseableHttpResponse response = httpClient.execute(post);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);

            Gson gson = new Gson();
            RegistrationResponse registrationResponse = gson.fromJson(result,RegistrationResponse.class);

            System.out.println(registrationResponse.getData().getId());
            System.out.println(registrationResponse.getData().getKbcTokenId());
            System.out.println("quantity:" + registrationResponse.getData().getQuantity());


        }
        catch (Exception e){
            e.printStackTrace();
        }


        
    }
}
