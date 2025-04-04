fun main() {
    
}

fun rowChecker(
    input: MutableList<MutableList<Any>>,
    row: Int // 0
): Boolean {
    val existing = mutableSetOf<Any>()
    for (col in input[row].indices) {
        val inxVal = input[row][col]
        
        if (inxVal != '-' && !existing.add(inxVal)) {
            
            return false
        }
    }
    return true
}

fun columnChecker(
    input: MutableList<MutableList<Any>>,
    col: Int 
): Boolean {
    val existing = mutableSetOf<Any>()
    for (row in input.indices) {
        val inxVal = input[row][col]
        if (inxVal != '-' && !existing.add(inxVal)) {
            
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
