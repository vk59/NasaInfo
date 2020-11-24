package com.vk59.nasainfo.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface IDescriptionView : MvpView {
    @StateStrategyType(value = SingleStateStrategy::class)
    fun showInfo(title: String?, description: String?, linksForImages: String?)

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun failure()
}