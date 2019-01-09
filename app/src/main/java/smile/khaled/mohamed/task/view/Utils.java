package smile.khaled.mohamed.task.view;

import android.content.Context;
import android.net.ConnectivityManager;

public class Utils {

    public static boolean isInternetAvailable(Context context){
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        boolean is=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isAvailable();
        boolean i=connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
        if (i){
            return true;
        } else if (is){
            return true;
        } else {
            return false;
        }

    }
}
