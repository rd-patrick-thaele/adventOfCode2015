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
                vowelsCount ++

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
}