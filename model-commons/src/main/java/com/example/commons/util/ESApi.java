package com.example.commons.util;//package com.example.demo.util;
//
//import org.apache.http.HttpHost;
//import org.elasticsearch.action.ActionListener;
//import org.elasticsearch.action.get.GetRequest;
//import org.elasticsearch.action.get.GetResponse;
//import org.elasticsearch.action.index.IndexRequest;
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.client.RequestOptions;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestClientBuilder;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.elasticsearch.common.Strings;
//import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author: Lc
// * @Date: 2021-05-27
// */
//public class ESApi {
//    private RestHighLevelClient client;
//
//    public void init(){
//        RestClientBuilder restClientBuilder = RestClient.builder(
//                new HttpHost("101.200.75.59",9200,"http"));
//        this.client = new RestHighLevelClient(restClientBuilder);
//    }
//
//    public void after() throws IOException {
//        this.client.close();
//    }
//
//
//    public void testCreate() throws IOException {
//        Map<String,Object> data = new HashMap<>();
//        data.put("id","2002");
//        data.put("title", "南京西路 拎包入住 一室一厅");
//        data.put("price", "4500");
//        IndexRequest indexRequest = new IndexRequest("test", "house")
//                .source(data);
//        IndexResponse indexResponse = this.client.index(indexRequest,
//                RequestOptions.DEFAULT);
//        System.out.println("id->" + indexResponse.getId());
//        System.out.println("index->" + indexResponse.getIndex());
//        System.out.println("type->" + indexResponse.getType());
//        System.out.println("version->" + indexResponse.getVersion());
//        System.out.println("result->" + indexResponse.getResult());
//        System.out.println("shardInfo->" + indexResponse.getShardInfo());
//    }
//
//    /**
//     * 异步创建文档
//     * @throws Exception
//     */
//    public void testCreateAsync() throws Exception {
//        Map<String, Object> data = new HashMap<>();
//        data.put("id", "2003");
//        data.put("title", "南京东路 最新房源 二室一厅");
//        data.put("price", "5500");
//        IndexRequest indexRequest = new IndexRequest("test", "house")
//                .source(data);
//        this.client.indexAsync(indexRequest, RequestOptions.DEFAULT, new ActionListener<IndexResponse>() {
//            @Override
//            public void onResponse(IndexResponse indexResponse) {
//                System.out.println("id->" + indexResponse.getId());
//                System.out.println("index->" + indexResponse.getIndex());
//                System.out.println("type->" + indexResponse.getType());
//                System.out.println("version->" + indexResponse.getVersion());
//                System.out.println("result->" + indexResponse.getResult());
//                System.out.println("shardInfo->" + indexResponse.getShardInfo());
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//                System.out.println(e);
//            }
//        });
//        System.out.println("ok");
//        Thread.sleep(20000);
//    }
//
//    /**
//     * 查询
//     * @throws Exception
//     */
//    public void testQuery() throws Exception {
//        GetRequest getRequest = new GetRequest("test", "house",
//                "6uheq3kBPxCvmSzPDYo1");
//        // 指定返回的字段
//        String[] includes = new String[]{"title", "id"};
//        String[] excludes = Strings.EMPTY_ARRAY;
//        FetchSourceContext fetchSourceContext =
//                new FetchSourceContext(true, includes, excludes);
//        getRequest.fetchSourceContext(fetchSourceContext);
//        GetResponse response = this.client.get(getRequest, RequestOptions.DEFAULT);
//        System.out.println("数据 -> " + response.getSource());
//    }
//
//    /**
//     * 关闭连接
//     */
//    private void close() {
//        try {
//            this.client.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public static void main(String[] args) throws Exception {
//        ESApi esApi = new ESApi();
//        esApi.init();
//        esApi.testQuery();
//    }
//}
