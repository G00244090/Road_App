package com.example.Service_App;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpUtils {
  public static String urlContent(String address) throws IOException, ClientProtocolException {
    HttpClient client = new DefaultHttpClient();
    HttpGet httpGet = new HttpGet(address);
    ResponseHandler<String> handler = new BasicResponseHandler();
    return(client.execute(httpGet, handler));
  }
  public static String urlContentPost(String address, String... paramNamesAndValues)
      throws IOException, ClientProtocolException {
    System.out.println("URL = "+address);
    HttpClient client = new DefaultHttpClient();
    HttpPost httpPost = new HttpPost(address);
    //System.out.println("Http post = "+httpPost);
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    for(int i=0; i<paramNamesAndValues.length-1; i=i+2) {
      String paramName = paramNamesAndValues[i];
      String paramValue = paramNamesAndValues[i+1];  // NOT URL-Encoded
      System.out.println("param name ="+paramName+" param value = "+paramValue);
      params.add(new BasicNameValuePair(paramName, paramValue));
    }
    System.out.println("Before url\n\n");
    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
    System.out.println("After url,before entity\n");
    httpPost.setEntity(entity);
    System.out.println("after entity\n");
    ResponseHandler<String> handler = new BasicResponseHandler();
    System.out.println("After Response handler\n");
    return(client.execute(httpPost, handler));
  }
}
