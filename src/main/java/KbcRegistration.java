import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class KbcRegistration {
    public static void main(String[] args) {

        RegistrationResponse res = null;

   try{
       String payload = """
               {
                    "fullName": "Binod Nakhan",
                    "email": "binod@gmail.com",
                    "phone": "9860876238",
                    "countryCode": "+977",
                    "quantity": 100
               }
               """;
       StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_JSON);
       CloseableHttpClient httpClient = HttpClients.createDefault();
       HttpPost request = new HttpPost("http://devapi.thedoko.com/api/kbc-registration");
       request.setEntity(entity);
       CloseableHttpResponse response = httpClient.execute(request);

       System.out.println(response.getStatusLine());



   }
   catch (Exception e){
       e.printStackTrace();
   }


        
    }
}
