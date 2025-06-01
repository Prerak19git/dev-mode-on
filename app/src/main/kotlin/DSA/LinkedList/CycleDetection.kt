package org.example.app.DSA.LinkedList

fun SingleLinkedList.hasCycle(): Boolean {

    /**   LOGIC
     *
     *  1 -> 2 -> 3 ...... -> entryOfCycle(k) -> k+1 -> k+2 ---> n (last node)
     *                              ↑             (CYCLE)            ↓
     *                               <----------------<--------------
     *
     *  So I have two pointers , lets say slow ( takes 1 step) and fast( takes 2 steps)
     *
     *  -> Both start at head
     *  -> If there is no cycle then fast will reach null, end of discussion
     *  -> If there is a cycle, then no pointer will reach null
     *  -> Lets say, when slow reached entryOfCycle(k), the fast will be somewhere inside
     *      the cycle just looping and can never escape.
     *      From that point lets say the number of nodes that fast exceeds slow
     *      is M ( in clockwise direction or the direction of cycle)
     *      And now see with fast is taking 2 steps and slow is taking 1 step in our frame.
     *      So if we see, fast it taking 1 step relative to slow and they are moving in cycle of lets say length L
     *      so after (L-M) steps fast will hit slow.
     *
     *  -> And if we talk about complexity  it will be (k) + (L-M) : Upper bound ( 2 * n (total nodes) )
     */

    var slow = head
    var fast = head

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (fast == slow) return true
    }

    return false
}

fun SingleLinkedList.getCycleStartingNode(): Node? {

    if (!hasCycle()) return null

    /**
     * LOGIC
     *       Lets say the cycleEntry(E) is K steps away from head, and the first collision happens at S and cycle length is L
     *
     *       Let x be how far the cycle start is from the collision point
     *
     *       x = L - (number of steps taken for slow and fast to collide)
     *
     *       after entering of slow, fast will come 1 step closer in the direction of cycle to slow
     *       x = L - ( clockwise distance between fast and slow )
     *       x = L - ( L  -  (2K-K) % L)
     *       x = K % L
     *        which means if someone starts at S and takes one step it will reach E in x steps
     *        but also, it will keep coming at E after every L steps
     *
     *      Let's say K = m(L)  + x  :  m >= 0, x <L
     *
     *      So lets say someone starts at S, he will reach E after x , x + L, x+2L  ..... x + mL steps
     *      Wait a min this means , so he will reach E after K steps as well.
     *
     *      Eureka, so if someone starts from head he will reach after K steps,this is what we have initially taken,
     *      and now from S also the same.
     *
     *      So , technically now, we will reset the slow to head and let fast be where he is, and we will tell me just keep moving
     *      on step, where you meet next is the E.
     *
     */

    var slow = head
    var fast = head

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        // we got the collision
        if (fast == slow) break
    }

    // setting slow to head, and fast to remain at the collision point.
    // the distance of entry to start (K) differs to distance of collision to entry (s) by a multiple of L ( the multiple can be 0 as well)
    // k is either equal to x or m(L) + x, any way they will collide now at entry(E)
    slow = head

    while (slow != fast) {
        slow = slow?.next
        fast = fast?.next
    }

    return slow


}


fun main() {

    list {
        addLast(1)
        addLast(2)
        addLast(3)
        addLast(4)
        println("has cycle = ${hasCycle()}") // false
    }

    list {
        addLast(1)
        head?.next = head
        println("has cycle = ${hasCycle()}") // true
        val entry = getCycleStartingNode()
        println("Cycle entry: ${entry?.value ?: "null"}")
    }

    list {
        addLast(1)
        addLast(2)
        addLast(3)
        addLast(4)
        addLast(5)
        // creating cycle: last node points to node with value 3
        var node = head
        var target: Node? = null
        while (node?.next != null) {
            if (node.value == 3) target = node
            node = node.next
        }
        node?.next = target // 5 -> 3
        println("has cycle = ${hasCycle()}") // true
        val entry = getCycleStartingNode()
        println("Cycle entry: ${entry?.value ?: "null"}")
    }

    list {
        addLast(10)
        addLast(20)
        val second = head?.next
        second?.next = head
        println("has cycle = ${hasCycle()}") // true
        val entry = getCycleStartingNode()
        println("Cycle entry: ${entry?.value ?: "null"}")
    }

    list {
        addLast(1)
        addLast(2)
        addLast(3)
        addLast(4)
        var last = head
        while (last?.next != null) {
            last = last.next
        }
        last?.next = head // create full loop
        println("has cycle = ${hasCycle()}") // true
        val entry = getCycleStartingNode()
        println("Cycle entry: ${entry?.value ?: "null"}")
    }
}