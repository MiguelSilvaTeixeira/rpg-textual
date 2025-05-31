package rpg.Personagem.enemies;

import rpg.Personagem.main_characters.Personagem;

public class Mobs extends Personagem {

    private Integer damage;

    private ISkill ISkill;

    public Mobs (String name, Integer lifePoints, Integer damage, ISkill ISkill) {

        super(name, lifePoints);

        this.damage = damage;

        this.ISkill = ISkill;

    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public ISkill getSkill() {
        return ISkill;
    }

    public void setSkill(ISkill ISkill) {
        this.ISkill = ISkill;
    }

}
