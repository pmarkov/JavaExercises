package com.markov;

public class SharedResource {

    private Worker Owner;

    SharedResource(Worker Owner) {
        this.Owner = Owner;
    }

    public Worker getOwner() {
        return Owner;
    }

    public synchronized void setOwner(Worker owner) {
        this.Owner = owner;
    }
}
