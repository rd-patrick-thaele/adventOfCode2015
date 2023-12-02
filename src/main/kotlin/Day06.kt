class Day06 {

    private val instructionRegex = "(turn on|toggle|turn off) ([0-9]+),([0-9]+) through ([0-9]+),([0-9]+)".toRegex()
    private val lightGrid = Array(1000) { i -> Array(1000) { j -> 0 } }

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
                    "turn on" -> lightGrid[x][y] = 1
                    "turn off" -> lightGrid[x][y] = 0
                    "toggle" -> lightGrid[x][y] = if (lightGrid[x][y] == 0) 1 else 0
                }

            }
        }
    }

    fun countLitLights(): Int {
        var countOfLitLights = 0

        for (column in lightGrid) {
            for (row in column) {
                if (row > 0) countOfLitLights++
            }
        }

        return countOfLitLights
    }

    fun getTotalBrightnessAfterInstructions(instructions: List<String>): Int {
        instructions.map { parseInstruction(it) }
            .forEach { applyBrighness(it) }

        return getTotalBrightness()
    }

    private fun applyBrighness(instruction: Instruction) {
        for (x in instruction.x1..instruction.x2) {
            for (y in instruction.y1..instruction.y2) {

                when (instruction.action) {
                    "turn on" -> lightGrid[x][y]++
                    "turn off" -> lightGrid[x][y] = if (lightGrid[x][y] == 0) 0 else lightGrid[x][y] - 1
                    "toggle" -> lightGrid[x][y] += 2
                }

            }
        }
    }

    private fun getTotalBrightness(): Int {
        var totalBrightness = 0

        for (column in lightGrid) {
            for (row in column) {
                totalBrightness += row
            }
        }

        return totalBrightness
    }
}

data class Instruction(val action: String, val x1: Int, val y1: Int, val x2: Int, val y2: Int)