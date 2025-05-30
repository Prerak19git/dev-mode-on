package org.example.app.DSA

class Node(val value: Int?) {
    var next: Node? = null
}

class SingleLinkedList {
    var head: Node? = null

    fun addFirst(value: Int?) {
        val newNode = Node(value)
        newNode.next = head
        head = newNode
        // head -> 1st node - >2nd Node
        // newNode -> head -> 1st node - > 2nd node
        // newHEAD - >1st node -> 2nd node .... so one
    }

    fun printList() {
        var curr = head
        while (curr != null) {
            print("${curr.value} -> ")
            curr = curr.next
        }
        println("null")
    }

    fun addLast(value: Int?) {
        val newNode = Node(value)
        if (head == null) {
            head = newNode
            return
        }
        var lastNodeCandidate = head

        while (lastNodeCandidate?.next != null) {
            lastNodeCandidate = lastNodeCandidate.next
        }

        lastNodeCandidate?.next = newNode

    }

    fun deleteByValue(value: Int?) {
        // head -> 2nd node - > 3rd node --- my prev ---" here i am" ---- my next
        while (head?.value == value) {
            head = head?.next
        }
        var curr = head
        while (curr != null) {
            val target = curr.next
            // if found
            if (target?.value == value) {
                curr.next = target?.next
            }
            curr = curr.next
        }


    }

    fun findMiddle() {
        var slow = head
        var fast = head

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next
            fast = fast.next?.next

        }
        println("value = ${slow?.value} ,  next = ${slow?.next}")
    }

    fun reverse() {
        var prev: Node? = null
        var curr = head

        while (curr != null) {
            val next = curr.next
            // prev ( no connection) curr -> next
            curr.next = prev
            // prev <--- curr (no connection) next
            prev = curr
            curr = next
            //      <--- newPrev (no connection) newCurr --> newNext

        }

        // at the end .... <---prev (no connection) null (end of list)
        head = prev
    }

}

fun main() {
    val list = SingleLinkedList()
    list.addFirst(3)
    list.addFirst(2)
    list.addFirst(1)
    list.printList()  // 1 -> 2 -> 3 -> null

    list.addLast(4)
    list.printList()  // 1 -> 2 -> 3 -> 4 -> null

    list.addFirst(2)
    list.addFirst(2)
    list.addLast(2)
    list.addLast(3)
    list.printList()
    list.deleteByValue(2)

    list.addLast(7)
    list.printList()  // 1 -> 3 -> 4 -> null
    list.findMiddle()
    list.reverse()
    list.printList()
}