fun main() {
    // this test case == true
    val input: MutableList<MutableList<Any>> = mutableListOf(
        mutableListOf(5, 3, 4, 6, 7, 8, 9, 1, 2),
        mutableListOf(6, 7, 2, 1, 9, 5, 3, 4, 8),
        mutableListOf(1, 9, 8, 3, 4, 2, 5, 6, 7),
        mutableListOf(8, 5, 9, 7, 6, 1, 4, 2, 3),
        mutableListOf(4, 2, 6, 8, 5, 3, 7, 9, 1),
        mutableListOf(7, 1, 3, 9, 2, 4, 8, 5, 6),
        mutableListOf(9, 6, 1, 5, 3, 7, 2, 8, 4),
        mutableListOf(2, 8, 7, 4, 1, 9, 6, 3, 5),
        mutableListOf(3, 4, 5, 2, 8, 6, 1, 7, 9)
    )

    val valid = sudokuChecker(input, boxSize = 3)
    println(valid)
}

fun rowChecker(
    input: MutableList<MutableList<Any>>,
    row: Int // 0
): Boolean {
    val existing = mutableSetOf<Any>()
    for (col in input[row].indices) {
        val inxVal = input[row][col]
        //  no                        no
        if (inxVal != '-' && !existing.add(inxVal)) {
            //println("Invalid $inxVal is duplicated in row [$row][$col]")
            return false
        }
    }
    return true
}

fun columnChecker(
    input: MutableList<MutableList<Any>>,
    col: Int // 0
): Boolean {
    val existing = mutableSetOf<Any>()
    for (row in input.indices) {
        val inxVal = input[row][col]
        if (inxVal != '-' && !existing.add(inxVal)) {
            //println("Invalid $inxVal is duplicated in column [$col][$row]")
            return false
        }
    }
    return true
}



fun boxChecker(
    input: MutableList<MutableList<Any>>,
    boxSize: Int,
    sRow: Int,
    sCol: Int
): Boolean {
    val existing = mutableSetOf<Any>()
    for (row in sRow until sRow + boxSize) {
        for (col in sCol until sCol + boxSize) {
            val inxVal = input[row][col]
            if (inxVal != '-' && !existing.add(inxVal)) {
                //println("Invalid $inxVal in box([$startRow][$startCol])")
                return false
            }
        }
    }
    return true
}

fun sudokuChecker(
    input: MutableList<MutableList<Any>>,
    boxSize: Int
): Boolean {
    val sudokuSize = input.size
    //println("sudokuSize = $sudokuSize")
    for (row in 0 until sudokuSize) {
        if (!rowChecker(input, row)){
            return false
        }
    }

    for (col in 0 until sudokuSize) {
        if (!columnChecker(input, col)){
            return false
        }
    }

    for (row in 0 until sudokuSize step boxSize) {
        for (col in 0 until sudokuSize step boxSize) {
            if (!boxChecker(input, boxSize, row, col)){
                return false
            }
        }
    }
    return true
}