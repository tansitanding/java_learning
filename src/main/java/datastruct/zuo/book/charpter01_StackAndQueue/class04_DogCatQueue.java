package datastruct.zuo.book.charpter01_StackAndQueue;

import java.util.Queue;

class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Dog extends Pet {
    public Dog() {
        super("dog");
    }
}


class Cat extends Pet {
    public Cat() {
        super("cat");
    }
}


class PetEnterQueue {
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }

    public String getEnterPetType() {
        return pet.getType();
    }
}

public class class04_DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public class04_DogCatQueue(Queue<PetEnterQueue> dogQ, Queue<PetEnterQueue> catQ) {
        this.dogQ = dogQ;
        this.catQ = catQ;
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getType().equals("dog")) {
            dogQ.add(new PetEnterQueue(pet, count++));
        } else if (pet.getType().equals("cat")) {
            catQ.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException("这是个啥子哦");
        }
    }

    public Pet pollAll() {
        if (!dogQ.isEmpty() && !catQ.isEmpty()) {
            if (dogQ.peek().getCount() < catQ.peek().getCount()) {
                return dogQ.poll().getPet();
            } else {
                return catQ.poll().getPet();
            }
        } else if (!dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else if (!catQ.isEmpty()) {
            return catQ.poll().getPet();
        } else {
            throw new RuntimeException("队列已经空了");
        }
    }

    public Dog pollDog() {
        if (!dogQ.isEmpty()) {
            return (Dog) dogQ.poll().getPet();
        } else {
            throw new RuntimeException("队列无狗");
        }
    }

    public Cat pollCay() {
        if (!catQ.isEmpty()) {
            return (Cat) catQ.poll().getPet();
        } else {
            throw new RuntimeException("队列无喵");
        }
    }

    public boolean isEmpty() {
        return dogQ.isEmpty() && catQ.isEmpty();
    }

    public boolean isDogQueueEmpty() {
        return dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty() {
        return catQ.isEmpty();
    }
}