package com.panwrona.gymlog.common.dagger.module

import android.app.Activity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(val activity: Activity) {

    //TODO uncomment when facebook added
//    @Provides
//    @PerActivity
//    fun provideCallbackManager(): CallbackManager {
//        return CallbackManager.Factory.create()
//    }
//
//    @Provides
//    @PerActivity
//    fun provideFacebookStore(callbackManager: CallbackManager): FacebookStore {
//        return FacebookStoreImpl(activity, callbackManager)
//    }
}