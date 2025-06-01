package org.example.app.DSA.LinkedList


private fun SingleLinkedList.reverseSecondHalf(): Node? {

    println("size  is $size")

    // a --> b --> c --> d --> e --> f
    if (head?.next == null) return null
    var curr = head
    val mid = (size) / 2
    var lastOfFirstHalf: Node? = curr
    // going till middle element
    for (i in 0 until mid) {
        lastOfFirstHalf = curr
        curr = curr?.next
    }

    println("last of First  is ${lastOfFirstHalf?.value}")

    // c is the last of first half

    var prev: Node? = null

    while (curr != null) {
        val nextNode = curr.next
        curr.next = prev
        prev = curr
        curr = nextNode
        println("prev becomes ${prev.value} , curr becomes ${curr?.value}")
    }

    // a -> b -> c -> d <- e <-f


    lastOfFirstHalf?.next = prev

    return prev
    // a -> b -> c -> f -> e -> d
}

//  1 2 3 4 3 2 1  ->  1 2 3 1 2 3 4
// 1 2 3 3 2 1 -- >  1 2 3 1 2 3

fun SingleLinkedList.checkPalindrome(): Boolean {

    if (head == null) return true

    val midNode = reverseSecondHalf()
    var currFirst = head
    var currSecond = midNode;

    var isPalindrome = true

    while (currFirst != midNode) {
        if (currFirst?.value != currSecond?.value) {
            isPalindrome = false
            break
        }
        currFirst = currFirst?.next
        currSecond = currSecond?.next
    }

    reverseSecondHalf()

    return isPalindrome

}

fun list(block: SingleLinkedList.() -> Unit): SingleLinkedList {
    val list = SingleLinkedList()
    list.block()
    return list
}

fun main() {

    list {

        addLast(1)
        addLast(2)
        addLast(3)
        addLast(2)
        addLast(1)

        printList()
        println("is it palindrome : ${checkPalindrome()}")
        printList()

    }
}