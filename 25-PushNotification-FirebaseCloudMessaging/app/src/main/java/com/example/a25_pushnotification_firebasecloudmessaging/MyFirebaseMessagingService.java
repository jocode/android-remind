package com.example.a25_pushnotification_firebasecloudmessaging;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Camilo on 31/07/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    // Cuando se reciba un mensaje, muestrelo en una notificacion
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.e("MessageFCM", ""+remoteMessage);
        String mensaje = remoteMessage.getData().get("messaje");
        showNotification(mensaje);
    }

    private void showNotification(String mensaje) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        //Instanciamos el elemento para el sonido de la notificacion
        Uri defaulSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this).setAutoCancel(true)
                .setContentTitle("Notificacion")
                .setContentText(mensaje)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setSound(defaulSound)
                .setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());

    }
}
