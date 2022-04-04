import java.lang.RuntimeException

object WallService {

    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var nextId = 1

    fun add(post: Post): Post {
        posts += post.copy(id = nextId)
        nextId++
        posts += post
        return post
    }

    fun update(post: Post): Boolean {
        for (i in posts.indices)
            if (posts[i].id == post.id) {
                posts[i] = post.copy(id = posts[i].id, date = posts[i].date)
                return true
            }
        return false
    }

    fun createComment(comment: Comment): Boolean {
        for (i in posts.indices)
            if (posts[i].id == comment.postId) {
                comments += comment
                return true
            }
        throw PostNotFoundException("no post with ${comment.postId}")
    }

    fun clearPosts() {
        posts = emptyArray()
    }
    fun clearComments() {
        comments = emptyArray()
    }
}

class PostNotFoundException(s: String) : RuntimeException(s)
