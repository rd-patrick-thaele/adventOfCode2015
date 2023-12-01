import io.kotest.core.spec.style.FreeSpec
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

        "deliver presents with roboSanta - one each" {
            // given
            val day03 = Day03()
            val commands = "^v"

            // when
            day03.deliverPresentsWithRoboSantaViaCommands(commands)

            // then
            day03.getNbOfHousesDelivered() shouldBe 3
        }

        "deliver presents with roboSanta - no circle anymore" {
            // given
            val day03 = Day03()
            val commands = "^>v<"

            // when
            day03.deliverPresentsWithRoboSantaViaCommands(commands)

            // then
            day03.getNbOfHousesDelivered() shouldBe 3
        }

        "deliver presents with roboSanta - moving in different directions" {
            // given
            val day03 = Day03()
            val commands = "^v^v^v^v^v"

            // when
            day03.deliverPresentsWithRoboSantaViaCommands(commands)

            // then
            day03.getNbOfHousesDelivered() shouldBe 11
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
            // given
            val day03 = Day03()

            // when
            day03.deliverPresentsWithRoboSantaViaCommands(commands)

            // then
            day03.getNbOfHousesDelivered() shouldBe 2631
        }
    }
}) {
}