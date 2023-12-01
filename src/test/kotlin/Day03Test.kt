import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe

class Day03Test : FreeSpec({

    "samples" - {
        "deliver presents - east" {
            // given
            val day03 = Day03()
            val commands = ">"

            // when
            day03.deliverPresentsViaCommands(commands)

            // then
            day03.getNbOfHousesDelivered() shouldBe 2
        }

        "deliver presents - in a circle" {
            // given
            val day03 = Day03()
            val commands = "^>v<"

            // when
            day03.deliverPresentsViaCommands(commands)

            // then
            day03.getNbOfHousesDelivered() shouldBe 4
        }

        "deliver presents - up and down" {
            // given
            val day03 = Day03()
            val commands = "^v^v^v^v^v"

            // when
            day03.deliverPresentsViaCommands(commands)

            // then
            day03.getNbOfHousesDelivered() shouldBe 2
        }
    }

    "solution" - {

        // given
        val commands = getResourceFileAsStringSequence("day03/input.txt").first()

        "part 1" {
            // given
            val day03 = Day03()

            // when
            day03.deliverPresentsViaCommands(commands)

            // then
            day03.getNbOfHousesDelivered() shouldBe 2572

        }

        "part 2" {
            // when

        }
    }
}) {
}