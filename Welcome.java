class Welcome<T> {
    T obj;
    Welcome(T obj) { 
        this.obj = obj; 
    } 
    public T getObject() { 
        return this.obj; 
    }
}