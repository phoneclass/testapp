//package example.classphone;
//
//import java.io.InputStream;
//import java.util.zip.GZIPInputStream;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.message.BasicHeader;
//import org.apache.http.protocol.HTTP;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import android.bluetooth.BluetoothClass.Device;
//import android.preference.PreferenceActivity.Header;
//
//public class Infosender implements Runnable {
//	MainActivity mainActivity;
//	public boolean running;
//
//	// TODO research about how to send infromation from application to server ->
//	// maybe through http ? developer.android
//	public Infosender(MainActivity mainActivity) {
//
//		this.mainActivity = mainActivity;
//		running = true;
//		new Thread(this).start();
//	}
//
//	void sendInfo() {
//
//		JSONObject jsonobj = new JSONObject();
//		try {
//			// adding some keys
//			jsonobj.put("id", "Ralphie");
//
//
//			 
//		} catch (JSONException ex) {
//			
//			ex.printStackTrace();
//		}
//		
//		DefaultHttpClient httpclient = new DefaultHttpClient();
//		HttpPost httppostreq = new HttpPost(
//				"http://emil-mueller.ch/json_test.php");
//		StringEntity se = new StringEntity(jsonobj.toString());
//		se.setContentType("application/json;charset=UTF-8");
//		se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
//				"application/json;charset=UTF-8"));
//		httppostreq.setEntity(se);
//		HttpResponse httpresponse = httpclient.execute(httppostreq);
//
//		HttpEntity resultentity = httpresponse.getEntity();
//		InputStream inputstream = resultentity.getContent();
//		org.apache.http.Header contentencoding = httpresponse
//				.getFirstHeader("Content-Encoding");
//		if (contentencoding != null
//				&& contentencoding.getValue().equalsIgnoreCase("gzip")) {
//			inputstream = new GZIPInputStream(inputstream);
//		}
//		String resultstring = convertStreamToString(inputstream);
//		inputstream.close();
//		resultstring = resultstring.substring(1, resultstring.length() - 1);
//		recvdref.setText(resultstring + "\n\n"
//				+ httppostreq.toString().getBytes());
//		JSONObject recvdjson = new JSONObject(resultstring);
//		recvdref.setText(recvdjson.toString(2));
//	}
//
//	@Override
//	public void run() {
//
//	}
//
//}
