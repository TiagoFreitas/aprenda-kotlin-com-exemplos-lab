enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO } 

data class Usuario(val nome: String, val email: String, val senha: String)

data class ConteudoEducacional(var nome: String, var duracao: Int = 1, val nivel: Nivel = Nivel.BASICO)

data class Formacao(val nome: String, val nivel: Nivel, var duracao: Int = 52, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

val conteudos = listOf(
    ConteudoEducacional("Principios", 7),
    ConteudoEducacional("Documentação", 13),
    ConteudoEducacional("Logica", 6),
    ConteudoEducacional("Padrões de Projeto", 5),
    ConteudoEducacional("Banco de Dados", 6),
    ConteudoEducacional("Spring Boot", 10)
)

fun main() { 
    
    val formacao = Formacao("Backend com Kotlin", Nivel.BASICO, 47, conteudos)
    
    formacao.matricular(Usuario("Tiago", "tiago@gmail.com", "123"))
    formacao.matricular(Usuario("Caio", "caio@gmail.com", "456"))
    formacao.matricular(Usuario("Maria", "maria@gmail.com", "987"))
    
    println("-----------------------------------------------------------------")
    println("Formação: ${formacao.nome} ")
    println("Duração ${formacao.duracao} horas")
    println("Nivel: ${formacao.nivel.name}")
    println("-----------------------------------------------------------------")
    
    formacao.conteudos.forEach{
    	println("*Conteudo: ${it.nome} ${it.duracao} hrs ${it.nivel.name}")
    }
    
    println("-----------------------------------------------------------------")
    formacao.inscritos.forEach{
    	println("Usuario inscrito: ${it.nome}")    
    }
  
}