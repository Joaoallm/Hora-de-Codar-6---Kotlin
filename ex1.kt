data class registro(val nome: String, val endereço: String, val telefone: Int)
var lista = mutableListOf<registro>()

//Agenda
//Considerando a necessidade de desenvolver uma agenda que contenha nomes, endereços e telefones de 10 pessoas,
// defina a estrutura de registro apropriada, o diagrama de blocos e a codificação de um programa
// que por meio do uso de um menu de opções, execute as seguintes etapas:
//
//a) Cadastrar os 10 registros.
//b) Pesquisar um dos 10 registros de cada vez pelo campo nome (usar o método seqüencial).
//c) Classificar por ordem de nome os registros cadastrados.
//d) Apresentar todos os registros.
//e) Sair do programa de cadastro.
fun main(){
    inicio()
}
fun inicio() {
    println("""
        Selecione uma opção:
        1 - Cadastrar os 10 registros
        2 - Pesquisar registros por nome
        3 - Classificar registros por nome
        4 - Apresentar todos os registros
        5 - Sair
    """.trimIndent())
    val opcao = readLine()?.toInt()

    when (opcao) {
        1 -> CadastrarOs10Registros()
        2 -> PesquisarRegistrosPorNome()
        3 -> ClassificarPorOrdemDeNome()
        4 -> ApresentarTodosOsRegistros()
        5 -> sair()
        else -> erro()
    }
}

fun CadastrarOs10Registros() {
    for (i in 1..10) {
        println("Faça o registro $i: ")
        println("Nome: ")
        val nome = readln()

        println("Endereço: ")
        val endereço = readln()

        println("Telefone: ")
        val telefone = readln().toInt()

        lista.add(registro(nome, endereço, telefone))
    }
    // Exibe os registros cadastrados
    println("\nRegistros cadastrados:")
    lista.forEach { println(it) }
    inicio()
}

fun PesquisarRegistrosPorNome(){
    print("Digite o nome que deseja buscar: ")
    val nomeProcurado = readln()

    var encontrado: registro? = null
    for (registro in lista) {
        if (registro.nome.equals(nomeProcurado, ignoreCase = true)) {
            encontrado = registro
            break
        }
    }
    if (encontrado != null) {
        println("Registro encontrado: Nome = ${encontrado.nome}, Endereço = ${encontrado.endereço}, Telefone = ${encontrado.telefone}")
    } else {
        println("Nenhum registro com o nome '$nomeProcurado' foi encontrado.")
    }
    inicio()
}

fun ClassificarPorOrdemDeNome(){
    lista.sortBy { it.nome }
    println("Registros classificados com sucesso!")
    inicio()
}

fun ApresentarTodosOsRegistros(){
    if (lista.isEmpty()) {
        println("Nenhum registro disponível.")
    } else {
        println("Registros cadastrados:")
        lista.forEach { registro ->
            println("Nome: ${registro.nome}, Endereço: ${registro.endereço}, Telefone: ${registro.telefone}")
        }
    }
    inicio()
}

fun sair() {
    println("Programa encerrado. Até mais!")
}

fun erro() {
    println("Por favor, informe um número entre 1 e 5.")
    inicio()
}