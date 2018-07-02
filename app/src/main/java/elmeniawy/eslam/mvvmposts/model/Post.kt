package elmeniawy.eslam.mvvmposts.model

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
data class Post(val userId: Int, val id: Int, val title: String, val body: String)