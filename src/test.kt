fun main(){
//     1.all true
    test(
        description = "When there is no repeated numbers in row, column and subgrid box",
        result = sudokuChecker(
            mutableListOf(
                mutableListOf(5, 3, 4, 6, 7, 8, 9, 1, 2),
                mutableListOf(6, 7, 2, 1, 9, 5, 3, 4, 8),
                mutableListOf(1, 9, 8, 3, 4, 2, 5, 6, 7),
                mutableListOf(8, 5, 9, 7, 6, 1, 4, 2, 3),
                mutableListOf(4, 2, 6, 8, 5, 3, 7, 9, 1),
                mutableListOf(7, 1, 3, 9, 2, 4, 8, 5, 6),
                mutableListOf(9, 6, 1, 5, 3, 7, 2, 8, 4),
                mutableListOf(2, 8, 7, 4, 1, 9, 6, 3, 5),
                mutableListOf(3, 4, 5, 2, 8, 6, 1, 7, 9)
            ),
            boxSize = 3
        ),
        correctResult = true
    )

    // 2.row & column -> true
    test(
        description = "When there is no repeated numbers in row and column but there is in subgrid box",
        result = sudokuChecker(
            input = mutableListOf(
                mutableListOf('-', 5, 8, 2, 4, '-', 9, 1, '-'),
                mutableListOf(3, '-', '-', '-', 9, '-', 6, 8, 7),
                mutableListOf('-', '-', '-', '-', 6, '-', 2, '-', '-'),
                mutableListOf(8, '-', 2, '-', '-', '-', 4, '-', '-'),
                mutableListOf('-', 7, '-', '-', 5, '-', 1, 6, 2),
                mutableListOf(1, 2, '-', '-', '-', 4, '-', 3, '-'),
                mutableListOf('-', 9, 6, '-', 8, 1, 3, '-', 5),
                mutableListOf('-', 8, 1, '-', '-', '-', '-', 2, '-'),
                mutableListOf(7, 4, 3, 5, '-', 6, '-', '-', '-')
            ),
            boxSize = 3
        ),
        correctResult = false
    )
    // 3.column -> true
    test(
        description = "When there is no repeated numbers in column but there is in subgrid box and row",
        result = sudokuChecker(
            input =
                mutableListOf(
                    mutableListOf(7, 7, '-', '-', '-', '-', '-', '-', '-'),
                    mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                    mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                    mutableListOf('-', '-', '-', 5, '-', '-', '-', '-', '-'),
                    mutableListOf('-', '-', '-', '-', 5, '-', '-', '-', '-'),
                    mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                    mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                    mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                    mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-')
                )
            ,
            boxSize = 3
        ),
        correctResult = false
    )
    // 4.all false
    test(
        description = "When there is repeated numbers in row, column and subgrid box",
        result = sudokuChecker(
            input =
                mutableListOf(
                    mutableListOf(5, 5, '-', '-', '-', '-', '-', '-', '-'),
                    mutableListOf('-', '-', 5, '-', '-', '-', '-', '-', '-'),
                    mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                    mutableListOf(5, '-', '-', '-', '-', '-', '-', '-', '-'),
                    mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                    mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                    mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                    mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                    mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-')
                ),
            boxSize = 3
        ),
        correctResult = false
    )
    // 5.row & box -> true
    test(
        description = "When there is no repeated numbers in subgrid box and row but there is in column",
        result = sudokuChecker(
            input =
                mutableListOf(
                    mutableListOf(5, '-', '-', '-', '-', '-', '-', '-', '-'),
                    mutableListOf('-', 1, '-', '-', '-', '-', '-', '-', '-'),
                    mutableListOf('-', '-', 2, '-', '-', '-', '-', '-', '-'),
                    mutableListOf(5, '-', '-', 3, '-', '-', '-', '-', '-'),
                    mutableListOf('-', '-', '-', '-', 4, '-', '-', '-', '-'),
                    mutableListOf('-', '-', '-', '-', '-', 5, '-', '-', '-'),
                    mutableListOf('-', '-', '-', '-', '-', '-', 6, '-', '-'),
                    mutableListOf('-', '-', '-', '-', '-', '-', '-', 7, '-'),
                    mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', 8)
                )
            ,
            boxSize = 3
        ),
        correctResult = false
    )
    // 6.box -> true
    test(
        description = "When there is no repeated numbers in subgrid box but there is in row and column",
        result = sudokuChecker(
            input = mutableListOf(
                mutableListOf(5, '-', '-', '-', 5, '-', '-', '-', '-'),
                mutableListOf('-', 1, '-', '-', '-', '-', '-', '-', '-'),
                mutableListOf('-', '-', 2, '-', '-', '-', '-', '-', '-'),
                mutableListOf(5, '-', '-', 3, '-', '-', '-', '-', '-'),
                mutableListOf('-', '-', '-', '-', 4, '-', '-', '-', '-'),
                mutableListOf('-', '-', '-', '-', '-', 6, '-', '-', '-'),
                mutableListOf('-', '-', '-', '-', '-', '-', 7, '-', '-'),
                mutableListOf('-', '-', '-', '-', '-', '-', '-', 8, '-'),
                mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', 9)
            ),
            boxSize = 3
        ),
        correctResult = false
    )
    // 7.row -> true
    test(
        description = "When there is no repeated numbers in row but there is in subgrid box and column",
        result = sudokuChecker(
            input = mutableListOf(
                mutableListOf(5, 1, 2, 3, 4, 6, 7, 8, 9),
                mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                mutableListOf(5, 7, 8, '-', '-', '-', '-', '-', '-'),
                mutableListOf('-', 5, '-', '-', '-', '-', '-', '-', '-'),
                mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-')
            ),
            boxSize = 3
        ),
        correctResult = false
    )
    // 8.Empty -> true
    test(
        description = "Empty",
        result = sudokuChecker(
            input = mutableListOf(
                mutableListOf('-' , '-' , '-' , '-' , '-' , '-' , '-' , '-' , '-'),
                mutableListOf('-' , '-' , '-' , '-' , '-' , '-' , '-' , '-' , '-'),
                mutableListOf('-' , '-' , '-' , '-' , '-' , '-' , '-' , '-' , '-'),
                mutableListOf('-' , '-' , '-' , '-' , '-' , '-' , '-' , '-' , '-'),
                mutableListOf('-' , '-' , '-' , '-' , '-' , '-' , '-' , '-' , '-'),
                mutableListOf('-' , '-' , '-' , '-' , '-' , '-' , '-' , '-' , '-'),
                mutableListOf('-' , '-' , '-' , '-' , '-' , '-' , '-' , '-' , '-'),
                mutableListOf('-' , '-' , '-' , '-' , '-' , '-' , '-' , '-' , '-'),
                mutableListOf('-' , '-' , '-' , '-' , '-' , '-' , '-' , '-' , '-')
            ),
            boxSize = 9
        ),
        correctResult = true
    )


}

fun test(
    description: String,
    result: Boolean,
    correctResult: Boolean
)
{
    if (result == correctResult){
        println("Success - $description")
    }else {
        println("Failed - $description")
    }
}
