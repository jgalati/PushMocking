package com.kunst.plugin;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.Iterator;



public class PushMockingPlugin extends CordovaPlugin {
    public static final String TAG = "PushMocking";

    public static final String ACTION_SHOW_PUSH = "showPush";


	/**
	 * Gets the application context from cordova's main activity.
	 * @return the application context
	 */
	private Context getApplicationContext() {
		return this.cordova.getActivity().getApplicationContext();
	}
    

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
	    try {
		    if (ACTION_SHOW_PUSH.equals(action)) { 
                        JSONObject arg_object = args.getJSONObject(0);
                        sendNotification(getApplicationContext(), arg_object.getString("title"), arg_object.getString("message"), arg_object.getString("appName"));				
                        callbackContext.success();
                        return true;
	    }
	    callbackContext.error("Invalid action");
	    return false;
		} catch(Exception e) {
			System.err.println("Exception: " + e.getMessage());
                        callbackContext.error(e.getMessage());
                        return false;
		}     
    }

    private void sendNotification(Context context, String title, String message, String appName){
		NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		NotificationCompat.Builder mBuilder =
			new NotificationCompat.Builder(context)
				.setSmallIcon(context.getApplicationInfo().icon)
				.setWhen(System.currentTimeMillis())
				.setContentTitle(title)
				.setTicker(title)
				.setContentText(message)
				.setNumber(1);

				mNotificationManager.notify(appName, 0, mBuilder.build());
    }

}