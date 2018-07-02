package elmeniawy.eslam.mvvmposts.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Post
 * Class which provides a model for post.
 * @constructor Sets all properties of the post.
 * @property userId the unique identifier of the author of the post.
 * @property id the unique identifier of the post.
 * @property title the title of the post.
 * @property body the content of the post.
 *
 * Created by Eslam El-Meniawy on 02-Jul-2018.
 * CITC - Mansoura University
 */
@Entity
data class Post(val userId: Int, @field:PrimaryKey val id: Int, val title: String, val body: String)