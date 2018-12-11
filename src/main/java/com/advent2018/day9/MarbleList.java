package com.advent2018.day9;

public class MarbleList {

    Marble initialMarble;
    Marble currentMarble;

    public MarbleList() {
        initialMarble = new Marble(0);
        initialMarble.setNext(initialMarble);
        initialMarble.setPrevious(initialMarble);

        currentMarble = initialMarble;
    }

    public Integer addMarble(Integer marbleNumber) {
        if(marbleNumber%23==0) {
            Marble toRemove = getMarbleAt(-7);

            toRemove.getPrevious().setNext(toRemove.getNext());
            toRemove.getNext().setPrevious(toRemove.getPrevious());
            currentMarble = toRemove.getNext();

            return marbleNumber + toRemove.number;
        } else {
            Marble next = getMarbleAt(1);

            Marble newMarble = new Marble(marbleNumber);
            newMarble.setPrevious(next);
            newMarble.setNext(next.getNext());

            next.getNext().setPrevious(newMarble);
            next.setNext(newMarble);
            currentMarble = newMarble;
            return 0;
        }
    }

    public Marble getMarbleAt(Integer rotation) {
        Marble marble = currentMarble;
        for(int i = 0; i <  Math.abs(rotation); i++) {
            marble = (rotation > 0) ? marble.next : marble.previous;
        }
        return marble;
    }

    public class Marble {
        Marble previous;
        Marble next;
        Integer number;

        public Marble(Integer number) {
            this.number = number;
        }

        public void setPrevious(Marble previous) {
            this.previous = previous;
        }

        public Marble getPrevious() {
            return previous;
        }

        public void setNext(Marble next) {
            this.next = next;
        }

        public Marble getNext() {
            return next;
        }
    }

}
