package example.classphone;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import android.net.*;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.Settings;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.*;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	public Logbook lb;
	public int Counter = 0;
	Login mainActivity;
	public boolean running;
	Login total;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StrictMode.ThreadPolicy policy = new StrictMode.
				ThreadPolicy.Builder().permitAll().build();
				StrictMode.setThreadPolicy(policy); 

		try {
			mainActivity = new Login("asdf");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainActivity.run();

		// } catch (JSONException e) {
		// // TODO Auto-generated catch block
		// Log.d("jsond",e.getMessage());
		// } catch (ClientProtocolException e) {
		// // TODO Auto-generated catch block
		// Log.d("jsond",e.getMessage());
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// Log.d("jsond",e.getMessage());



		// disableWIFI();
		// disableMobile();
		// enableAirplane();
		lb = new Logbook(this);

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		lb.running = false;

	}

	// WIFI; läuft
	public boolean Wifinf() {

		ConnectivityManager cm = (ConnectivityManager) getApplicationContext()
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo wifinf = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

		return wifinf.isConnected();

	}

	void disableWIFI() {
		WifiManager wm = (WifiManager) getBaseContext().getSystemService(
				Context.WIFI_SERVICE);
		Log.d("Wifi----------____________", String.valueOf(Wifinf()));
		if (Wifinf()) {
			Log.d("Wifi----------____________",
					String.valueOf(wm.getWifiState()));

			wm.setWifiEnabled(false);
//			mainActivity.Login();
		}
	}

	// EVTL: (Falls Airplanemode nicht funktioniert)
	// Mobiler Datenverkehr -> set Status von connected auf disconnected?
	// public boolean Mobile() {
	// ConnectivityManager cm = (ConnectivityManager) getApplicationContext()
	// .getSystemService(Context.CONNECTIVITY_SERVICE);
	// NetworkInfo mobinf = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
	// return mobinf.isConnected();
	// }
	//
	// void disableMobile() {
	// TelephonyManager tm = (TelephonyManager) getApplicationContext()
	// .getSystemService(Context.TELEPHONY_SERVICE);
	//
	// if (Mobile()) {
	// Log.d("MOBILE________", String.valueOf(tm.getDataState()));
	//
	// }
	// }

	// public boolean Airinf() {
	// return true;
	// }
	//
	// public static boolean isAirplaneModeOn(Context context) {
	// return Settings.System.getInt(context.getContentResolver(),
	// Settings.System.AIRPLANE_MODE_ON, 0) != 0;
	// }
	//
	// public static void checkMode(Context context) {
	// if (Settings.System.getInt(context.getContentResolver(),
	// Settings.System.AIRPLANE_MODE_ON, 0) != 0) {
	// System.out.println(Settings.System.getInt(
	// context.getContentResolver(),
	// Settings.System.AIRPLANE_MODE_ON, 0));
	// Log.d("AIRPLANEMODE___________________", String
	// .valueOf(Settings.System.getInt(
	// context.getContentResolver(),
	// Settings.System.AIRPLANE_MODE_ON, 0)));
	// }
	// }
	// }

	// public static void setAirplaneMode(Context context,boolean status)
	// {
	// boolean isAirplaneModeOn = isAirplaneModeOn(context);
	//
	// if(isAirplaneModeOn && status)
	// {
	// return;
	// }
	// if(!isAirplaneModeOn && !status)
	// {
	// return;
	// }
	// if(isAirplaneModeOn && !status)
	// {
	// Settings.System.putInt(AppContext.getInstance().getContext
	// ().getContentResolver(),
	// Settings.System.AIRPLANE_MODE_ON, 0);
	// Intent intent = new Intent
	// (Intent.ACTION_AIRPLANE_MODE_CHANGED);
	// intent.putExtra("state", 0);
	// AppContext.getInstance().getContext().sendBroadcast
	// (intent);
	// return;
	// }
	// if(!isAirplaneModeOn && status)
	// {
	// Settings.System.putInt(AppContext.getInstance().getContext
	// ().getContentResolver(),
	// Settings.System.AIRPLANE_MODE_ON, 1);
	// Intent intent = new Intent
	// (Intent.ACTION_AIRPLANE_MODE_CHANGED);
	// intent.putExtra("state", 1);
	// AppContext.getInstance().getContext().sendBroadcast
	// (intent);
	// return;
	// }
}
