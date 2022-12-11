package dgtic.unam.soap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import dgtic.unam.soap.databinding.ActivityMainBinding
import java.util.concurrent.Executors


class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    private val executor = Executors.newSingleThreadExecutor()
    private val myHandler = Handler( Looper.getMainLooper() )

    override fun onCreate(savedInstanceState: Bundle?)
            {
                super.onCreate( savedInstanceState )

                binding = ActivityMainBinding.inflate( layoutInflater )
                setContentView( binding.root )

                binding.button.setOnClickListener {
                    val dataOne = binding.parameterOne.text.toString().trim()
                    val dataTwo = binding.parameterTwo.text.toString().trim()
                    //Llamar el servicio

                    getService( dataOne, dataTwo )
                }
            }

    private fun getService( dataOne: String, dataTwo: String )
            {
                    //Hacer la conexion
                    executor.execute{
                        val response = CallService().callApi( Utils.METHOD_ADD, dataOne, dataTwo )
                        //Despues de hacer la respuesta, ejecutar en segundo plano
                        myHandler.post{
                            try {
                                binding.textView.text = response
                            } catch ( e:Exception )
                            {
                                e.printStackTrace()
                            }
                        }
                    }
            }


}