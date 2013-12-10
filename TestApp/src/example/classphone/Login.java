package example.classphone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Login extends Thread {
	JSONObject jsonobj;
	public boolean running;
	private String text;
	
//jaklsdfjioasijdfojaldfjioadfsjklaöjfklads
	public Login(String name) throws JSONException {
		this.jsonobj = new JSONObject();
		running = true;
		//new Thread(this).start();
		jsonobj.put("id", name);

	}

	public void run() {

		// TODO Auto-generated method stub

		

		// serving its purpose

		//this.start();

		HttpClient httpclient = new DefaultHttpClient();

		HttpPost httppostreq = new HttpPost(
				"http://www.emil-mueller.ch/json_test.php");

		httppostreq.setHeader("Accept", "application/json");

		// httppostreq.setHeader("Content-type", "application/json");

		StringEntity se;

		try {

			se = new StringEntity(jsonobj.toString());

			se.setContentType("application/json;charset=UTF-8");

			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,

			"application/json;charset=UTF-8"));

			httppostreq.setEntity(se);

			httppostreq.addHeader("content-type",
					"application/x-www-form-urlencoded");

			HttpResponse httpresponse;

			httpresponse = httpclient.execute(httppostreq);

			HttpEntity resultentity = httpresponse.getEntity();

			InputStream inputstream = resultentity.getContent();

			org.apache.http.Header contentencoding = httpresponse

			.getFirstHeader("Content-Encoding");

			if (contentencoding != null

			&& contentencoding.getValue().equalsIgnoreCase("gzip")) {

				inputstream = new GZIPInputStream(inputstream);

			}

			String resultstring = convertStreamToString(inputstream);

			inputstream.close();
			this.text=resultstring;

			Log.d("---------------------------------LOGIN", resultstring);

		} catch (UnsupportedEncodingException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (ClientProtocolException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}
	
	public String getText(){
		return this.text;
	}

	private static String convertStreamToString(InputStream is) {
		String line = "";

		StringBuilder total = new StringBuilder();

		BufferedReader rd = new BufferedReader(new InputStreamReader(is));

		try {

			while ((line = rd.readLine()) != null) {

				total.append(line);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return total.toString();

	}

	
}
