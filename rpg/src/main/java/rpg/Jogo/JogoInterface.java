package rpg.Jogo;

import rpg.Personagem.enemies.Mobs;
import rpg.Personagem.enemies.skills.None;
import rpg.Personagem.enemies.skills.Paralyze;
import rpg.Personagem.enums.WeaponType;
import rpg.Personagem.main_characters.DrMorato;
import rpg.Personagem.main_characters.Liz;
import rpg.Personagem.main_characters.Personagem;
import rpg.Personagem.main_characters.Weapon;
import rpg.Util.Colors;
import rpg.Util.FileReader;
import rpg.exceptions.InvalidUserInputException;

import java.util.*;

public class JogoInterface {
    private String choice;

    public void start () {
        DrMorato escolha1 = new DrMorato();
        Liz escolha2 = new Liz();

        Scanner sc = new Scanner(System.in);


        printSlowly(Objects.requireNonNull(FileReader.readTxtFile("Texto.txt")), 5);

        System.out.println("Pressione enter para continuar!");
        sc.nextLine();

        String texto1 = Colors.VERDE
                + "[ACESSANDO TERMINAL DA RESISTÊNCIA VERDE...]\n"
                + "\n"
                + ">> Conexão segura estabelecida.\n"
                + "\n"
                + ">> Identidade confirmada. Acesso de campo liberado.\n"
                + "\n"
                + ">> Carregando perfil dos agentes disponíveis para a missão final: OPERAÇÃO RAIZ...\n"
                + "\n"
                + ">> Apenas dois membros ativos estão aptos para a infiltração nos Núcleos Verdes.\n"
                + "\n"
                + ">> Escolha obrigatória para iniciar a missão.\n"
                + "\n"
                + ">> Apenas um agente poderá seguir com você nesta operação.\n"
                + "\n"
                + ">> ATENÇÃO: Sua escolha influenciará sua jornada.\n"
                + "\n"
                + Colors.RESET;


       printSlowlyWithSound(texto1, 28);

        splitVoid();

        System.out.println("Pressione enter para continuar!");
        sc.nextLine();

        System.out.println("Personagens que podem ser escolhidos: ");
        splitVoid();
        printSlowly(escolha1.escolha(), 20);
        splitVoid();
        printSlowly(escolha2.escolha(), 20);
        splitVoid();


        do {
            System.out.print("Escolha a opção desejada (1/2):");
            choice = sc.nextLine();
            if (!choice.equals("1") && !choice.equals("2")){
                System.out.print("Opção invalida, digite novamente escolhendo entre 1 e 2: ");
                choice = sc.next();
            }
        } while (!choice.equals("1") && !choice.equals("2"));


        Personagem chosenCharacter = chooseYourCharacter(choice);

        printSlowly(Objects.requireNonNull(FileReader.readTxtFile("Texto2.txt")), 0);
        System.out.println("Pressione enter para continuar!");
        sc.nextLine();




        /* Comando para alterar armas
        character.setWeapon(new Weapon(WeaponType.Lamina_De_Ferro_Reciclado, 50));
        System.out.println(escolha1);
        */


        if (chosenCharacter != null) {

            if (chosenCharacter instanceof DrMorato) {

                drMoratoStoryline(sc, chosenCharacter);

            }

            else if (chosenCharacter instanceof Liz) {

                lizStoryline(sc, chosenCharacter);

            }

        }

    }

    private void drMoratoStoryline (Scanner sc, Personagem character) {

        System.out.println(character);

        droneVigiaFight(sc, character);

        character.setLife(character.getLife() + 90);

        droneControleLeveFight(sc, character);

        character.setLife(character.getLife() + 90);

        gaiaFight(sc, character);

    }

    private void lizStoryline (Scanner sc, Personagem character) {

        System.out.println(character);

        droneVigiaFight(sc, character);

        character.setLife(character.getLife() + 30);

        droneControleLeveFight(sc, character);

        character.setLife(character.getLife() + 30);

        gaiaFight(sc, character);

    }

