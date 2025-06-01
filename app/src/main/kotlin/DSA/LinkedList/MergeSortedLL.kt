package org.example.app.DSA.LinkedList


fun mergeSortedLists(listA: Node?, listB: Node?): Node? {
    /**
     *   1 -> 2 -> 3
     *   2 -> 4 -> 6
     *
     *   compare 1 and 2
     *
     *   so null -> 1( maintain as prevSet)->null
     *
     *   2 -> 3
     *   2 -> 4 -> 6
     *
     *   so prevSet -> 2(new - prevSet) ->null
     *
     *   3
     *   2 -> 4 -> 6
     *
     *   so prevSet-> 2(new- prevSet) -> null
     *
     *   3
     *   4 -> 6
     *
     *  so prevSet-> 3 (new- prevSet) -> null
     *
     *  4 -> 6
     *
     *  as one of them is empty, if other one lives just append
     *
     *  prevSet -> 4 -> 6
     *
     *
     */

    var currNodeA = listA
    var currNodeB = listB

    var lastMergedNode: Node? = null
    var firstNode: Node? = null

    while (currNodeA != null && currNodeB != null) {
        if (currNodeA.value <= currNodeB.value) {
            // what will be the next node for A
            val nextNodeForA = currNodeA.next

            // breaking the currNode from list A and attaching it to the merged list
            currNodeA.next = null
            lastMergedNode?.next = currNodeA
            lastMergedNode = currNodeA

            // setting the first node at the first merge
            if (firstNode == null) firstNode = currNodeA

            currNodeA = nextNodeForA


        } else {
            // what will be the next node for A
            val nextNodeForB = currNodeB.next

            // breaking the currNode from list A and attaching it to the merged list
            currNodeB.next = null
            lastMergedNode?.next = currNodeB
            lastMergedNode = currNodeB

            // setting the first node at the first merge
            if (firstNode == null) firstNode = currNodeB

            currNodeB = nextNodeForB

        }
    }

    if (currNodeA != null) {
        lastMergedNode?.next = currNodeA
        lastMergedNode = currNodeA
        // setting the first node at the first merge
        if (firstNode == null) firstNode = currNodeA


    } else {
        lastMergedNode?.next = currNodeB
        lastMergedNode = currNodeB

        // setting the first node at the first merge
        if (firstNode == null) firstNode = currNodeB

    }

    return firstNode
}

fun printList(head: Node?) {
    var curr = head
    while (curr != null) {
        print("${curr.value} -> ")
        curr = curr.next
    }
    println("null")
}

fun main() {

    val listA = list {
        addLast(1)
        addLast(1)
        addLast(1)
    }
    val listB = list {
        addLast(1)
        addLast(1)

    }

    val mergedList = mergeSortedLists(listA.head, listB.head)
    printList(mergedList)

}