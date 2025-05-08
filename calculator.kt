fun main() {

    println("\nSimple Calculator in Kotlin")
    println(
            "\nThe program will prompt you to enter the first number, then the operator, then the second. After that, it will output the result."
    )
    var runProgram = true; while (runProgram) { // At the end of the calculations, the program assumes that the user will
        // want to calculate something again. Here begins a loop that will end when
        // the user refuses to continue calculating.
        // Number 1 Input
        var num1: Double = 0.0 // Created a mutable double variable that will default to zero
        var validNum1 = false // Created a mutable boolean variable to check for a valid number

        while (!validNum1) { // Start a loop that checks the number for validity
            println("Enter first number: ")
            val input1 = readLine() // Write the first number

            if (input1.isNullOrBlank()) { // Checks if our input is not null
                println("Error: No input found!") // Shows an error if it is null
            } else {
                val parsedNum1 =
                        input1.toDoubleOrNull() // It it is not null then converts string to double
                if (parsedNum1 == null) {
                    println("Error: Invalid input!") // Shows an error if it is not double
                } else {
                    num1 = parsedNum1
                    validNum1 = true
                }
            }
        }

        // Operator Input
        var operator: String =
                "+" // Created a mutable string variable that will default to + operator
        var validOperator =
                false // Created a mutable boolean variable to check for a valid operator

        while (!validOperator) { // Start a loop that checks the operator for validity
            println("Enter operator (+, -, *, /): ")
            val opInput = readLine() // Write the operator

            if (opInput.isNullOrBlank()) { // Checks if our operator is not null
                println("Error: No operator found!") // Shows an error if it is null
            } else if (opInput in listOf("+", "-", "*", "/")
            ) { // Checks if the operator is supported by the program
                operator = opInput
                validOperator = true
            } else {
                println(
                        "'Error: Invalid operator. Choose one from the list!"
                ) // Shows an error if the operator can't be used
            }
        }

        // Number 2 Input
        var num2: Double = 0.0 // Created a mutable double variable that will default to zero
        var validNum2 = false // Created a mutable boolean variable to check for a valid number

        while (!validNum2) { // Start a loop that checks the number for validity
            println("Enter second number: ")
            val input2 = readLine() // Write the second number

            if (input2.isNullOrBlank()) { // Checks if our input is not null
                println("Error: No input found!") // Shows an error if it is null
            } else {
                val parsedNum2 =
                        input2.toDoubleOrNull() // It it is not null then converts string to double
                if (parsedNum2 == null) {
                    println("Error: Invalid input!") // Shows an error if it is not double
                } else if (operator == "/" && parsedNum2 == 0.0
                ) { // Checks if our operation is not a division by zero
                    println("Error: Cannot divide by zero!")
                } else {
                    num2 = parsedNum2
                    validNum2 = true
                }
            }
        }

        // Calculation
        val result =
                when (operator) { // Uses cases to choose a needed logic
                    "+" -> num1 + num2
                    "-" -> num1 - num2
                    "*" -> num1 * num2
                    "/" -> num1 / num2
                    else -> 0.0 // Impossible case (we validated earlier)
                }

        println("Result: $result")

        // Closing program
        var gotAnswer =
                false // Created a mutable boolean variable to check if another calculation is
        // needed

        while (!gotAnswer) { // Start a loop that checks yes or no answers
            println("Do another calculation? (y/n)")
            val response = readLine()

            when (response?.lowercase()) { //Converts any input to lovercase
                "y" -> {
                    runProgram = true
                    gotAnswer = true
                }
                "n" -> {
                    runProgram = false
                    gotAnswer = true
                }
                else -> println("Please answer 'y' or 'n'!")
            }
        }
    }

    println("Program stopped.")
}
