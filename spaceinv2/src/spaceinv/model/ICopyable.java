package spaceinv.model;

/*
   Contract for any class that can create a copy of something (i.e. the T object)
 */
public interface ICopyable<T> {
    T copyOf();
}
