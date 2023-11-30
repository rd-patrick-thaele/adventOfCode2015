class Day01(private val directions: String) {

    private val BASEMENT = -1

    fun floor(): Int{
        val goUp = directions.count { it == '(' }
        val goDown = directions.length - goUp

        return goUp - goDown
    }

    fun nbOfFloorsPassedWhenArrivingAtBasementTheFirstTime(): Int {
        var floor = 0
        var nbOfFloorsPassed = 0

        for (direction: Char in directions) {
            nbOfFloorsPassed++

            when (direction) {
                '(' -> floor++
                ')' -> floor--
            }

            if (floor == BASEMENT) break
        }

        return nbOfFloorsPassed
    }
}