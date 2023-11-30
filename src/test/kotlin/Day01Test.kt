import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Day01Test : FreeSpec({

    "samples" - {
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

    "solution" - {
        "part 1" {
            // given
            val directions = getResourceFileAsStringSequence("day01/input_part1.txt")

            // then
            Day01(directions.first()).floor() shouldBe 74
        }
    }
}) {
}