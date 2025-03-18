data class armazem(val altura: Double, val nome: String)
var armazemL = mutableListOf<armazem>()
var altura = Int
fun main(){
    começo()
}

fun começo(){
    println("\nSelecione uma opção: \n1. Cadastras 15 registros: \n2. Menores ou iguais a 1.5m \n3. maiores que 1.5m \n4. maiores que 1.5 e menores que 2m \n5. Media das alturas \n 6. Sair")

    val opcao = readln().toInt()

    when(opcao){
        1 -> Cadastras15registros()
        2 -> MenoresOuiguaisA1m50()
        3 -> MaioresQue1m50()
        4 -> MaioresQue1m50eMenoresQue2m()
        5 -> Mediadasalturas()
        6 -> saiir()
        else ->
            erro()
        }
    }

fun Cadastras15registros() {
    for (i in 1..15) {
        println("Informe o Nome: ")
        val nome = readln()

        println("Informe a altura: ")
        val altura = readln().toDouble()

        armazemL.add(armazem(altura, nome))
    }
    // Exibe os registros cadastrados
    println("\nRegistros cadastrados:")
    armazemL.forEach { println(it) } //forEach esta imprimindo todos os registros na tela
    começo()
}

fun MenoresOuiguaisA1m50() {
    val menoresIguais = armazemL.filter { it.altura <= 1.5 }
        if (menoresIguais.isEmpty()) {
            println("Nenhuma pessoa com altura menor a 1.5")
        }
        else{
            println("Pessoas com altura menor ou igual a 1.5m:")
            menoresIguais.forEach { println("Nome: ${it.nome}, Altura: ${it.altura}") }
        }
            começo()
        }


fun MaioresQue1m50(){
    val maiores = armazemL.filter { it.altura > 1.5 }
    if (maiores.isEmpty()) {
        println("Nenhuma pessoa com altura maior que 1.5m foi encontrada.")
    } else {
        println("Pessoas com altura maior que 1.5m:")
        maiores.forEach { println("Nome: ${it.nome}, Altura: ${it.altura}") }
    }
    começo()
    }

fun MaioresQue1m50eMenoresQue2m(){
    val intervalo = armazemL.filter { it.altura > 1.5 && it.altura < 2.0 }

    if (intervalo.isEmpty()) {
        println("Nenhuma pessoa com altura entre 1.5m e 2.0m foi encontrada.")
    } else {
        println("Pessoas com altura entre 1.5m e 2.0m:")
        intervalo.forEach { println("Nome: ${it.nome}, Altura: ${it.altura}") }
    }
    começo()
}

fun Mediadasalturas(){
    if (armazemL.isEmpty()) {
        println("Nenhum registro encontrado para calcular a média.")
    } else {
        // Calcula a média usando average
        val media = armazemL.map { it.altura }.average() // O map cria uma nova lista contendo apenas os valores da
                                                        // propriedade altura de cada objeto no armazemL.

        // Exibe a média formatada com 2 casas decimais
        println("A média das alturas é: %.2f".format(media))
        // %.2f = A média é exibida com duas casas decimais, para maior clareza.
    }
    // Volta ao menu inicial
    começo()
}

fun saiir(){
    println("Programa encerrado. Até mais!")
}