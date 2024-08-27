import org.mariuszgromada.math.mxparser.Expression

fun solveExpression(expression: String): String {
    // Adiciona parênteses aos números negativos e converte porcentagens
    val modifiedExpression = expression
        .replace(Regex("(?<!\\d|\\))(-\\d+(?:\\.\\d+)?)")) { "($it)" }
        .replace("÷", "/")
        .replace("×", "*")

    return try {
        val result = Expression(modifiedExpression).calculate().toString()
        when {
            result.isEmpty() || result == "Infinito" || result == "-Infinito" || result == "NaN" -> "Error"
            else -> result.removeSuffix(".0")
        }
    } catch (e: Exception) {
        "Não foi possível"
    }
}

fun delCharacter(expression: String): String = expression.dropLast(1)