import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Enzo Cotter on 2019/2/11.
 */
public class SpiderTest {
    public static void main(String[] args) throws IOException {

        String indexUrl = "http://www.itcast.cn";

        CloseableHttpClient HttpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(indexUrl);

        CloseableHttpResponse response = HttpClient.execute(httpGet);

        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            Header[] headers = response.getHeaders("Content-Type");
            System.out.println(headers[0].getValue());

            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity, "utf-8");
            System.out.println(s);
        }

        HttpClient.close();


    }
}
