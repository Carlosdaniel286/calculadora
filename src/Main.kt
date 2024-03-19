//import operations.MathOperations
import operations.Calculation
import operations.NumericExpressionBuilder
fun main() {
    try {
        // Solicita ao usuário que digite uma expressão aritmética.
        print("Digite algo: ")
        val input: String? = readlnOrNull()
        val calculation = Calculation(input)
        val result = calculation.result()
        // Imprime o resultado da expressão aritmética.
        println("Resultado: $result")
    }catch (err: IllegalArgumentException){
        println(err.message)

    }
}

