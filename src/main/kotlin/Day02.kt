class Day02 {
    fun getTotalWrappingPaper(elvesList: List<String>): Int {
        return readElvesList(elvesList).map { it.neededWrappingPaper() }
            .sum()
    }

    fun getTotalRibbonLength(elvesList: List<String>): Int {
        return readElvesList(elvesList).map { it.totalFeetOfRibbon() }
            .sum()
    }

    fun readElvesList(elvesList: List<String>): List<Present> {
        val boxRegex = "([0-9]+)x([0-9]+)x([0-9]+)".toRegex()

        return elvesList.map {
            val (length, width, height) = boxRegex.find(it)!!.destructured
            Present(length.toInt(), width.toInt(), height.toInt())
        }
    }
}

data class Present(val length: Int, val width: Int, val height: Int) {
    fun neededWrappingPaper(): Int{
        val area1 = length * width
        val area2 = length * height
        val area3 = width * height

        val slackMaterial = listOf(area1, area2, area3).min()

        return 2 * area1 + 2 * area2 + 2 * area3 + slackMaterial
    }

    fun totalFeetOfRibbon(): Int {
        val sortedDimensions = listOf(length, width, height).sorted()
        val ribbonLength = sortedDimensions.first() * 2 + sortedDimensions[1] * 2

        return ribbonLength + volume()
    }

    fun volume(): Int {
        return length * width * height
    }

}
