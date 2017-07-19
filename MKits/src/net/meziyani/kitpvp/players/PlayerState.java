package net.meziyani.kitpvp.players;

/**
 * Created by yanim on 2017-07-18.
 */
public enum PlayerState {

    LOBBY(false, false, false, false), FIGHT(false, true, false, true), ADMIN(false, true, true, true);

    public boolean canBuild;
    public boolean canBeDamaged;
    public boolean canLoseFood;
    public boolean canDrop;


    PlayerState(boolean canBuild, boolean canBeDamaged,boolean canLoseFood, boolean canDrop){
        this.canBeDamaged = canBeDamaged;
        this.canBuild = canBuild;
        this.canDrop = canDrop;
        this.canLoseFood = canLoseFood;
    }



}
