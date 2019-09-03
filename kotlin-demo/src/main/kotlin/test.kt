open class Group (
    val groupId : Long,
    var photoUrl : String,
    var title : String,
    var description : String
)

 open class Post (
     val idPost : Long,
     groupId: Long,
     photoUrl : String,
     title : String,
     description : String
) : Group (groupId,photoUrl,title,description) {
     open fun likeNumber(idPost : Long) {
      println(2)
   }
    open fun numberComments(idPost : Long) {
        println(3)
    }
     open fun numberReposts(idPost : Long) {
        println(4)
    }
     open fun numberViews(idPost : Long) {
        println(5)
    }
}

class Repost (
    val idRepost : Long,
    val GroupRepostId : Long,
    idPost : Long,
    groupId: Long,
    photoUrl : String,
    title : String,
    description : String

): Post(idPost,groupId,photoUrl,title,description) {
    override fun likeNumber(idRepost: Long) = super.likeNumber(idRepost)

    override fun numberComments(idRepost: Long)  = super.numberComments(idRepost)

}

fun main() {
    val group = Group(1,"ddd", "ddd","ss")
    val post = Post(1,1,"dd","dsd","d")
    val repost = Repost(1,2,5,4,"ds","ds","ds")
    repost.likeNumber(1)
}

