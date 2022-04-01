package com.gopay.customviews

import com.gopay.responses.StarWarsPeople

sealed class FullScreenViewType {
    object LoadingView: FullScreenViewType()
    object ErrorView: FullScreenViewType()
    class ResponseView(val list: List<StarWarsPeople>): FullScreenViewType()
}