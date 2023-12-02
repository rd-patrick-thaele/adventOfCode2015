import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Day06Test : FreeSpec({

    "samples" - {
        "parseInstruction - turn on" {
            // given
            val instruction = "turn on 0,0 through 999,999"

            // when
            val parsed = Day06().parseInstruction(instruction)

            // then
            parsed shouldBe Instruction("turn on", 0,0,999,999)
        }

        "parseInstruction - toggle" {
            // given
            val instruction = "toggle 0,0 through 999,0"

            // when
            val parsed = Day06().parseInstruction(instruction)

            // then
            parsed shouldBe Instruction("toggle", 0,0,999,0)
        }

        "parseInstruction - turn off" {
            // given
            val instruction = "turn off 499,498 through 501,500"

            // when
            val parsed = Day06().parseInstruction(instruction)

            // then
            parsed shouldBe Instruction("turn off", 499,498,501,500)
        }

        "countLitLights" {
            // expected
            Day06().countLitLights() shouldBe 0
        }

        "countLitLightsAfterInstructions - turn on" {
            // given
            val instructions = """
                turn on 0,0 through 999,999
            """.trimIndent().lineSequence().toList()

            // when
            val nbOfLitLights = Day06().countLitLightsAfterInstructions(instructions)

            // then
            nbOfLitLights shouldBe 1_000_000
        }

        "countLitLightsAfterInstructions - turn off" {
            // given
            val instructions = """
                turn on 0,0 through 999,999
                turn off 0,0 through 999,0
            """.trimIndent().lineSequence().toList()

            // when
            val nbOfLitLights = Day06().countLitLightsAfterInstructions(instructions)

            // then
            nbOfLitLights shouldBe 999_000
        }

        "countLitLightsAfterInstructions - toggle" {
            // given
            val instructions = """
                turn on 0,0 through 999,999
                turn off 0,0 through 999,0
                toggle 0,0 through 0,999
            """.trimIndent().lineSequence().toList()

            // when
            val nbOfLitLights = Day06().countLitLightsAfterInstructions(instructions)

            // then
            nbOfLitLights shouldBe 998_002
        }
    }

    "solution" - {

        "part 1" {
            // given
            val instructions = getResourceFileAsStringSequence("day06/input.txt")

            // when
            val nbOfLitLights = Day06().countLitLightsAfterInstructions(instructions)

            // then
            nbOfLitLights shouldBe 400410
        }

        "part 2" {

        }
    }
}) {
}