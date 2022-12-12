package es.esat.heroesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import es.esat.heroesapp.HeroeFragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onListFragmentInteraction(item: Heroe?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        // Operador ternario
        Snackbar.make(mainView, item?.name ?: "", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
    }

}
