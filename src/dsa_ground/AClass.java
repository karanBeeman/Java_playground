package dsa_ground;

public class AClass {

    String name;

    public AClass(String karan) {
        this.name = karan;
    }

    public AClass() {
    }

    static void method() {
        System.out.println("karan");
    }

    void method2() {
         System.out.println("preetha");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AClass)) return false;
        AClass u = (AClass) o;
        return this.name.equals(u.name);
    }


}
