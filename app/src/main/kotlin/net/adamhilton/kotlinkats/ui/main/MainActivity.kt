package net.adamhilton.kotlinkats.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import net.adamhilton.kotlinkats.R
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val url = "http://thecatapi.com/api/images/get"

    @BindView(R.id.cat_pic)
    lateinit var catPic: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        initializeUi()
    }

    private fun initializeUi() {
        loadCatPic()
    }

    @OnClick(R.id.cat_pic)
    fun onCatPicClicked() {
        loadCatPic()
    }

    private fun loadCatPic() {
        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.loading_animation)
                .memoryPolicy(MemoryPolicy.NO_CACHE )
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(catPic)
    }
}
