public interface exec<T,R> {
    
    void execute(T elem);

    R getResult();
}   
