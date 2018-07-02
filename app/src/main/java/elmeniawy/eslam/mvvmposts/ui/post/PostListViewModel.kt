package elmeniawy.eslam.mvvmposts.ui.post

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import android.view.View
import elmeniawy.eslam.mvvmposts.R
import elmeniawy.eslam.mvvmposts.base.BaseViewModel
import elmeniawy.eslam.mvvmposts.model.Post
import elmeniawy.eslam.mvvmposts.model.PostDao
import elmeniawy.eslam.mvvmposts.network.PostApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * PostListViewModel
 *
 * Created by Eslam El-Meniawy on 02-Jul-2018.
 * CITC - Mansoura University
 */
class PostListViewModel(private val postDao: PostDao) : BaseViewModel() {
    @Inject
    lateinit var postApi: PostApi

    private lateinit var subscription: Disposable
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPosts() }
    val postListAdapter: PostListAdapter = PostListAdapter()

    init {
        loadPosts()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadPosts() {
//        subscription = postApi.getPosts()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe { onRetrievePostListStart() }
//                .doOnTerminate { onRetrievePostListFinish() }
//                .subscribe(
//                        { result -> onRetrievePostListSuccess(result) },
//                        { error -> onRetrievePostListError(error) }
//                )
        subscription = Observable.fromCallable { postDao.all }
                .concatMap { dbPostList ->
                    if (dbPostList.isEmpty())
                        postApi.getPosts().concatMap { apiPostList ->
                            postDao.insertAll(*apiPostList.toTypedArray())
                            Observable.just(apiPostList)
                        }
                    else
                        Observable.just(dbPostList)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrievePostListStart() }
                .doOnTerminate { onRetrievePostListFinish() }
                .subscribe(
                        { result -> onRetrievePostListSuccess(result) },
                        { throwable -> onRetrievePostListError(throwable) }
                )
    }

    private fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(postList: List<Post>) {
        postListAdapter.updatePostList(postList)
    }

    private fun onRetrievePostListError(throwable: Throwable) {
        Log.e(PostListViewModel::class.simpleName, throwable.message, throwable)
        errorMessage.value = R.string.post_error
    }
}