import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Day01Test : FreeSpec({

    "samples" - {
        "part 1" - {
            "ground floor" {
                Day01("(())").floor() shouldBe 0
                Day01("()()").floor() shouldBe 0
            }

            "3rd floor" {
                Day01("(((").floor() shouldBe 3
                Day01("(()(()(").floor() shouldBe 3
                Day01("))(((((").floor() shouldBe 3
            }

            "basement level" {
                Day01("())").floor() shouldBe -1
                Day01("))(").floor() shouldBe -1
            }

            "underground" {
                Day01(")))").floor() shouldBe -3
                Day01(")())())").floor() shouldBe -3
            }
        }

        "part 2" - {
            "enters basement at 1" {
                Day01(")").nbOfFloorsPassedWhenArrivingAtBasementTheFirstTime() shouldBe 1
            }

            "enters basement at 5" {
                Day01("()())").nbOfFloorsPassedWhenArrivingAtBasementTheFirstTime() shouldBe 5
            }
        }

    }

    "solution" - {
        // given
        val directions = getResourceFileAsStringSequence("day01/input_part1.txt")

        "part 1" {
            // then
            Day01(directions.first()).floor() shouldBe 74
        }

        "part 2" {
            // then
            Day01(directions.first()).nbOfFloorsPassedWhenArrivingAtBasementTheFirstTime() shouldBe 1795
        }
    }
}) {
}