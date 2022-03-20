public class task_2 {
    int x;
    float fx,y;

    public task_2(){};
    public task_2(int x) {
        this.x = x;
    }
    public task_2(float fx, float y) {
        this.fx = fx;
        this.y = y;
    }
    public boolean check() {
        return (this.x > 5 && this.x < 24);
    }

    public float min() {
        if (this.fx > this.y){
            return y;
        }
        return fx;
    }

    public static void main(String args[]) {
        task_2 O = new task_2(6);
        task_2 O2 = new task_2();
        task_2 O3 = new task_2(2.3f, 3.5f);
        System.out.println(O3.min());
    }
}
