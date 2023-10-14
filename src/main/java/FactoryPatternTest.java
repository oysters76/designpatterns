import java.util.Random;

public class FactoryPatternTest {

    public static void main(String[] args) {
        System.out.println("Hello seaman!");
        int threshold_delta = 5;
        int bound_delta = 15;

        FactoryPatternTest patternTest = new FactoryPatternTest();
        RandomEnemyFactory factory = patternTest.new RandomEnemyFactory(threshold_delta, bound_delta);

        for (int i = 0; i < 10000; i++){
            //game loop
            if (i % 100 == 0){
                factory.setBound(factory.getBound()+bound_delta);
                factory.setThreshold(factory.getThreshold()+threshold_delta);
                System.out.println("Changed enemy-factory settings : ");
                factory.getStat();
            }
            Enemy enemy = factory.makeEnemy();
            enemy.getStat();
        }
    }

    interface Enemy{
        void doAttack();
        void getStat();
    }

    class AsteriodEnemy implements Enemy{

        @Override
        public void doAttack() {
            System.out.println("Asteriod Attack!");
        }

        @Override
        public void getStat() {
            System.out.println("This is a asteriod");
        }


    }

    class SpaceShipEnemy implements Enemy{

        @Override
        public void doAttack() {
            System.out.println("Space ship attack");
        }

        @Override
        public void getStat() {
            System.out.println("This is a space-ship");
        }
    }

    interface EnemyFactory{
        public Enemy makeEnemy();
        public void getStat();
    }

    class RandomEnemyFactory implements EnemyFactory{
        private int threshold;
        private int bound;

        public RandomEnemyFactory(int threshold, int bound){
            this.threshold = threshold;
            this.bound = bound;
        }

        public void setThreshold(int threshold){
            this.threshold = threshold;
        }

        public void setBound(int bound){
            this.bound = bound;
        }

        public int getBound(){
            return this.bound;
        }

        public int getThreshold(){
            return this.threshold;
        }


        @Override
        public Enemy makeEnemy() {
            Random r = new Random();
            int value = r.nextInt(bound);
            if (value > threshold){
                return new SpaceShipEnemy();
            }else{
                return new AsteriodEnemy();
            }
        }

        @Override
        public void getStat() {
            System.out.println("Generating objects via RandomEnemyFactory with bound: " + this.getBound() + " threshold: " + this.getThreshold());
        }


    }




}
