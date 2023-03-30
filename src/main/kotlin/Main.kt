fun main(args: Array<String>) {
    val newPost = Post(
        content = "Это первая публикация"
    )
    val newPost2 = Post(
        content = "Это вторая публикация"
    )
    WallService.add(newPost)
    WallService.add(newPost2)
    WallService.update(newPost)
}

data class Post(
    var id: Int = 0,                //Идентификатор записи.
    val views: Int = 0,             //Информация о просмотрах записи
    val ownerId: Int = 0,           //Идентификатор владельца стены, на которой размещена запись.
    val fromId: Int = 0,            //Идентификатор автора записи (от чьего имени опубликована запись).
    val createdBy: Int = 0,         //Идентификатор администратора, который опубликовал запись
    val dateCreated: Long = 0L,      //Дата публикации записи
    val content: String,        //Конь тент
    val replyOwnerId: Int = 0,      //Идентификатор владельца записи, в ответ на которую была оставлена текущая.
    val replyPostId: Int = 0,       //Идентификатор записи, в ответ на которую была оставлена текущая.
    val friendsOnly: Boolean = false,   //True, если запись была создана с опцией «Только для друзей».
    val postType: String = "post",       //Тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest.
    val signerId: Int = 0,          //Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем.
    val canPin: Boolean = true,        //Может ли текущий пользователь закрепить запись (1 — может, 0 — не может).
    val canDelete: Boolean = true,     //Может ли текущий пользователь удалить запись (1 — может, 0 — не может).
    val canEdit: Boolean = true,       //Может ли текущий пользователь изменить запись (1 — может, 0 — не может).
    val isPinned: Boolean = false,      //Информация о том, что запись закреплена.(True - закреплена, 0 - нет).
    val markedAsAds: Boolean = false,   //Является ли запись рекламой (True - реклама, 0 - нет).
    val isFavorite: Boolean = false,    //true, если объект добавлен в закладки у текущего пользователя.
    val comments: comments = comments(),      //Информация о комментариях к записи, класс с полями
    val copyright: copyright = copyright(),    //Информация об источнике
    val likes: likes = likes(),
)

class comments(
    val count: Int = 0,                //Количество комментариев.
    val canPost: Boolean = true,       //Может ли текущий пользователь комментировать запись (True — может, 0 — не может).
    val groupsCanPost: Boolean = true, //Могут ли сообщества комментировать запись (True — может, 0 — не может).
    val canClose: Boolean = true,      //Может ли текущий пользователь закрыть комментарии к записи (True — может, 0 — не может).
    val canOpen: Boolean = true,       //Может ли текущий пользователь открыть комментарии к записи (True — может, 0 — не может).
)

class copyright(
    val id: Int = 0,
    val link: String = "",
    val name: String = "",
    val type: String = "",
)

class likes(
    val count: Int = 0,                 // Число пользователей, которым понравилась запись
    val userLikes: Boolean = false,     //Наличие отметки «Мне нравится» от текущего пользователя (True — есть, 0 — нет);
    val canLike: Boolean = true,        //Может ли текущий пользователь поставить отметку «Мне нравится» (1 — может, 0 — не может);
    val canPublish: Boolean = true,     // Может ли текущий пользователь сделать репост записи (1 — может, 0 — не может).
)

object WallService {
    private var posts = emptyArray<Post>()
    private var arrayPostId: Int = 0
    fun add(post: Post): Post {
        arrayPostId += 1
        val modifiedPost: Post = post.copy(id = post.id + arrayPostId)
        post.id = modifiedPost.id
        posts += modifiedPost
        println("В массив добавлен пост: ")
        println(modifiedPost)
        return posts.last()
    }

    /*   fun updateById(id: Int): Boolean {
           var found = false
           for ((index, post) in posts.withIndex()) {
               if (post.id == id) {
                   println(post)
                   found = true
               } else found = false
           }
           return found
       }*/
    fun update(postToUpdate: Post): Boolean {
        var found = false
        for ((index, post) in this.posts.withIndex()) {
            if (postToUpdate.id == post.id) {
                println("Найден пост совпадающий с запросом c ID:")
                println(post.id)
                found = true
                posts[index] = postToUpdate
                println("Информация будет полностью обновлена в посте:")
                println(posts[index])
            } else found = false
        }
        return found
    }
    fun clear() {
        posts = emptyArray()
        var arrayPostId: Int = 0
    }
}
