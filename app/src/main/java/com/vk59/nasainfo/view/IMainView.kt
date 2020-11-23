package com.vk59.nasainfo.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.vk59.nasainfo.model.ResponseData

interface IMainView : MvpView {
    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun loading()

    @StateStrategyType(value = SingleStateStrategy::class)
    fun success(data: ResponseData?)

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun failure()
}