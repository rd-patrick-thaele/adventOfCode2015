class Day06 {

    private val instructionRegex = "(turn on|toggle|turn off) ([0-9]+),([0-9]+) through ([0-9]+),([0-9]+)".toRegex()
    private val lightGrid = Array(1000) { i -> Array(1000) { j -> false } }

    fun countLitLightsAfterInstructions(instructions: List<String>): Int {
        instructions.map { parseInstruction(it) }
            .forEach { applyInstruction(it) }

        return countLitLights()
    }

    fun parseInstruction(instruction: String): Instruction {
        val (action, x1, y1, x2, y2) = instructionRegex.find(instruction)!!.destructured

        return Instruction(action, x1.toInt(), y1.toInt(), x2.toInt(), y2.toInt())
    }

    private fun applyInstruction(instruction: Instruction) {
        for (x in instruction.x1..instruction.x2) {
            for (y in instruction.y1..instruction.y2) {

                when (instruction.action) {
                    "turn on" -> lightGrid[x][y] = true
                    "turn off" -> lightGrid[x][y] = false
                    "toggle" -> lightGrid[x][y] = !lightGrid[x][y]
                }

            }
        }
    }

    fun countLitLights(): Int {
        var countOfLitLights = 0

        for (column in lightGrid) {
            for (row in column) {
                if (row) countOfLitLights++
            }
        }

        return countOfLitLights
    }
}

data class Instruction(val action: String, val x1: Int, val y1: Int, val x2: Int, val y2: Int)