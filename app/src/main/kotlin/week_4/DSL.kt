package org.example.app.week_4

@DslMarker
annotation class EmailDsl

data class EmailContent(
    val sendTo: String,
    val subject: String,
    val body: String
)

@EmailDsl
class Email {

    private lateinit var sendTo: String
    private lateinit var subject: String
    private lateinit var emailBody: String

    @EmailDsl
    class Body {

        private val lines = mutableListOf<String>()
        fun line(emailBodyLine: String) {
            lines.add(emailBodyLine)
        }

        fun build() = lines.toList()
    }

    fun sendTo(emailToSend: String) {
        sendTo = emailToSend
    }

    fun subject(emailSubject: String) {
        subject = emailSubject
    }

    fun body(block: Body.() -> Unit): Unit {
        val body = Body()
        body.block()
        emailBody = body.build().joinToString(separator = "\n") {
            it
        }
    }

    fun build(): EmailContent {
        return EmailContent(sendTo, subject, emailBody)
    }
}

fun email(block: Email.() -> Unit): EmailContent {
    val email = Email()
    email.block()
    return email.build()

}


fun main() {

    val emailContent =
        email {
            sendTo("prerak@example.com")
            subject("DSLs in Kotlin")
            body {
                line("Hope you're enjoying this.")
                line("Keep going strong.")
            }
        }

    println("send To : " + emailContent.sendTo)
    println("subject : " + emailContent.subject)
    println("Body : " + emailContent.body)

}