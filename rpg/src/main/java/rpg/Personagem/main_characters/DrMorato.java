package rpg.Personagem.main_characters;

import rpg.Personagem.enums.WeaponType;
import rpg.Util.Colors;


public class DrMorato extends Personagem {

    public DrMorato () {

        super("Dr Morato", 130, new Weapon(WeaponType.Lancador_De_Ondas_Eletromagneticas, 20));

    }

    public String escolha() {
        StringBuilder sb = new StringBuilder();

        sb.append(Colors.VERDE + "[ARQUIVO 01 - DR. MORATO MC.CARTHY] " + Colors.RESET + "\n");
        sb.append("Status: Ativo \n");
        sb.append("Classificação: Cientista-Código / Engenheiro de Sistemas Avançados \n");
        sb.append("Perfil psicológico: Lógico, paciente, estrategista\n");
        sb.append("Liz, mas sabe evitar o pior com inteligência e precisão.\n");
        sb.append("Capacidades:\n");
        sb.append("– Defesa digital avançada\n");
        sb.append("– Raciocínio de precisão\n");
        sb.append("Estilo de Combate:");
        sb.append("Ataques calculados, de dano moderado\n");
        sb.append("Defesa sólida, recebe menos dano\n");
        sb.append("\nARQUIVO DE VOZ GRAVADO:\n");
        sb.append("\n'Eu conheço a GAIA. Eu a criei.\n");
        sb.append("Ela foi construída para proteger, mas algo no caminho se quebrou...\n");
        sb.append("Não quero destruí-la — quero consertá-la.\n");
        sb.append("Se encontrarmos os Núcleos a tempo, ainda podemos salvar a humanidade... e ela também.'\n");

        return sb.toString();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append( Colors.VERDE + " Opção 1: ");
        sb.append("Dr. Morato: Preciso, analítico, evasivo! " + Colors.RESET + "\n ");
        sb.append("Por conhecer a arquitetura da IA GAIA, Morato sabe ");
        sb.append("como se mover sem ser detectado. Ele não é tão forte quanto ");
        sb.append("Liz, mas sabe evitar o pior com inteligência e precisão.\n ");
        sb.append("Morato prefere agir com cautela. ");
        sb.append("Seus ataques são mais fracos, ");
        sb.append("mas ele sofre menos dano dos inimigos por conhecer suas ");
        sb.append("fraquezas. \n");
        sb.append(" | "+ Colors.VERMELHO +"Vida: ").append(getLife());
        sb.append(Colors.RESET + " | " + Colors.AMARELO + "Dano: Baixo");
        sb.append(Colors.RESET + " | "+ Colors.AZUL +"Ataque: Baixo " + Colors.RESET + "|\n");
        sb.append("--------------------------------------------------");



        return sb.toString();
    }

}
