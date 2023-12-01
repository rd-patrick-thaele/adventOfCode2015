class Day03 {

    companion object {
        const val GO_EAST = '>'
        const val GO_SOUTH = 'v'
        const val GO_WEST = '<'
        const val GO_NORTH = '^'
    }

    private var currentLocation = Coordinate(0,0)
    private val visitedHouses = mutableSetOf<Coordinate>()

    fun deliverPresentsViaCommands(commands: String) {
        visitedHouses.add(currentLocation)

        for (command in commands) {
            when (command) {
                GO_EAST -> currentLocation = Coordinate(currentLocation.first + 1, currentLocation.second)
                GO_SOUTH -> currentLocation = Coordinate(currentLocation.first, currentLocation.second - 1)
                GO_WEST -> currentLocation = Coordinate(currentLocation.first - 1, currentLocation.second)
                GO_NORTH -> currentLocation = Coordinate(currentLocation.first, currentLocation.second + 1)
            }

            visitedHouses.add(currentLocation)
        }
    }

    fun getNbOfHousesDelivered(): Int {
        return visitedHouses.size
    }

    fun deliverPresentsWithRoboSantaViaCommands(commands: String) {
        TODO("Not yet implemented")
    }
}

typealias Coordinate = Pair<Int, Int>