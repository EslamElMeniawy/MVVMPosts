package elmeniawy.eslam.mvvmposts.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import elmeniawy.eslam.mvvmposts.model.Post
import elmeniawy.eslam.mvvmposts.model.PostDao

/**
 * AppDatabase
 *
 * Created by Eslam El-Meniawy on 02-Jul-2018.
 * CITC - Mansoura University
 */
@Database(entities = arrayOf(Post::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}