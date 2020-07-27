fun main(args: Array<String>) {
    val ciudades = listOf("Alicante", "Almería", "Barcelona", "Bilbao", "Burgos", "Cádiz", "Cartagena", "Córdoba", "Gerona"
        , "Gijón", "Granada", "Huelva", "Tenerife", "Ibiza", "Jerez", "Madrid", "Málaga", "Marbella", "Murcia", "Oviedo"
        , "Pamplona", "Ronda", "Salamanca", "San Sebastián", "Santander", "Santiago", "Sevilla", "Tarragona", "Toledo",
        "Valencia", "Zaragoza")

    // Crea una lista con todas las ciudades que tengan la letra "a" mayuscula o minuscula
    println(ejercicio1(ciudades))

    // Crea una lista lazy list de todas las ciudades que tengan la letra "a" mayuscula o minuscula. Las que tengan una "A"
    // deber ser mostradas en mayusculas todas las letras.
    ejercicio2(ciudades)

    // Elimina de ciudades todas las ciudades que tengan 8 letras. Recuerda que tu lista no Mutable
    println(ejercicio3(ciudades))

    // Escribe la lista de ciudades. Aquellas ciudades con una cantidad de letras impar al rever reves. Ej. Ibiza - azibI
    // Resultado esperado: [Alicante, aíremlA, anolecraB, Bilbao, Burgos, zidáC, anegatraC, abodróC, Gerona, nójiG, adanarG, Huelva, Tenerife, azibI, zereJ, Madrid, Málaga, Marbella, Murcia, Oviedo, Pamplona, adnoR, acnamalaS, náitsabeS naS, rednatnaS, Santiago, alliveS, anogarraT, Toledo, Valencia, Zaragoza]
    println(ejercicio5(ciudades))
}

fun ejercicio5(ciudades: List<String>): Any? {
    val ciudadesMutable = ciudades.toMutableList()
    val ciudadesImpares = ciudades.asSequence().filter { (it.length.rem(2) == 1) }
    ciudadesImpares.forEach { ciudadImpar: String ->  ciudadesMutable.forEachIndexed{ index: Int, ciudad: String ->  if (ciudad.contentEquals(ciudadImpar)) ciudadesMutable[index] = ciudadesMutable[index].reversed() }  }
    return ciudadesMutable
}

fun ejercicio3(ciudades: List<String>): MutableList<String> {
    val ciudadesABorrar = ciudades.asSequence().filter { it.length == 8 }
    // Las tres ultimas líneas podrían reducirse a esta:
    // return ciudades.toMutableList().apply { removeAll(ciudadesABorrar) }
    val ciudadesMutable = ciudades.toMutableList()
    ciudadesMutable.removeAll(ciudadesABorrar)
    return ciudadesMutable
}

fun ejercicio2(ciudades: List<String>) {
    ciudades.asSequence().filter { it.contains("a") }
    ciudades.forEach { if (it.contains("A")) print("${it.toUpperCase()}, ") else print("$it, ") }
    println()
}

fun ejercicio1(ciudades: List<String>): List<String> {
    // Tambien se puede hacer con expresiones regulares
    return ciudades.filter { it.contains("a") || it.contains("A") }
}
