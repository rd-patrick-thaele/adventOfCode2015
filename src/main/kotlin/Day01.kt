class Day01(private val directions: String) {

    fun floor(): Int{
        val goUp = directions.count { it == '(' }
        val goDown = directions.length - goUp

        return goUp - goDown
    }
}