    private void droneVigiaFight (Scanner sc, Personagem character) {

        List<Mobs> drones = new ArrayList<>();
        drones.add(new Mobs("Drone Vigia #1", 30, 10, new None()));
        drones.add(new Mobs("Drone Vigia #2", 30, 10, new None()));
        drones.add(new Mobs("Drone Vigia #3", 30, 10, new None()));


        System.out.println(">>> Combate iniciado: " + character.getName() + " vs Drones de Vigilância");
        System.out.println(">>> "+ character.weaponNames() + Colors.AMARELO +" Dano: " + character.getWeapon().getDamage() + Colors.RESET);
        splitVoid();
        System.out.println();

        while (character.getLife() > 0 && drones.stream().anyMatch(drone -> drone.getLife() > 0)) {

            System.out.println("Status atual:");
            System.out.println(character.getName() + " - " + Colors.VERMELHO + "Vida: " + character.getLife() + Colors.RESET);

            for (int i = 0; i < drones.size(); i++) {

                Mobs drone = drones.get(i);
                System.out.println((i + 1) + " - " + drone.getName() + " - " + Colors.ROXO + "Vida: " + drone.getLife() + Colors.RESET );
            }

            splitVoid();

            System.out.println("Seu turno! Escolha uma ação:");
            System.out.println("1 - Atacar com arma");
            System.out.println("2 - Fugir");
            System.out.print("Opção: ");

            int option = sc.nextInt();

            while (option != 1 && option != 2) {
                System.out.println("Seu turno! Escolha uma ação:");
                System.out.println("1 - Atacar com arma");
                System.out.println("2 - Fugir");
                System.out.print("Opção: ");

                option = sc.nextInt();

                if (option != 1 && option != 2) {
                    System.out.println("Opção inválida! Tente novamente.\n");
                }
            }

            switch (option) {

                case 1:
                    if (drones.isEmpty()) {
                        System.out.println("Não há drones para atacar!");
                        break;
                    }

                    System.out.println("Escolha um drone para atacar:");
                    for (int i = 0; i < drones.size(); i++) {
                        Mobs drone = drones.get(i);
                        if (drone.getLife() > 0) {
                            System.out.println((i + 1) + " - " + drone.getName() + " (" + Colors.ROXO + "Vida: " + drone.getLife() + Colors.RESET + ")");
                        }
                    }

                    int alvo = -1;
                    boolean alvoValido = false;

                    while (!alvoValido) {
                        System.out.print("Opção: ");
                        alvo = sc.nextInt() - 1;

                        if (alvo >= 0 && alvo < drones.size() && drones.get(alvo).getLife() > 0) {
                            alvoValido = true;
                        } else {
                            System.out.println("Alvo inválido! Tente novamente.");
                        }
                    }

                    int dano = 0;
                    if (character instanceof DrMorato) {
                        dano = ((DrMorato) character).getWeapon().getDamage();
                    } else if (character instanceof Liz) {
                        dano = ((Liz) character).getWeapon().getDamage();
                    }

                    Mobs droneAlvo = drones.get(alvo);
                    droneAlvo.setLife(Math.max(0, droneAlvo.getLife() - dano));
                    System.out.println("Você atacou " + droneAlvo.getName() + " causando " + Colors.AMARELO + dano + " de dano!" + Colors.RESET);
                    break;

                case 2:
                    System.out.println(character.getName() + " fugiu da batalha!");
                    return;
            }

            for (Mobs drone : drones) {

                if (drone.getLife() > 0) {

                    System.out.println(drone.getName() + " ataca causando " + Colors.AMARELO +drone.getDamage() + " de dano!" + Colors.RESET);

                    character.setLife(Math.max(0, character.getLife() - drone.getDamage()));

                    if (character.getLife() <= 0) {

                        break;

                    }

                }

            }

            splitVoid();

        }

    }

