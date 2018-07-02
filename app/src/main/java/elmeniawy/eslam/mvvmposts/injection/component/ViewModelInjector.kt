package elmeniawy.eslam.mvvmposts.injection.component

import dagger.Component
import elmeniawy.eslam.mvvmposts.injection.module.NetworkModule
import elmeniawy.eslam.mvvmposts.ui.post.PostListViewModel
import javax.inject.Singleton

/**
 * ViewModelInjector
 * Component providing inject() methods for presenters.
 *
 * Created by Eslam El-Meniawy on 02-Jul-2018.
 * CITC - Mansoura University
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified PostListViewModel.
     * @param postListViewModel PostListViewModel in which to inject the dependencies.
     */
    fun inject(postListViewModel: PostListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }

}