package solutions.pack1;

public class Dog_661534 {
    public Breed_661534 breed;
    public int weight;
    
    public Dog_661534(Breed_661534 b, int w){
        breed = b;
        weight = w;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((breed == null) ? 0 : breed.hashCode());
        result = prime * result + weight;
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dog_661534 other = (Dog_661534) obj;
        if (breed != other.breed)
            return false;
        if (weight != other.weight)
            return false;
        return true;
    }



    @Override
    public String toString() {
        return "Dog [breed=" + breed + ", weight=" + weight + "]";
    }

   
    
}