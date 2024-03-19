package operations


// Esta classe é responsável por construir uma expressão numérica a partir de uma string fornecida.
// Ela verifica se a string contém uma expressão numérica válida e a divide em uma lista de tokens (números e operadores).
class NumericExpressionBuilder(value: String?) {
    private val _value: String? = value
    // Método para verificar se a string fornecida é uma expressão numérica válida.
    // Ele retorna uma lista de tokens da expressão.
    fun isNumericExpression(): MutableList<String> {
        try {
            // Divide a string em tokens usando operadores como delimitadores.
            val value = this._value.toString().split(Regex("(?<=[-+x/])|(?=[-+x/])")).toMutableList()
            val regex = Regex("[0-9+\\-x/]+")
            for (char in value) {
                if (!char.toString().matches(regex)) {

                    throw IllegalArgumentException("A entrada contém caracteres inválidos: $char")
                    // Se algum caractere não corresponder à expressão regular, você pode parar o loop ou lidar com isso de outra forma.
                }
            }

            if(value.size==1)  throw IllegalArgumentException("Isso não é uma expressão que pode ser convertida")
            return value
        } catch (err: IllegalArgumentException) {
            // Se ocorrer uma exceção ao tentar dividir a string, lança uma exceção informando que não é uma expressão válida.
         throw IllegalArgumentException(err.message)
        }
    }
}