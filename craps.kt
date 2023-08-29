/*
Jogo de CRAPS
    - O jogador lança um par de dados, obtendo um valor entre 2 e 12.
    - Se na primeira jogada, o jogador tirar 7 ou 11, ele tirou um "natural" e ganhou.
    - Se tirar 2, 3 ou 12, isto é chamado de "craps" e o jogador perde.
    - Se o jogador tira um 4, 5, 6, 8, 9 ou 10, este é seu "Ponto". O objetivo agora é 
      continuar jogando os dados até tirar o mesmo número novamente. O jogador perde, 
      no entanto, se tirar um 7 antes de tirar este Ponto novamente.
 */

import kotlin.random.Random

fun playDices(): Int {
    val dice1 = Random.nextInt(1, 7)
    val dice2 = Random.nextInt(1, 7)
    return dice1 + dice2
}

fun craps() {
    val result = playDices()
    println("Você tirou $result")
    
    when (result) {
        7, 11 -> println("Você tirou um natural e ganhou!")
        2, 3, 12 -> println("CRAPS!!! Você perdeu!")
        else -> {
            val point = result
            println("Seu ponto é $point. Continue jogando...")

            while (true) {
                val result = playDices()
                println("Você tirou $result")

                when {
                    result == point -> {
                        println("Você tirou seu ponto novamente e ganhou!")
                        break
                    }
                    result == 7 -> {
                        println("Você tirou um 7 antes de tirar seu ponto novamente e perdeu!")
                        break
                    }
                }
            }
        }
    }
}

fun main() {
    println("-".repeat(20) + " Jogo de Craps " + "-".repeat(20))
    craps()
}

