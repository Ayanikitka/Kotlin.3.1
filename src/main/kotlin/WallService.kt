object WallService {

    private var posts = emptyArray<Post>()
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

    fun clearPosts() {
        posts = emptyArray()
    }
}