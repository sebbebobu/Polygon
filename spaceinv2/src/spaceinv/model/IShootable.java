package spaceinv.model;

/*
   Contract for anything that can shoot something (i.e. the T object)

 */
public interface IShootable<T> {

    T fire();

    void setProjectile(T projectile);
}
