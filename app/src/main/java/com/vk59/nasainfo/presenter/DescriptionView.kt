package com.vk59.nasainfo.presenter

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface DescriptionView : MvpView {
    @StateStrategyType(value = SingleStateStrategy::class)
    fun showInfo(title: String?, description: String?, date: String?, link: String?)
}