    private void droneControleLeveFight (Scanner sc, Personagem character) {

        Mobs droneControle = new Mobs("Drone de Controle Leve", 50, 40, new Paralyze());
        boolean weaponLocked = false;
        int lockTurns = 0;

        System.out.println(">>> Combate iniciado: " + character.getName() + " vs " + droneControle.getName());
        if (choice.equals("1")) {
            character.setWeapon(new Weapon(WeaponType.Disruptor_Portatil, 20));
        }
        else {
            character.setWeapon(new Weapon(WeaponType.Furia_Urbana, 20));
        }
        System.out.println(">>> "+ character.weaponNames() + Colors.AMARELO +" Dano: " + character.getWeapon().getDamage() + Colors.RESET);
        System.out.println();

        while (character.getLife() > 0 && droneControle.getLife() > 0) {

            System.out.println("Status atual:");
            System.out.println(character.getName() + " - " + Colors.VERMELHO + "Vida: " + character.getLife() + Colors.RESET);
            System.out.println(droneControle.getName() + " - " + Colors.ROXO + "Vida: " + droneControle.getLife() + Colors.RESET);
            System.out.println();

            if (weaponLocked && lockTurns > 0) {
                System.out.println("Sua arma está travada e você não pode atacar neste turno!");
                lockTurns--;
            } else {
                int option = -1;


                while (option != 1 && option != 2) {
                    System.out.println("Seu turno! Escolha uma ação:");
                    System.out.println("1 - Atacar com arma");
                    System.out.println("2 - Fugir");
                    System.out.print("Opção: ");

                    option = sc.nextInt();

                    if (option != 1 && option != 2) {
                        System.out.println("Opção inválida! Tente novamente.\n");
                    }
                }

                switch (option) {
                    case 1:
                        int dano = 0;
                        if (character instanceof DrMorato) {
                            dano = ((DrMorato) character).getWeapon().getDamage();
                        } else if (character instanceof Liz) {
                            dano = ((Liz) character).getWeapon().getDamage();
                        }

                        droneControle.setLife(Math.max(0, droneControle.getLife() - dano));
                        System.out.println("Você atacou causando " + Colors.AMARELO + dano + " de dano!" + Colors.RESET);
                        break;

                    case 2:
                        System.out.println(character.getName() + " fugiu da batalha!");
                        return;
                }
            }


            if (droneControle.getLife() > 0) {
                System.out.println(droneControle.getName() + " ataca causando " + Colors.AMARELO + droneControle.getDamage() + " de dano!" + Colors.RESET);
                character.setLife(Math.max(0, character.getLife() - droneControle.getDamage()));

                if (!weaponLocked && Math.random() < 0.3) {
                    droneControle.getSkill().use(character);
                    weaponLocked = true;
                    lockTurns = 1;
                    System.out.println(droneControle.getName() + " usou a habilidade: Travar Arma! Você perderá o próximo turno.");
                }
            }


        }

        if (character.getLife() <= 0) {
            System.out.println(character.getName() + " foi derrotado.");
        } else {
            System.out.println(character.getName() + " venceu o combate!");
            splitVoid();
        }

    }

