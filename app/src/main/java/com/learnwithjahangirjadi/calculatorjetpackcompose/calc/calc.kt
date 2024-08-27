import org.mariuszgromada.math.mxparser.Expression

fun solveExpression(expression: String): String {
    // Adiciona parênteses aos números negativos e converte porcentagens
    val modifiedExpression = expression
        .replace(Regex("(?<!\\d|\\))(-\\d+(?:\\.\\d+)?)")) { "($it)" }
        .let { handlePercentage(it) }
        .replace("÷", "/")
        .replace("×", "*")

    return try {
        if (!isValidExpression(modifiedExpression)) return "Error"
        val result = Expression(modifiedExpression).calculate().toString()
        when {
            result.isEmpty() || result == "Infinity" || result == "-Infinity" || result == "NaN" -> "Error"
            else -> result.removeSuffix(".0")
        }
    } catch (e: Exception) {
        "Não foi possível"
    }
}

fun isValidExpression(expression: String): Boolean {
    // Valida a expressão para garantir que não contenha erros básicos
    val parenCount = expression.count { it == '(' } - expression.count { it == ')' }
    return parenCount == 0 && expression.isNotBlank()
}

fun delCharacter(expression: String): String = expression.dropLast(1)

fun alternarSinal(input: String): String {
    val index = input.indexOfLast { !it.isDigit() && it != '.' }
    val lastNumber = input.substring(index + 1)
    return when {
        lastNumber.startsWith("(-") && lastNumber.endsWith(")") -> input.substring(0, index + 1) + lastNumber.substring(2, lastNumber.length - 1)
        lastNumber.startsWith("(") && lastNumber.endsWith(")") -> input
        else -> input.substring(0, index + 1) + "(-$lastNumber)"
    }
}

fun handlePercentage(expression: String): String {
    val regex = Regex("([+\\-*/])\\s*(\\d+(?:\\.\\d+)?)%")
    val modifiedExpression = expression.replace(regex) { match ->
        val operator = match.groupValues[1]
        val percentageValue = match.groupValues[2]
        "$operator ($percentageValue / 100)"
    }

    // Handle percentage at the beginning or end of the expression
    return Regex("^(\\d+(?:\\.\\d+)?)%").replace(modifiedExpression) { match ->
        val baseValue = match.groupValues[1]
        "$baseValue / 100"
    }
}
