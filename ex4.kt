data class informaçoes (val matricula: Int, val nome: String, val salario: Double)
var infoL = mutableListOf<informaçoes>()

fun main(){
    começar()
}

fun começar(){
    println("\nSelecione uma opção: \n1. Cadastras 20 registros: \n2. Pesquisar empregado \n3. Acima de 1.000,00 \n4. Salarios abaixo de 1.000,00 \n5. salarios igual a 1.000,00 \n6. Sair")

    val opçoes = readln().toInt()
    when(opçoes){
        1 -> Cadastrar20registros()
        2 -> PesquisarEmpregado()
        3 -> AcimaDe1000()
        4 -> SalariosAbaixoDe1000()
        5 -> salariosIgualA1000()
        6 -> quit()
        else ->
            erro()
    }
}

fun Cadastrar20registros(){
    for (i in 1..20) {
        println("Faça o registro $i: ")
        println("Matricula: ")
        val matricula = readln().toInt()

        println("Nome: ")
        val nome = readln()

        println("salario: ")
        val salario = readln().toDouble()

        infoL.add(informaçoes(matricula, nome, salario))
    }
    // Exibe os registros cadastrados
    println("\nRegistros cadastrados:")
    infoL.forEach { println(it) }
    lista.sortBy { it.nome }
    println("Registros classificados com sucesso!")
    começar()
}

fun PesquisarEmpregado(){
    print("Digite a matricula que deseja buscar: ")
    var matProcurado = readln().toInt()

    var matEncontrado: informaçoes? = null
    for (informaçoes in infoL){
        if (informaçoes.matricula == matProcurado) {
            matEncontrado = informaçoes
            break
        }
}
    if (matEncontrado != null) {
        println("Registro encontrado: matricula= ${matEncontrado.matricula}, nome = ${matEncontrado.nome}, Salario = ${matEncontrado.salario}")
    } else {
        println("Nenhum registro com o matricula '$matProcurado' foi encontrado.")
    }
    começar()
}
fun AcimaDe1000(){
    val maiores1000 = infoL.filter { it.salario >1000 }

    if (maiores1000.isEmpty()) {
        println("Nenhuma pessoa com salario maior que 1.000,00")
    }
    else{
        println("Pessoas com salario maior que 1.000,00:")
        maiores1000.forEach { println("Matricula: ${it.matricula}, Salario: ${it.salario}") }
    }
    começar()
}

fun SalariosAbaixoDe1000(){
    val menores1000 = infoL.filter { it.salario <1000 }

    if (menores1000.isEmpty()) {
        println("Nenhuma pessoa com salario menor que 1.000,00")
    }
    else{
        println("Pessoas com salario menor que 1.000,00:")
        menores1000.forEach { println("Matricula: ${it.matricula}, Salario: ${it.salario}") }
    }
    começar()
}

fun salariosIgualA1000(){
    val iguais1000 = infoL.filter { it.salario.toInt() == 1000 }

    if (iguais1000.isEmpty()) {
        println("Nenhuma pessoa com salario igual a 1.000,00")
    }
    else{
        println("Pessoas com salario iguais a 1.000,00:")
        iguais1000.forEach { println("Matricula: ${it.matricula}, Salario: ${it.salario}") }
    }
    começar()
}
fun quit(){
    println("Programa encerrado. Até mais!")
}
