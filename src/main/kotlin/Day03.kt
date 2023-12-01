class Day03 {

    companion object {
        const val GO_EAST = '>'
        const val GO_SOUTH = 'v'
        const val GO_WEST = '<'
        const val GO_NORTH = '^'
    }

    private var currentLocation = Coordinate(0,0)
    private var currentLocationRobot = Coordinate(0,0)
    private val visitedHouses = mutableSetOf<Coordinate>()

    fun deliverPresentsViaCommands(commands: String) {
        visitedHouses.add(currentLocation)

        for (command in commands) {
            currentLocation = move(command, currentLocation)
            visitedHouses.add(currentLocation)
        }
    }

    private fun move(command: Char, currentLocation: Coordinate): Coordinate{
        return when (command) {
            GO_EAST -> Coordinate(currentLocation.first + 1, currentLocation.second)
            GO_SOUTH -> Coordinate(currentLocation.first, currentLocation.second - 1)
            GO_WEST -> Coordinate(currentLocation.first - 1, currentLocation.second)
            GO_NORTH -> Coordinate(currentLocation.first, currentLocation.second + 1)
            else -> Coordinate(0,0)
        }
    }

    fun getNbOfHousesDelivered(): Int {
        return visitedHouses.size
    }

    fun deliverPresentsWithRoboSantaViaCommands(commands: String) {
        var isRobot = false

        visitedHouses.add(currentLocation)

        for (command in commands) {
            if (isRobot)
                currentLocationRobot = move(command, currentLocationRobot)
            else
                currentLocation = move(command, currentLocation)

            isRobot = !isRobot

            visitedHouses.add(currentLocation)
            visitedHouses.add(currentLocationRobot)
        }
    }
}

typealias Coordinate = Pair<Int, Int>