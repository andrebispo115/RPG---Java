
# 🎮 JRPG - Sistema de Combate em Turno

Este projeto é um jogo estilo **JRPG (Japanese Role-Playing Game)**, desenvolvido em **Java**, onde o jogador cria um personagem e enfrenta combates por turnos em um mundo de fantasia. Inspirado em clássicos como **Dragon Quest**, o objetivo é oferecer uma experiência acessível, divertida e estratégica, com elementos de progressão, equipamentos e inimigos variados.


## 📖 Sobre o Projeto

Este jogo implementa um **sistema de combate em turno** com foco na simplicidade e acessibilidade. O jogador deve enfrentar **três batalhas**, cada uma mais difícil que a anterior, distribuindo pontos de atributos, escolhendo armas e armaduras e usando estratégias como ataque, magia, defesa ou poções.


## ⚙️ Funcionalidades

* 🎭 **Criação de personagem personalizada**

  * Nome
  * Distribuição de 15 pontos em 4 atributos: Força, Constituição, Agilidade e Destreza
  * Escolha entre 3 armas iniciais e 3 armaduras iniciais

* ⚔️ **Sistema de combate por turnos**

  * Ordem baseada na **Agilidade**
  * Ações disponíveis:

    * Atacar
    * Usar magia
    * Defender
    * Usar poção (máximo de 3 por combate)

* 🧙‍♂️ **Sistema de Magia**

  * Dano direto ignorando armadura
  * Efeitos especiais (status negativos)

* 🛡️ **Sistema de equipamentos**

  * Armas leves e pesadas com cálculos distintos de dano
  * Armaduras com defesa baseada na Constituição

* 🧍‍♂️ **Adversários variados**

  * Seis inimigos diferentes com atributos e comportamentos próprios
  * Seleção aleatória nos dois primeiros combates

* 🏆 **Sistema de progressão**

  * A cada vitória: escolha de novos equipamentos e distribuição de novos pontos de atributo
  * Após a terceira luta: **vitória final**

* 🔁 **Sistema de derrota e reinício**

  * Caso o jogador perca, é redirecionado ao menu principal

## 📂 Estrutura de Pastas

```bash
jrpg-combate-turno/
├── Main.java
├── Jogador.java
├── Adversario.java
├── Arma.java
├── Armadura.java
├── Pocao.java
├── Magia.java
├── utils/
│   └── Dado.java
├── data/
│   ├── armasIniciais.json
│   └── armadurasIniciais.json
└── README.md
```

## 🧱 Tecnologias Utilizadas

* 💻 **Java 8+**
* 🗂️ Paradigma **Orientado a Objetos**

  * Herança
  * Encapsulamento
  * Polimorfismo
* 🎲 Simulação de rolagens de dados (d4, d6, d12)

---


## 📌 Requisitos

* ✅ Classes obrigatórias:

  * `Jogador`
  * `Arma`
  * `Armadura`
  * `Pocao`
  * `Adversario`
* ✅ Construtores e encapsulamento aplicados
* ✅ Herança aplicada onde necessário
* ✅ Seis adversários implementados (aleatoriedade nos combates)
* ✅ Menu inicial com opções: Jogar, História, Sair
