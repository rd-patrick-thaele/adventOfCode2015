import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe

class Day02Test : FreeSpec({

    "samples" - {
        "present wrapping paper" {
            Present(2, 3, 4).neededWrappingPaper() shouldBe 58
            Present(1, 1, 10).neededWrappingPaper() shouldBe 43
        }

        "present feet of ribbon" {
            Present(2, 3, 4).totalFeetOfRibbon() shouldBe 34
            Present(1, 1, 10).totalFeetOfRibbon() shouldBe 14
        }

        "read elves list" {
            // given
            val elvesList = listOf("2x3x4","1x1x10")

            // when
            val presents = Day02().readElvesList(elvesList)

            // expected
            presents shouldContain Present(2,3,4)
            presents shouldContain Present(1,1,10)
            presents.size shouldBe 2
        }

        "part 1 - total wrapping paper" - {
            // given
            val elvesList = listOf("2x3x4","1x1x10")

            // when
            val totalWrappingPaper = Day02().getTotalWrappingPaper(elvesList)

            // then
            totalWrappingPaper shouldBe 101
        }

        "part 2 - total ribbon length" - {
            // given
            val elvesList = listOf("2x3x4","1x1x10")

            // when
            val totalRibbonLength = Day02().getTotalRibbonLength(elvesList)

            // then
            totalRibbonLength shouldBe 48
        }
    }

    "solution" - {

        // given
        val elvesList = getResourceFileAsStringSequence("day02/input.txt")

        "part 1" {
            // when
            val totalWrappingPaper = Day02().getTotalWrappingPaper(elvesList)

            // then
            totalWrappingPaper shouldBe 1588178
        }

        "part 2" {
            // when
            val totalRibbonLength = Day02().getTotalRibbonLength(elvesList)

            // then
            totalRibbonLength shouldBe 3783758
        }
    }
}) {
}