class Day05 {
    private val vowels = listOf('a', 'e', 'i', 'o', 'u')
    private val naughtySubstrings = listOf("ab", "cd", "pq", "xy")
    fun countNiceStrings(letter: List<String>): Int {
        return letter.count { isNiceString(it) }
    }

    fun isNiceString(stringInLetter: String): Boolean {
        var vowelsCount = 0
        var doubleCharExists = false
        var prevChar = '_'

        for (char in stringInLetter) {
            if (vowels.contains(char))
                vowelsCount++

            if (prevChar == char)
                doubleCharExists = true

            if (naughtySubstrings.contains(prevChar.toString() + char))
                return false

            prevChar = char
        }

        if (vowelsCount < 3)
            return false

        return doubleCharExists
    }

    fun countNiceStringsV2(letter: List<String>): Int {
        return letter.count { isNiceStringV2(it) }
    }

    fun isNiceStringV2(stringInLetter: String): Boolean {
        var prevChar = '_'
        var prevPrevChar = '_'
        var hasDoubleSingle = false

        val foundDoubles = mutableSetOf<String>()
        var hasDoublePair = false

        for (char in stringInLetter) {
            if (prevPrevChar == char)
                hasDoubleSingle = true

            val lastTwoCharsCombined = prevChar.toString() + char
            val pastCharsCombined = prevPrevChar.toString() + prevChar

            if (foundDoubles.contains(lastTwoCharsCombined)) {
                hasDoublePair = true
            }

            // wait one turn before pair is added to the cache to prevent false positives due to overlapping
            foundDoubles.add(pastCharsCombined)

            prevPrevChar = prevChar
            prevChar = char
        }

        return hasDoubleSingle && hasDoublePair
    }
}