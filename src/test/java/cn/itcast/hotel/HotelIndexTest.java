package cn.itcast.hotel;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class HotelIndexTest {
    private RestHighLevelClient client;
    @Test
    void test(){
        System.out.println(client);
    }
    @Test
    void    createHotelIndex() throws IOException {
        CreateIndexRequest request=new CreateIndexRequest("hotel");
        request.source("", XContentType.JSON);
        client.indices().create(request, RequestOptions.DEFAULT);
    }
    @BeforeEach
    void setup(){
         this.client=new RestHighLevelClient(RestClient.builder(
                 HttpHost.create("http://192.168.198.137:9200")));
     }
     @AfterEach
     void terndown() throws IOException {
        client.close();
     }
}
