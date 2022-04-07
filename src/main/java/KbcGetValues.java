import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.google.gson.Gson;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class KbcGetValues {
    public static void main(String[] args)  {


        Response responseData = null;

        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet("https://devapi.thedoko.com/api");
            request.addHeader("accept","application/json");

            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            System.out.println(result);
            /*convert json to java object*/
            Gson gson = new Gson();
            Response data =gson.fromJson(result, Response.class);

            System.out.println(data.getAdvertisement().getId());
            System.out.println(data.getAdvertisement().getType());
            System.out.println(data.getAdvertisement().getText());
            System.out.println(data.getAdvertisement().getTextNP());
            System.out.println(data.getAdvertisement().getUrl());
            System.out.println(data.getAdvertisement().getUpdatedAt());
            System.out.println(data.getAdvertisement().getDuration());
            System.out.println(data.getAdvertisement().getExpireDate());
            System.out.println(data.getAdvertisement().getPriority());
            System.out.println(data.getAdvertisement().getInterval());
            System.out.println(data.getAdvertisement().getFrequency());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}



