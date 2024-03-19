package operations
import operations.MathOperations
import operations.NumericExpressionBuilder

// Esta classe é responsável por realizar o cálculo da expressão aritmética.
class Calculation(value: String?) {
    private val numericExpressionBuilder = NumericExpressionBuilder(value)
    private val expressionArithmetic = numericExpressionBuilder.isNumericExpression()
    private var number1 = 0.0
    private var number2 = 0.0
    private val arithmeticOperators = listOf("+", "-", "/", "x")
    private var result: String = ""
    private var index: Int = 0

    // Método para calcular a expressão aritmética.
    fun result(): String {
        try {
            for (i in 0..expressionArithmetic.size) {
                val findPrecedence = expressionArithmetic.find { it == "x" || it == "/" }
                val findSecondPrecedence = expressionArithmetic.find { it == "+" || it == "-" }
                val mathOperations = MathOperations()

                if (expressionArithmetic.size == 1) break

                if (findPrecedence is String) {
                    this.setNumbers(findPrecedence)
                    if (findPrecedence == "x") {
                        val calculate = mathOperations.multiplication(this.number1, this.number2)
                        this.result = calculate
                        this.setResult()
                    }
                    if (findPrecedence == "/") {
                        val calculate = mathOperations.division(this.number1, this.number2)
                        this.result = calculate
                        this.setResult()
                    }
                } else if (findSecondPrecedence is String) {
                    this.setNumbers(findSecondPrecedence)

                    if (findSecondPrecedence == "+") {
                        val calculate = mathOperations.addition(this.number1, this.number2)
                        this.result = calculate
                        this.setResult()
                    }
                    if (findSecondPrecedence == "-") {
                        val calculate = mathOperations.subtraction(this.number1, this.number2)
                        this.result = calculate
                        this.setResult()
                    }
                }
            }
            // Retorna o resultado da expressão aritmética.
            return expressionArithmetic[0]
        } catch (err: IllegalArgumentException) {
            // Se ocorrer um erro durante o cálculo, imprime a mensagem de erro e lança uma exceção.
            println(err.message)
            throw IllegalArgumentException("Sem index")
        }
    }

    // Método privado para definir os números a serem calculados com base no operador fornecido.
    private fun setNumbers(find: String) {
        try {
            val isArithmeticOperators = this.arithmeticOperators.find { it == find }
            if (isArithmeticOperators !is String) {
                throw IllegalArgumentException("Sem operadores aritméticos")
            }
            val index = expressionArithmetic.indexOf(isArithmeticOperators)
            val beforeIndex = expressionArithmetic[index - 1]
            val afterIndex = expressionArithmetic[index + 1]
            val numberBeforeIndex: Double = beforeIndex.toDouble()
            val numberAfterIndex: Double = afterIndex.toDouble()
            this.number1 = numberBeforeIndex
            this.number2 = numberAfterIndex
            this.index = index
        } catch (err: IllegalArgumentException) {
            println(err.message)
        }
    }

    // Método privado para definir o resultado da operação e atualizar a lista de expressão aritmética.
    private fun setResult() {
        this.expressionArithmetic[this.index] = this.result
        this.expressionArithmetic.removeAt(this.index - 1)
        this.expressionArithmetic.removeAt(this.index)
    }
}
