package com.test.spider;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.tools.ant.filters.StringInputStream;

public class HttpTest {

	public String getJsonContent(String url, String referUrl) {
		try {
			HttpClient httpClient = HttpClients.createDefault();
//			PostMethod method = new PostMethod(url); 
			
			HttpPost method = new HttpPost(url);
//			HttpGet method = new HttpGet(url);

			// 建立一个NameValuePair数组，用于存储欲传送的参数
			method.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
			method.addHeader("Accept-Encoding", "gzip, deflate");
			method.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
			method.addHeader("Connection", "keep-alive");
			method.addHeader("Content-Type", "application/json");
			method.addHeader("Referer", referUrl);
//			method.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
			method.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
			method.addHeader("X-Requested-With", "XMLHttpRequest");
			
//			method.setRequestBody("{}");
			
			InputStreamEntity reqEntity = new InputStreamEntity(
					new StringInputStream("{}"), -1, ContentType.APPLICATION_OCTET_STREAM);
			
			method.setEntity(reqEntity);
			
			
			HttpResponse response = httpClient.execute(method);

			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				System.out.println("request api fail :" + response.getStatusLine());
			}

			String body = EntityUtils.toString(response.getEntity());
			System.out.println(body);
			return body;
		} catch (Exception e) {
			System.out.println("请求JSON数据"+e);
		}

		return null;
	}
	
	public static void main(String[] argv){
		String url = "http://gs.amac.org.cn/amac-infodisc/api/pof/fund?rand=0.4775126091664055&page=0&size=20";// page从0开始,size=100
//		String referUrl = "http://gs.amac.org.cn/amac-infodisc/res/aoin/product/index.html";

//		String url = "http://gs.amac.org.cn/amac-infodisc/api/pof/fund?rand=0.5135618324280553&page=0&size=20";// page从0开始,size=100
//		String url = "http://gs.amac.org.cn/amac-infodisc/api/pof/manager?rand=0.35120890842190167&page=0&size=10";// page从0开始,size=100
		String referUrl = "http://gs.amac.org.cn/amac-infodisc/res/pof/fund/index.html";
//		String referUrl = "http://gs.amac.org.cn/amac-infodisc/res/pof/manager/index.html";
//		String url = "http://gs.amac.org.cn/amac-infodisc/res/pof/manager/index.html";
//		String url = "https://api.keandata.com/kdata/api/get?uid=luke&arg=66132382-7&sign=aca0bd081eb5c47c54f698b9670fb6b4";
		
		new HttpTest().getJsonContent(url, referUrl);
	}
}
