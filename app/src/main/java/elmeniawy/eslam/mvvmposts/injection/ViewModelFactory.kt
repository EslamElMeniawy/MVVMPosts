package elmeniawy.eslam.mvvmposts.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import elmeniawy.eslam.mvvmposts.model.database.AppDatabase
import elmeniawy.eslam.mvvmposts.ui.post.PostListViewModel

/**
 * ViewModelFactory
 *
 * Created by Eslam El-Meniawy on 02-Jul-2018.
 * CITC - Mansoura University
 */
class ViewModelFactory(private val activity: AppCompatActivity) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext,
                    AppDatabase::class.java, "posts").build()

            @Suppress("UNCHECKED_CAST")
            return PostListViewModel(db.postDao()) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")

    }
}