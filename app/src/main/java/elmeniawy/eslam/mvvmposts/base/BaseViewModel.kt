package elmeniawy.eslam.mvvmposts.base

import android.arch.lifecycle.ViewModel
import elmeniawy.eslam.mvvmposts.injection.component.DaggerViewModelInjector
import elmeniawy.eslam.mvvmposts.injection.component.ViewModelInjector
import elmeniawy.eslam.mvvmposts.injection.module.NetworkModule
import elmeniawy.eslam.mvvmposts.ui.post.PostListViewModel

/**
 * BaseViewModel
 *
 * Created by Eslam El-Meniawy on 02-Jul-2018.
 * CITC - Mansoura University
 */
abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
        }
    }
}