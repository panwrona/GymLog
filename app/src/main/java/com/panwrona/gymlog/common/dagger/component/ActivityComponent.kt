package com.panwrona.gymlog.common.dagger.component

import com.panwrona.gymlog.common.dagger.module.ActivityModule
import com.panwrona.gymlog.common.dagger.scope.PerActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(
        modules = arrayOf(ActivityModule::class)
)
interface ActivityComponent {
}