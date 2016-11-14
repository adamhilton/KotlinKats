package net.adamhilton.kotlinkats.ui.main

import android.os.Bundle
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import net.adamhilton.kotlinkats.R
import net.adamhilton.kotlinkats.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    private val url = "http://thecatapi.com/api/images/get"

    @BindView(R.id.cat_pic)
    lateinit var catPic: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ActivityComponent.inject(this)
        ButterKnife.bind(this)
        initializeUi()
    }

    private fun initializeUi() {
        loadCatPic()
    }

    @OnClick(R.id.activity_main)
    fun onCatPicClicked() {
        loadCatPic()
    }

    private fun loadCatPic() {
        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_error_black_48dp)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(catPic)
    }
}

