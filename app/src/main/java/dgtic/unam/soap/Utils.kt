package dgtic.unam.soap

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi

class Utils {
    companion object {
        val SOAP_URL = "http://www.dneonline.com/calculator.asmx?"
        val SOAP_NAMESPACE = "http://tempuri.org/"
        ////val METHOD_ADD = "Add"
        val METHOD_ADD = "Multiply"

        @RequiresApi( Build.VERSION_CODES.M )
        fun isConnected( context: Context ) : Boolean
            {
                    val cm = context.getSystemService( Context.CONNECTIVITY_SERVICE ) as ConnectivityManager
                    val aciveNetwork = cm.activeNetwork
                    val capabilities = cm.getNetworkCapabilities( aciveNetwork )
                    return capabilities != null && capabilities.hasTransport( NetworkCapabilities.TRANSPORT_WIFI )
            }
    }
}