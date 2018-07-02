package elmeniawy.eslam.mvvmposts.ui.post

import android.arch.lifecycle.MutableLiveData
import elmeniawy.eslam.mvvmposts.base.BaseViewModel
import elmeniawy.eslam.mvvmposts.model.Post

/**
 * PostViewModel
 *
 * Created by Eslam El-Meniawy on 02-Jul-2018.
 * CITC - Mansoura University
 */
class PostViewModel : BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: Post) {
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle(): MutableLiveData<String> {
        return postTitle
    }

    fun getPostBody(): MutableLiveData<String> {
        return postBody
    }
}