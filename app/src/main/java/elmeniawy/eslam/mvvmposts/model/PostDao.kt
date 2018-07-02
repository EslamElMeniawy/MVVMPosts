package elmeniawy.eslam.mvvmposts.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * PostDao
 *
 * Created by Eslam El-Meniawy on 02-Jul-2018.
 * CITC - Mansoura University
 */
@Dao
interface PostDao {
    @get:Query("SELECT * FROM post")
    val all: List<Post>

    @Insert
    fun insertAll(vararg posts: Post)
}