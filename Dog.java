package cmsc256;

public class Dog implements Comparable<Dog>{
    String dogName;
    int count;

    public Dog(String dogName, int count) {
        this.dogName = dogName;
        this.count = count;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(Dog o) {
        return 0;
    }

}
