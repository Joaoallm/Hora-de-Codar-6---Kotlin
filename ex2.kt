data class registros(val nome: String, val medias : Int)
var listas = mutableListOf<registros>()
var medias = Int
fun main(){
    iniciar()
}
fun iniciar(){
    println("selecione uma opçao: \n1. Cadastrar os 20 registros \n2. Efetuar classificaçao por nome \n3. Pesquisa por nome \n4. Media do aluno \n5. Sair do programa")

    val opcao = readLine()?.toInt()

    when (opcao) {
        1 -> CadastrarOs20Registros()
        2 -> OrdemPorNome()
        3 -> PesquisaPorNome()
        4 -> MediaDoAluno()
        5 -> sairr()
        else -> erro()
    }
}

fun CadastrarOs20Registros() {
    for (i in 1..20) {
        println("Faça o registro $i: ")
        println("Nome: ")
        val nome = readln()

        println("Media: ")
        var medias = readln().toInt()

        listas.add(registros(nome, medias))
    }
    // Exibe os registros cadastrados
    println("\nRegistros cadastrados:")
    listas.forEach { println(it) } //forEach esta imprimindo todos os registros na tela
    iniciar()
}
fun OrdemPorNome(){
    listas.sortBy { it.nome }
    println("Registros classificados com sucesso!")
    iniciar()
}

fun PesquisaPorNome(){
    println("Digite o nome que deseja buscar: ")
    val nomeBuscar = readln()

    var buscar : registros? = null
    for (registros in listas){
        if (registros.nome.equals(nomeBuscar, ignoreCase = true)) {
            buscar = registros
            if (registros.medias <= 5) {
                println("Aluno ${registros.nome} esta reprovado com média ${registros.medias}.")
            }
            else{
                println("Aluno ${registros.nome} está aprovado com média ${registros.medias}.")
            }
            break
        }
    }
    if (buscar == null) {
        println("Nenhum aluno com o nome '$nomeBuscar' foi encontrado.")
        PesquisaPorNome()
    }
}
fun MediaDoAluno(){
    if (listas.isEmpty()) {
        println("Nenhum registro encontrado")
    }
    else {
        println("Registros cadastrados: ")
        listas.forEach { registros ->
            val status = if (registros.medias <= 5) "Reprovado" else "Aprovado"
            println("Nome: ${registros.nome}, media: ${registros.medias}, $status")
        }
    }
    iniciar()
    }
fun sairr(){
    println("Programa encerrado. Até mais!")
}
