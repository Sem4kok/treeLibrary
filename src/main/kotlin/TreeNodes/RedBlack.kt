package TreeNodes


// BLACK == false
// RED == true
interface RedBlack {
    var color: Boolean
    fun isRed() : Boolean {
        return color
    }
}