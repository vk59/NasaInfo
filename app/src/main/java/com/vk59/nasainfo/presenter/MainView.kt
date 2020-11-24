package com.vk59.nasainfo.presenter

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.vk59.nasainfo.model.Item

interface MainView : MvpView {
    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun loading()

    @StateStrategyType(value = SingleStateStrategy::class)
    fun success(data: List<Item>)

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun failure()
}