package put.inf154030.szlakiturystyczne

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Animation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        // Znajdź logo
        val logoImageView = findViewById<ImageView>(R.id.hiking_icon)

        // Załaduj animację alfa (fade in)
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        // Załaduj animację obrotu
        val rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_image)

        // Ustaw listener na animację alfa, aby po jej zakończeniu rozpocząć animację obrotu
        fadeInAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                // Nic nie robić
            }

            override fun onAnimationEnd(animation: Animation) {
                // Rozpocznij animację obrotu
                logoImageView.startAnimation(rotateAnimation)
            }

            override fun onAnimationRepeat(animation: Animation) {
                // Nic nie robić
            }
        })

        // Rozpocznij animację alfa
        logoImageView.startAnimation(fadeInAnimation)

        // Ustaw opóźnienie przed przejściem do MainActivity
        val splashScreenTimeOut = 4000L // Więcej czasu, aby uwzględnić czas obu animacji
        logoImageView.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, splashScreenTimeOut)
    }
}