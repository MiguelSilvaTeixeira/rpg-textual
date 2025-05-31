# Atividades Práticas Supervisionadas (APS) - 3º Semestre - 2025

---

## I. TEMA:
***“DESENVOLVIMENTO DE UM JOGO NO ESTILO RPG, DE INTERAÇÕES TEXTUAIS COM O USUÁRIO”***

## II. PROPOSTA DO TRABALHO

Esta Atividade Prática Supervisionada será constituída da seguinte forma:

Pede-se aos alunos que desenvolvam um jogo, utilizando a linguagem Java, no estilo RPG de interações textuais com o Usuário / Jogador. O tema do jogo tem que conter a educação ambiental tendo como base a vida numa grande metrópole.

### Observações:

1. Disciplina vinculada a este trabalho: **Linguagem de Programação Orientada a Objetos – LPOO**.  
2. Quaisquer formas de interação textual com o Usuário poderão ser utilizadas, desde que o desenvolvimento seja na linguagem Java.  
3. Neste jogo, o Jogador deverá jogar "contra o computador" (ou ainda, contra ele mesmo), tentando fazer com que o personagem chegue "vivo" até o final do jogo.  
4. O grupo deverá fazer uma dissertação sobre todos os elementos técnicos de Orientação a Objeto, utilizados no desenvolvimento do projeto, assim como o efeito desse trabalho na sua formação, e discutir a interdisciplinaridade envolvida no mesmo.  
5. O nível de refinamento, de funcionalidade, de complexidade, de tratamento de erros, de funções extras, assim como a quantidade utilizada, para a construção do jogo, de elementos conceituais vistos em Teoria na disciplina LPOO, terão impacto direto na nota final deste trabalho.  
6. A nota atribuída ao trabalho entregue configurará a nota das APS, de forma que:
   - Parte I - 5 pontos (no máximo) será referente ao programa (jogo).
   - Parte II - 5 pontos (no máximo) será referente à documentação.
   - A nota final da disciplina APS será a soma das duas partes.

---

## Tecnologias Utilizadas

Para o desenvolvimento do RPG textual, utilizamos:

- **Java 21** – Linguagem principal do jogo.  
- **Maven** – Gerenciador de dependências.  
- **Jansi** – Biblioteca para estilização e cores nos outputs do terminal.

---

## Como rodar o projeto

Para rodar o projeto em sua máquina local, é necessário ter o Java instalado na versão 21. E além disso, ter feito a instalação do gerenciador de dependências Maven.

Primeiramente, faça o clone do projeto através do seguinte comando:

```bash
git clone https://github.com/MiguelSilvaTeixeira/rpg-textual
```

Depois disso, faça as instalações das dependências no diretório do projeto clonado:

```bash
mvn install 
```

E então, pode finalmente rodar o projeto utilizando este comando:

```bash
 mvn clean compile exec:java   
```