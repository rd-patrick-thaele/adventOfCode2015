import java.math.BigInteger
import java.security.MessageDigest

class Day04 {
    fun getMd5InHex(toBeHashed: String): String {
        // https://stackoverflow.com/a/64171625
        val md = MessageDigest.getInstance("MD5")

        return BigInteger(1, md.digest(toBeHashed.toByteArray()))
            .toString(16)
            .padStart(32, '0')
    }

    fun mineAdventCoins(secret: String, nbOfZeros: Int = 5): Int {
        var seed = 0

        while(true) {
          val md5 = getMd5InHex(secret + seed)

          if (md5.startsWith("0".repeat(nbOfZeros))) return seed

          seed++
        }
    }
}