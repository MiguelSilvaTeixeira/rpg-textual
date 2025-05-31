package rpg.Personagem.main_characters;

import rpg.Personagem.enums.WeaponType;
import rpg.Util.Colors;

public class Liz extends Personagem {

    private Weapon weapon;

    public Liz () {

        super("Liz", 150, new Weapon(WeaponType.Lamina_De_Ferro_Reciclado, 30));

    }

    public String escolha() {
        StringBuilder sb = new StringBuilder();

        sb.append(Colors.VERDE + "[ARQUIVO 02 - ELIZABETH FRITZ]"+Colors.RESET+"\n");
        sb.append("Status: Ativa\n");
        sb.append("Classificação: Hacker Tática / Combate Urbano\n ");
        sb.append("Perfil psicológico: Impulsiva, determinada, visceral\n");
        sb.append("Capacidades:\n");
        sb.append("– Habilidades letais com armamento improvisado\n");
        sb.append("– Acesso à tecnologia bélica urbana\n");
        sb.append("– Espírito de combate e sobrevivência\n");
        sb.append("Estilo de Combate:\n");
        sb.append("Ataques fortes e explosivos");
        sb.append("Pouca defesa, recebe mais dano\n");
        sb.append("\nARQUIVO DE VOZ GRAVADO:\n");
        sb.append("\n'Não confie em máquinas. Eu confiei… e vi tudo ruir.\n");
        sb.append("GAIA escolheu a extinção.\n");
        sb.append("Se é guerra que ela quer, então vai ter.\n");
        sb.append("Eu vou queimar cada servidor se for preciso.'\n");

        return sb.toString();
    }


    @Override
    public String toString() {


        StringBuilder sb = new StringBuilder();

        sb.append(Colors.VERDE + "Opção 2: ");
        sb.append("Liz: Ofensiva, explosiva, intensa! " + Colors.RESET + "\n ");
        sb.append("Ex-agente da NeoEnergy, Liz é impetuosa e determinada. \n ");
        sb.append("Acostumada ao confronto direto, ela causa alto dano aos inimigos, ");
        sb.append("mas sua impulsividade a deixa vulnerável.\n ");
        sb.append("Morato prefere agir com cautela. Seus ataques são mais fracos, ");
        sb.append("mas ele sofre menos dano dos inimigos por conhecer suas ");
        sb.append("fraquezas. \n");
        sb.append(" | "+ Colors.VERMELHO +"Vida: ").append(getLife());
        sb.append(Colors.RESET + " | " + Colors.AMARELO + "Dano: Baixo");
        sb.append(Colors.RESET + " | "+ Colors.AZUL +"Ataque: Baixo " + Colors.RESET + "|\n");
        sb.append("--------------------------------------------------");

        return sb.toString();
    }

}
