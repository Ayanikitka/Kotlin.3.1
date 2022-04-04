import org.junit.Test

import org.junit.Assert.*

class WallServiceAddTest {

    @Test
    fun add() {
        WallService.clearPosts()
        val post = Post(
            id = -1,
            date = 12343
        )
        WallService.add(post)
        assertTrue(post.id != 0)
    }
    @Test
    fun update_existingId() {
        WallService.clearPosts()
        WallService.add(Post())
        WallService.add(Post())
        val update = Post(id = 2)

        val isUpdate = WallService.update(update)

        assertTrue(isUpdate)
    }
    @Test
    fun update_notExistingId() {
        WallService.clearPosts()
        WallService.add(Post())
        WallService.add(Post())
        val update = Post(id = -1)

        val isNotUpdate = WallService.update(update)

        assertFalse(isNotUpdate)
    }
    @Test
    fun createComment_existingId() {
        WallService.clearPosts()
        WallService.clearComments()
        WallService.add(Post())
        val comment = Comment(postId = 1)

        val isAdded = WallService.createComment(comment)

        assertTrue(isAdded)
    }

    @Test(expected = PostNotFoundException::class)
    fun createComment_notExistingId() {
        WallService.clearPosts()
        WallService.clearComments()
        WallService.add(Post())
        val comment = Comment(postId = 5)

        val isAdded = WallService.createComment(comment)
    }
}