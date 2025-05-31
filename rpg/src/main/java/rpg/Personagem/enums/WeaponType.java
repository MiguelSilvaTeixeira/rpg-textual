package rpg.Personagem.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum WeaponType {

    // Armas do DR. Morato:

    Lancador_De_Ondas_Eletromagneticas,

    Caneta_De_Pulso,

    Disruptor_Portatil,

    Modulo_De_Redirecionamento,

    Campo_De_Distorcao_Portatil,

    Reator_De_Particulas,

    // Armas da Liz:

    Lamina_De_Ferro_Reciclado,

    Furiosa,

    Furia_Urbana,

    Grito_De_Plasma,

    Punho_Espectral,

    Raio_Pessoal;

    public String getFormattedName() {
        return Arrays.stream(this.name().split("_"))
                .map(word -> word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

}
