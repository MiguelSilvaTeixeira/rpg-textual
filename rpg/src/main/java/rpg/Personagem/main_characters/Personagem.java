package rpg.Personagem.main_characters;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Personagem {

    private String name;

    private Integer life;

    private Weapon weapon;

    public Personagem (String name, Integer life, Weapon weapon) {

        this.name = name;
        this.life = life;
        this.weapon = weapon;

    }

    public Personagem (String name, Integer life) {

        this.name = name;
        this.life = life;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public void damageReceived(Integer damage){

        life -= damage;
        System.out.println(name + " recebeu " + damage + " de dano. Vida restante: " + life);

    }

    public void status() {

        System.out.println("Nome: "
                + name
                + " | Vida: "
                + life);

    }

    public String weaponNames(){
        return weapon.weaponName();
    }

    public Weapon getWeapon() {

        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String changeEnumNames (String name) {

        name = name.replace("_", " ");

        return name;

    }

    @Override
    public String toString() {
        return "Personagem{" +
                "name='" + name + '\'' +
                ", life=" + life +
                '}';
    }
}
