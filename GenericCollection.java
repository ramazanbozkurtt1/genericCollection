import java.util.Arrays;

public class GenericCollection<T>{
    private int capacity = 10;
    private int size = 0;
    private T[] list;

    @SuppressWarnings("unchecked")
    public GenericCollection(){
        this.list = (T[]) new Object[this.capacity];
    }
    @SuppressWarnings("unchecked")
    public GenericCollection(int capacity){
        this.capacity = capacity;
        this.list = (T[]) new Object[this.capacity];
    }
    public int getSize(){
        return this.size;
    }
    public int getCapacity(){
        return this.capacity;
    }

    @SuppressWarnings("unchecked")
    public void doubleCapacity(){
        this.capacity = this.capacity * 2;
        T[] tempList = (T[]) new Object[capacity];
        System.arraycopy(this.list, 0, tempList, 0, this.getSize());
        this.list = tempList;
        System.gc();
    }
    public void decCapacity(int capacity){
        this.capacity = capacity;
    }

    public void incSize(){
        this.size = this.size + 1;
    }
    public void decSize(int amount){
        this.size = this.size - amount;
    }

    public T get(int index){
        if(index<this.getSize() && index>=0){
            return this.list[index];
        }else{
            return null;
        }
    }
    public void add(T data){
        if(this.size == this.capacity){
            this.doubleCapacity();
        }
        this.list[this.getSize()] = data;
        this.incSize();
    }

    public void remove(int index){
        if(index < this.getSize() && index >= 0){
            for(int i = index;i<this.getSize() - 1;i++){
                this.list[i] = this.list[i+1];
            }
            this.list[getSize() - 1] = null;
            this.decSize(1);
        }else{
            System.out.println("\nIndex "+index+" out of bound!\n");
        }
    }

    public void set(int index, T data){
        if(index < this.getSize() && index >= 0){
            this.list[index] = data;
        }else{
            System.out.println("\nIndex "+index+" out of bound!\n");
        }
    }

    @Override
    public String toString(){
        return "MyCollection{" +
                "size = " + this.getSize() +
                ", capacity = " + this.getCapacity() +
                ", elements = " + Arrays.toString(this.list) +
                '}';
    }

    public int indexOf(T data){
        for(int i = 0;i < this.getSize();i++){
            if (data.equals(this.list[i])){
               return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data){
        int lastIndex = -1;
        for(int i = 0;i < this.getSize();i++){
            if (data.equals(this.list[i])){
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] resultArray = (T[]) new Object[this.getSize()];

        System.arraycopy(this.list, 0, resultArray, 0, this.getSize());

        return resultArray;
    }

    public void clear(){
        for(int i = 0;i < this.getSize();i++){
            this.list[i] = null;
        }
        this.decSize(this.getSize());
        this.decCapacity(10);
    }

    public GenericCollection<T> sublist(int start, int finish){
        if(start>=0 && finish<this.getSize()){
            GenericCollection<T> subList =  new GenericCollection<T>(finish - start);
            for (int i = start; i < finish; i++) {
                subList.add(this.list[i]);
            }
            return subList;
        }else{
            if(start<0){
                System.out.println("\nIndex "+start+" out of bound!\n");
            }else if(finish>= this.getSize()){
                System.out.println("\nIndex "+finish+" out of bound!\n");
            }
            return null;
        }
    }
    public boolean contains(T data){
        return this.indexOf(data) != -1;
    }
    public boolean isEmpty(){
        return this.getSize() == 0;
    }

}
