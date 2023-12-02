import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Day05Test : FreeSpec({

    "samples" - {
        "part 1" - {
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

        "part 2" - {
            "nice string - long" {
                //expect
                Day05().isNiceStringV2("qjhvhtzxzqqjkmpb") shouldBe true
            }

            "nice string - overlapping criteria" {
                //expect
                Day05().isNiceStringV2("xxyxx") shouldBe true
            }

            "naughty string - no repeat with a single letter between them" {
                //expect
                Day05().isNiceStringV2("uurcxstgmygtbstg") shouldBe false
            }

            "naughty string - no pair that appears twice" {
                //expect
                Day05().isNiceStringV2("ieodomkazucvgmuy") shouldBe false
            }

            "naughty string - pairs must not overlap" {
                //expect
                Day05().isNiceStringV2("aaa") shouldBe false
            }

            "nice string - no overlap of pairs but all the same letters" {
                //expect
                Day05().isNiceStringV2("aaaa") shouldBe true
            }
        }
    }

    "solution" - {

        // given
        val letter = getResourceFileAsStringSequence("day05/input.txt")

        "part 1" {
            // when
            val nbOfNiceStrings = Day05().countNiceStrings(letter)

            // then
            nbOfNiceStrings shouldBe 236
        }

        "part 2" {
            // when
            val nbOfNiceStrings = Day05().countNiceStringsV2(letter)

            // then
            nbOfNiceStrings shouldBe 51

        }
    }
}) {
}