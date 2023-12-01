import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith

class Day04Test : FreeSpec({

    "samples" - {
        "get MD5 hash in HEX" {
            // expect
            Day04().getMd5InHex("abcdef609043") shouldStartWith "000001dbbfa"
            Day04().getMd5InHex("pqrstuv1048970") shouldStartWith "000006136ef"
        }

        "mine advent coins - sample 1" {
            // when
            val seed = Day04().mineAdventCoins("abcdef")

            // then
            seed shouldBe 609043
        }

        "mine advent coins - sample 2" {
            // when
            val seed = Day04().mineAdventCoins("pqrstuv")

            // then
            seed shouldBe 1048970
        }
    }

    "solution" - {

        "part 1" {
            // when
            val seed = Day04().mineAdventCoins("ckczppom")

            // then
            seed shouldBe 117946

        }

        "part 2" {
            // when
            val seed = Day04().mineAdventCoins("ckczppom", 6)

            // then
            seed shouldBe 3938038

        }
    }
}) {
}