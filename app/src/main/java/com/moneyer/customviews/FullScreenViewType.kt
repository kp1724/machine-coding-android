package com.moneyer.customviews

import com.moneyer.responses.StarWarsPeople

sealed class FullScreenViewType {
    object LoadingView: FullScreenViewType()
    object ErrorView: FullScreenViewType()
    class ResponseView(val list: List<StarWarsPeople>): FullScreenViewType()
}