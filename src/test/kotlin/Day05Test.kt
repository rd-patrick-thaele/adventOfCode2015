import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Day05Test : FreeSpec({

    "samples" - {
        "nice string" {
            // expect
            Day05().isNiceString("ugknbfddgicrmopn") shouldBe true
        }

        "nice string - overlaying rules" {
            // expect
            Day05().isNiceString("aaa") shouldBe true
        }

        "naughty string - no double letter" {
            // expect
            Day05().isNiceString("jchzalrnumimnmhp") shouldBe false
        }

        "naughty string - forbidden char sequence" {
            // expect
            Day05().isNiceString("haegwjzuvuyypxyu") shouldBe false
        }

        "naughty string - only one vowel " {
            // expect
            Day05().isNiceString("dvszwmarrgswjxmb") shouldBe false
        }

        "part 1" {
            // given
            val letter = """
                ugknbfddgicrmopn
                aaa
                jchzalrnumimnmhp
                haegwjzuvuyypxyu
                dvszwmarrgswjxmb
            """.trimIndent().lineSequence().toList()

            // when
            val nbOfNiceStrings = Day05().countNiceStrings(letter)

            // then
            nbOfNiceStrings shouldBe 2
        }
    }

    "solution" - {

        "part 1" {
            // given
            val letter = getResourceFileAsStringSequence("day05/input.txt")

            // when
            val nbOfNiceStrings = Day05().countNiceStrings(letter)

            // then
            nbOfNiceStrings shouldBe 236
        }

        "part 2" {
            // when

        }
    }
}) {
}