    private void gaiaFight(Scanner sc, Personagem character) {

        Mobs gaia = new Mobs("GAIA – Raiz Primária", 130, 10, new None()); // Ignora armadura por padrão
        List<Mobs> drones = new ArrayList<>();
        int turnCount = 0;

        System.out.println(">>> BOSS FIGHT: " + character.getName() + " vs " + gaia.getName());
        if (choice.equals("1")) {
            character.setWeapon(new Weapon(WeaponType.Reator_De_Particulas, 30));
        }
        else {
            character.setWeapon(new Weapon(WeaponType.Raio_Pessoal, 40));
        }
        System.out.println(">>> "+ character.weaponNames() + Colors.AMARELO +" Dano: " + character.getWeapon().getDamage() + Colors.RESET);
        System.out.println();
        System.out.println("Descrição: A própria IA em sua forma digital/humana, protegida por um corpo energético e drones secundários.");
        System.out.println();

        while (character.getLife() > 0 && gaia.getLife() > 0) {
            turnCount++;

            System.out.println("========== TURNO " + turnCount + " ==========");
            System.out.println(character.getName() + " - " + Colors.VERMELHO + "Vida: " + character.getLife() + Colors.RESET);
            System.out.println(gaia.getName() + " - " + Colors.ROXO + "Vida: " + gaia.getLife() + Colors.RESET);

            for (int i = 0; i < drones.size(); i++) {
                Mobs drone = drones.get(i);
                if (drone.getLife() > 0) {
                    System.out.println("Drone Suporte #" + (i + 1) + " - " + Colors.ROXO + "Vida: " + drone.getLife() + Colors.RESET);
                }
            }

            System.out.println();
            System.out.println("Seu turno! Escolha uma ação:");
            System.out.println("1 - Atacar GAIA");
            System.out.println("2 - Atacar Drone Suporte");
            System.out.println("3 - Fugir");
            System.out.print("Opção: ");
            int option = sc.nextInt();

            while (option < 1 || option > 3) {
                System.out.println("Escolha uma ação:");
                System.out.println("1 - Atacar GAIA");
                System.out.println("2 - Atacar um drone de suporte");
                System.out.println("3 - Fugir");
                System.out.print("Opção: ");

                option = sc.nextInt();

                if (option < 1 || option > 3) {
                    System.out.println("Opção inválida! Tente novamente.\n");
                }
            }

            switch (option) {
                case 1:
                    int danoGaia = getDano(character);
                    gaia.setLife(Math.max(0, gaia.getLife() - danoGaia));
                    System.out.println("Você atacou GAIA causando " + Colors.AMARELO + danoGaia + " de dano!" + Colors.RESET);
                    break;

                case 2:
                    List<Mobs> dronesVivos = drones.stream()
                            .filter(d -> d.getLife() > 0)
                            .toList();

                    if (dronesVivos.isEmpty()) {
                        System.out.println("Não há drones vivos para atacar!");
                    } else {
                        for (int i = 0; i < dronesVivos.size(); i++) {
                            System.out.println((i + 1) + " - Drone Suporte (" + Colors.ROXO + "Vida: " + dronesVivos.get(i).getLife() + Colors.RESET + ")");
                        }

                        int droneIndex = -1;
                        boolean alvoValido = false;

                        while (!alvoValido) {
                            System.out.print("Escolha o número do drone: ");
                            droneIndex = sc.nextInt() - 1;

                            if (droneIndex >= 0 && droneIndex < dronesVivos.size()) {
                                alvoValido = true;
                            } else {
                                System.out.println("Drone inválido! Tente novamente.");
                            }
                        }

                        Mobs alvo = dronesVivos.get(droneIndex);
                        int dano = getDano(character);
                        alvo.setLife(Math.max(0, alvo.getLife() - dano));
                        System.out.println("Você atacou o drone causando " + Colors.AMARELO + dano + " de dano!" + Colors.RESET);
                    }
                    break;

                case 3:
                    System.out.println(character.getName() + " fugiu da batalha!");
                    return;
            }

            if (gaia.getLife() > 0) {
                System.out.println("GAIA usa Pulso Zero Carbono e causa " + Colors.AMARELO +gaia.getDamage() + " de dano ignorando armaduras!"+ Colors.RESET);
                character.setLife(Math.max(0, character.getLife() - gaia.getDamage()));
            }

            for (Mobs drone : drones) {
                if (drone.getLife() > 0) {
                    if (Math.random() < 0.5 && gaia.getLife() > 0) {

                        gaia.setLife(Math.min(100, gaia.getLife() + 10));
                        System.out.println(drone.getName() + " cura GAIA em " + Colors.ROXO + "+10 de vida!" + Colors.RESET);
                    } else {

                        System.out.println(drone.getName() + " ataca causando "+Colors.AMARELO+"10 de dano!"+ Colors.RESET);
                        character.setLife(Math.max(0, character.getLife() - 10));
                    }
                }
            }

            if (turnCount % 2 == 0) {
                Mobs novoDrone = new Mobs("Drone Suporte de GAIA", 30, 10, new None());
                drones.add(novoDrone);
                System.out.println("Um novo Drone Suporte apareceu!");
            }

            if (turnCount % 3 == 0 && gaia.getLife() > 0) {
                gaia.setLife(Math.min(100, gaia.getLife() + 20));
                System.out.println("GAIA ativa Regeneração Ambiental! " + Colors.ROXO + "+20 de vida."+ Colors.RESET);
            }

            splitVoid();
        }

        if (character.getLife() <= 0) {
            System.out.println(character.getName() + " foi derrotado...");
        }
        else if (choice.equals("1")){
            System.out.println("Batalha finalizada com sucesso!");
            printSlowly(Objects.requireNonNull(FileReader.readTxtFile("Texto3.txt")), 5);
            printSlowlyWithSound(Colors.VERMELHO + "   _____ ____  _   _ _______ _____ _   _ _    _               \n" +
                    "  / ____/ __ \\| \\ | |__   __|_   _| \\ | | |  | |  /\\          \n" +
                    " | |   | |  | |  \\| |  | |    | | |  \\| | |  | | /  \\         \n" +
                    " | |   | |  | | . ` |  | |    | | | . ` | |  | |/ /\\ \\        \n" +
                    " | |____ |__| | |\\  |  | |   _| |_| |\\  | |__| / ____ \\ _ _ _ \n" +
                    "  \\_____\\____/|_| \\_|  |_|  |_____|_| \\_|\\____/_/    \\_(_)_)_)" + Colors.RESET, 50);
        }
        else {
            System.out.println("Batalha finalizada com sucesso!");
            printSlowly(Objects.requireNonNull(FileReader.readTxtFile("Texto4.txt")), 5);
            printSlowlyWithSound(Colors.VERMELHO +
                    "  / ____/ __ \\| \\ | |__   __|_   _| \\ | | |  | |  /\\          \n" +
                    " | |   | |  | |  \\| |  | |    | | |  \\| | |  | | /  \\         \n" +
                    " | |   | |  | | . ` |  | |    | | | . ` | |  | |/ /\\ \\        \n" +
                    " | |____ |__| | |\\  |  | |   _| |_| |\\  | |__| / ____ \\ _ _ _ \n" +
                    "  \\_____\\____/|_| \\_|  |_|  |_____|_| \\_|\\____/_/    \\_(_)_)_)" + Colors.RESET, 50);
        }
    }

    private int getDano(Personagem character) {
        if (character instanceof DrMorato) {
            return ((DrMorato) character).getWeapon().getDamage();
        } else if (character instanceof Liz) {
            return ((Liz) character).getWeapon().getDamage();
        }
        return 10; // default
    }

    public static void printSlowly(String text, long delay) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();  // boa prática
            }
        }
        System.out.println();  // pular linha no final
    }

    public static void printSlowlyWithSound(String text, long delayMillis) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            System.out.flush();

            if (c == ' ') {
                SomInterface.playBeep(); // Toca o beep só quando for espaço
            }

            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();

        SomInterface.fecharBeep(); // <- FECHA O SOM AQUI!

    }



    private Personagem chooseYourCharacter (String choice) {

        try {

            switch (choice) {

                case "1":

                    return new DrMorato();

                case "2":

                    return new Liz();

                default:

                    System.out.println("Opção escolhida invalida!");

                    break;

            }



        } catch (IllegalArgumentException | InputMismatchException ex) {

            throw new InvalidUserInputException(ex.getMessage());

        }

        return null;

    }

    private void splitVoid(){
        System.out.println(Colors.CIANO + "-------------------------------------------------------------------------------------------------------------" + Colors.RESET);
    }

}
