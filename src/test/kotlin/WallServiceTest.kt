import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {


    @Test
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }
    fun addPostIdChanged() {
        val testContent: String = "Это тестовая публикация"
        val testPost = Post(content = testContent)
        val result = WallService.add(testPost)

        assertEquals(1, result.id)
    }



    @Test
    @Before
    fun clearBeforeTestUpdate() {
        WallService.clear()
    }
    fun updateIdExist() {
        val testContent: String = "Это тестовая публикация для проверки обновления поста, когда ID существует в массиве"
        val testPost = Post(content = testContent)
        WallService.add(testPost)
        val result = WallService.update(testPost.copy(id = 1))
        assertEquals(true, result)
        }



    @Test
    @Before
    fun clearBeforeTestUpdateNoId() {
        WallService.clear()
    }
    fun updateIdNotExist() {
        val testContent: String = "Это тестовая публикация для проверки обновления поста, когда ID существует в массиве"
        val testPost = Post(content = testContent)
        //WallService.add(testPost)
        val result = WallService.update(testPost)
        assertEquals(false, result)
    }

}