import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }
    @Test
    fun addPostIdChanged() {
        val testContent: String = "Это тестовая публикация"
        val testPost = Post (content = testContent)
        val result = WallService.add(testPost)

        assertEquals(1,result.id)
    }
    @Before
    fun clearBeforeTestUpdate() {
        WallService.clear()
    }
    @Test
    fun updateIdExist() {
        val testContent: String = "Это тестовая публикация для проверки обновления поста, когда ID существует в массиве"
        val testPost = Post (content = testContent)
        WallService.add(testPost)
        val result = WallService.update(testPost)
        assertEquals(true, result)
    }
    @Before
    fun clearBeforeTestUpdateNoId() {
        WallService.clear()
    }
    @Test
    fun updateIdNotExist() {
        val testContent: String = "Это тестовая публикация для проверки обновления поста, когда ID существует в массиве"
        val testPost = Post (content = testContent)
        //WallService.add(testPost)
        val result = WallService.update(testPost)
        assertEquals(false, result)
    }

}