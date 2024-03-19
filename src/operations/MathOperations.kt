package operations

class MathOperations {

    // Método para realizar adição.
    fun addition(firstNum: Double, secondNum: Double): String {
        try {
            val result = firstNum + secondNum
            return result.toString()
        } catch (e: Exception) {
            throw IllegalArgumentException("Erro ao realizar a adição: ${e.message}")
        }
    }

    // Método para realizar subtração.
    fun subtraction(firstNum: Double, secondNum: Double): String {
        try {
            val result = firstNum - secondNum
            return result.toString()
        } catch (e: Exception) {
            return "Erro ao realizar a subtração: ${e.message}"
        }
    }

    // Método para realizar multiplicação.
    fun multiplication(firstNum: Double, secondNum: Double): String {
        try {
            val result = firstNum * secondNum
            return result.toString()
        } catch (e: Exception) {
            return "Erro ao realizar a multiplicação: ${e.message}"
        }
    }

    // Método para realizar divisão.
    fun division(firstNum: Double, secondNum: Double): String {
        try {
            if (secondNum == 0.0) {
                throw IllegalArgumentException("Divisão por zero não é permitida.")
            }
            val result = firstNum / secondNum
            return result.toString()
        } catch (e: Exception) {
            return "Erro ao realizar a divisão: ${e.message}"
        }
    }
}
