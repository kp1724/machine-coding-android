package com.gopay.customviews

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.gopay.R
import com.gopay.adapter.PeopleAdapter
import com.gopay.customviews.FullScreenViewType.ErrorView
import com.gopay.customviews.FullScreenViewType.LoadingView
import com.gopay.extensions.ViewExtensions.gone
import com.gopay.extensions.ViewExtensions.isGone
import com.gopay.extensions.ViewExtensions.isVisible
import com.gopay.extensions.ViewExtensions.visible
import com.gopay.responses.StarWarsPeople

class FullScreenView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var rvadapter: PeopleAdapter
    private var recyclerView: RecyclerView
    private var errorView: LottieAnimationView
    private var errortext: TextView
    private var loader: CardView

    init {
        val view = inflate(
            context,
            R.layout.full_screen_view,
            this
        )
        view.run {
            recyclerView = findViewById(R.id.recyclerView)
            errorView = findViewById(R.id.error_view)
            errortext = findViewById(R.id.error_text)
            loader = findViewById(R.id.loader)
        }
        rvadapter = PeopleAdapter()
        recyclerView.run {
            layoutManager = LinearLayoutManager(context)
            adapter = rvadapter
        }
    }

    fun show(type: FullScreenViewType) {
        when (type) {
            LoadingView -> {
                if (loader.isGone()) {
                    loader.visible()
                }
                hide(FullScreenViewType.ResponseView(emptyList()))
            }
            ErrorView -> {
                if (loader.isVisible()) {
                    loader.gone()
                }
                if (errorView.isGone()) {
                    errorView.visible()
                }
                if (errortext.isGone()) {
                    errortext.visible()
                }
            }
            is FullScreenViewType.ResponseView -> {
                hide(ErrorView)
                hide(LoadingView)
                recyclerView.visible()
                setDataToRecyclerView(type.list)
            }
        }
    }

    private fun setDataToRecyclerView(list: List<StarWarsPeople>) {
        rvadapter.addData(list as MutableList<StarWarsPeople>)
        rvadapter.notifyDataSetChanged()
    }

    private fun hide(type: FullScreenViewType) {
        when (type) {
            LoadingView -> {
                if (loader.isVisible()) {
                    loader.gone()
                }
            }
            ErrorView -> {
                if (errorView.isVisible()) {
                    errorView.gone()
                }
                if (errortext.isVisible()) {
                    errortext.gone()
                }
            }
            is FullScreenViewType.ResponseView -> {
                if(recyclerView.isVisible()) {
                    recyclerView.gone()
                }
            }
        }
    }

}