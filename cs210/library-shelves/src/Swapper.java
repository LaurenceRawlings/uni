import java.util.Random;

public class Swapper implements Runnable {
    //STM
    public static boolean STM = true;

    private Shelf shelfA;
    private Shelf shelfB;
    private String name;

    private Random random = new Random();
    private int randomWait = 0;

    Swapper(String name, Shelf shelfA, Shelf shelfB) {
        this.name = name;
        this.shelfA = shelfA;
        this.shelfB = shelfB;
    }

    @Override
    public void run() {
        int randomIndexA = 0;
        int randomIndexB = 0;

        while (true) {
            randomIndexA = random.nextInt(shelfA.getCapacity());
            randomIndexB = random.nextInt(shelfB.getCapacity());

            try {
                if (STM) {
                    //STM
                    shelfA.atomicSwap(shelfB, randomIndexA, randomIndexB);
                    System.out.println(name + " completed atomic swap.");
                } else {
                    if (shelfA.getId() < shelfB.getId()) {
                        System.out.println(name + " is trying to acquire " + shelfA.getId());
                        shelfA.acquire();

                        System.out.println(name + " is trying to acquire " + shelfB.getId());
                        shelfB.acquire();

                        shelfA.swap(shelfB, randomIndexA, randomIndexB);
                        System.out.println(name + " completed swap.");

                        shelfA.release();
                        shelfB.release();
                        System.out.println(name + " has released the shelves.");
                    } else {
                        System.out.println(name + " is trying to acquire " + shelfB.getId());
                        shelfB.acquire();

                        System.out.println(name + " is trying to acquire " + shelfA.getId());
                        shelfA.acquire();

                        shelfA.swap(shelfB, randomIndexA, randomIndexB);
                        System.out.println(name + " completed swap.");

                        shelfB.release();
                        shelfA.release();
                        System.out.println(name + " has released the shelves.");
                    }
                }

                randomWait = random.nextInt(1000); // upto 1 sec
                Thread.sleep(randomWait);
            } catch (InterruptedException ex) {
                System.out.println("Thread Interrupted.");
                break;
            }
        }
    }

    private void acquireShelves() {
        boolean acquired = false;

        try {
            while (!acquired) {
                randomWait = random.nextInt(1000);
                Thread.sleep(randomWait);
                if (!shelfA.isTaken() && !shelfB.isTaken()) {
                    System.out.println(name + " is trying to acquire " + shelfA.getId());
                    shelfA.acquire();
                    System.out.println(name + " is trying to acquire " + shelfB.getId());
                    shelfB.acquire();
                    acquired = true;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
